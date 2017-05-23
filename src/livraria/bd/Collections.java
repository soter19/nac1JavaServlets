package livraria.bd;

/**
 * Forged by Soter Padua on 12/04/17.
 */
public enum Collections {
	LIVROS("livros"),
	ADMINS("admins"),
	AUTORES("autores"),
	ASSUNTOS("assuntos"),
	USUARIOS("usuarios"),
	EDITORAS("editoras");

	final public String nome;
	Collections(final String nome) {
		this.nome = nome;
	}
}
