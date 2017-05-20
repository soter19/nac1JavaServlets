package livraria.beans;

import livraria.bd.BeanCRUD;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class Editora implements BeanCRUD{
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
