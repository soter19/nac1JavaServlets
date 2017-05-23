package livraria.managedBeans;

import livraria.beans.Livro;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

/**
 * Forged by Soter Padua on 23/05/17.
 */
@ManagedBean
public class CarrinhoMB {
	static ArrayList<Livro> carrinho;

	public Boolean adicionaCarrinho(){
		return false;
	}

	public Boolean adicionaFavorito(){
		return false;
	}
}
