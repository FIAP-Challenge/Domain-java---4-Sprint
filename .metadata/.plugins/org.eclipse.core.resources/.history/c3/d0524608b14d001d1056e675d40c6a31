package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.merge.dao.DiscDao;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Disc;

/**
 * Classe para realizar regra de negocio do disc
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */

public class DiscBo {

	/**
	 * Atributo para chamar o DiscDAO
	 */
	private DiscDao discDao;

	/**
	 * Atributo da conexao
	 */
	private Connection conexao;

	/**
	 * Construtor da classe
	 * 
	 * @param Conexao
	 */
	public DiscBo(Connection conexao) {
		discDao = new DiscDao(conexao);
	}

	/**
	 * Metodo para cadastrar um Disc
	 * 
	 * @param Disc
	 */
	public void cadastrar(Disc disc) throws SQLException, ClassNotFoundException {
		discDao.cadastrar(disc);
	}

	
	/**
	 *  Metodo para listar um Disc pelo id
	 *  @param ID DO CANDIDATO
	 */
	public Disc listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return discDao.select(id);
	}

	/**
	 * Metodo para atualizar um disc
	 * @param Disc
	 * @param id do candidato
	 */
	public void atualizar(Disc disc, int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

		discDao.atualizar(disc, id);
	}

	
	/**
	 * Metodo para remover um disc
	 * @param id do disc
	 */
	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		discDao.remover(id);

	}

}
