package br.com.merge.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que repesenta um Idioma
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */

@XmlRootElement
public class Idiomas {

	/**
	 * armazena o nome do idioma
	 */
	private String nome;

	/**
	 * construtor com atributos
	 * 
	 * @param nome do idioma
	 */
	public Idiomas(String nome) {
		super();
		this.nome = nome;
	}

	/**
	 * Costrutor sem atributos
	 */
	public Idiomas() {
		super();
	}

	/**
	 * Retorna o nome do idioma
	 * 
	 * @return nome do idioma
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do idioma
	 * 
	 * @param nome do idioma
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * retorna o toString do idioma
	 * 
	 * @return toString do idioma
	 */
	@Override
	public String toString() {
		return "Idiomas [nome=" + nome + "]";
	}

}