package br.com.merge.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que repesenta um Curriculo
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
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

	/**
	 * Construtor com atributos
	 * 
	 * @param codigo
	 * @param Lista  de cursos
	 * @param Lista  de Formações
	 * @param Lista  de idiomas
	 * @param data
	 */
	public Curriculo(int codigo, List<Curso> cursos, List<Formacao> formacoes, List<Idiomas> idiomas, String data) {
		super();
		this.codigo = codigo;
		this.cursos = cursos;
		this.formacoes = formacoes;
		this.idiomas = idiomas;
		this.data = data;
	}

	/**
	 * Retorna o codigo do curriculo
	 * 
	 * @return codigo do curriculo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Altera o codigo do curriculo
	 * 
	 * @param codigo do curriculo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna a data do curriculo
	 * 
	 * @return data do curriculo
	 */
	public String getData() {
		return data;
	}

	/**
	 * Altera a data do curriculo
	 * 
	 * @param data do curriculo
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * Retorna a lista de cursos do curriculo
	 * 
	 * @return lista de cursos do curriculo
	 */
	public List<Curso> getCursos() {
		return cursos;
	}

	/**
	 * Altera a lista de cursos do curriculo
	 * 
	 * @param lista de cursos do curriculo
	 */
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	/**
	 * Retorna a lista de formacoes do curriculo
	 * 
	 * @return lista de formacoes do curriculo
	 */
	public List<Formacao> getFormacoes() {
		return formacoes;
	}

	/**
	 * Altera a lista de formacoes do curriculo
	 * 
	 * @param lista de formacoes do curriculo
	 */
	public void setFormacoes(List<Formacao> formacoes) {
		this.formacoes = formacoes;
	}

	/**
	 * Retorna a lista de idiomas do curriculo
	 * 
	 * @return lista de idiomas do curriculo
	 */
	public List<Idiomas> getIdiomas() {
		return idiomas;
	}

	/**
	 * Altera a lista de idiomas do curriculo
	 * 
	 * @param lista de idiomas do curriculo
	 */
	public void setIdiomas(List<Idiomas> idiomas) {
		this.idiomas = idiomas;
	}

	/**
	 * retorna o toString do Curriculo
	 * 
	 * @return toString do Curriculo
	 */
	@Override
	public String toString() {
		return "Curriculo [codigo=" + codigo + ", data=" + data + ", cursos=" + cursos + ", formacoes=" + formacoes
				+ ", idiomas=" + idiomas + "]";
	}

}
