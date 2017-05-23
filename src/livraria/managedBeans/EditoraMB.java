package livraria.managedBeans;

import livraria.bd.BeanCRUD;
import livraria.beans.Editora;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class EditoraMB{
	private Editora editora;

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
}
