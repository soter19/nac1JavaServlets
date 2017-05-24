package livraria.managedBeans;
import com.mongodb.client.MongoCursor;
import livraria.beans.Assunto;
import livraria.beans.Editora;
import org.bson.Document;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

@ManagedBean
public class AssuntoMB {
	private Assunto assunto = new Assunto();

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public ArrayList<Assunto> getAll(){
		ArrayList<Assunto>    todos = new ArrayList<>();
		MongoCursor<Document> all   = Assunto.getAll();
		while(all.hasNext()){
			Document assuntoDoc = all.next();
			Assunto  fromDocument = Assunto.getFromDocument(assuntoDoc);
			todos.add(fromDocument);
		}
		return todos;
	}
}
