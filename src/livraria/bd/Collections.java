package livraria.bd;

/**
 * Forged by Soter Padua on 12/04/17.
 */
public enum Collections {
	LIVROS("livros"),
	AUTORES("autores"),
	ASSUNTOS("assuntos"),
	USUARIOS("usuarios");

	final public String nome;
	Collections(final String nome) {
		this.nome = nome;
	}
}
