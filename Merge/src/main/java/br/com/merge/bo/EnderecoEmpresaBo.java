package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.merge.dao.EnderecoEmpresaDao;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Endereco;

/**
 * Classe para realizar regra de negocio da empresa
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */

public class EnderecoEmpresaBo {

	/**
	 * Atributo para chamar o EnderecoEmpresaDao
	 */
	private EnderecoEmpresaDao endereco;

	/**
	 * Construtor para a classe
	 * 
	 * @param Conexao
	 */
	public EnderecoEmpresaBo(Connection conexao) {
		endereco = new EnderecoEmpresaDao(conexao);
	}

	/**
	 * Metodo para cadastrar
	 * 
	 * @param Endereco
	 */
	public void cadastrar(Endereco end) throws SQLException, ClassNotFoundException {
		endereco.cadastrar(end);

	}

	/**
	 * Metodo para listar um endereco da empresa pelo ID da empresa
	 * 
	 * @param codigo da empresa
	 */
	public Endereco listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return endereco.select(id);
	}

	/**
	 * Metodo para atualizar um Endereco da empresa
	 * @param Endereco
	 * @param codigo da empresa
	 */
	public void atualizar(Endereco end, int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

		endereco.atualizar(end, id);
	}
	
	/**
	 * Metodo para remover um endereco da empresa
	 * @param codigo endereço da empresa
	 */

	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		endereco.remover(id);

	}

}
