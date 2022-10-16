package br.com.merge.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *Classe que repesenta um Idioma
 *@author Henrique Cesar
 *@author Dennys Nascimenro 
 *@author Luan Reis
 *@author Gustavo Fonseca
 *@author Rodrigo Machado
 *
 */

@XmlRootElement
public class Idiomas {

	private String nome;
	
	
	

	public Idiomas(String nome) {
		super();
		this.nome = nome;
	}
	


	public Idiomas() {
		super();
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	@Override
	public String toString() {
		return "Idiomas [nome=" + nome + "]";
	}
	
	
	
	
}