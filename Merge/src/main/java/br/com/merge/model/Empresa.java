package br.com.merge.model;


import javax.xml.bind.annotation.XmlRootElement;

/**
 *Classe que repesenta uma Empresa
 *@author Henrique Cesar
 *@author Dennys Nascimenro 
 *@author Luan Reis
 *@author Gustavo Fonseca
 *
 */

@XmlRootElement
public class Empresa {
	
	/**
	 * Armazena o codigo da empresa
	 */
	private int codigo;

	/**
	 * Armazena a descricao, nome, cnpj, responsavel, email, senha, statusLogin e o tipoLogin da empresa
	 */
	private String descricao, nome, cnpj, responsavel, email, senha, statusLogin, tipoLogin;
	
	/**
	 * Armazena o telefone da empresa
	 */
	private Telefone telefone;
	
	/**
	 * Armazena o endereco da empresa
	 */
	private Endereco endereco;

	/**
	 * Construtor sem atributos
	 */
	public Empresa() {
	}
	
	/**
	 * Construtor com atributos
	 * @param codigo
	 * @param descricao
	 * @param nome
	 * @param cnpj
	 * @param responsavel
	 * @param email
	 * @param senha
	 * @param statusLogin
	 * @param tipoLogin da empresa
	 */
	public Empresa(int codigo, String descricao, String nome, String cnpj, String responsavel, String email,
			String senha, String statusLogin, String tipoLogin) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.nome = nome;
		this.cnpj = cnpj;
		this.responsavel = responsavel;
		this.email = email;
		this.senha = senha;
		this.statusLogin = statusLogin;
		this.tipoLogin = tipoLogin;
	}
	
	/**
	 * Construtor com atributos 
	 * @param codigo
	 * @param descricao
	 * @param nome
	 * @param cnpj
	 * @param responsavel
	 * @param email
	 * @param senha
	 * @param endereco
	 * @param telefone
	 * @param statusLogin
	 * @param tipoLogin da empresa
	 */
	public Empresa(int codigo, String descricao, String nome, String cnpj, String responsavel, String email,
			String senha, Endereco endereco, Telefone telefone, String statusLogin, String tipoLogin) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.nome = nome;
		this.cnpj = cnpj;
		this.responsavel = responsavel;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone = telefone;
		this.statusLogin = statusLogin;
		this.tipoLogin = tipoLogin;
	}

	/**
	 * retorna o codigo da empresa
	 * @return codigo da empresa
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Altera o codigo da empresa
	 * @param codigo da empresa
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * retorna a descrição da empresa
	 * @return descrição da empresa
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Altera a descricao da empresa
	 * @param descricao da empresa
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * retorna o nome da empresa
	 * @return nome da empresa
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome da empresa
	 * @param nome da empresa
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * retorna o cnpj da empresa
	 * @return cnpj da empresa
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * Altera o cnpj da empresa
	 * @param cnpj da empresa
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * retorna o responsavel da empresa
	 * @return responsavel da empresa
	 */
	public String getResponsavel() {
		return responsavel;
	}

	/**
	 * Altera o responsavel da empresa
	 * @param responsavel da empresa
	 */
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	/**
	 * retorna o email da empresa
	 * @return email da empresa
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Altera o email da empresa
	 * @param email da empresa
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * retorna a senha da empresa
	 * @return senha da empresa
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Altera a senha da empresa
	 * @param senha da empresa
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * retorna o endereco da empresa
	 * @return endereco da empresa
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * Altera o endereco da empresa
	 * @param endereco da empresa
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * retorna o telefone da empresa
	 * @return telefone da empresa
	 */
	public Telefone getTelefone() {
		return telefone;
	}

	/**
	 * Altera o telefone da empresa
	 * @param telefone da empresa
	 */
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	/**
	 * retorna o status do Login da empresa
	 * @return status do Login da empresa
	 */
	public String getStatusLogin() {
		return statusLogin;
	}

	/**
	 * Altera o status do Login da empresa
	 * @param status do Login da empresa
	 */
	public void setStatusLogin(String statusLogin) {
		this.statusLogin = statusLogin;
	}

	/**
	 * retorna o tipo do Login da empresa
	 * @return tipo do Login da empresa
	 */
	public String getTipoLogin() {
		return tipoLogin;
	}

	/**
	 * Altera o tipo do Login da empresa
	 * @param tipo do Login da empresa
	 */
	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	/**
	 * retorna o toString da empresa
	 * @return toString da empresa
	 */
	@Override
	public String toString() {
		return "Empresa [codigo=" + codigo + ", descricao=" + descricao + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", responsavel=" + responsavel + ", email=" + email + ", senha=" + senha + ", statusLogin="
				+ statusLogin + ", tipoLogin=" + tipoLogin + "]";
	}
	
		
}