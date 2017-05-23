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
@ManagedBean(name = "LoginMB")
@SessionScoped
public class LoginMB {
	private Usuario usuario = new Usuario();

	public String login() {
		try {
			if(checkLogin()){
				HttpSession session = SessionUtils.getSession();
				session.setAttribute("username", usuario.getEmail());
				FacesMessages.info("Success:","Logged!");
			}else{
				FacesMessages.warning("Wrong Credentials: ","Please try again");
				return NomesPaginas.LOGIN.nome; // No caso de erro estamos mandando para a página de login.
			}
		} catch(Exception e) {
			FacesMessages.warning("Erro: ", e.getMessage());
			return NomesPaginas.LOGIN.nome; // No caso de erro estamos mandando para a página login.
		}
		return NomesPaginas.INDEX.nome;
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
		if(!usuario.isValid()){
			FacesMessages.warning("Usuário inválido: ","Por favor preencha e-mail e senha.");
		}

		try {
			usuario.criarUsuario();
		} catch(Exception e) {
			FacesMessages.warning(e.getMessage());
			return;
		}

		login();
	}

	public void forgotPassword() {
		if(Helper.isNullOrEmptyString(usuario.getEmail())){
			FacesMessages.warning("Por favor, inserir o e-mail");
		}

		// Código que simula o email de troca de senha
		// Atualmente só troca a senha atual para 123

		try {
			usuario.trocarSenha();
			FacesMessages.info("Caso haja um cliente com esse e-mail, será enviado um e-mail para alterar a senha. "
			                   + "(Mentira, a senha agora é 123.)");

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
