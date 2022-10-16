package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.merge.dao.CandidaturaDao;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Candidatura;

public class CandidaturaBo {

	private CandidaturaDao candidatura;

	private Connection conexao;

	public CandidaturaBo(Connection conexao) {
		this.conexao = conexao;
		candidatura = new CandidaturaDao(conexao);
	
	}

	public List<Candidatura> listar() throws ClassNotFoundException, SQLException, IdNotFoundException {

		return candidatura.select();
	}

	public List<Candidatura>listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return candidatura.select(id);
	}

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

	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		candidatura.remover(id);

	}

}
