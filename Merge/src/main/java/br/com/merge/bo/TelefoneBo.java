package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.merge.dao.TelefoneDao;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Telefone;

/**
 * Classe para a regra de negocio do Telefone
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class TelefoneBo {

	/**
	 * Atributo para chamar o TelefoneDao
	 */
	private TelefoneDao telefonedao;

	/**
	 * Atributo da conexao
	 */
	private Connection conexao;

	/**
	 * Construtor da classe
	 * 
	 * @param Conexao
	 */
	public TelefoneBo(Connection conexao) {
		telefonedao = new TelefoneDao(conexao);
	}

	/**
	 * Metodo para cadastar um telefone
	 * @param Telefone
	 */
	public void cadastrar(Telefone tel) throws SQLException, ClassNotFoundException {
		telefonedao.cadastrar(tel);

	}

	/**
	 * Metodo para listar um telefone pelo codigo do candidato;
	 * @param codigo candidato
	 */
	public Telefone listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return telefonedao.select(id);
	}

	/**
	 * Metodo para atualizar um telefone
	 * @param Telefone
	 * @param codigo do candidato;
	 */
	public void atualizar(Telefone tel, int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

		telefonedao.atualizar(tel, id);
	}

	
	/**
	 * Metodo para remover um telefone
	 * @param id do telefone
	 */
	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		telefonedao.remover(id);

	}

}
