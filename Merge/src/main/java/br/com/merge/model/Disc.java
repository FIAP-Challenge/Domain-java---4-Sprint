package br.com.merge.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que repesenta o DISC
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
@XmlRootElement
public class Disc {

	/**
	 * Armazena o codigo, dominante, estavel, influente, condescendente
	 */
	private int codigo, dominante, estavel, influente, condescendente;

	/**
	 * Construtor sem atributos
	 */
	public Disc() {
		super();
	}

	/**
	 * Construtor com atributos
	 * 
	 * @param codigo
	 * @param dominante
	 * @param estavel
	 * @param influente
	 * @param condescendente
	 */
	public Disc(int codigo, int dominante, int estavel, int influente, int condescendente) {
		super();
		this.codigo = codigo;
		this.dominante = dominante;
		this.estavel = estavel;
		this.influente = influente;
		this.condescendente = condescendente;
	}

	/**
	 * Construtor com atributos
	 * 
	 * @param dominante, estavel, influente, condescendente
	 */
	public Disc(int dominante, int estavel, int influente, int condescendente) {
		super();
		this.dominante = dominante;
		this.estavel = estavel;
		this.influente = influente;
		this.condescendente = condescendente;
	}

	/**
	 * Retorna o codigo do DISC
	 * 
	 * @return codigo do DISC
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Altera o codigo do DISC
	 * 
	 * @param codigo do DISC
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna o valor dominante
	 * 
	 * @return valor dominante
	 */
	public int getDominante() {
		return dominante;
	}

	/**
	 * Altera o valor dominante
	 * 
	 * @param valor dominante
	 */
	public void setDominante(int dominante) {
		this.dominante = dominante;
	}

	/**
	 * Retorna o valor influente
	 * 
	 * @return valor influente
	 */
	public int getInfluente() {
		return influente;
	}

	/**
	 * Altera o valor influente
	 * 
	 * @param valor influente
	 */
	public void setInfluente(int influente) {
		this.influente = influente;
	}

	/**
	 * Retorna o valor estavel
	 * 
	 * @return valor estavel
	 */
	public int getEstavel() {
		return estavel;
	}

	/**
	 * Altera o valor estavel
	 * 
	 * @param valor estavel
	 */
	public void setEstavel(int estavel) {
		this.estavel = estavel;
	}

	/**
	 * Retorna o valor condescendente
	 * 
	 * @return valor condescendente
	 */
	public int getCondescendente() {
		return condescendente;
	}

	/**
	 * Altera o valor condescendente
	 * 
	 * @param valor condescendente
	 */
	public void setCondescendente(int condescendente) {
		this.condescendente = condescendente;
	}

	/**
	 * retorna o toString do DISC
	 * 
	 * @return toString do DISC
	 */
	@Override
	public String toString() {
		return "Disc [dominante=" + dominante + ", influente=" + influente + ", estavel=" + estavel
				+ ", condescendente=" + condescendente + "]";
	}

}
