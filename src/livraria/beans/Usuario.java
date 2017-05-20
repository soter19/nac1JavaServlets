package livraria.beans;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import livraria.Helper;
import livraria.bd.Collections;
import livraria.bd.LivrariaBD;
import org.bson.Document;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class Usuario {
	private String id;
	private String email;
	private String senha;

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

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

	// Static Methods
	public static MongoCollection getCollection(){
		return LivrariaBD.getInstancia().getBD().getCollection(Collections
			                                                       .USUARIOS
			                                                       .nome);
	}

	public static Usuario getUserFromEmail(String email) throws Exception {
		if(Helper.isNullOrEmptyString(email)){
			throw new Exception("Email inválido");
		}
		Document     query   = new Document("email", email);
		FindIterable iterable = getCollection().find(query);

		if(!iterable.iterator().hasNext()){
			throw new Exception("Usuário Inexistente");
		}

		Document userDoc = (Document) iterable.first();
		return new Usuario(userDoc.getString("email"),userDoc.getString("senha"));

	}

	// Validation
	public Boolean isValid(){
		return !Helper.isNullOrEmptyString(email) &&
		       !Helper.isNullOrEmptyString(senha);
	}

	public void trocarSenha() throws Exception {
		if(!isValid()){
			throw new Exception("Usuário não é válido");
		}
//		TODO:
//		getCollection().findOneAndUpdate();
	}
}
