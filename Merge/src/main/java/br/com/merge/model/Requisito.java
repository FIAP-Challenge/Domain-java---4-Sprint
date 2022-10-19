package br.com.merge.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que repesenta o requisito para vaga
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
@XmlRootElement
public class Requisito {

	/**
	 * Armazena o nome do requisito
	 */
	private String nome;

	/**
	 * Construtor com atributos
	 * 
	 * @param nome do requisito
	 */
	public Requisito(String nome) {
		super();
		this.nome = nome;
	}

	/**
	 * Construtor sem atributos
	 */
	public Requisito() {
		super();
	}

	/**
	 * Retorna o nome do requisito
	 * 
	 * @return nome do requisito
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do requisito
	 * 
	 * @param nome do requisito
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}