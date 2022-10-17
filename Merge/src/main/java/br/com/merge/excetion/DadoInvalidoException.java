package br.com.merge.excetion;

/**
 * Classe para exception de dado invalidado
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class DadoInvalidoException extends Exception {

	/**
	 * Atributo da mensagem
	 */
	private String mensagem;

	/**
	 * Construtor com mensagem de dado invalido
	 */
	public DadoInvalidoException() {
		super("Dado invalido");
	}

	/**
	 * Construtor com parametro da mensagem
	 * 
	 * @param msg
	 */
	public DadoInvalidoException(String msg) {
		this.mensagem = msg;
	}

	/**
	 * Getter da mensagem
	 * 
	 * @return mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * Setter da mensagem
	 * 
	 * @param mensagem
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
