package livraria.managedBeans;

import com.mongodb.client.result.UpdateResult;
import livraria.bd.BeanCRUD;
import livraria.beans.Assunto;
import livraria.beans.Autor;
import org.bson.Document;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import static com.mongodb.client.model.Filters.eq;

@ManagedBean
public class AutorMB {
	Autor autor;
}

