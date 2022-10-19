package br.com.merge.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *Classe que repesenta um Candidato
 *@author Henrique Cesar
 *@author Dennys Nascimenro 
 *@author Luan Reis
 *@author Gustavo Fonseca
 *
 */

@XmlRootElement
public class Candidato {
	
	
	private int codigo;

	/**
	 *Armazena o nome, cpf, estado civil, sexo, email e senha  
	 */
    private String nome, cpf, sexo, email, senhaLogin;
    
    /**
     * Armazena o estado civil;
     */
    private String estadoCivil;
    
    /**
     * Armazena a data de nascimento
     */
    private String dtNascimento;
    
    /**
     * Armazena o telefone
     */
    private Telefone telefone;
    
    /**
     * Armazena endereco
     */
    private Endereco endereco;
    
    /**
     * Armazena o curriculo
     */
    private Curriculo curriculo;    
    
    /**
     * Armazena o status do login
     */
    private String statusLogin;
    
    /**
     * Armazena o tipo de login
     */
    private String tipoLogin;
    
    /**
     * Armazena o resultato do DISC
     */
    private Disc disc;
    
    /**
     * Construtor padrão sem atributos
     */
    public Candidato(){
    }

    /**
     * Construtor com atributos
     * @param codigo
     * @param nome
     * @param cpf
     * @param sexo
     * @param email
     * @param senhaLogin
     * @param estadoCivil
     * @param dtNascimento
     * @param telefone
     * @param endereco
     * @param statusLogin
     * @param tipoLogin
     */
	public Candidato(
			int codigo, String nome, String cpf, String sexo, String email, String senhaLogin,
			String estadoCivil, String dtNascimento, Telefone telefone, Endereco endereco,
			String statusLogin, String tipoLogin) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.senhaLogin = senhaLogin;
		this.estadoCivil = estadoCivil;
		this.dtNascimento = dtNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.statusLogin = statusLogin;
		this.tipoLogin = tipoLogin;
		
	
	}

	/**
	 * Construtor com atributos
	 * @param codigo
	 * @param nome
	 * @param cpf
	 * @param dtNascimento
	 * @param estadoCivil
	 * @param sexo
	 * @param email
	 * @param endereco
	 * @param senhaLogin
	 * @param statusLogin
	 * @param tipoLogin
	 */
	public Candidato(
			int codigo, String nome, String cpf, String dtNascimento, String estadoCivil, String sexo,
			String email, Endereco endereco, String senhaLogin, String statusLogin, String tipoLogin) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.email = email;
		this.senhaLogin = senhaLogin;
		this.statusLogin = statusLogin;
		this.tipoLogin = tipoLogin;
	

	}
	
	/**
	 * Construtor com atributos
	 * @param codigo
	 * @param nome
	 * @param cpf
	 * @param dtNascimento
	 * @param estadoCivil
	 * @param sexo
	 * @param email
	 * @param senhaLogin
	 * @param statusLogin
	 * @param tipoLogin
	 */
	public Candidato(
			int codigo, String nome, String cpf, String dtNascimento, String estadoCivil, 
			String sexo, String email, String senhaLogin, String statusLogin, String tipoLogin) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.email = email;
		this.senhaLogin = senhaLogin;
		this.statusLogin = statusLogin;
		this.tipoLogin = tipoLogin;
		System.out.println("3 construtor" + codigo);

	}
	
	/**
	 * Construtor com atributos
	 * @param codigo
	 * @param nome
	 * @param cpf
	 * @param sexo
	 * @param email
	 * @param senhaLogin
	 * @param estadoCivil
	 * @param dtNascimento
	 * @param telefone
	 * @param endereco
	 * @param statusLogin
	 * @param tipoLogin
	 * @param disc
	 */
	public Candidato(
			int codigo, String nome, String cpf, String sexo, String email, String senhaLogin,
			String estadoCivil, String dtNascimento, Telefone telefone, Endereco endereco,
			String statusLogin, String tipoLogin, Disc disc) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.senhaLogin = senhaLogin;
		this.estadoCivil = estadoCivil;
		this.dtNascimento = dtNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.statusLogin = statusLogin;
		this.tipoLogin = tipoLogin;
		this.disc = disc;
		
	
	}	

	/**
	 * Construtor com atributos
	 * @param codigo
	 * @param nome
	 * @param cpf
	 * @param sexo 
	 * @param email
	 * @param senhaLogin
	 * @param estadoCivil
	 * @param dtNascimento
	 * @param telefone
	 * @param endereco
	 * @param curriculo
	 * @param statusLogin
	 * @param tipoLogin
	 * @param disc
	 */
	public Candidato(int codigo, String nome, String cpf, String sexo, String email, String senhaLogin,
			String estadoCivil, String dtNascimento, Telefone telefone, Endereco endereco, Curriculo curriculo,
			String statusLogin, String tipoLogin, Disc disc) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.senhaLogin = senhaLogin;
		this.estadoCivil = estadoCivil;
		this.dtNascimento = dtNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.curriculo = curriculo;
		this.statusLogin = statusLogin;
		this.tipoLogin = tipoLogin;
		this.disc = disc;
	}

	/**
	 * get de codigo
	 * @return codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * set de codigo
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna o nome do candidato
	 * @return nomde candidato
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do candidato
	 * @param nome do candidato
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o cpf do candidato
	 * @return cpf do candidato
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Altera o cpf do candidato
	 * @param cpf do candidato
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Retorna o estado civil do candidato
	 * @return estado civil do candidato
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * Altera o estado civil do candidato
	 * @param estado civil do candidato
	 */
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/**
	 * Retorna o sexo do candidato
	 * @return sexo do candidato
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Altera o sexo do candidato
	 * @param sexo do candidato
	 */
	public void setDsSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * Retorna o email do candidato
	 * @return email do candidato
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Altera o email do candidato
	 * @param email do candidato
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna a senha do candidato
	 * @return senha do candidato
	 */
	public String getSenhaLogin() {
		return senhaLogin;
	}

	/**
	 * Altera a senha do candidato
	 * @param senha do candidato
	 */
	public void setSenhaLogin(String senhaLogin) {
		this.senhaLogin = senhaLogin;
	}

	/**
	 * Retorna a data de nascimento do candidato
	 * @return data de nascimento candidato
	 */
	public String getDtNascimento() {
		return dtNascimento;
	}

	/**
	 * Altera a data de nascimento do candidato
	 * @param data de nascimento do candidato
	 */
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	/**
	 * Retorna um curriculo do candidato
	 * @return um curriculo do candidato
	 */
	public Curriculo getCurriculo() {
		return curriculo;
	}

	/**
	 * Altera o curriculo do candidato
	 * @param curriculo do candidato
	 */
	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	/**
	 * Retorna o endereco do candidato
	 * @return endereco do candidato
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	
	/**
	 * Altera o endereco do candidato
	 * @param endereco do candidato
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * Retorna o telefone do candidato
	 * @return telefone do candidato
	 */
	public Telefone getTelefone() {
		return telefone;
	}

	/**
	 * Altera o telefone do candidato
	 * @param telefone do candidato
	 */
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	/**
	 * Retorna o status do login
	 * @return status do login
	 */
	public String getStatusLogin() {
		return statusLogin;
	}

	/**
	 * Altera o status do login
	 * @param status do login
	 */
	public void setStatusLogin(String statusLogin) {
		this.statusLogin = statusLogin;
	}

	/**
	 * Retorna o tipo de login
	 * @return tipo de login
	 */
	public String getTipoLogin() {
		return tipoLogin;
	}

	/**
	 * Altera o tipo de login
	 * @param tipo de login
	 */
	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	/**
	 * Retorna o Disc
	 * @return Disc
	 */
	public Disc getDisc() {
		return disc;
	}

	/**
	 * Altera o disc
	 * @param disc
	 */
	public void setDisc(Disc disc) {
		this.disc = disc;
	}

	/**
	 * retorna o toString do candidato
	 * @return toString do candidato
	 */
	@Override
	public String toString() {
		return "Candidato [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", email=" + email
				+ ", senhaLogin=" + senhaLogin + ", estadoCivil=" + estadoCivil + ", dtNascimento=" + dtNascimento
				+ ", telefone=" + telefone + ", endereco=" + endereco + ", curriculo=" + curriculo + ", statusLogin="
				+ statusLogin + ", tipoLogin=" + tipoLogin + ", disc=" + disc + "]";
	}










	
	
	
	
	

}