package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.merge.dao.EnderecoDao;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Endereco;

/**
 * Classe que repesenta um Candidato
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */

public class EnderecoBo {

	/**
	 * Atributo do EnderecoDao
	 */
	private EnderecoDao endereco;
	
	/**
	 * Construtor da classe
	 * @param Conexao
	 */
	public EnderecoBo(Connection conexao) {
		endereco = new EnderecoDao(conexao);
	}

	
	/**
	 * Metodo para cadastrar um novo endereço
	 * @param Endereco
	 */
	public void cadastrar(Endereco end) throws SQLException, ClassNotFoundException {
		endereco.cadastrar(end);

	}

	/**
	 * Metodo para listar um endereço pelo ID
	 * @param codigo do candidato;
	 */
	public Endereco listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return endereco.select(id);
	}

	/**
	 * Metodo para atualizar um endereço pelo codigo do candidato
	 * @param Endereco
	 * @param codigo do candidato
	 */
	public void atualizar(Endereco end, int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

		endereco.atualizar(end, id);
	}

	/**
	 * Metodo para remover um endereco
	 * @param codigo do endereço
	 */
	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		endereco.remover(id);

	}

}
