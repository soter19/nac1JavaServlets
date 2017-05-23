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
public class Autor implements BeanCRUD{
	public final static String nomeFieldName = "nome";
	private String id;
	private String nome;

	public Autor(){}

	public Autor(String id) throws Exception {
		BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
		Document      first = getCollection().find(query).first();// Weird but https://jira.mongodb.org/browse/JAVA-1744

		if(first == null){
			throw new Exception("Autor not found");
		}

		this.nome = first.getString("nome");
	}

	// Getters and Setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Static Methods

	private static MongoCollection<Document> getCollection(){
		return LivrariaBD.getInstancia()
		                 .getBD()
		                 .getCollection(Collections.AUTORES.nome);
	}

	public static MongoCursor<Document> getAll() {
		return getCollection().find().iterator();
	}

	public static Autor getFromDocument(Document doc){
		Autor a = new Autor();
		a.setId(doc.getObjectId(idFieldName).toString());
		a.setNome(doc.getString(nomeFieldName));
		return a;
	}

	// DB
	@Override
	public Document getDocument(){
		Document doc = new Document();
		doc.append(nomeFieldName, nome);
		if(!Helper.isNullOrEmptyString(id)){
			doc.append(idFieldName, id);
		}
		return doc;
	}

	@Override
	public void createOnDB() {
		Document doc = new Document();
		doc.append(nomeFieldName, nome);
		if(!Helper.isNullOrEmptyString(id)){
			doc.append(idFieldName, id);
		}
		getCollection().insertOne(doc);
		FacesMessages.info("Autor "+ nome +" Criado no BD");
	}

	@Override
	public Document getFromDB() {
		return null;
	}

	@Override
	public boolean updateOnDB() {
		UpdateResult updateResult = Assunto.getCollection().updateOne(
			// Query Conditions
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
		return false;
	}
}
