package livraria.beans;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.UpdateResult;
import livraria.Helper;
import livraria.bd.BeanCRUD;
import livraria.bd.Collections;
import livraria.bd.LivrariaBD;
import net.bootsfaces.utils.FacesMessages;
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

	public Assunto(){}

	public Assunto(String id) throws Exception {
		BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
		Document      first = getCollection().find(query).first();// Weird but https://jira.mongodb.org/browse/JAVA-1744

		if(first == null){
			throw new Exception("Assunto não encontrado");
		}
		this.id = id;
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
		return doc;
	}

	// Static Methods
	static MongoCollection<Document> getCollection() {
		return LivrariaBD.getInstancia()
		                 .getBD()
		                 .getCollection(Collections.ASSUNTOS.nome);
	}

	public static MongoCursor<Document> getAll() {
		return getCollection().find().iterator();
	}

	public static Assunto getFromDocument(Document doc){
		Assunto a = new Assunto();
		a.setId(doc.getObjectId(idFieldName).toString());
		a.setTitulo(doc.getString(tituloFieldName));
		return a;
	}

	// DB
	@Override
	public void createOnDB() throws Exception {
		if(isValid()){
			throw new Exception("Not valid");
		}

		Assunto.getCollection().insertOne(getDocument());
		FacesMessages.info("Assunto Criado no BD");

	}

	@Override
	public void getIdFromDB() {

	}

	@Override
	public boolean updateOnDB() {
		UpdateResult updateResult = getCollection().updateOne(
			// Query Conditions
			eq(idFieldName, new ObjectId(id)),
			new Document("$set", getDocument())
		);

		return updateResult.wasAcknowledged();
	}

	@Override
	public boolean deleteFromDB() {
		return getCollection().deleteOne(eq(idFieldName, new ObjectId(id))).wasAcknowledged();
	}

	@Override
	public boolean isValid() {
		return Helper.isNullOrEmptyString(titulo);
	}
}
