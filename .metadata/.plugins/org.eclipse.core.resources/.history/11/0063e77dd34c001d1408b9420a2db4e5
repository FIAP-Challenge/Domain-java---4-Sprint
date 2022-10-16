package br.com.merge.view;

import java.sql.Connection;
import java.sql.SQLException;


import br.com.merge.factory.ConnetionFactoy;
import br.com.merge.bo.CandidatoBO;
import br.com.merge.bo.EnderecoBo;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Candidato;
import br.com.merge.model.Curso;
import br.com.merge.model.Endereco;
import br.com.merge.model.Telefone;

public class Testes {

	public static void main(String[] args) throws SQLException, IdNotFoundException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Connection conexao = null;
		try {
		
		conexao = ConnetionFactoy.getConnection();
//		
//		CandidatoBO cand = new CandidatoBO(conexao);
//	EnderecoBo ender = new EnderecoBo(conexao);
//		Telefone telefone = new Telefone();
//		Endereco end = new Endereco(1, "041231", "sao", 1, "dsadas", "dsada", "dsdasda", "dsada", "dsada", "dasda");		
//		Candidato candidato = new Candidato(3, "Reis", "40231312", "Feminino", "Luad@", "Sdad", "solteiro", "19/11/1995", "A", "C");
//		
//		cand.atualizar(candidato);
	
		
	} catch (Exception e) {
		try {
			if (conexao != null) conexao.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		e.printStackTrace();
	}		
		
		
	}

}
