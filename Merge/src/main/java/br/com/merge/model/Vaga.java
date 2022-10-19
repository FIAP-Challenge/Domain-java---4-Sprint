package br.com.merge.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que representa uma Vaga
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 * @author Rodrigo Machado
 *
 */

@XmlRootElement
public class Vaga {

	/**
	 * Armazena o codigo, codigoEmpresa e a cargaHoraria
	 */
	private int codigo, codigoEmpresa, cargaHoraria;

	/**
	 * Armazena o nome, cargo, descricao do Cargo, historia da Empresa, descricao da
	 * Vaga, remuneracao, beneficios e o modo de Trabalho
	 */
	private String nome, cargo, descricaoCargo, historiaEmpresa, descricaoVaga, remuneracao, beneficios, modoTrabalho;

	/**
	 * Armazena a lista de requisitos
	 */
	private List<Requisito> requisitos;
	
	
	/**
	 * Armazena a data de inicio para inscrição e a data fim
	 */
	private String dataInscricao, dataFim;
	
	

	/**
	 * Construtor sem atributos
	 */
	public Vaga() {
		super();
	}

	/**
	 * Construtor com atributos
	 * 
	 * @param codigo
	 * @param codigoEmpresa
	 * @param nome
	 * @param cargo
	 * @param descricaoCargo
	 * @param historiaEmpresa
	 * @param descricaoVaga
	 * @param remuneracao
	 * @param beneficios
	 * @param cargaHoraria
	 * @param modoTrabalho
	 * @param Lista           de requisitos
	 */
	public Vaga(int codigo, int codigoEmpresa, String nome, String cargo, String descricaoCargo, String historiaEmpresa,
			String descricaoVaga, String remuneracao, String beneficios, int cargaHoraria, String modoTrabalho,
			List<Requisito> requisitos, String dataInscricao, String dataFim) {
		super();
		this.codigo = codigo;
		this.codigoEmpresa = codigoEmpresa;
		this.nome = nome;
		this.cargo = cargo;
		this.descricaoCargo = descricaoCargo;
		this.historiaEmpresa = historiaEmpresa;
		this.descricaoVaga = descricaoVaga;
		this.remuneracao = remuneracao;
		this.beneficios = beneficios;
		this.cargaHoraria = cargaHoraria;
		this.modoTrabalho = modoTrabalho;
		this.requisitos = requisitos;
		this.dataInscricao = dataInscricao;
		this.dataFim = dataFim;
	}

	/**
	 * Retorna o codigo da vaga
	 * 
	 * @return codigo da vaga
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Altera o codigo da vaga
	 * 
	 * @param codigo da vaga
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna o codigo da empresa da vaga
	 * 
	 * @return codigo da empresa da vaga
	 */
	public int getCodigoEmpresa() {
		return codigoEmpresa;
	}

	/**
	 * Altera o codigo da empresa da vaga
	 * 
	 * @param codigo da empresa da vaga
	 */
	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	/**
	 * Retorna o nome da vaga
	 * 
	 * @return nome da vaga
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome da vaga
	 * 
	 * @param nome da vaga
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o cargo da vaga
	 * 
	 * @return cargo da vaga
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * Altera o cargo da vaga
	 * 
	 * @param cargo da vaga
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * Retorna o descrição do cargo da vaga
	 * 
	 * @return descrição do cargo da vaga
	 */
	public String getDescricaoCargo() {
		return descricaoCargo;
	}

	/**
	 * Altera o descrição do cargo da vaga
	 * 
	 * @param descrição do cargo da vaga
	 */
	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = descricaoCargo;
	}

	/**
	 * Retorna o Historia da empresa
	 * 
	 * @return Historia da empresa
	 */
	public String getHistoriaEmpresa() {
		return historiaEmpresa;
	}

	/**
	 * Altera o Historia da empresa
	 * 
	 * @param Historia da empresa
	 */
	public void setHistoriaEmpresa(String historiaEmpresa) {
		this.historiaEmpresa = historiaEmpresa;
	}

	/**
	 * Retorna o descrição da vaga
	 * 
	 * @return descrição da vaga
	 */
	public String getDescricaoVaga() {
		return descricaoVaga;
	}

	/**
	 * Altera o descrição da vaga
	 * 
	 * @param descrição da vaga
	 */
	public void setDescricaoVaga(String descricaoVaga) {
		this.descricaoVaga = descricaoVaga;
	}

	/**
	 * Retorna a remuneracao da vaga
	 * 
	 * @return remuneracao da vaga
	 */
	public String getRemuneracao() {
		return remuneracao;
	}

	/**
	 * Altera a remuneracao da vaga
	 * 
	 * @param remuneracao da vaga
	 */
	public void setRemuneracao(String remuneracao) {
		this.remuneracao = remuneracao;
	}

	/**
	 * Retorna os beneficios da vaga
	 * 
	 * @return beneficios da vaga
	 */
	public String getBeneficios() {
		return beneficios;
	}

	/**
	 * Altera os beneficios da vag
	 * 
	 * @param beneficios da vag
	 */
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	/**
	 * Retorna a carga horaria da vaga
	 * 
	 * @return carga horaria da vaga
	 */
	public int getCargaHoraria() {
		return cargaHoraria;
	}

	/**
	 * Altera a carga horaria da vaga
	 * 
	 * @param carga horaria da vaga
	 */
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	/**
	 * Retorna o modo de trabalho da vaga
	 * 
	 * @return modo de trabalho da vaga
	 */
	public String getModoTrabalho() {
		return modoTrabalho;
	}

	/**
	 * Altera o modo de trabalho da vaga
	 * 
	 * @param modo de trabalho da vaga
	 */
	public void setModoTrabalho(String modoTrabalho) {
		this.modoTrabalho = modoTrabalho;
	}

	/**
	 * Retorna os requisitos da vaga
	 * 
	 * @return Lista de requisitos da vaga
	 */
	public List<Requisito> getRequisitos() {
		return requisitos;
	}

	/**
	 * Altera os requisitos da vaga
	 * 
	 * @param Lista de requisitos da vaga
	 */
	public void setRequisitos(List<Requisito> requisitos) {
		this.requisitos = requisitos;
	}

	
	/**
	 * 
	 * @return
	 */
	public String getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(String dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	/**
	 * ToString da classe para poder visualizar
	 */
	@Override
	public String toString() {
		return "Vaga [codigo=" + codigo + ", codigoEmpresa=" + codigoEmpresa + ", cargaHoraria=" + cargaHoraria
				+ ", nome=" + nome + ", cargo=" + cargo + ", descricaoCargo=" + descricaoCargo + ", historiaEmpresa="
				+ historiaEmpresa + ", descricaoVaga=" + descricaoVaga + ", remuneracao=" + remuneracao
				+ ", beneficios=" + beneficios + ", modoTrabalho=" + modoTrabalho + ", requisitos=" + requisitos
				+ ", dataInscricao=" + dataInscricao + ", dataFim=" + dataFim + "]";
	}

	
	
	
	

}