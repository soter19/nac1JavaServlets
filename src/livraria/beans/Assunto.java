package livraria.beans;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import livraria.Helper;
import livraria.bd.BeanCRUD;
import livraria.bd.Collections;
import livraria.bd.LivrariaBD;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;
import static livraria.Helper.idFieldName;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class Assunto implements BeanCRUD{;
	private transient static final String tituloFieldName = "titulo";

	private String id;
	private String titulo;

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

	// DB
	public Document getDocument() {
		Document doc = new Document(tituloFieldName, titulo);
		if(!Helper.isNullOrEmptyString(id)){
			doc.append(idFieldName, id);
		}
		return doc;
	}

	// Static Methods
	static MongoCollection<Document> getCollection() {
		return LivrariaBD.getInstancia()
		                 .getBD()
		                 .getCollection(Collections.ASSUNTOS.nome);
	}

	// DB
	@Override
	public boolean createOnDB() {
		if(isValid()){
			return false;
		}

		Assunto.getCollection().insertOne(getDocument());

		return true;
	}

	@Override
	public Document getFromDB() {
		return null;
	}

	@Override
	public boolean updateOnDB() {
		if(!isValid()){
			return false;
		}

		UpdateResult updateResult = Assunto.getCollection().updateOne(
			eq("_id", id),
			new Document("$set", getDocument())
		);

		return updateResult.wasAcknowledged();
	}

	@Override
	public boolean deleteFromDB() {
		return false;
	}

	@Override
	public boolean isValid() {
		return Helper.isNullOrEmptyString(titulo);
	}
}
