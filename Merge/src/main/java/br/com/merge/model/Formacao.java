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

	private String nome;

	
	
	

	public Formacao(String nome) {
		super();
		this.nome = nome;
	}





	public Formacao() {
		super();
	}





	public String getNome() {
		return nome;
	}





	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
	
	
	
	
	
	
	
	
	


}