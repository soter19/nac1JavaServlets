package livraria.managedBeans;

import livraria.bd.BeanCRUD;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class AutorBean implements BeanCRUD {
	String nome;

	@Override
	public boolean createOnDB() {
		return false;
	}

	@Override
	public boolean getFromDB() {
		return false;
	}

	@Override
	public boolean updateOnDB() {
		return false;
	}

	@Override
	public boolean deleteFromDB() {
		return false;
	}

	public void info(){
		FacesContext c = FacesContext.getCurrentInstance();
		c.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Sucesso! ","Produto Inserido ao Carrinho"));
	}
}

