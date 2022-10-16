package br.com.merge.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Disc {

	private int codigo;
	
	private int dominante;
		
	private int estavel;
	
	private int influente;
	
	private int condescendente;
	
	

	public Disc() {
		super();
	}
	
	public Disc(int codigo, int dominante,  int estavel, int influente, int condescendente) {
		super();
		this.codigo = codigo;
		this.dominante = dominante;
		this.estavel = estavel;
		this.influente = influente;
		this.condescendente = condescendente;
	}


	public Disc(int dominante, int estavel, int influente, int condescendente) {
		super();
		this.dominante = dominante;
		this.estavel = estavel;
		this.influente = influente;
		this.condescendente = condescendente;
	}

	

	
		
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getDominante() {
		return dominante;
	}


	public void setDominante(int dominante) {
		this.dominante = dominante;
	}


	public int getInfluente() {
		return influente;
	}


	public void setInfluente(int influente) {
		this.influente = influente;
	}


	public int getEstavel() {
		return estavel;
	}


	public void setEstavel(int estavel) {
		this.estavel = estavel;
	}


	public int getCondescendente() {
		return condescendente;
	}


	public void setCondescendente(int condescendente) {
		this.condescendente = condescendente;
	}


	@Override
	public String toString() {
		return "Disc [dominante=" + dominante + ", influente=" + influente + ", estavel=" + estavel
				+ ", condescendente=" + condescendente + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
