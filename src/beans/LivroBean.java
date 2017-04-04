package beans;

import javax.faces.bean.ManagedBean;

/**
 * Forged by Soter Padua on 30/03/17.
 */
@ManagedBean
public class LivroBean {
	private String      titulo;
	private AutorBean   autor;
	private AssuntoBean assunto;
	private EditoraBean editora;
	private Double      valor;

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public AutorBean getAutor() {
		return autor;
	}
	public void setAutor(AutorBean autor) {
		this.autor = autor;
	}
	public AssuntoBean getAssunto() {
		return assunto;
	}
	public void setAssunto(AssuntoBean assunto) {
		this.assunto = assunto;
	}
	public EditoraBean getEditora() {
		return editora;
	}
	public void setEditora(EditoraBean editora) {
		this.editora = editora;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
