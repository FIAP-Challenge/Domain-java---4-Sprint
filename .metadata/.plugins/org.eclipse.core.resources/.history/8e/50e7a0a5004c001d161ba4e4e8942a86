package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.merge.dao.EmpresaDao;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Empresa;

public class EmpresaBo {

	private EmpresaDao empresa;
	private EnderecoEmpresaBo enderecobo;
	private TelefoneEmpresaBo telefonebo;
//	private DiscBo discbo;
	private Connection conexao;

	public EmpresaBo(Connection conexao) {
		this.conexao = conexao;
		empresa = new EmpresaDao(conexao);
		telefonebo = new TelefoneEmpresaBo(conexao);
		enderecobo = new EnderecoEmpresaBo(conexao);
	}

	public List<Empresa> listar() throws ClassNotFoundException, SQLException, IdNotFoundException {

		return empresa.select();
	}

	public Empresa listar(String cnpj) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return empresa.select(cnpj);
	}

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

	public void remover(String cnpj) throws SQLException, IdNotFoundException, ClassNotFoundException {
		empresa.remover(cnpj);

	}

}
