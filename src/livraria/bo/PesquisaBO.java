package livraria.bo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import livraria.bd.LivrariaBD;
import livraria.beans.Livro;
import livraria.managedBeans.AutorMB;
import livraria.managedBeans.EditoraMB;
import livraria.managedBeans.LivroMB;
import livraria.utils.Helper;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.regex;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class PesquisaBO {
	public static ArrayList<Livro> pesquisa(String livro) throws Exception {
		if(Helper.isNullOrEmpty(livro)){
			throw new Exception();
		}
		MongoCollection<Document> a = LivrariaBD.getInstancia().getBD().getCollection("livros");

		String pattern = ".*" + livro + ".*";

		MongoCursor<Document> cur = a.find(regex("titulo", pattern, "i")).iterator();

		ArrayList<Livro> res = new ArrayList<>();
		while(cur.hasNext()){
			Document next = cur.next();
			Livro currLivro = Livro.fromDocument(next);
			res.add(currLivro);
		}
		return res;
	}

	public AutorMB pesquisa(AutorMB autor){
		return null;
	}

	public EditoraMB pesquisa(EditoraMB autor){
		return null;
	}

	public LivroMB pesquisa(livraria.managedBeans.LivroMB autor){
		return null;
	}
}
