package livraria.managedBeans;

import livraria.beans.Livro;
import livraria.bo.PesquisaBO;
import livraria.utils.NomesPaginas;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;

/**
 * Forged by Soter Padua on 03/04/17.
 */
@ManagedBean
@RequestScoped
public class PesquisaMB {
	private String           pesquisaString;
	private ArrayList<Livro> livrosResultados;

	private String paTitulo;
	private String paAutor;
	private String paAssunto;
	private String paEditora;

	public String getPaTitulo() {
		return paTitulo;
	}

	public void setPaTitulo(String paTitulo) {
		this.paTitulo = paTitulo;
	}

	public String getPaAutor() {
		return paAutor;
	}

	public void setPaAutor(String paAutor) {
		this.paAutor = paAutor;
	}

	public String getPaAssunto() {
		return paAssunto;
	}

	public void setPaAssunto(String paAssunto) {
		this.paAssunto = paAssunto;
	}

	public String getPaEditora() {
		return paEditora;
	}

	public void setPaEditora(String paEditora) {
		this.paEditora = paEditora;
	}

	public void setPesquisaString(String pesquisaString) {
		this.pesquisaString = pesquisaString;
	}

	public String getPesquisaString() {

		return pesquisaString;
	}

	public ArrayList<Livro> getLivrosResultados() {
		return livrosResultados;
	}

	public void setLivrosResultados(ArrayList<Livro> livrosResultados) {
		this.livrosResultados = livrosResultados;
	}

	public String getErro() {
		return erro;
	}

	//Propriedades de saída (Placeholders)
	private String erro;

	public String pesquisar(){
		try {
			livrosResultados = PesquisaBO.pesquisaSimples(pesquisaString);
		}catch(Exception e){
			erro = e.getMessage();
		}
		return NomesPaginas.PESQUISA.nome;
	}
}
