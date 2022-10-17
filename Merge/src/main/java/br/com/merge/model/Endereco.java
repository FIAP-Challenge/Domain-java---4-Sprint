package br.com.merge.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que repesenta um Endereco
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
@XmlRootElement
public class Endereco {
	private int codigo;

	/**
	 * Armazena o cep,logradouro, numeroLogradouro, bairro, complemento, cidade,
	 * estado e a siglaEstado
	 */
	private String cep, logradouro, numeroLogradouro, bairro, complemento, cidade, estado, siglaEstado;

	/**
	 * 
	 * Construtor padrão
	 */
	public Endereco() {
	}

	/**
	 * Construtor que recebe cep, bairro, logradouro, complememto, descrição do
	 * ponto de referencia, cidade, Estado , sigla do Estado e nome do pais e numero
	 * do logradouro
	 * 
	 * @param cep
	 * @param nome      Bairro
	 * @param nome      Logradouro
	 * @param descrição do Complemento
	 * @param descriçaõ do PontoReferencia
	 * @param nome      da Cidade
	 * @param nome      do Estado
	 * @param sigla     do Estado
	 * @param nome      do Pais
	 * @param numero    Logradouro
	 */
	public Endereco(int codigo, String cep, String bairro, String numeroLogradouro, String logradouro,
			String complemento, String cidade, String estado, String siglaEstado) {
		this.codigo = codigo;
		this.cep = cep;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.siglaEstado = siglaEstado;
		this.numeroLogradouro = numeroLogradouro;
	}

	/**
	 * construtor com atributos
	 * 
	 * @param cep
	 * @param bairro
	 * @param numeroLogradouro
	 * @param logradouro
	 * @param complemento
	 * @param cidade
	 * @param estado
	 * @param siglaEstado
	 */
	public Endereco(String cep, String bairro, String numeroLogradouro, String logradouro, String complemento,
			String cidade, String estado, String siglaEstado) {
		this.cep = cep;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.siglaEstado = siglaEstado;
		this.numeroLogradouro = numeroLogradouro;
	}

	/**
	 * Retorna o codigo do endereco
	 * 
	 * @return codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * Altera o codigo do endereco
	 * 
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna o cep do endereco
	 * 
	 * @return cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Altera o cep do endereco
	 * 
	 * @param cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Retorna o nome do bairro do endereco
	 * 
	 * @return nome do bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Altera o nome do bairro do endereco
	 * 
	 * @param nome do Bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Retorna o nome do logradouro do endereco
	 * 
	 * @return o nome do logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Altera o nome do logradouro do endereco
	 * 
	 * @param nome do logradouro
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * Retorna a descrição do complemento do endereco
	 * 
	 * @return a descrição do complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * Altera a descrição do complemento do endereco
	 * 
	 * @param a descrição do complemento
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Retorna o nome da cidade do endereco
	 * 
	 * @return o nome da cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Altera o nome da cidade do endereco
	 * 
	 * @param o nome da cidade do endereco
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Retorna o nome do Estado do endereco
	 * 
	 * @return o nome do Estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Altera o nome do Estado do endereco
	 * 
	 * @param o nome do Estado do endereco
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Retorna o nome da sigla do Estado do endereco
	 * 
	 * @return o nome da sigla do Estado
	 */
	public String getSiglaEstado() {
		return siglaEstado;
	}

	/**
	 * Altera nome da sigla do Estado do endereco
	 * 
	 * @param o nome da sigla do Estado do endereco
	 */
	public void getSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	/**
	 * Retorna o numero do logradouro do endereco
	 * 
	 * @return o numero do logradouro do endereco
	 */
	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	/**
	 * Altera o numero do logradouro do endereco
	 * 
	 * @param o numero do logradouro do endereco
	 */
	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	/**
	 * retorna o toString do Endereco
	 * 
	 * @return toString do Endereco
	 */
	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", bairro=" + bairro + ", logradouro=" + logradouro + ", complemento="
				+ complemento + ", cidade=" + cidade + ", estado=" + estado + ", siglaEstado=" + siglaEstado
				+ ", numeroLogradouro=" + numeroLogradouro + ", codigo=" + codigo + "]";
	}

}