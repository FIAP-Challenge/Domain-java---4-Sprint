package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.merge.dao.CurriculoDao;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Curriculo;


public class CurriculoBo {

	private CurriculoDao curriculoDao;
	private Connection conexao;

	public CurriculoBo(Connection conexao) {
		curriculoDao = new CurriculoDao(conexao);
//		cursobo = new CursoDao(conexao);
	}

	public void cadastrar(Curriculo curriculo) throws SQLException, ClassNotFoundException, DadoInvalidoException {
			curriculoDao.cadastrar(curriculo);
		
				
			
	}

	public Curriculo listar(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return curriculoDao.select(id);
	}
	
	
	public void atualizar(Curriculo curriculo) throws ClassNotFoundException, SQLException, IdNotFoundException {
		
		 curriculoDao.atualizar(curriculo);
	}

	public void remover(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {
		curriculoDao.remover(id);

	}

}
