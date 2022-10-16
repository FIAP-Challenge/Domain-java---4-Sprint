package br.com.merge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Requisito;
import br.com.merge.model.Vaga;

public class VagaDao {

	private Connection conexao;

	/**
	 * Coleção que armazena os Endereço da aplicacao
	 */
	List<Vaga> listaVagas = new ArrayList<>();

	public VagaDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(Vaga vaga) throws SQLException {

		String requisitos = null;

		PreparedStatement stmt = conexao.prepareStatement(
				"insert into T_MERGE_VAGAS values " + "(sq_t_merge_vagas.nextval,1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		if (vaga.getRequisitos() != null) {
			for (int i = 0; i < vaga.getRequisitos().size(); i++) {
				requisitos += vaga.getRequisitos().get(i).getNome() + ",";
			}

			requisitos = requisitos.substring(0, requisitos.length() - 1);
			requisitos = requisitos.replace("null", "");
		}

		stmt.setString(1, vaga.getNome());
		stmt.setString(2, vaga.getCargo());
		stmt.setString(3, vaga.getDescricaoCargo());
		stmt.setString(4, vaga.getHistoriaEmpresa());
		stmt.setString(5, vaga.getDescricaoVaga());
		stmt.setString(6, vaga.getRemuneracao());
		stmt.setString(7, vaga.getBeneficios());
		stmt.setInt(8, vaga.getCargaHoraria());
		stmt.setString(9, vaga.getModoTrabalho());
		stmt.setString(10, requisitos);

		stmt.executeUpdate();
	}

	public void atualizar(Vaga vaga) throws SQLException, IdNotFoundException {
		String requisitos = null;
		// Criar o PreparedStatement com o comando SQL de update
		PreparedStatement stmt = conexao.prepareStatement("update T_MERGE_VAGAS set "
				+ "NM_VAGA = ?, NM_CARGO = ?, DS_CARGO = ?, DS_HISTORIA_EMPRESA = ?, DS_VAGA = ?, VL_REMUNERACAO = ?, DS_BENEFICIOS = ? , HR_CARGA = ?, DS_MODALIDADE_TRABALHO = ? DS_REQUISITOS = ? where ID_VAGAS = ?");

		// Setar os valores na query

		if (vaga.getRequisitos() != null) {
			for (int i = 0; i < vaga.getRequisitos().size(); i++) {
				requisitos += vaga.getRequisitos().get(i).getNome() + ",";
			}

			requisitos = requisitos.substring(0, requisitos.length() - 1);
			requisitos = requisitos.replace("null", "");
		}

		stmt.setString(1, vaga.getNome());
		stmt.setString(2, vaga.getCargo());
		stmt.setString(3, vaga.getDescricaoCargo());
		stmt.setString(4, vaga.getHistoriaEmpresa());
		stmt.setString(5, vaga.getDescricaoVaga());
		stmt.setString(6, vaga.getRemuneracao());
		stmt.setString(7, vaga.getBeneficios());
		stmt.setInt(8, vaga.getCargaHoraria());
		stmt.setString(9, vaga.getModoTrabalho());
		stmt.setString(10, requisitos);
		stmt.setInt(11, vaga.getCodigo());
		// Executar a query e recuperar a qtd de linhas afetadas no banco
		int qtd = stmt.executeUpdate();

		// Verifica se algum registro foi modificado no banco
		if (qtd == 0)
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA ATUALIZAR");
	}

	public Vaga select(int id) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("select * from T_MERGE_VAGAS where ID_vagas = ?");

		stmt.setInt(1, id);

		ResultSet result = stmt.executeQuery();

		if (!result.next()) {
			throw new IdNotFoundException("VAGA NAO ENCONTRADA");
		}
		int codigo = result.getInt("ID_VAGAS");
		String nome = result.getString("NM_VAGA");
		String cargo = result.getString("NM_CARGO");
		String descricaoCargo = result.getString("DS_CARGO");
		String historiaEmpresa = result.getString("DS_HISTORIA_EMPRESA");
		String descricaoVaga = result.getString("DS_VAGA");
		String remuneracao = result.getString("VL_REMUNERACAO");
		String beneficios = result.getString("DS_BENEFICIOS");
		int cargaHoraria = result.getInt("HR_CARGA");
		String modoTrabalho = result.getString("DS_MODALIDADE_TRABALHO");
		String requisitos = result.getString("DS_REQUISITOS");
		Requisito requisitoClasse;
		List<Requisito> listaRequisitos = new ArrayList<Requisito>();

		if (requisitos != null) {
			String[] listaR = requisitos.split(",");

			for (int i = 0; i < listaR.length; i++) {
				listaRequisitos.add(requisitoClasse = new Requisito(listaR[i]));

			}
		}

		Vaga vaga = new Vaga(codigo, nome, cargo, descricaoCargo, historiaEmpresa, descricaoVaga, remuneracao,
				beneficios, cargaHoraria, modoTrabalho, listaRequisitos );
		return vaga;
	}

	public List<Vaga> select() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_MERGE_VAGAS ORDER BY ID_VAGAS ASC");
		ResultSet result = stmt.executeQuery();
		List<Vaga> lista = new ArrayList<Vaga>();

		while (result.next()) {

			int codigo = result.getInt("ID_VAGAS");
			String nome = result.getString("NM_VAGA");
			String cargo = result.getString("NM_CARGO");
			String descricaoCargo = result.getString("DS_CARGO");
			String historiaEmpresa = result.getString("DS_HISTORIA_EMPRESA");
			String descricaoVaga = result.getString("DS_VAGA");
			String remuneracao = result.getString("VL_REMUNERACAO");
			String beneficios = result.getString("DS_BENEFICIOS");
			int cargaHoraria = result.getInt("HR_CARGA");
			String modoTrabalho = result.getString("DS_MODALIDADE_TRABALHO");
			String requisitos = result.getString("DS_REQUISITOS");
			Requisito requisitoClasse;
			List<Requisito> listaRequisitos = new ArrayList<Requisito>();
		
			if (requisitos != null) {
				String[] listaR = requisitos.split(",");

				for (int i = 0; i < listaR.length; i++) {
					listaRequisitos.add(requisitoClasse = new Requisito(listaR[i]));

				}
			}
			
			
			Vaga vaga = new Vaga(codigo, nome, cargo, descricaoCargo, historiaEmpresa, descricaoVaga, remuneracao,
					beneficios, cargaHoraria, modoTrabalho, listaRequisitos );

			lista.add(vaga);

		}

		return lista;
	}

	public void remover(int id) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_MERGE_VAGAS WHERE ID_VAGAS = ?");

		stmt.setInt(1, id);

		int quantidadeDadosAfetados = stmt.executeUpdate();

		if (quantidadeDadosAfetados == 0) {
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA REMOÇÃO");
		}
	}

}
