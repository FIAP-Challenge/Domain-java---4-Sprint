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

/**
<<<<<<< HEAD
 * Classe responsável por cadastrar, encontrar e listar
=======
 * Classe que repesenta um Curriculo
>>>>>>> 7c266373efd636e028b0e7cd07c554615352a2c5
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class VagaDao {

	private Connection conexao;

	/**
	 * Coleção que armazena os Endereço da aplicacao
	 */
	List<Vaga> listaVagas = new ArrayList<>();

	public VagaDao(Connection conexao) {
		this.conexao = conexao;
	}

/**
 * Metodo cadastrar
 * @param vaga
 * @throws SQLException
 */
	public void cadastrar(Vaga vaga) throws SQLException {

		String requisitos = null;

		PreparedStatement stmt = conexao.prepareStatement(
				"insert into T_MERGE_VAGAS values " + "(sq_t_merge_vagas.nextval,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?, 'dd/mm/yyyy'), to_date(?, 'dd/mm/yyyy'))");

		if (vaga.getRequisitos() != null) {
			for (int i = 0; i < vaga.getRequisitos().size(); i++) {
				requisitos += vaga.getRequisitos().get(i).getNome() + ",";
			}

			requisitos = requisitos.substring(0, requisitos.length() - 1);
			requisitos = requisitos.replace("null", "");
		}

		stmt.setInt(1, vaga.getCodigoEmpresa());
		stmt.setString(2, vaga.getNome());
		stmt.setString(3, vaga.getCargo());
		stmt.setString(4, vaga.getDescricaoCargo());
		stmt.setString(5, vaga.getHistoriaEmpresa());
		stmt.setString(6, vaga.getDescricaoVaga());
		stmt.setString(7, vaga.getRemuneracao());
		stmt.setString(8, vaga.getBeneficios());
		stmt.setInt(9, vaga.getCargaHoraria());
		stmt.setString(10, vaga.getModoTrabalho());
		stmt.setString(11, requisitos);
		stmt.setString(12, vaga.getDataInscricao());
		stmt.setString(13, vaga.getDataFim());

		stmt.executeUpdate();
	}

	/**
	 * Metodo para atualizar uma vaga
	 * 
	 * @param vaga
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Vaga vaga) throws SQLException, IdNotFoundException {
		String requisitos = null;
		PreparedStatement stmt = conexao.prepareStatement("update T_MERGE_VAGAS set "
				+ "NM_VAGA = ?, NM_CARGO = ?, DS_CARGO = ?, DS_HISTORIA_EMPRESA = ?, DS_VAGA = ?, VL_REMUNERACAO = ?, DS_BENEFICIOS = ? , HR_CARGA = ?, DS_MODALIDADE_TRABALHO = ?, DS_REQUISITOS = ?, DT_INICIO_INSCRICAO = to_date(?, 'dd/mm/yyyy'), DT_FIM_INSCRICAO = to_date(?, 'dd/mm/yyyy') where ID_VAGAS = ?");

		if (vaga.getRequisitos() != null) {
			for (int i = 0; i < vaga.getRequisitos().size(); i++) {
				requisitos += vaga.getRequisitos().get(i).getNome() + ",";
			}

			requisitos = requisitos.substring(0, requisitos.length() - 1);
			requisitos = requisitos.replace("null", "");
		}
		
		System.out.println(vaga.toString());

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
		stmt.setString(11, vaga.getDataInscricao());
		stmt.setString(12, vaga.getDataFim());
		stmt.setInt(13, vaga.getCodigo());
		int qtd = stmt.executeUpdate();

		if (qtd == 0)
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA ATUALIZAR");
	}

	/**
	 * Metodo selecionar por id
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public Vaga select(int id) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("select * from T_MERGE_VAGAS where ID_vagas = ?");

		stmt.setInt(1, id);

		ResultSet result = stmt.executeQuery();

		if (!result.next()) {
			throw new IdNotFoundException("VAGA NAO ENCONTRADA");
		}
		int codigo = result.getInt("ID_VAGAS");
		int codigoEmpresa = result.getInt("ID_EMPRESA");
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
		String dataInscricao = result.getString("DT_INICIO_INSCRICAO");
		String dataFim = result.getString("DT_FIM_INSCRICAO");
		Requisito requisitoClasse;
		List<Requisito> listaRequisitos = new ArrayList<Requisito>();

		if (requisitos != null) {
			String[] listaR = requisitos.split(",");

			for (int i = 0; i < listaR.length; i++) {
				listaRequisitos.add(requisitoClasse = new Requisito(listaR[i]));

			}
		}

		Vaga vaga = new Vaga(codigo, codigoEmpresa, nome, cargo, descricaoCargo, historiaEmpresa, descricaoVaga,
				remuneracao, beneficios, cargaHoraria, modoTrabalho, listaRequisitos, dataInscricao, dataFim);
		return vaga;
	}

	/**
	 * Metodo para listar vagas
	 * 
	 * @return lista de vagas
	 * @throws SQLException
	 */
	public List<Vaga> select() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_MERGE_VAGAS ORDER BY ID_VAGAS ASC");
		ResultSet result = stmt.executeQuery();
		List<Vaga> lista = new ArrayList<Vaga>();

		while (result.next()) {

			int codigo = result.getInt("ID_VAGAS");
			int codigoEmpresa = result.getInt("ID_EMPRESA");
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
			String dataInscricao = result.getString("DT_INICIO_INSCRICAO");
			String dataFim = result.getString("DT_FIM_INSCRICAO");
			Requisito requisitoClasse;
			List<Requisito> listaRequisitos = new ArrayList<Requisito>();

			if (requisitos != null) {
				String[] listaR = requisitos.split(",");

				for (int i = 0; i < listaR.length; i++) {
					listaRequisitos.add(requisitoClasse = new Requisito(listaR[i]));

				}
			}

			Vaga vaga = new Vaga(codigo, codigoEmpresa, nome, cargo, descricaoCargo, historiaEmpresa, descricaoVaga,
					remuneracao, beneficios, cargaHoraria, modoTrabalho, listaRequisitos, dataInscricao, dataFim);

			lista.add(vaga);

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

		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_MERGE_VAGAS WHERE ID_VAGAS = ?");

		stmt.setInt(1, id);

		int quantidadeDadosAfetados = stmt.executeUpdate();

		if (quantidadeDadosAfetados == 0) {
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA REMOÇÃO");
		}
	}

}
