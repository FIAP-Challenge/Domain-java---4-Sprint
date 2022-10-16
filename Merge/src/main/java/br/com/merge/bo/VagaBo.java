package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.merge.dao.VagaDao;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Vaga;

public class VagaBo {
	
	private VagaDao vagadao;
	

	
	public VagaBo(Connection conexao) {
		vagadao = new VagaDao(conexao);
	}

	
	public void cadastrar(Vaga vaga) throws SQLException, ClassNotFoundException, DadoInvalidoException {
		
		vagadao.cadastrar(vaga);
		
		
	}
	
	public Vaga listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return vagadao.select(id);
	}
	
	public List<Vaga> listar() throws ClassNotFoundException, SQLException, IdNotFoundException {

		return vagadao.select();
	}
	
	
	public void atualizar(Vaga vaga) throws ClassNotFoundException, SQLException, IdNotFoundException {
		
		vagadao.atualizar(vaga);
	}

	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		vagadao.remover(id);

	}
	
	
}
