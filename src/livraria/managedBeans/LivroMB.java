package livraria.managedBeans;

import com.mongodb.client.MongoCursor;
import livraria.bd.BeanCRUD;
import livraria.beans.Assunto;
import livraria.beans.Autor;
import livraria.beans.Editora;
import livraria.beans.Livro;
import net.bootsfaces.utils.FacesMessages;
import org.bson.Document;
import sun.security.validator.ValidatorException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;

import static com.mongodb.client.model.Filters.or;
import static com.mongodb.client.model.Filters.regex;

/**
 * Forged by Soter Padua on 30/03/17.
 */
@ManagedBean
public class LivroMB{
	private Livro livro = new Livro();

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public ArrayList<Livro> allLivros() throws Exception {
		MongoCursor<Document> allLivrosCursor = Livro.getAll();
		ArrayList<Livro> allLivros = new ArrayList<>();

		while(allLivrosCursor.hasNext()){
			allLivros.add(Livro.fromDocument(allLivrosCursor.next()));
		}

		return allLivros;
	}

	public void validarLivroRepetido(FacesContext context,
									 UIComponent componentToValidate,
									 Object value) throws Exception {

		String busca = value.toString();
		String pattern = ".*" + busca + ".*";
		MongoCursor<Document> cur = Livro.getCollection().find(
				or(
						regex("titulo", pattern, "i")
				)).iterator();

		while(cur.hasNext()){
			Document next = cur.next();
			Livro currLivro = Livro.fromDocument(next);
			if (currLivro.getTitulo().equals(value)){
				FacesMessages.error("Livro Existente!");
			}
		}

	}
}
