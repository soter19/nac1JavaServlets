package livraria.beans;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import livraria.bd.BeanCRUD;
import livraria.bd.Collections;
import livraria.bd.LivrariaBD;
import org.bson.Document;
import org.bson.types.ObjectId;

import static livraria.Helper.idFieldName;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class Editora implements BeanCRUD {
	private final static transient String nomeFieldName = "nome";
	private String id;
	private String nome;

	public Editora(){}

	public Editora(String id) throws Exception {
		BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
		Document      first = getCollection().find(query).first();// Weird but https://jira.mongodb.org/browse/JAVA-1744

		if(first == null){
			throw new Exception("Editora não encontrada");
		}

		this.nome = first.getString("nome");
	}

	// Getters and Setters
	public void setId(String id){this.id = id;}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// DB
	private static MongoCollection<Document> getCollection(){
		return LivrariaBD.getInstancia()
		                 .getBD()
		                 .getCollection(Collections.EDITORAS.nome);
	}

	public static Editora getFromDocument(Document doc){
		Editora e = new Editora();
		e.setId(doc.getObjectId(idFieldName).toString());
		e.setNome(doc.getString(nomeFieldName));
		return e;
	}

	public static MongoCursor<Document> getAll() {
		return getCollection().find().iterator();
	}

	@Override
	public void createOnDB() {
		return;
	}

	@Override
	public Document getFromDB() {
		return null;
	}

	@Override
	public boolean updateOnDB() {
		return false;
	}

	@Override
	public boolean deleteFromDB() {
		return false;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Document getDocument() {
		return null;
	}
}
