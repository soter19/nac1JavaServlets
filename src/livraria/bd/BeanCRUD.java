package livraria.bd;

import org.bson.Document;

/**
 * Forged by Soter Padua on 11/05/17.
 */
public interface BeanCRUD {
	public void createOnDB() throws Exception;
	public void getIdFromDB() throws Exception;
	public boolean updateOnDB();
	public boolean deleteFromDB();
	public boolean isValid();
	public Document getDocument();
}
