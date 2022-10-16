package br.com.merge.model;

public class Candidatura {

	private int codigo;

	private int codigoVaga;

	private int codigoCandidato;
	
	private String status;

	private String resultado;

	private int score;

	private String dataCadastro;

	private String dataInscrição;

	private String dataFimInscrição;

	public Candidatura() {
		super();
	}

	public Candidatura(int codigo, int codigoVaga, int codigoCandidato, String status,
			String resultado, int score, String dataCadastro, String dataInscrição, String dataFimInscrição) {
		super();
		this.codigo = codigo;
		this.codigoVaga = codigoVaga;
		this.codigoCandidato = codigoCandidato;
		this.status = status;
		this.resultado = resultado;
		this.score = score;
		this.dataCadastro = dataCadastro;
		this.dataInscrição = dataInscrição;
		this.dataFimInscrição = dataFimInscrição;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoVaga() {
		return codigoVaga;
	}

	public void setCodigoVaga(int codigoVaga) {
		this.codigoVaga = codigoVaga;
	}

	public int getCodigoCandidato() {
		return codigoCandidato;
	}

	public void setCodigoCandidato(int codigoCandidato) {
		this.codigoCandidato = codigoCandidato;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDataInscrição() {
		return dataInscrição;
	}

	public void setDataInscrição(String dataInscrição) {
		this.dataInscrição = dataInscrição;
	}

	public String getDataFimInscrição() {
		return dataFimInscrição;
	}

	public void setDataFimInscrição(String dataFimInscrição) {
		this.dataFimInscrição = dataFimInscrição;
	}

	
	
}
