package managedBeans;

import beans.Livro;
import bo.PesquisaBO;
import utils.NomesPaginas;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

/**
 * Forged by Soter Padua on 03/04/17.
 */
@ManagedBean
public class PesquisaBean {
	private String           pesquisaString;
	private ArrayList<Livro> livrosResultados;

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

	//Propriedades de saída (Placeholders)
	private String erro;

	public String pesquisar(){
		try {
			livrosResultados = PesquisaBO.pesquisa(pesquisaString);
		}catch(Exception e){
			erro = e.getMessage();
		}
		return NomesPaginas.PESQUISA.nome;
	}
}
