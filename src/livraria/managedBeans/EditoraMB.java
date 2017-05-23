package livraria.managedBeans;

import com.mongodb.client.MongoCursor;
import livraria.bd.BeanCRUD;
import livraria.beans.Autor;
import livraria.beans.Editora;
import org.bson.Document;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

@ManagedBean
public class EditoraMB{
	private Editora editora;

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public ArrayList<Editora> getAll(){
		ArrayList<Editora>    todos = new ArrayList<>();
		MongoCursor<Document> all   = Editora.getAll();
		while(all.hasNext()){
			Document autorDoc = all.next();
			Editora  fromDocument = Editora.getFromDocument(autorDoc);
			todos.add(fromDocument);
		}
		return todos;
	}
}
