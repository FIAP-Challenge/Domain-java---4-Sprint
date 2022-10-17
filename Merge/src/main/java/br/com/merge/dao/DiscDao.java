package br.com.merge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Disc;

/**
 * Classe responsável por cadastrar, encontrar e listar
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class DiscDao {

	/**
	 * Atributo para conexao
	 */
	private Connection conexao;

	/**
	 * Construtor para a classe
	 * 
	 * @param conexao
	 */
	public DiscDao(Connection conexao) {
		this.conexao = conexao;
	}

	/**
	 * Metodo para cadastrar
	 * 
	 * @param disc
	 * @throws SQLException
	 */
	public void cadastrar(Disc disc) throws SQLException {

		PreparedStatement stmt = conexao.prepareStatement("insert into T_MERGE_DISC values "
				+ "(SQ_T_MERGE_CANDIDATO.CURRVAL, sq_T_MERGE_DISC.nextval, ?, ?, ?, ?)");

		stmt.setInt(1, disc.getDominante());
		stmt.setInt(2, disc.getEstavel());
		stmt.setInt(3, disc.getInfluente());
		stmt.setInt(4, disc.getCondescendente());
		System.out.println("chegou aq?");
		stmt.executeUpdate();
	}

	/**
	 * Metodo para atualizar
	 * 
	 * @param disc
	 * @param id
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Disc disc, int id) throws SQLException, IdNotFoundException {
		// Criar o PreparedStatement com o comando SQL de update
		PreparedStatement stmt = conexao.prepareStatement("update T_MERGE_DISC set "
				+ "NR_DOMINANTE = ?, NR_ESTAVEL = ?, NR_INFLUENTE = ?, NR_CONDESCENDENTE = ? where id_candidato = ?");

		// Setar os valores na query

		stmt.setInt(1, disc.getDominante());
		stmt.setInt(2, disc.getEstavel());
		stmt.setInt(3, disc.getInfluente());
		stmt.setInt(4, disc.getCondescendente());
		stmt.setInt(5, id);

		int qtd = stmt.executeUpdate();

		if (qtd == 0)
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA A" + "ATUALIZAR");

	}

	/**
	 * Metodo para listar por id do candidato
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Disc select(int id) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("select * from T_MERGE_DISC where ID_CANDIDATO = ?");
		Disc disc;
		stmt.setInt(1, id);

		ResultSet result = stmt.executeQuery();

		if (!result.next()) {
			disc = new Disc();
		} else {
			int codigo = result.getInt("ID_DISC");
			int dominante = result.getInt("NR_DOMINANTE");
			int estavel = result.getInt("NR_ESTAVEL");
			int influente = result.getInt("NR_INFLUENTE");
			int condescendente = result.getInt("NR_CONDESCENDENTE");
			disc = new Disc(codigo, dominante, estavel, influente, condescendente);
		}

		return disc;
	}

	/**
	 * Metodo para listar varios disc
	 * 
	 * @return Lista de disc
	 * @throws SQLException
	 */
	public List<Disc> select() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_MERGE_DISC");
		ResultSet result = stmt.executeQuery();
		List<Disc> lista = new ArrayList<Disc>();

		while (result.next()) {

			int codigo = result.getInt("ID_DISC");
			int dominante = result.getInt("NR_DOMINANTE");
			int estavel = result.getInt("NR_ESTAVEL");
			int influente = result.getInt("NR_INFLUENTE");
			int condescendente = result.getInt("NR_CONDESCENDENTE");

			Disc disc = new Disc(codigo, dominante, estavel, influente, condescendente);

			lista.add(disc);

		}

		return lista;
	}

	/**
	 * Metodo para remover pelo id do Disc
	 * 
	 * @param id
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(int id) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_MERGE_DISC WHERE ID_CANDIDATO = ?");

		stmt.setInt(1, id);

		int quantidadeDadosAfetados = stmt.executeUpdate();

		if (quantidadeDadosAfetados == 0) {
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA REMOÇÃO");
		}
	}

}
