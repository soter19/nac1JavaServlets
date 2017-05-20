package livraria.beans;

import com.mongodb.client.MongoCollection;
import livraria.Helper;
import livraria.bd.Collections;
import livraria.bd.LivrariaBD;

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
	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public static MongoCollection getCollection(){
		return LivrariaBD.getInstancia().getBD().getCollection(Collections
			                                                       .USUARIOS
			                                                       .nome);
	}

	// Validation
	public Boolean isValid(){
		return !Helper.isNullOrEmptyString(email) &&
		       !Helper.isNullOrEmptyString(senha);
	}
	}
}
