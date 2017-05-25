package livraria.managedBeans;

import livraria.beans.Usuario;
import net.bootsfaces.utils.FacesMessages;

import javax.faces.bean.ManagedBean;

/**
 * Forged by Soter Padua on 25/05/17.
 */
@ManagedBean
public class CadastroMB {
	private Usuario user = new Usuario();

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public void cadastrar(){
		try {
			user.criarUsuario();
		} catch(Exception e) {
			FacesMessages.error(e.getMessage());
		}
	}
}
