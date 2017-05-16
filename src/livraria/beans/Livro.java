package livraria.beans;

import org.bson.Document;
/**
 * Forged by Soter Padua on 30/03/17.
 */
public class Livro{
	private String  titulo;
	private Autor   autor;
	private Assunto assunto;
	private Editora editora;
	private String  imgURL;
	private Double  valor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public static Livro fromDocument(Document doc) throws Exception {
		Livro livro = new Livro();

		Autor autor = new Autor(doc.getString("autor"));

		Assunto assunto = new Assunto(doc.getString("assunto"));;

		livro.setTitulo(doc.getString("titulo"));
		livro.setAutor(autor);
		livro.setAssunto(assunto);
		livro.setValor(doc.getDouble("valor"));
		livro.setImgURL(doc.getString("imgURL"));

		return livro;

	}
}
