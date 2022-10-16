package br.com.merge.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *Classe que repesenta um Curso do curriculo
 *@author Henrique Cesar
 *@author Dennys Nascimenro 
 *@author Luan Reis
 *@author Gustavo Fonseca
 *@author Rodrigo Machado
 *
 */
@XmlRootElement
public class Curso {
	

	
	private String nome;
	
	
	
	

	



	public Curso(String nome) {
		super();
		this.nome = nome;
	}







	public String getNome() {
		return nome;
	}







	public void setNome(String nome) {
		this.nome = nome;
	}







	public Curso() {
		super();
	}




	
	
	
	
	
	
}