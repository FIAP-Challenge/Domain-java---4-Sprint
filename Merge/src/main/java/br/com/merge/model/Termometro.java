package br.com.merge.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que representa um termometro
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */

@XmlRootElement
public class Termometro {

	/**
	 * Armazena o score do termometro
	 */
	private Integer nrScore;

	/**
	 * Método padrão
	 */
	public Termometro() {
	}

	/**
	 * Construtor que recebe o score do termometro
	 * 
	 * @param nrScore
	 */
	public Termometro(int nrScore) {
		this.nrScore = nrScore;
	}

	/**
	 * Retrona o numero do score do termometro
	 * 
	 * @return score do termometro
	 */
	public Integer getNrScore() {
		return nrScore;
	}

	/**
	 * Altera o score do termometro
	 * 
	 * @param numero do Score
	 */
	public void setNrScore(Integer nrScore) {
		this.nrScore = nrScore;
	}

}