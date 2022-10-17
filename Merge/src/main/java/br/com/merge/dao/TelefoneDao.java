package br.com.merge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Telefone;

/**
 * Classe responsável por cadastrar, encontrar e telefones
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */

public class TelefoneDao {

	/**
	 * Atributo para conexao
	 */
	private Connection conexao;

	/**
	 * Construtor da classe
	 * 
	 * @param conexao
	 */

	public TelefoneDao(Connection conexao) {
		this.conexao = conexao;
	}

	/**
	 * Metodo para cadastrar
	 * 
	 * @param telefone
	 * @throws SQLException
	 */
	public void cadastrar(Telefone telefone) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement("insert into T_MERGE_TELEFONE_CANDIDATO values "
				+ "(sq_t_merge_candidato.currval, sq_T_MERGE_TELEFONE_CANDIDATO.nextval, ?, ?, ?)");

		stmt.setString(1, telefone.getDdd());
		stmt.setString(2, telefone.getNumero());
		stmt.setString(3, telefone.getTipo());

		stmt.executeUpdate();
	}

	/**
	 * Metodo para atualizar
	 * 
	 * @param telefone
	 * @param id
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Telefone telefone, int id) throws SQLException, IdNotFoundException {
		// Criar o PreparedStatement com o comando SQL de update
		PreparedStatement stmt = conexao.prepareStatement("update T_MERGE_TELEFONE_CANDIDATO set "
				+ "NR_DDD = ?, NR_TELEFONE = ?, TP_TELEFONE = ? where id_candidato = ?");

		stmt.setString(1, telefone.getDdd());
		stmt.setString(2, telefone.getNumero());
		stmt.setString(3, telefone.getTipo());

		stmt.setInt(4, id);

		int qtd = stmt.executeUpdate();

		if (qtd == 0)
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA ATUALIZAR");
	}

	/**
	 * Metodo para listar telefone pelo id do candidato
	 * 
	 * @param id
	 * @return Telefone
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Telefone select(int id) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao
				.prepareStatement("select * from T_MERGE_TELEFONE_CANDIDATO where ID_CANDIDATO = ?");

		stmt.setInt(1, id);

		ResultSet result = stmt.executeQuery();

		if (!result.next()) {
			throw new IdNotFoundException("TELEFONE NAO ENCONTRADO");
		}
		int codigo = result.getInt("ID_TELEFONE");
		String ddd = result.getString("NR_DDD");
		String numero = result.getString("NR_TELEFONE");
		String tipo = result.getString("TP_TELEFONE");

		Telefone telefone = new Telefone(codigo, ddd, numero, tipo);
		return telefone;
	}

	/**
	 * Metodo para listar telefones
	 * 
	 * @return Telefone
	 * @throws SQLException
	 */
	public List<Telefone> select() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_MERGE_TELEFONE_CANDIDATO");
		ResultSet result = stmt.executeQuery();
		List<Telefone> lista = new ArrayList<Telefone>();

		while (result.next()) {

			int codigo = result.getInt("ID_TELEFONE");
			String ddd = result.getString("NR_DDD");
			String numero = result.getString("NR_TELEFONE");
			String tipo = result.getString("TP_TELEFONE");

			Telefone telefone = new Telefone(codigo, ddd, numero, tipo);

			lista.add(telefone);
		}

		return lista;
	}

	/**
	 * Metodo para remover
	 * 
	 * @param id
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */

	public void remover(int id) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao
				.prepareStatement("DELETE FROM T_MERGE_TELEFONE_CANDIDATO WHERE ID_CANDIDATO = ?");

		stmt.setInt(1, id);

		int quantidadeDadosAfetados = stmt.executeUpdate();

		if (quantidadeDadosAfetados == 0) {
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA REMOÇÃO");
		}
	}

}
