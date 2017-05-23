package livraria.utils;

/**
 * ENUM responsável por guardar todos os nomes de páginas, para facilitar
 * quando o retorno dos beans.
 */
public enum NomesPaginas {
	INDEX("index"),
	CARRINHO("carrinho"),
	PESQUISA("pesquisa"),
	LOGIN("login");

	final public String nome;
	NomesPaginas(final String nome) {
		this.nome = nome;
	}
}
