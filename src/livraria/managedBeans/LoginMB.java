package livraria.managedBeans;

import com.mongodb.BasicDBObject;
import livraria.Helper;
import livraria.SessionUtils;
import livraria.beans.Usuario;
import livraria.utils.NomesPaginas;
import net.bootsfaces.utils.FacesMessages;
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Forged by Soter Padua on 17/05/17.
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginMB {
	private Usuario usuario;

	public String login() {
		try {
			if(checkLogin()){
				HttpSession session = SessionUtils.getSession();
				session.setAttribute("username", usuario.getEmail());
				FacesMessages.info("Success:","Logged!");

			}else{
				FacesMessages.warning("Wrong Credentials: ","Please try again");
			}
		} catch(Exception e) {
			FacesMessages.warning("Erro: ", e.getMessage());
		}
		return "index";
	}

	private Boolean checkLogin() throws Exception {
		if(!usuario.isValid()){
			throw new Exception("Login Inválido");
		}

		BasicDBObject query = new BasicDBObject();
		query.append("email", usuario.getEmail());
		query.append("senha", usuario.getSenha());

		Object first = Usuario.getCollection().find(query).first();

		return first != null;
	}

	public void signup(){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Congratulations! You've successfully logged in.");
		FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);

	}

	public void forgotPassword() {
		if(Helper.isNullOrEmptyString(usuario.getEmail())){
			FacesMessages.warning("Por favor, inserir o e-mail");
		}
		FacesMessages.info("Caso haja um cliente com esse e-mail, será enviado um e-mail para alterar a senha.");
		// Código que simula o email de troca de senha
		// Atualmente só troca a senha atual para 123

		try {
			usuario.trocarSenha();

		} catch(Exception e) {
			FacesMessages.warning(e.getMessage());
		}
	}

	public String getEmail() {
		return usuario.getEmail();
	}

	public void setEmail(String email) {
		usuario.setEmail(email);
	}

	public String getSenha() {
		return usuario.getSenha();
	}

	public void setSenha(String senha) {
		usuario.setSenha(senha);;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
