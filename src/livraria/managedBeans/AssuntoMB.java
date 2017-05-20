package livraria.managedBeans;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.result.UpdateResult;
import livraria.bd.BeanCRUD;
import livraria.beans.Assunto;
import net.bootsfaces.utils.FacesMessages;
import org.bson.BSON;
import org.bson.Document;

import javax.faces.bean.ManagedBean;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

@ManagedBean
public class AssuntoMB implements BeanCRUD {
	Assunto assunto;

	@Override
	public boolean createOnDB() {
		if(!assunto.isValid()){
			return false;
		}

		Assunto.getCollection().insertOne(assunto.getDocument());

		return true;
	}

	@Override
	public boolean getFromDB() {
		return false;
	}

	@Override
	public boolean updateOnDB() {
		if(!assunto.isValid()){
			return false;
		}

		UpdateResult updateResult = Assunto.getCollection().updateOne(
			// Query Conditions
			eq("_id", assunto.getId()),
			new Document("$set", assunto.getDocument())
		);

		return updateResult.wasAcknowledged();
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
