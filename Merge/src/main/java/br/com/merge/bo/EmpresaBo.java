package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.merge.dao.EmpresaDao;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Empresa;

/**
 * Classe para realizar regra de negocio da empresa
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class EmpresaBo {

	/**
	 * Atributo para chamar a EmpresaDAO
	 */
	private EmpresaDao empresa;

	/**
	 * Atributo para chamar o EnderecoEmpresaBO
	 */
	private EnderecoEmpresaBo enderecobo;

	/**
	 * Atributo para chamar o TelefoneEmpresaBO
	 */
	private TelefoneEmpresaBo telefonebo;

	/**
	 * Atributo para chamar a conexao
	 */
	private Connection conexao;

	/**
	 * Construtor da classe
	 * 
	 * @param Conexao
	 */
	public EmpresaBo(Connection conexao) {
		this.conexao = conexao;
		empresa = new EmpresaDao(conexao);
		telefonebo = new TelefoneEmpresaBo(conexao);
		enderecobo = new EnderecoEmpresaBo(conexao);
	}

	/**
	 * Metodo para listar várias empresas
	 * 
	 */
	public List<Empresa> listar() throws ClassNotFoundException, SQLException, IdNotFoundException {

		return empresa.select();
	}

	/**
	 * Metodo para listar uma empresa pelo CNPJ
	 * 
	 * @param cnpj
	 */
	public Empresa listar(String cnpj) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return empresa.select(cnpj);
	}

	/**
	 * Método para listar a empresa pelo email e senha
	 * 
	 * @param email
	 * @param senha
	 */
	public Empresa listar(String email, String senha) throws SQLException, IdNotFoundException, ClassNotFoundException {

		try {
			return empresa.select(email, senha);
		} catch (Exception e) {

			throw new IdNotFoundException(e.getMessage());
		}
	}

	/**
	 * Metodo para cadastar uma empresa
	 * 
	 * @param Empresa
	 */
	public void cadastrar(Empresa emp) throws SQLException, ClassNotFoundException, DadoInvalidoException {

		conexao.setAutoCommit(false);

		try {
			empresa.cadastrar(emp);
			telefonebo.cadastrar(emp.getTelefone());
			enderecobo.cadastrar(emp.getEndereco());
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
	 * Metodo para atualizar uma empresa
	 * 
	 * @param Empresa
	 */
	public void atualizar(Empresa emp) throws ClassNotFoundException, SQLException, IdNotFoundException {
		conexao.setAutoCommit(false);

		empresa.atualizar(emp);
		telefonebo.atualizar(emp.getTelefone(), emp.getCodigo());
		enderecobo.atualizar(emp.getEndereco(), emp.getCodigo());

		try {
			conexao.commit();
		} catch (Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar o commit");
		}
	}

	/**
	 * Metodo para remover uma empresa
	 * 
	 * @param cnpj
	 */
	public void remover(String cnpj) throws SQLException, IdNotFoundException, ClassNotFoundException {
		empresa.remover(cnpj);

	}

}
