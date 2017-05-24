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
		MongoCursor<Document> all = Autor.getAll();
		ArrayList<Autor> allAutores = new ArrayList<>();

		while(all.hasNext()){
			Document autorDoc = all.next();
			Autor    fromDocument = Autor.getFromDocument(autorDoc);
			allAutores.add(fromDocument);
		}
		return allAutores;
	}
}

