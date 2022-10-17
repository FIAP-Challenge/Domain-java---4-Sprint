package br.com.merge.model;

/**
 * Classe que repesenta uma Habilidade
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class Habilidades {

	/**
	 * Armazena um nome da habilidade
	 */
	private String nmHab;

	/**
	 * Construtor que recebe o nome da habilidade
	 * 
	 * @param nmHabilidade
	 */
	public Habilidades(String nmHab) {
		this.nmHab = nmHab;
	}

	/**
	 * Retorna o nome da habilidade do candidato
	 * 
	 * @return o nome da habilidade
	 */
	public String getNmHabilidade() {
		return nmHab;
	}

	/**
	 * Altera o nome da habilidade do candidato
	 * 
	 * @param o nome da habilidade
	 */
	public void setNmHabilidade(String nmHab) {
		this.nmHab = nmHab;
	}

}
