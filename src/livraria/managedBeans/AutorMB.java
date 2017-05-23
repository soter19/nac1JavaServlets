package livraria.managedBeans;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.UpdateResult;
import livraria.Helper;
import livraria.bd.BeanCRUD;
import livraria.beans.Assunto;
import livraria.beans.Autor;
import org.bson.Document;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@ManagedBean
public class AutorMB {
	private Autor autor;

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<String> getAllIds(){
		List<String> allIds = new ArrayList<>();
		MongoCursor<Document> all = Autor.getAll();
		while(all.hasNext()){
			Document autor = all.next();
			allIds.add(autor.getString(Helper.idFieldName));
		}
		return allIds;
	}

	public List<String> getAllNomes(){
		List<String> allNames = new ArrayList<>();
		MongoCursor<Document> all = Autor.getAll();
		while(all.hasNext()){
			Document autor = all.next();
			allNames.add(autor.getString(Autor.nomeFieldName));
		}
		return allNames;
	}
}

