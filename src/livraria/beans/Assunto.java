package livraria.beans;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import livraria.Helper;
import livraria.bd.Collections;
import livraria.bd.LivrariaBD;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class Assunto {;
	public transient static final String idFieldName = "_id";
	public transient static final String tituloFieldName = "titulo";

	private String id;
	private String titulo;

	public Assunto(){}

	public Assunto(String id) throws Exception {
		BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
		Document      first = getCollection().find(query).first();// Weird but https://jira.mongodb.org/browse/JAVA-1744

		if(first == null){
			throw new Exception("Assunto não encontrado");
		}

		this.titulo = first.getString("titulo");
	}

	// Getters and Setters
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

	// Validation
	public boolean isValid() {
		return Helper.isNullOrEmptyString(titulo);
	}

	// DB
	public Document getDocument() {
		Document doc = new Document(tituloFieldName, titulo);
		if(!Helper.isNullOrEmptyString(id)){
			doc.append(idFieldName, id);
		}
		return doc;
	}

	// Static Methods
	public static MongoCollection<Document> getCollection() {
		return LivrariaBD.getInstancia()
		                 .getBD()
		                 .getCollection(Collections.ASSUNTOS.nome);
	}
}
