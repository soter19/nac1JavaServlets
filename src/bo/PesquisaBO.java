package bo;

import beans.AutorBean;
import beans.EditoraBean;
import beans.LivroBean;
import utils.Helper;

import java.util.ArrayList;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class PesquisaBO {

	public ArrayList<LivroBO> pesquisa(String livro) throws Exception {
		if(Helper.isNullOrEmpty(livro)){
			throw new Exception();
		}
		ArrayList<LivroBO> res = new ArrayList<LivroBO>();

		//TODO: CHAMADA PARA O BD COM A QUERY, ASSIM QUE RECUPERARMOS RESULTADO ITERAR E GUARDAR NO ARRAYLIST.

		return res;
	}

	public AutorBean pesquisa(AutorBean autor){
		return null;
	}

	public EditoraBean pesquisa(EditoraBean autor){
		return null;
	}

	public LivroBean pesquisa(LivroBean autor){
		return null;
	}
}
