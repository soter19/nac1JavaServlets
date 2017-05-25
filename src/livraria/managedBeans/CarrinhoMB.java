package livraria.managedBeans;

import livraria.beans.Livro;
import net.bootsfaces.utils.FacesMessages;

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
	private double valorFrete;
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
			Double novoValor = l.getValor();
			if(l.getDesconto() != null){
				novoValor = l.getValor() - (l.getValor()/100 * l.getDesconto());
			}
			total += novoValor * l.getQuantidade();
		}
		valorTotal = total + valorFrete;
	}

	public ArrayList<Livro> getCarrinho() {
		return carrinho;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public void setSedex(){
		valorFrete = 5;
		CalculaValorTotal();
	}

	public void setExpresso(){
		valorFrete = 10;
		CalculaValorTotal();
	}

	public void finalizarCompra(){
		carrinho = new ArrayList<>();
		valorTotal = 0;
		valorFrete = 0;
		FacesMessages.info("Compra efetuada com sucesso!");
	}
}
