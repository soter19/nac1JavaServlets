package livraria.bd;

/**
 * Forged by Soter Padua on 11/05/17.
 */
public interface BeanCRUD {
	public boolean createOnDB();
	public boolean getFromDB();
	public boolean updateOnDB();
	public boolean deleteFromDB();
}
