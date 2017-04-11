package beans;

import bo.LivroBO;
import bo.PesquisaBO;
import utils.NomesPaginas;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;

/**
 * Forged by Soter Padua on 03/04/17.
 */
@ManagedBean
public class PesquisaBean {
	private String    pesquisaString;
	private ArrayList<LivroBO> livrosResultados;

	public void setPesquisaString(String pesquisaString) {
		this.pesquisaString = pesquisaString;
	}

	public String getPesquisaString() {

		return pesquisaString;
	}

	public ArrayList<LivroBO> getLivrosResultados() {
		return livrosResultados;
	}

	public void setLivrosResultados(ArrayList<LivroBO> livrosResultados) {
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
