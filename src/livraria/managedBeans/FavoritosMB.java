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
	private ArrayList<Livro> livrosFavoritos = new ArrayList<>();

	public ArrayList<Livro> getLivrosFavoritos() {
		return livrosFavoritos;
	}

	public void adicionarAosFavoritos(Livro l){
		livrosFavoritos.add(l);
	}

	public void removerDosFavoritos(Livro l){
		livrosFavoritos.remove(l);
	}

}
