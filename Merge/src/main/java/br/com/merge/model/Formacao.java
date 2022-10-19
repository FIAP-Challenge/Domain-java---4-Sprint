package br.com.merge.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que representa uma formacao
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */

@XmlRootElement
public class Formacao {

	/**
	 * Armazena o nome da formação
	 */
	private String nome;

	/**
	 * Construtor com atributos
	 * 
	 * @param nome da formação
	 */
	public Formacao(String nome) {
		super();
		this.nome = nome;
	}

	/**
	 * Construtor sem atributos
	 */
	public Formacao() {
	}

	/**
	 * Retorna o nome da formação
	 * 
	 * @return nome da formação
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome da formação
	 * 
	 * @param nome da formação
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}