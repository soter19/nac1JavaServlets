package bo;

import beans.Autor;
import beans.Livro;
import managedBeans.AutorBean;
import managedBeans.EditoraBean;
import utils.Helper;

import java.util.ArrayList;

/**
 * Forged by Soter Padua on 03/04/17.
 */
public class PesquisaBO {
	public static ArrayList<Livro> pesquisa(String livro) throws Exception {
		if(Helper.isNullOrEmpty(livro)){
			throw new Exception();
		}
		//TODO: CHAMADA PARA O BD COM A QUERY, ASSIM QUE RECUPERARMOS RESULTADO ITERAR E GUARDAR NO ARRAYLIST.
		ArrayList<Livro> res = new ArrayList<Livro>();
		Livro            a   = new Livro();
		a.setTitulo("fodase");
		a.setAutor(new Autor());
		res.add(a);
		return res;
	}

	public AutorBean pesquisa(AutorBean autor){
		return null;
	}

	public EditoraBean pesquisa(EditoraBean autor){
		return null;
	}

	public managedBeans.LivroBean pesquisa(managedBeans.LivroBean autor){
		return null;
	}
}
