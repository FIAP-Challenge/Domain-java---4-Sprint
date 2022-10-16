package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.merge.dao.DiscDao;
import br.com.merge.dao.TelefoneDao;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Disc;

public class DiscBo {
	
	private DiscDao discDao;
	private Connection conexao;


	
	public DiscBo(Connection conexao) {
		discDao = new DiscDao(conexao);
	}

	
	public void cadastrar(Disc disc) throws SQLException, ClassNotFoundException {
		
		
		discDao.cadastrar(disc);
		
		
	}
	
	public Disc listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return discDao.select(id);
	}
	
	
	public void atualizar(Disc disc, int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		
		discDao.atualizar(disc, id);
	}

	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		discDao.remover(id);

	}
	
	
}
