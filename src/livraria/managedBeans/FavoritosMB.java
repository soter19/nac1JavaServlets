package livraria.managedBeans;

import livraria.beans.Livro;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

/**
 * Forged by Soter Padua on 23/05/17.
 */

@ManagedBean
@SessionScoped
public class FavoritosMB {
	private static ArrayList<Livro> livrosFavoritos = new ArrayList<>();

	public static ArrayList<Livro> getLivrosFavoritos() {
		return livrosFavoritos;
	}

	public static void adicionarAosFavoritos(Livro l){
		livrosFavoritos.add(l);
	}
}
