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
import br.com.merge.model.Curriculo;
import br.com.merge.model.Curso;
import br.com.merge.model.Formacao;
import br.com.merge.model.Idiomas;

/**
 * Classe para realizar regra de negocio do curriculo
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class CurriculoDao {

	/**
	 * Atributo da conexao
	 */
	private Connection conexao;

	/**
	 * Construtora da conexao
	 * 
	 * @param conexao
	 */
	public CurriculoDao(Connection conexao) {
		this.conexao = conexao;
	}

	/**
	 * Metodo para cadastrar
	 * 
	 * @param curriculo
	 * @throws SQLException
	 * @throws DadoInvalidoException
	 */
	public void cadastrar(Curriculo curriculo) throws SQLException, DadoInvalidoException {

		String curso = null;
		String formacao = null;
		String idiomas = null;
		PreparedStatement stmt = conexao.prepareStatement("insert into T_MERGE_CURRICULO values "
				+ "(sq_T_MERGE_CURRICULO.nextval, SQ_T_MERGE_CANDIDATO.CURRVAL,?, ?, ?, to_date(?, 'dd/mm/yyyy'))",
				new String[] { "ID_CURRICULO" });

		if (curriculo.getCursos() != null) {
			for (int i = 0; i < curriculo.getCursos().size(); i++) {
				curso += curriculo.getCursos().get(i).getNome() + ",";
			}
			curso = curso.substring(0, curso.length() - 1);
			curso = curso.replace("null", "");
		}

		if (curriculo.getFormacoes() != null) {

			for (int i = 0; i < curriculo.getFormacoes().size(); i++) {
				formacao += curriculo.getFormacoes().get(i).getNome() + ",";

			}
			formacao = formacao.substring(0, formacao.length() - 1);
			formacao = formacao.replace("null", "");

		}

		if (curriculo.getIdiomas() != null) {

			for (int i = 0; i < curriculo.getIdiomas().size(); i++) {
				idiomas += curriculo.getIdiomas().get(i).getNome() + ",";

			}
			idiomas = idiomas.substring(0, idiomas.length() - 1);
			idiomas = idiomas.replace("null", "");
		}

		stmt.setString(1, curso);
		stmt.setString(2, formacao);
		stmt.setString(3, idiomas);
		stmt.setString(4, curriculo.getData());

		try {

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DadoInvalidoException(e.getMessage());
		}

		ResultSet result = stmt.getGeneratedKeys();
		if (result.next()) {
			int codigo = result.getInt(1);
			curriculo.setCodigo(codigo);
		}
	}

	/**
	 * Metodo para atualizar
	 * 
	 * @param curriculo
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Curriculo curriculo) throws SQLException, IdNotFoundException {
		// Criar o PreparedStatement com o comando SQL de update
		PreparedStatement stmt = conexao.prepareStatement("update T_MERGE_CURRICULO set "
				+ "NM_CURSOS = ?, NM_FORMACOES = ?, NM_IDIOMAS = ?, DT_CADASTRO = to_date(?, 'dd/mm/yyyy')");

		String curso = null;
		String formacao = null;
		String idiomas = null;

		if (curriculo.getCursos() != null) {
			for (int i = 0; i < curriculo.getCursos().size(); i++) {
				curso += curriculo.getCursos().get(i).getNome() + ",";
			}
			curso = curso.substring(0, curso.length() - 1);
		}
		curso = curso.replace("null", "");

		if (curriculo.getFormacoes() != null) {

			for (int i = 0; i < curriculo.getFormacoes().size(); i++) {
				formacao += curriculo.getFormacoes().get(i).getNome() + ",";

			}
			formacao = formacao.substring(0, formacao.length() - 1);
			formacao = formacao.replace("null", "");
		}

		if (curriculo.getIdiomas() != null) {

			for (int i = 0; i < curriculo.getIdiomas().size(); i++) {
				idiomas += curriculo.getIdiomas().get(i).getNome() + ",";

			}
			idiomas = idiomas.substring(0, idiomas.length() - 1);
			idiomas = idiomas.replace("null", "");
		}

		Locale brasil = new Locale("pt", "BR");
		Calendar dt = Calendar.getInstance();
		Date dataHoje = dt.getTime();
		dt.setTime(dataHoje);
		dataHoje = dt.getTime();
		DateFormat f3 = DateFormat.getDateInstance(DateFormat.DATE_FIELD, brasil);

		stmt.setString(1, curso);
		stmt.setString(2, formacao);
		stmt.setString(3, idiomas);
		stmt.setString(4, f3.format(dataHoje).toString());

		int qtd = stmt.executeUpdate();

		// Verifica se algum registro foi modificado no banco
		if (qtd == 0)
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA A" + "ATUALIZAR");

	}

	public Curriculo select(int id) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("select * from T_MERGE_CURRICULO where ID_CANDIDATO = ?");
		Curriculo curriculo;
		stmt.setInt(1, id);

		ResultSet result = stmt.executeQuery();

		if (!result.next()) {
			curriculo = new Curriculo();
		} else {
			int codigo = result.getInt("ID_CURRICULO");
			String curso = result.getString("NM_CURSOS");
			String formacoes = result.getString("NM_FORMACOES");
			String idiomas = result.getString("NM_IDIOMAS");
			String data = result.getString("DT_CADASTRO");
			Curso cursoClasse;
			Formacao formacaoClasse;
			Idiomas idioma;

			List<Curso> listaCursos = new ArrayList<Curso>();
			List<Formacao> listaFormacoes = new ArrayList<Formacao>();
			List<Idiomas> listaIdiomas = new ArrayList<Idiomas>();

			if (curso != null) {

				String[] listaC = curso.split(",");

				for (int i = 0; i < listaC.length; i++) {
					listaCursos.add(cursoClasse = new Curso(listaC[i]));

				}
			}

			if (formacoes != null) {
				String[] listaF = formacoes.split(",");

				for (int i = 0; i < listaF.length; i++) {
					listaFormacoes.add(formacaoClasse = new Formacao(listaF[i]));

				}
			}

			if (idiomas != null) {
				String[] listaI = idiomas.split(",");

				for (int i = 0; i < listaI.length; i++) {
					listaIdiomas.add(idioma = new Idiomas(listaI[i]));

				}
			}

			curriculo = new Curriculo(codigo, listaCursos, listaFormacoes, listaIdiomas, data);
		}

		return curriculo;
	}

	/**
	 * Metodo para buscar varios curriculo
	 * 
	 * @return Lista de curriculo
	 * @throws SQLException
	 */
	public List<Curriculo> select() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_MERGE_CURRICULO");
		ResultSet result = stmt.executeQuery();
		List<Curriculo> lista = new ArrayList<Curriculo>();

		while (result.next()) {

			int codigo = result.getInt("ID_CURRICULO");
			String curso = result.getString("NM_CURSOS");
			String formacoes = result.getString("NM_FORMACOES");
			String idiomas = result.getString("NM_IDIOMAS");
			String data = result.getString("DT_CADASTRO");
			Curso cursoClasse = new Curso();
			Formacao formacaoClasse = new Formacao();
			Idiomas idioma;

			List<Curso> listaCursos = new ArrayList<Curso>();
			List<Formacao> listaFormacoes = new ArrayList<Formacao>();
			List<Idiomas> listaIdiomas = new ArrayList<Idiomas>();

			if (curso != null) {

				String[] listaC = curso.split(",");

				for (int i = 0; i < listaC.length; i++) {
					listaCursos.add(cursoClasse = new Curso(listaC[i]));

				}
			}

			if (formacoes != null) {
				String[] listaF = formacoes.split(",");

				for (int i = 0; i < listaF.length; i++) {
					listaFormacoes.add(formacaoClasse = new Formacao(listaF[i]));

				}
			}

			if (idiomas != null) {
				String[] listaI = idiomas.split(",");

				for (int i = 0; i < listaI.length; i++) {
					listaIdiomas.add(idioma = new Idiomas(listaI[i]));

				}
			}

			Curriculo curriculo = new Curriculo(codigo, listaCursos, listaFormacoes, listaIdiomas, data);

			lista.add(curriculo);

		}

		return lista;
	}

	/**
	 * Metodo para remover um curriculo
	 * 
	 * @param id
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int id) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_MERGE_CURRICULO WHERE ID_CANDIDATO = ?");

		stmt.setInt(1, id);

		int quantidadeDadosAfetados = stmt.executeUpdate();

		if (quantidadeDadosAfetados == 0) {
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA REMOÇÃO");
		}
	}

}
