package livraria.bo;
import com.mongodb.client.MongoCursor;
import livraria.beans.Autor;
import livraria.beans.Editora;
import livraria.beans.Livro;
import livraria.managedBeans.AutorMB;
import livraria.managedBeans.EditoraMB;
import livraria.managedBeans.LivroMB;
import livraria.utils.Helper;
import org.bson.BSON;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;
import static livraria.Helper.idFieldName;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class PesquisaBO {
	public static ArrayList<Livro> pesquisaSimples(String busca) throws Exception {
		if(Helper.isNullOrEmpty(busca)){
			throw new Exception("Busca vazia...");
		}

		String pattern = ".*" + busca + ".*";

		ArrayList<String> autores  = pesquisaAutor(busca);
		ArrayList<String> editoras = pesquisaEditora(busca);

		MongoCursor<Document> cur = Livro.getCollection().find(
			or(
				regex("titulo", pattern, "i"),
				in("editora", editoras),
			    in("autor", autores)
			)).iterator();

		ArrayList<Livro> res = new
			                       ArrayList<>();
		while(cur.hasNext()){
			Document next = cur.next();
			Livro currLivro = Livro.fromDocument(next);
			res.add(currLivro);
		}
		return res;
	}

	private static ArrayList<String> pesquisaAutor(String busca){
		ArrayList<String> autoresIds = new ArrayList<>();
		for(Document document : Autor.getCollection().find(regex("nome", busca, "i"))) {
			autoresIds.add(document.getObjectId(idFieldName).toString());
		}
		return autoresIds;
	}

	private static ArrayList<String> pesquisaEditora(String busca){
		ArrayList<String> editorasIds = new ArrayList<>();
		for(Document document : Editora.getCollection().find(regex("nome", busca, "i"))) {
			editorasIds.add(document.getObjectId(idFieldName).toString());
		}
		return editorasIds;
	}
}
