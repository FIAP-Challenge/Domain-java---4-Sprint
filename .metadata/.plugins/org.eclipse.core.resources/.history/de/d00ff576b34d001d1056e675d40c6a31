package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.merge.dao.TelefoneDao;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Telefone;

public class TelefoneBo {
	
	private TelefoneDao telefonedao;
	private Connection conexao;

	
	public TelefoneBo(Connection conexao) {
		telefonedao = new TelefoneDao(conexao);
	}

	
	public void cadastrar(Telefone tel) throws SQLException, ClassNotFoundException {
		telefonedao.cadastrar(tel);
		
		
	}
	
	public Telefone listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return telefonedao.select(id);
	}
	
	
	public void atualizar(Telefone tel, int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		
		telefonedao.atualizar(tel, id);
	}

	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		telefonedao.remover(id);

	}
	
	
}
