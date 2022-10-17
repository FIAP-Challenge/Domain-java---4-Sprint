package br.com.merge.model;

/**
 * Classe que repesenta o login do usuario
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class LoginUser {

	/**
	 * Armazena o email e a senha do usuario
	 */
	private String email, senha;

	/**
	 * Construtor sem atributos
	 */
	public LoginUser() {
		super();
	}

	/**
	 * Construtor com atributos
	 * 
	 * @param email do usuario
	 * @param senha do usuario
	 */
	public LoginUser(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	/**
	 * Retorna o email do usuario
	 * 
	 * @return email do usuario
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Altera o email do usuario
	 * 
	 * @param email do usuario
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna o senha do usuario
	 * 
	 * @return senha do usuario
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Altera o senha do usuario
	 * 
	 * @param senha do usuario
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * retorna o toString do login do usuario
	 * 
	 * @return toString do login do usuario
	 */
	@Override
	public String toString() {
		return "LoginUser [email=" + email + ", senha=" + senha + "]";
	}

}
