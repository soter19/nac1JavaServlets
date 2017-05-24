package livraria.managedBeans;

import livraria.beans.Livro;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import java.util.ArrayList;

/**
 * Forged by Soter Padua on 23/05/17.
 */
@ManagedBean
@SessionScoped
public class CarrinhoMB {
	private ArrayList<Livro> carrinho = new ArrayList<>();

	public ArrayList<Livro> getCarrinho() {
		return carrinho;
	}

	public void adicionaAoCarrinho(Livro l){
		if(!carrinho.contains(l)){
			carrinho.add(l);
		}
	}

	public void remover(Livro l){
		carrinho.remove(l);
	}

	public double valorTotal(){
		double total = 0;
		for(Livro l : carrinho){
			total += l.getValor();
		}
		return total;
	}
}
