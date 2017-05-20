package livraria.managedBeans;
import livraria.bd.BeanCRUD;
import livraria.beans.Assunto;
import org.bson.BSON;
import org.bson.Document;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AssuntoMB implements BeanCRUD {
	String titulo;

	@Override
	public boolean createOnDB() {
		Assunto newAssunto = new Assunto();
		newAssunto.setTitulo(titulo);

		if(!newAssunto.isValid()){
			return false;
		}

		Assunto.getCollection().insertOne(newAssunto.getDocument());

		return true;
	}

	@Override
	public boolean getFromDB() {
		return false;
	}

	@Override
	public boolean updateOnDB() {
		Assunto newAssunto = new Assunto();
		newAssunto.setTitulo(titulo);

		if(!newAssunto.isValid()){
			return false;
		}

//		Document oneAndUpdate = Assunto.getCollection().findOneAndUpdate(newAssunto.getDocument());
		return true;
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
