package br.com.merge.excetion;

/**
 * Classe de exception para id não encontrado
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class IdNotFoundException extends Exception {

	/**
	 * Construtor vazio da exception
	 */
	public IdNotFoundException() {
	}

	/**
	 * Construtor com parametro da mensagem
	 * @param msg
	 */
	public IdNotFoundException(String msg) {
		super(msg);
	}

}
