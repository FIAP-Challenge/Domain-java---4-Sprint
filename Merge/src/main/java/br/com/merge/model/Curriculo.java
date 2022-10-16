package br.com.merge.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *Classe que repesenta um  Curriculo
 *@author Henrique Cesar
 *@author Dennys Nascimenro 
 *@author Luan Reis
 *@author Gustavo Fonseca
 *@author Rodrigo Machado
 *
 */
@XmlRootElement
public class Curriculo {
	
	/**
	 * Armazana uma coleção de cursoss do candidato
	 */
	private int codigo;
	
	
	
	private List<Curso> cursos;
	
	/**
	 * Armazena uma coleçaõ de formações do candidato
	 */
	private List<Formacao> formacoes;
	
	/**
	 * Armazena uma coleção de idiomas do candidato
	 */
	private List<Idiomas> idiomas;
	

	private String data;
	/**
	 * Construtor padrão
	 */
	public Curriculo() {
	}


	public Curriculo(int codigo,List<Curso> cursos, List<Formacao> formacoes, List<Idiomas> idiomas,  String data) {
		super();
		this.codigo = codigo;
		this.cursos = cursos;
		this.formacoes = formacoes;
		this.idiomas = idiomas;
		this.data = data;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public List<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}


	public List<Formacao> getFormacoes() {
		return formacoes;
	}


	public void setFormacoes(List<Formacao> formacoes) {
		this.formacoes = formacoes;
	}


	public List<Idiomas> getIdiomas() {
		return idiomas;
	}


	public void setIdiomas(List<Idiomas> idiomas) {
		this.idiomas = idiomas;
	}


	@Override
	public String toString() {
		return "Curriculo [codigo=" + codigo + ", data=" + data + ", cursos=" + cursos + ", formacoes=" + formacoes
				+ ", idiomas=" + idiomas + "]";
	}


	
	
	

	
	
	
}
