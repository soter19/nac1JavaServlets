package livraria.managedBeans;

import livraria.bd.BeanCRUD;
import livraria.beans.Assunto;
import livraria.beans.Autor;
import livraria.beans.Editora;
import livraria.beans.Livro;

import javax.faces.bean.ManagedBean;

/**
 * Forged by Soter Padua on 30/03/17.
 */
@ManagedBean
public class LivroMB implements BeanCRUD{
	private Livro livro = new Livro();

	public String getTitulo() {
		return livro.getTitulo();
	}

	public void setTitulo(String titulo) {
		livro.setTitulo(titulo);
	}

	public Autor getAutor() {
		return livro.getAutor();
	}

	public void setAutor(Autor autor) {
		livro.setAutor(autor);
	}

	public Assunto getAssunto() {
		return livro.getAssunto();
	}

	public void setAssunto(Assunto assunto) {
		livro.setAssunto(assunto);
	}

	public Editora getEditora() {
		return livro.getEditora();
	}

	public void setEditora(Editora editora) {
		livro.setEditora(editora);
	}

	public Double getValor() {
		return livro.getValor();
	}

	public void setValor(Double valor) {
		livro.setValor(valor);
	}

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
