package br.com.merge.view;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
		
		conexao = ConnetionFactoy.abrirConexao();
//		
//		CandidatoBO cand = new CandidatoBO(conexao);
//	EnderecoBo ender = new EnderecoBo(conexao);
//		Telefone telefone = new Telefone();
//		Endereco end = new Endereco(1, "041231", "sao", 1, "dsadas", "dsada", "dsdasda", "dsada", "dsada", "dasda");		
//		Candidato candidato = new Candidato(3, "Reis", "40231312", "Feminino", "Luad@", "Sdad", "solteiro", "19/11/1995", "A", "C");
//		
//		cand.atualizar(candidato);
	
		
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		
		c.setTime(data);
		c.add(Calendar.DATE, 30);
		data = c.getTime();
		Locale brasil = new Locale("pt", "BR"); //Retorna do país e a língua

		Calendar dt = Calendar.getInstance();
		Date dataHoje = dt.getTime();
		dt.setTime(dataHoje);
		dataHoje = dt.getTime();
		
		
		DateFormat f3 = DateFormat.getDateInstance(DateFormat.DATE_FIELD, brasil);
		System.out.println(f3.format(dataHoje).toString());
		
		DateFormat f2 = DateFormat.getDateInstance(DateFormat.DATE_FIELD, brasil);
		
		

		
		
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
