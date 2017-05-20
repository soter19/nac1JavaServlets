package livraria.managedBeans;

import livraria.bd.BeanCRUD;
import livraria.beans.Autor;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class AutorMB implements BeanCRUD {
	Autor autor;

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

	@Override
	public boolean isValid() {
		return false;
	}
}

