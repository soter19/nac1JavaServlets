package livraria.managedBeans;

import com.mongodb.client.MongoCursor;
import livraria.Helper;
import livraria.beans.Autor;
import org.bson.Document;

import javax.faces.bean.ManagedBean;

import java.util.*;

import static com.mongodb.client.model.Filters.eq;

@ManagedBean
public class AutorMB {
	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public ArrayList<Autor> getAll(){
		ArrayList<Autor> todos = new ArrayList<>();
		MongoCursor<Document> all = Autor.getAll();
		while(all.hasNext()){
			Document autorDoc = all.next();
			Autor    fromDocument = Autor.getFromDocument(autorDoc);
			todos.add(fromDocument);
		}
		return todos;
	}
}

