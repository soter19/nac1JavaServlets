package livraria.managedBeans;

import com.mongodb.client.MongoCursor;
import livraria.bd.BeanCRUD;
import livraria.beans.Assunto;
import livraria.beans.Autor;
import livraria.beans.Editora;
import livraria.beans.Livro;
import org.bson.Document;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

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

	public ArrayList<Livro> getAllLivros() throws Exception {
		MongoCursor<Document> allLivrosCursor = Livro.getAll();
		ArrayList<Livro> allLivros = new ArrayList<>();

		while(allLivrosCursor.hasNext()){
			Document currLivroDoc = allLivrosCursor.next();
			Livro currLivro = new Livro();
			currLivro.setTitulo(currLivroDoc.getString("titulo"));
			currLivro.setImgURL(currLivroDoc.getString("imgUrl"));
			currLivro.setValor(currLivroDoc.getDouble("valor"));
			currLivro.setAssunto(new Assunto(currLivroDoc.getString("assunto")));
			currLivro.setAutor(  new Autor(currLivroDoc.getString("autor")));
			currLivro.setEditora(new Editora(currLivroDoc.getString("editora")));


			allLivros.add(currLivro);
		}
		return allLivros;
	}
}
