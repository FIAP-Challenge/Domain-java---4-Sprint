package br.com.merge.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *Classe que repesenta um Contato da Empresa
 *@author Henrique Cesar
 *@author Dennys Nascimenro 
 *@author Luan Reis
 *@author Gustavo Fonseca
 *
 */
@XmlRootElement
public class ContatoEmpresa {
	
	/**
	 * Armazena ddd, número de telefone
	 */
	private Integer nrDdd, nrTelefone;

	/**
	 * Armazena tipo de telefone
	 */
	private String tpTelefone;
	/**
	 * Construtor padrão
	 */
	public ContatoEmpresa() {
	}

	/**
	 * Construtor que recebe número dd, telefone
	 * @param nrDdd
	 * @param nrTelefone
	 * @param nrTeleMovel
	 */
	public ContatoEmpresa(Integer nrDdd, Integer nrTelefone, String tpTelefone) {
		this.nrDdd = nrDdd;
		this.nrTelefone = nrTelefone;
		this.tpTelefone = tpTelefone;
	}

	/**
	 * Retorna o ddd da empresa
	 * @return dd da empresa
	 */
	public Integer getNrDdd() {
		return nrDdd;
	}

	/**
	 * Altera o ddd da empresa
	 * @param Ddd da empresa
	 */
	public void setNrDdd(Integer nrDdd) {
		this.nrDdd = nrDdd;
	}
	
	/**
	 * Retorna o telefone da empresa
	 * @return telefone da empresa
	 */
	public Integer getNrTelefone() {
		return nrTelefone;
	}

	/**
	 * Altera o telefone da empresa
	 * @param telefone da empresa
	 */
	public void setNrTelefone(Integer nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	/**
	 * Retorna o tipo telefone da empresa
	 * @return tipo telefone da empresa
	 */
	public String getTpTelefone() {
		return tpTelefone;
	}

	/**
	 * Retorna o tipo telefone da empresa
	 * @return tipo telefone da empresa
	 */
	public void setTpTelefone(String tpTelefone) {
		this.tpTelefone = tpTelefone;
	}

}
