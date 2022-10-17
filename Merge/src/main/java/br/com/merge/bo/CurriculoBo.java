package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.merge.dao.CurriculoDao;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Curriculo;

/**
 * Classe que repesenta um Candidato
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */

public class CurriculoBo {

	/**
	 * Atributo para chamar o CurriculoDAO
	 */

	private CurriculoDao curriculoDao;

	/**
	 * Atributo para chamar o a conexao
	 */

	private Connection conexao;

	/**
	 * Construtor do CurriculoBO
	 * 
	 * @param Conexao
	 */

	public CurriculoBo(Connection conexao) {
		curriculoDao = new CurriculoDao(conexao);
	}

	/**
	 * Metodo para cadastrar um curriculo
	 * 
	 * @param Curriculo
	 */

	public void cadastrar(Curriculo curriculo) throws SQLException, ClassNotFoundException, DadoInvalidoException {
		curriculoDao.cadastrar(curriculo);

	}

	/**
	 * Metodo para listar curriculo pelo ID do candidato
	 * 
	 * @param ID do candidato
	 */

	public Curriculo listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return curriculoDao.select(id);
	}

	/**
	 * Metodo para atualizar o curriculo
	 * 
	 * @param Curriculo
	 */

	public void atualizar(Curriculo curriculo) throws ClassNotFoundException, SQLException, IdNotFoundException {

		curriculoDao.atualizar(curriculo);
	}

	/**
	 * Metodo para remover o curriculo
	 * 
	 * @param ID do curriculo
	 */

	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		curriculoDao.remover(id);

	}

}
