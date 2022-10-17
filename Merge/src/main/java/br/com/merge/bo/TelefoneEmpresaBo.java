package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.merge.dao.TelefoneEmpresaDao;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Telefone;

/**
 * Classe que que faz a regra de negocio do TelefoneEmpresa
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */

public class TelefoneEmpresaBo {

	/**
	 * Atributo do telefoneEmpresaDAo
	 */

	private TelefoneEmpresaDao telefonedao;

	/**
	 * Construtor da classe
	 * @param conexao
	 */
	public TelefoneEmpresaBo(Connection conexao) {
		telefonedao = new TelefoneEmpresaDao(conexao);
	}

	/**
	 * Metodo para cadastrar um telefone
	 * @param telefone
	 */
	public void cadastrar(Telefone tel) throws SQLException, ClassNotFoundException {
		telefonedao.cadastrar(tel);

	}

	/**
	 *  Metodo para listar um telefone pelo Id da empresa
	 *  @param id da empresa
	 */
	public Telefone listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return telefonedao.select(id);
	}

	/**
	 * Metodo para atualizar um telefone pelo id da empresa
	 * @param Telefone
	 * @param codigo empresa
	 */
	public void atualizar(Telefone tel, int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

		telefonedao.atualizar(tel, id);
	}

	/**
	 * Metodo para remover um telefone da empresa;
	 */
	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		telefonedao.remover(id);

	}

}
