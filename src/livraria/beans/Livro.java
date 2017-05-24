package livraria.beans;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import livraria.Helper;
import livraria.bd.BeanCRUD;
import livraria.bd.Collections;
import livraria.bd.LivrariaBD;
import net.bootsfaces.utils.FacesMessages;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static livraria.Helper.idFieldName;

/**
 * Forged by Soter Padua on 30/03/17.
 */
public class Livro implements BeanCRUD{
	private String  id;
	private String  titulo;
	private Autor   autor;
	private Assunto assunto;
	private Editora editora;
	private String  imgURL;
	private Double  valor;

	public Livro(){
		autor = new Autor();
		assunto = new Assunto();
		editora = new Editora();
	}

	public Livro(String id){
		this.id = id;

		autor = new Autor();
	}

	public static Livro fromDocument(Document doc) throws Exception {
		Livro livro = new Livro();
		Autor autor = new Autor(doc.getString("autor"));
		Assunto assunto = new Assunto(doc.getString("assunto"));
		Editora editora = new Editora(doc.getString("editora"));

		livro.setTitulo(doc.getString("titulo"));
		livro.setAutor(autor);
		livro.setAssunto(assunto);
		livro.setValor(doc.getDouble("valor"));
		livro.setImgURL(doc.getString("imgURL"));
		livro.setEditora(editora);
		livro.setValor(doc.getDouble("valor"));

		return livro;

	}

	public static MongoCursor<Document> getAll(){
		return getCollection().find().iterator();
	}

	public static MongoCollection<Document> getCollection(){
		return LivrariaBD.getInstancia()
		                 .getBD()
		                 .getCollection(Collections.LIVROS.nome);
	}

	// Getters And Setters
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


	// DB
	@Override
	public void createOnDB() {
		getCollection().insertOne(getDocument());
		FacesMessages.info("Livro Criado no BD!");
	}

	@Override
	public void getIdFromDB() {
	}

	@Override
	public boolean updateOnDB() {
		return false;
	}

	@Override
	public boolean deleteFromDB() {
		return false;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public Document getDocument() {
		Document livroDoc = new Document();
		if(!Helper.isNullOrEmptyString(id)){
			livroDoc.append(idFieldName, id);
		}
		livroDoc.append("titulo", titulo);
		livroDoc.append("autor", autor.getId());
		livroDoc.append("assunto", assunto.getId());
		livroDoc.append("editora", editora.getId());
		livroDoc.append("valor", valor);
		livroDoc.append("imgUrl", imgURL);

		return livroDoc;
	}
}
