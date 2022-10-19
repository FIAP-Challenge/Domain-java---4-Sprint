package br.com.merge.model;

public class Candidatura {
	
	/**
	 * Armazena o codigo da candidatura, codigo da vaga, codigo do candidato e o score
	 */
	private int codigo, codigoVaga, codigoCandidato,score;
	
	/**
	 * Armazena o status da candidatura, resultado, data do cadastro, data de inscrição, data do fim da inscrição
	 */
	private String status, resultado, dataCadastro;

	/**
	 * Construtor sem atributos
	 */
	public Candidatura() {
		super();
	}

	/**
	 * Construtor com atributos
	 * @param codigo
	 * @param codigoVaga
	 * @param codigoCandidato
	 * @param status
	 * @param resultado
	 * @param score
	 * @param dataCadastro
	 * @param dataInscrição
	 * @param dataFimInscrição
	 */
	public Candidatura(int codigo, int codigoVaga, int codigoCandidato, String status,
			String resultado, int score, String dataCadastro) {
		super();
		this.codigo = codigo;
		this.codigoVaga = codigoVaga;
		this.codigoCandidato = codigoCandidato;
		this.status = status;
		this.resultado = resultado;
		this.score = score;
		this.dataCadastro = dataCadastro;
	}

	/**
	 * Retorna o codigo da candidatura
	 * @return codigo da candidatura
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Altera o codigo da candidatura
	 * @param codigo da candidatura
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna o codigo da vaga
	 * @return codigo da vaga
	 */
	public int getCodigoVaga() {
		return codigoVaga;
	}

	/**
	 * Altera o codigo da vaga
	 * @param codigo da vaga
	 */
	public void setCodigoVaga(int codigoVaga) {
		this.codigoVaga = codigoVaga;
	}

	/**
	 * Retorna o codigo do candidato
	 * @return codigo do candidato
	 */	
	public int getCodigoCandidato() {
		return codigoCandidato;
	}

	/**
	 * Altera o codigo do candidato
	 * @param codigo do candidato
	 */
	public void setCodigoCandidato(int codigoCandidato) {
		this.codigoCandidato = codigoCandidato;
	}

	/**
	 * Retorna a data de cadastro
	 * @return a data de cadastro
	 */	
	public String getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * Altera o data de cadastro
	 * @param data de cadastro
	 */
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * Retorna o status da candidatura
	 * @return status da candidatura
	 */	
	public String getStatus() {
		return status;
	}

	/**
	 * Altera o status da candidatura
	 * @param status da candidatura
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Retorna o resultado da candidatura
	 * @return resultado da candidatura
	 */	
	public String getResultado() {
		return resultado;
	}

	/**
	 * Altera o resultado da candidatura
	 * @param resultado da candidatura
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * Retorna o score com a vaga
	 * @return score com a vaga
	 */	
	public int getScore() {
		return score;
	}

	/**
	 * Altera o score com a vaga
	 * @param score com a vaga
	 */
	public void setScore(int score) {
		this.score = score;
	}	
	
}
