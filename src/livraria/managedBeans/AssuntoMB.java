package livraria.managedBeans;
import livraria.bd.BeanCRUD;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AssuntoMB implements BeanCRUD {
	String Nome;

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
}
