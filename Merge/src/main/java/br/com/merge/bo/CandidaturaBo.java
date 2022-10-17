package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.merge.dao.CandidaturaDao;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Candidatura;

/**
 *Classe que que faz a regra de negocio da candidatura
 *@author Henrique Cesar
 *@author Dennys Nascimenro 
 *@author Luan Reis
 *@author Gustavo Fonseca
 *
 */


public class CandidaturaBo {

	/**
	 * Atributo para chamar a CandidaturaDAO
	 */
	private CandidaturaDao candidatura;

	/**
	 * Atributo para conexao
	 */
	private Connection conexao;

	/**
	 * Construtor da Classe e recebe o parametro da conexao
	 * 
	 * @param Conexao
	 */
	public CandidaturaBo(Connection conexao) {
		this.conexao = conexao;
		candidatura = new CandidaturaDao(conexao);

	}

	/**
	 * Metodo para listar candidatura
	 */
	public List<Candidatura> listar() throws ClassNotFoundException, SQLException, IdNotFoundException {

		return candidatura.select();
	}

	/**
	 * MEtodo para listar candidatura pelo ID do candidato
	 * 
	 * @param ID do candidato
	 */
	public List<Candidatura> listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return candidatura.select(id);
	}

	/**
	 * Metodo para listagem da candidatura
	 * 
	 * @param id da vaga
	 * @param id do candidato
	 */
	public Candidatura listar(int codigoVaga, int codigoCandidato)
			throws SQLException, IdNotFoundException, ClassNotFoundException {

		try {
			return candidatura.select(codigoVaga, codigoCandidato);
		} catch (Exception e) {
			throw new IdNotFoundException(e.getMessage());
		}

	}

	/**
	 * Metodo para cadastrar uma candidatura
	 * 
	 * @param Candidatura
	 */
	public void cadastrar(Candidatura cand) throws SQLException, ClassNotFoundException, DadoInvalidoException {

		conexao.setAutoCommit(false);
		try {
			candidatura.cadastrar(cand);

		} catch (SQLException e) {

			throw new DadoInvalidoException(e.getMessage());

		}

		try {
			conexao.commit();
		} catch (Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar o commit");
		}

	}

	
	/**
	 * Metodo para atualizar uma candidatura 
	 * @param Candidatura
	 */
	public void atualizar(Candidatura cand) throws ClassNotFoundException, SQLException, IdNotFoundException {
		conexao.setAutoCommit(false);
		candidatura.atualizar(cand);

		try {
			conexao.commit();
		} catch (Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar o commit");
		}
	}

	
	/**
	 * Metodo para remover uma candidatura pelo ID
	 */
	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		conexao.setAutoCommit(false);

		candidatura.remover(id);

		try {
			conexao.commit();
		} catch (Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar o commit");
		}
	}

}
