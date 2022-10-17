package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.merge.dao.EnderecoDao;
import br.com.merge.dao.EnderecoEmpresaDao;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Endereco;

public class EnderecoEmpresaBo {
	
	private EnderecoEmpresaDao endereco;
	

	
	public EnderecoEmpresaBo(Connection conexao) {
		endereco = new EnderecoEmpresaDao(conexao);
	}

	
	public void cadastrar(Endereco end) throws SQLException, ClassNotFoundException {
		endereco.cadastrar(end);
		
		
	}
	
	public Endereco listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return endereco.select(id);
	}
	
	
	public void atualizar(Endereco end, int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		
		endereco.atualizar(end, id);
	}

	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		endereco.remover(id);

	}
	
	
}
