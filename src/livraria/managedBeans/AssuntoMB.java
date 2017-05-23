package livraria.managedBeans;
import com.mongodb.client.result.UpdateResult;
import livraria.bd.BeanCRUD;
import livraria.beans.Assunto;
import org.bson.Document;

import javax.faces.bean.ManagedBean;

import static com.mongodb.client.model.Filters.eq;

@ManagedBean
public class AssuntoMB {
	private Assunto assunto;
}
