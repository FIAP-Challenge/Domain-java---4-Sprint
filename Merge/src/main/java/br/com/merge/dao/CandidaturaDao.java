package br.com.merge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Candidatura;

public class CandidaturaDao {

	private Connection conexao;

	public CandidaturaDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(Candidatura candidatura) throws SQLException, DadoInvalidoException {

		PreparedStatement stmt = conexao.prepareStatement("insert into T_MERGE_CANDIDATURA values "
				+ "(sq_t_merge_candidatura.nextval,?, ?, ?, ?,to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), to_date(?,'dd/mm/yyyy'), ? )",
				new String[] { "id_candidatura" });
		
		

		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		c.setTime(data);
		c.add(Calendar.DATE, 30);
		data = c.getTime();
		Locale brasil = new Locale("pt", "BR");		
		DateFormat f2 = DateFormat.getDateInstance(DateFormat.DATE_FIELD, brasil);
		
		
		Calendar dt = Calendar.getInstance();
		Date dataHoje = dt.getTime();
		dt.setTime(dataHoje);
		dataHoje = dt.getTime();
		DateFormat f3 = DateFormat.getDateInstance(DateFormat.DATE_FIELD, brasil);


		stmt.setInt(1, candidatura.getCodigoVaga());
		stmt.setInt(2, candidatura.getCodigoCandidato());
		stmt.setString(3, "A");
		stmt.setString(4, "Aguardando andamento");
		stmt.setString(5, f3.format(dataHoje).toString());
		stmt.setString(6, f3.format(dataHoje).toString());
		stmt.setString(7, f2.format(data).toString());
		stmt.setInt(8, candidatura.getScore());

		try {

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DadoInvalidoException(e.getMessage());
		}

		ResultSet result = stmt.getGeneratedKeys();
		if (result.next()) {
			int codigo = result.getInt(1);
			candidatura.setCodigo(codigo);
		}

	}

	public void atualizar(Candidatura candidatura) throws SQLException, IdNotFoundException {
		// Criar o PreparedStatement com o comando SQL de update
		PreparedStatement stmt = conexao.prepareStatement(
				"UPDATE T_MERGE_CANDIDATURA SET , NR_SCORE_TER = ?  where ID_CANDIDATURA = ?");

		Locale brasil = new Locale("pt", "BR");	
		Calendar dt = Calendar.getInstance();
		Date dataHoje = dt.getTime();
		dt.setTime(dataHoje);
		dataHoje = dt.getTime();
		DateFormat f3 = DateFormat.getDateInstance(DateFormat.DATE_FIELD, brasil);
		
		stmt.setInt(1, candidatura.getCodigoVaga());
		stmt.setInt(2, candidatura.getCodigoCandidato());
		stmt.setString(3, candidatura.getStatus());
		stmt.setString(4, candidatura.getResultado());
		stmt.setString(5, f3.format(dataHoje).toString());
		stmt.setString(6, candidatura.getDataInscrição());
		stmt.setString(7, candidatura.getDataFimInscrição());
		stmt.setInt(8, candidatura.getScore());
		stmt.setInt(10, candidatura.getCodigo());
		int qtd = stmt.executeUpdate();

		if (qtd == 0)
			throw new IdNotFoundException("Não localizado para alterar");

	}

	public List<Candidatura> select(int id) throws SQLException, IdNotFoundException, ClassNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("select * from T_MERGE_CANDIDATURA where ID_CANDIDATO = ?");

		stmt.setInt(1, id);
		List<Candidatura> lista = new ArrayList<Candidatura>();

		ResultSet result = stmt.executeQuery();

		while (result.next()) {

			int codigo = result.getInt("ID_CANDIDATURA");
			int codigoVaga = result.getInt("ID_VAGAS");
			int codigoCandidato = result.getInt("ID_CANDIDATO");
			String status = result.getString("DS_STATUS");
			String resultado = result.getString("DS_RESULTADO");
			int score = result.getInt("NR_SCORE_TER");
			String dataCadastro = result.getString("DT_CADASTRO");
			String dataInscricao = result.getString("DT_INICIO_INSCRICAO");
			String dataFim = result.getString("DT_FIM_INSCRICAO");

			Candidatura candidatura = new Candidatura(codigo, codigoVaga, codigoCandidato, status, resultado, score,
					dataCadastro, dataInscricao, dataFim);

			lista.add(candidatura);

		}
		
		return lista;
	}
		
		public Candidatura select(int codigoVaga, int codigoCandidato) throws SQLException, IdNotFoundException, ClassNotFoundException {

			PreparedStatement stmt = conexao.prepareStatement("select * from T_MERGE_CANDIDATURA where ID_VAGAS = ? AND ID_CANDIDATO = ?");

			
			stmt.setInt(1, codigoVaga);
			stmt.setInt(2, codigoCandidato);
			ResultSet result = stmt.executeQuery();

			if (!result.next()) {
				throw new IdNotFoundException("CANDIDATO NÃO ENCONTRADO");
			} 
				int codigo = result.getInt("ID_CANDIDATURA");
				String status = result.getString("DS_STATUS");
				String resultado = result.getString("DS_RESULTADO");
				int score = result.getInt("NR_SCORE_TER");
				String dataCadastro = result.getString("DT_CADASTRO");
				String dataInscricao = result.getString("DT_INICIO_INSCRICAO");
				String dataFim = result.getString("DT_FIM_INSCRICAO");

				Candidatura candidatura = new Candidatura(codigo, codigoVaga, codigoCandidato, status, resultado, score,
						dataCadastro, dataInscricao, dataFim);
		
		return candidatura;
	
	}

	/**
	 * Lista os candidatos
	 * 
	 * @return a lista de candidatos
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws ClassNotFoundException
	 */
	public List<Candidatura> select() throws SQLException, ClassNotFoundException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_MERGE_CANDIDATURA");
		ResultSet result = stmt.executeQuery();
		List<Candidatura> lista = new ArrayList<Candidatura>();

		while (result.next()) {

			int codigo = result.getInt("ID_CANDIDATURA");
			int codigoVaga = result.getInt("ID_VAGAS");
			int codigoCandidato = result.getInt("ID_CANDIDATO");
			String status = result.getString("DS_STATUS");
			String resultado = result.getString("DS_RESULTADO");
			int score = result.getInt("NR_SCORE_TER");
			String dataCadastro = result.getString("DT_CADASTRO");
			String dataInscricao = result.getString("DT_INICIO_INSCRICAO");
			String dataFim = result.getString("DT_FIM_INSCRICAO");

			Candidatura candidatura = new Candidatura(codigo, codigoVaga, codigoCandidato, status, resultado, score,
					dataCadastro, dataInscricao, dataFim);

			lista.add(candidatura);

		}

		return lista;
	}

	public void remover(int id) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_MERGE_CANDIDATURA WHERE ID_CANDIDATURA = ?");

		stmt.setInt(1, id);

		int quantidadeDadosAfetados = stmt.executeUpdate();

		if (quantidadeDadosAfetados == 0) {
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA REMOÇÃO");

		}

	}

}