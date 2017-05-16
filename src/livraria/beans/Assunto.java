package livraria.beans;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;
import livraria.bd.Collections;
import livraria.bd.LivrariaBD;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class Assunto {
	private String id;
	private String titulo;

	public Assunto(String id) throws Exception {
		BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
		Document      first = getCollection().find(query).first();// Weird but https://jira.mongodb.org/browse/JAVA-1744

		if(first == null){
			throw new Exception("Assunto not found");
		}

		this.titulo = first.getString("titulo");
	}

	private MongoCollection<Document> getCollection() {
		return LivrariaBD.getInstancia()
		                 .getBD()
		                 .getCollection(Collections.ASSUNTOS.nome);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
