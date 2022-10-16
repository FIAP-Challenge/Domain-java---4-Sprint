package br.com.merge.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *Classe que repesenta um Curso do curriculo
 *@author Henrique Cesar
 *@author Dennys Nascimenro 
 *@author Luan Reis
 *@author Gustavo Fonseca
 *
 */
@XmlRootElement
public class Curso {
	

	/**
	 * Armazena o nome do curso
	 */
	private String nome;
	
	/**
	 * Construtor sem atributos
	 */
	public Curso() {
	}
	
	/**
	 * Construtor com atributos
	 * @param nome
	 */
	public Curso(String nome) {
		super();
		this.nome = nome;
	}

	/**
	 * Retorna o nome do curso
	 * @return nome do curso
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do curso
	 * @param nome do curso
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}