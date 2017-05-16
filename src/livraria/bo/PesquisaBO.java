package livraria.bo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import livraria.bd.LivrariaBD;
import livraria.beans.Livro;
import livraria.managedBeans.AutorBean;
import livraria.managedBeans.EditoraBean;
import livraria.managedBeans.LivroBean;
import livraria.utils.Helper;
import org.bson.Document;

import java.util.ArrayList;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class PesquisaBO {
	public static ArrayList<Livro> pesquisa(String livro) throws Exception {
		if(Helper.isNullOrEmpty(livro)){
			throw new Exception();
		}
		MongoCollection<Document> a = LivrariaBD.getInstancia().getBD().getCollection("livros");
		Document query = new Document();
		query.append("titulo", livro);
		MongoCursor<Document> cur = a.find(query).iterator();

		ArrayList<Livro> res = new ArrayList<>();
		while(cur.hasNext()){
			Document next = cur.next();
			Livro currLivro = Livro.fromDocument(next);
			res.add(currLivro);
		}
		return res;
	}

	public AutorBean pesquisa(AutorBean autor){
		return null;
	}

	public EditoraBean pesquisa(EditoraBean autor){
		return null;
	}

	public LivroBean pesquisa(livraria.managedBeans.LivroBean autor){
		return null;
	}
}
