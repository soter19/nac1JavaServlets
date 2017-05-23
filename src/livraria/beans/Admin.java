package livraria.beans;

import com.mongodb.client.MongoCollection;
import livraria.Helper;
import livraria.bd.Collections;
import livraria.bd.LivrariaBD;
import org.bson.Document;

/**
 * Forged by Soter Padua on 23/05/17.
 */
public class Admin {
	private String  email;
	private String  senha;

	// Getters and Setters
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Static Methods
	public static MongoCollection<Document> getCollection(){
		return LivrariaBD.getInstancia()
		                 .getBD()
		                 .getCollection(Collections.ADMINS.nome);
	}

	// Validation
	public Boolean isValid(){
		return !Helper.isNullOrEmptyString(email) && !Helper.isNullOrEmptyString(senha);
	}
}
