package livraria.beans;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import livraria.Helper;
import livraria.bd.Collections;
import livraria.bd.LivrariaBD;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static livraria.Helper.idFieldName;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class Usuario {
	private final static transient String emailFieldName = "email";
	private final static transient String senhaFieldName = "senha";

	private String id;
	private String email;
	private String senha;

	public Usuario() {}

	//	Getters and Setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// DB operations
	public void trocarSenha() throws Exception {
		if(!isValid()){
			throw new Exception("Usuário não é válido, informe o e-mail.");
		}

		// parece burro, mas é para lidar com o fato de que só usuários
		// deslogados podem pedir pela senha.
		Usuario u = getUserFromEmail(email);


		getCollection().updateOne(eq("_id", u.id), new Document("$set", new Document(Usuario.senhaFieldName,
		                                                                             "123")));
	}

	public void criarUsuario() throws Exception{
		if(emailExiste(email)){
			throw new Exception("Email já cadastrado.");
		}

		Document user = new Document();
		user.append(emailFieldName,email);
		user.append(senhaFieldName,senha);

		getCollection().insertOne(user);
	}

	private static Boolean emailExiste(String email){
		Document usr = getCollection().find(eq(emailFieldName, email)).first();
		return usr != null;
	}

	// Static Methods
	public static MongoCollection<Document> getCollection(){
		return LivrariaBD.getInstancia().getBD().getCollection(Collections
			                                                       .USUARIOS
			                                                       .nome);
	}

	private static Usuario getUserFromEmail(String email) throws Exception {
		if(Helper.isNullOrEmptyString(email)){
			throw new Exception("Email inválido");
		}
		Document               query    = new Document("email", email);
		FindIterable<Document> iterable = getCollection().find(query);

		if(!iterable.iterator().hasNext()){
			throw new Exception("Usuário Inexistente");
		}

		Document userDoc = iterable.first();
		Usuario  usuario = new Usuario();
		usuario.setId(userDoc.getObjectId(idFieldName).toString());
		usuario.setEmail(userDoc.getString(emailFieldName));
		usuario.setSenha(userDoc.getString(senhaFieldName));

		return usuario;

	}

	// Validation
	public Boolean isValid(){
		return !Helper.isNullOrEmptyString(email);
	}
}
