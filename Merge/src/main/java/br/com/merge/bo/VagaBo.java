package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.merge.dao.VagaDao;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Vaga;

/**
 * Classe para realizar regra de negocio da vaga
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class VagaBo {

	/**
	 * Atributo da VagaDao
	 */
	private VagaDao vagadao;

	/**
	 * Construtor da classe
	 * 
	 * @param conexao
	 */

	public VagaBo(Connection conexao) {
		vagadao = new VagaDao(conexao);
	}

	/**
	 * Metodo para cadastrar uma vaga
	 * 
	 * @param Vaga
	 */
	public void cadastrar(Vaga vaga) throws SQLException, ClassNotFoundException, DadoInvalidoException {

		vagadao.cadastrar(vaga);

	}

	/**
	 * Metodo para listar uma vaga pelo id
	 * 
	 * @para id
	 */
	public Vaga listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return vagadao.select(id);
	}

	/**
	 * Metodo para listar varias vaga
	 */
	public List<Vaga> listar() throws ClassNotFoundException, SQLException, IdNotFoundException {

		return vagadao.select();
	}

	/**
	 * Metodo para atualizar uma vaga
	 * 
	 * @param Vaga
	 */
	public void atualizar(Vaga vaga) throws ClassNotFoundException, SQLException, IdNotFoundException {

		vagadao.atualizar(vaga);
	}

	/**
	 * Metodo para remover uma vaga
	 * 
	 * @param id da vaga
	 */
	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		vagadao.remover(id);

	}

}
