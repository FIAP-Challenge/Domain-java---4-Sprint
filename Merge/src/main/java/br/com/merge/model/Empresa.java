package br.com.merge.model;


import javax.xml.bind.annotation.XmlRootElement;

/**
 *Classe que repesenta uma Empresa
 *@author Henrique Cesar
 *@author Dennys Nascimenro 
 *@author Luan Reis
 *@author Gustavo Fonseca
 *@author Rodrigo Machado
 *
 */

@XmlRootElement
public class Empresa {
	

	private int codigo;

	private String descricao;
	
	private String nome;
	
	private String cnpj;
	
	private String responsavel;
	
	private String email;
	
	private String senha;
	
	private Telefone telefone;
	
	private Endereco endereco;
	
	private String statusLogin;
	
	private String tipoLogin;
	

	
	
	
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
	
	

	public Empresa() {
		super();
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Telefone getTelefone() {
		return telefone;
	}


	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}


	public String getStatusLogin() {
		return statusLogin;
	}

	public void setStatusLogin(String statusLogin) {
		this.statusLogin = statusLogin;
	}

	public String getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	@Override
	public String toString() {
		return "Empresa [codigo=" + codigo + ", descricao=" + descricao + ", nome=" + nome + ", cnpj=" + cnpj
				+ ", responsavel=" + responsavel + ", email=" + email + ", senha=" + senha + ", statusLogin="
				+ statusLogin + ", tipoLogin=" + tipoLogin + "]";
	}
	
		
}