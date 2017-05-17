package livraria.managedBeans;

import com.mongodb.BasicDBObject;
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
public class LoginBean {
	private Usuario usuario;
	private String email;
	private String senha;

	public String login() {
		try {
			usuario = new Usuario(email, senha);
			if(checkLogin()){
				HttpSession session = SessionUtils.getSession();
				session.setAttribute("username", email);
				FacesMessages.info("Success:","Logged!");
			}else{
				FacesMessages.warning("Wrong Credentials:","Please try again");
			}
		} catch(Exception e) {
			FacesMessages.warning("Erro:", e.getMessage());
		}
		return NomesPaginas.LOGIN.nome;
	}

	private Boolean checkLogin() throws Exception {
		if(!usuario.isValid()){
			throw new Exception("Login Inválido");
		}

		BasicDBObject query = new BasicDBObject();
		query.append("email", usuario.getUser());
		query.append("senha", usuario.getPassword());

		Object first = Usuario.getCollection().find(query).first();

		return first != null;
	}


	public void signup(){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Congratulations! You've successfully logged in.");
		FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
	}

	public void forgotPassword() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default user name: BootsFaces");
		FacesContext.getCurrentInstance().addMessage("loginForm:username", msg);
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Default password: rocks!");
		FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
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
}
