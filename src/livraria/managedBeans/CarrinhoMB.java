package livraria.managedBeans;

import livraria.beans.Livro;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.*;

/**
 * Forged by Soter Padua on 23/05/17.
 */
@ManagedBean
@SessionScoped
public class CarrinhoMB {
	private ArrayList<Livro> carrinho = new ArrayList<>();
	private double valorTotal;

	public void adicionaAoCarrinho(Livro l){
		if(!carrinho.contains(l)){
			carrinho.add(l);
		}
		CalculaValorTotal();
	}

	public void remover(Livro l){
		carrinho.remove(l);
	}

	public void CalculaValorTotal(){
		double total = 0;
		for(Livro l : carrinho){
			total += l.getValor() * l.getQuantidade();
		}
		valorTotal = total;
	}

	public ArrayList<Livro> getCarrinho() {
		return carrinho;
	}

	public double getValorTotal() {
		return valorTotal;
	}
}
