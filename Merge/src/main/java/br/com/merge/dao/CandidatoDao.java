package br.com.merge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.merge.bo.CurriculoBo;
import br.com.merge.bo.DiscBo;
import br.com.merge.bo.EnderecoBo;
import br.com.merge.bo.TelefoneBo;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Candidato;
import br.com.merge.model.Curriculo;
import br.com.merge.model.Curso;
import br.com.merge.model.Disc;
import br.com.merge.model.Endereco;
import br.com.merge.model.Formacao;
import br.com.merge.model.Idiomas;
import br.com.merge.model.Telefone;

/**
 * Classe responsável por cadastrar, encontrar, alterar senha e listar um
 * Candidato
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class CandidatoDao {

	private Connection conexao;

	/**
	 * Coleção que armazena os Candidatos da aplicacao
	 */
	List<Candidato> listaCandidato = new ArrayList<>();

	/**
	 * Método que cadastra um candidato
	 * 
	 * @param candidato
	 * @param email     do candidato
	 * @return se esse emai já está cadastrado ou se foi cadastrado
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public CandidatoDao(Connection conexao) {
		this.conexao = conexao;
	}

	/**
	 * Metodo para cadastrar um candidato
	 * 
	 * @param Candidato
	 * @throws SQLException
	 * @throws DadoInvalidoException
	 */
	public void cadastrar(Candidato candidato) throws SQLException, DadoInvalidoException {

		PreparedStatement stmt = conexao.prepareStatement(
				"insert into T_MERGE_CANDIDATO values "
						+ "(sq_t_merge_candidato.nextval, ?, ?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?, ? )",
				new String[] { "id_candidato" });

		stmt.setString(1, candidato.getNome());
		stmt.setString(2, candidato.getCpf());
		stmt.setString(3, candidato.getDtNascimento());
		stmt.setString(4, candidato.getEstadoCivil());
		stmt.setString(5, candidato.getSexo());
		stmt.setString(6, candidato.getEmail());
		stmt.setString(7, candidato.getSenhaLogin());
		stmt.setString(8, "A");
		stmt.setString(9, "C");

		try {

			stmt.executeUpdate();
		} catch (SQLException e) {
			conexao.rollback();
			throw new DadoInvalidoException(e.getMessage());
		}

		ResultSet result = stmt.getGeneratedKeys();
		if (result.next()) {
			int codigo = result.getInt(1);
			candidato.setCodigo(codigo);
		}

	}

	/**
	 * Metodo para atualizar um candidato
	 * 
	 * @param Candidato
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Candidato candidato) throws SQLException, IdNotFoundException {
		// Criar o PreparedStatement com o comando SQL de update
		PreparedStatement stmt = conexao.prepareStatement(
				"UPDATE T_MERGE_CANDIDATO SET NM_CANDIDATO = ?, NR_CPF = ?, DT_NASCIMENTO = to_date(?,'dd/mm/yyyy'), DS_ESTADO_CIVIL = ?, DS_SEXO = ?, DS_EMAIL = ?, PS_SENHA = ? where ID_CANDIDATO = ?");

		// Setar os valores na query
		stmt.setString(1, candidato.getNome());
		stmt.setString(2, candidato.getCpf());
		stmt.setString(3, candidato.getDtNascimento());
		stmt.setString(4, candidato.getEstadoCivil());
		stmt.setString(5, candidato.getSexo());
		stmt.setString(6, candidato.getEmail());
		stmt.setString(7, candidato.getSenhaLogin());
		stmt.setInt(8, candidato.getCodigo());

		int qtd = stmt.executeUpdate();

		if (qtd == 0)
			throw new IdNotFoundException("Não localizado para alterar");

	}

	/**
	 * Método que encontra na lista o candidato pelo cpf
	 * 
	 * @param cpf dop candidato
	 * @return o candidato
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws ClassNotFoundException
	 */
	public Candidato select(String cpf) throws SQLException, IdNotFoundException, ClassNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("select * from T_MERGE_CANDIDATO where NR_CPF = ?");

		stmt.setString(1, cpf);

		ResultSet result = stmt.executeQuery();

		if (!result.next()) {
			throw new IdNotFoundException("CANDIDATO NÃO ENCONTRADO");
		}
		int codigo = result.getInt("ID_CANDIDATO");
		String nome = result.getString("NM_CANDIDATO");
		String dataNascim = result.getString("DT_NASCIMENTO");
		String estadoCivil = result.getString("DS_ESTADO_CIVIL");
		String sexo = result.getString("DS_SEXO");
		String email = result.getString("DS_EMAIL");
		String senha = result.getString("PS_SENHA");
		String statusLogin = result.getString("ST_LOGIN");
		String tipoLogin = result.getString("TP_LOGIN");

		EnderecoBo endereco = new EnderecoBo(conexao);
		int codigoEndereco = endereco.listar(codigo).getCodigo();
		String cep = endereco.listar(codigo).getCep();
		String bairro = endereco.listar(codigo).getBairro();
		String numero = endereco.listar(codigo).getNumeroLogradouro();
		String nomeLogradouro = endereco.listar(codigo).getLogradouro();
		String complemento = endereco.listar(codigo).getComplemento();
		String nomeCidade = endereco.listar(codigo).getCidade();
		String nomeEstado = endereco.listar(codigo).getEstado();
		String SiglaEstado = endereco.listar(codigo).getSiglaEstado();

		TelefoneBo telefone = new TelefoneBo(conexao);
		int codigoTelefone = telefone.listar(codigo).getCodigo();
		String ddd = telefone.listar(codigo).getDdd();
		String numeroTelelefone = telefone.listar(codigo).getNumero();
		String tipoTelefone = telefone.listar(codigo).getTipo();

		DiscBo disc = new DiscBo(conexao);
		int codigoDisc = disc.listar(codigo).getCodigo();
		int dominante = disc.listar(codigo).getDominante();
		int estavel = disc.listar(codigo).getEstavel();
		int influente = disc.listar(codigo).getInfluente();
		int condescendente = disc.listar(codigo).getCondescendente();

		Disc discCandidato = new Disc(codigoDisc, dominante, estavel, influente, condescendente);
		Telefone telefoneCandidato = new Telefone(codigoTelefone, ddd, numeroTelelefone, tipoTelefone);
		Endereco enderecoCandidato = new Endereco(codigoEndereco, cep, bairro, numero, nomeLogradouro, complemento,
				nomeCidade, nomeEstado, SiglaEstado);

		CurriculoBo curriculo = new CurriculoBo(conexao);
		int codigoCurriculo = curriculo.listar(codigo).getCodigo();
		List<Curso> cursos = curriculo.listar(codigo).getCursos();
		List<Formacao> formacoes = curriculo.listar(codigo).getFormacoes();
		List<Idiomas> idiomas = curriculo.listar(codigo).getIdiomas();
		String data = curriculo.listar(codigo).getData();

		Curriculo curriculoCandidato = new Curriculo(codigoCurriculo, cursos, formacoes, idiomas, data);

		Candidato candidato = new Candidato(codigo, nome, cpf, sexo, email, senha, estadoCivil, dataNascim,
				telefoneCandidato, enderecoCandidato, curriculoCandidato, statusLogin, tipoLogin, discCandidato);

		return candidato;
	}

	/**
	 * Lista os candidatos
	 * 
	 * @return a lista de candidatos
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws ClassNotFoundException
	 */
	public List<Candidato> select() throws SQLException, ClassNotFoundException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_MERGE_CANDIDATO ORDER BY ID_CANDIDATO ASC");
		ResultSet result = stmt.executeQuery();
		List<Candidato> lista = new ArrayList<Candidato>();

		while (result.next()) {

			int codigo = result.getInt("ID_CANDIDATO");
			String nome = result.getString("NM_CANDIDATO");
			String cpf = result.getString("NR_CPF");
			String dataNascim = result.getString("DT_NASCIMENTO");
			String estadoCivil = result.getString("DS_ESTADO_CIVIL");
			String sexo = result.getString("DS_SEXO");
			String email = result.getString("DS_EMAIL");
			String senha = result.getString("PS_SENHA");
			String statusLogin = result.getString("ST_LOGIN");
			String tipoLogin = result.getString("TP_LOGIN");

			EnderecoBo endereco = new EnderecoBo(conexao);
			int codigoEndereco = endereco.listar(codigo).getCodigo();
			String cep = endereco.listar(codigo).getCep();
			String bairro = endereco.listar(codigo).getBairro();
			String numero = endereco.listar(codigo).getNumeroLogradouro();
			String nomeLogradouro = endereco.listar(codigo).getLogradouro();
			String complemento = endereco.listar(codigo).getComplemento();
			String nomeCidade = endereco.listar(codigo).getCidade();
			String nomeEstado = endereco.listar(codigo).getEstado();
			String SiglaEstado = endereco.listar(codigo).getSiglaEstado();

			TelefoneBo telefone = new TelefoneBo(conexao);
			int codigoTelefone = telefone.listar(codigo).getCodigo();
			String ddd = telefone.listar(codigo).getDdd();
			String numeroTelelefone = telefone.listar(codigo).getNumero();
			String tipoTelefone = telefone.listar(codigo).getTipo();

			DiscBo disc = new DiscBo(conexao);
			int codigoDisc = disc.listar(codigo).getCodigo();
			int dominante = disc.listar(codigo).getDominante();
			int estavel = disc.listar(codigo).getEstavel();
			int influente = disc.listar(codigo).getInfluente();
			int condescendente = disc.listar(codigo).getCondescendente();

			Disc discCandidato = new Disc(codigoDisc, dominante, estavel, influente, condescendente);
			Telefone telefoneCandidato = new Telefone(codigoTelefone, ddd, numeroTelelefone, tipoTelefone);
			Endereco enderecoCandidato = new Endereco(codigoEndereco, cep, bairro, numero, nomeLogradouro, complemento,
					nomeCidade, nomeEstado, SiglaEstado);

			CurriculoBo curriculo = new CurriculoBo(conexao);
			int codigoCurriculo = curriculo.listar(codigo).getCodigo();
			List<Curso> cursos = curriculo.listar(codigo).getCursos();
			List<Formacao> formacoes = curriculo.listar(codigo).getFormacoes();
			List<Idiomas> idiomas = curriculo.listar(codigo).getIdiomas();
			String data = curriculo.listar(codigo).getData();

			Curriculo curriculoCandidato = new Curriculo(codigoCurriculo, cursos, formacoes, idiomas, data);

			Candidato candidato = new Candidato(codigo, nome, cpf, sexo, email, senha, estadoCivil, dataNascim,
					telefoneCandidato, enderecoCandidato, curriculoCandidato, statusLogin, tipoLogin, discCandidato);

			lista.add(candidato);

		}

		return lista;
	}

	
	/**
	 * Metodo para busca de candidato
	 * @param 
	 * @return Candidato
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws ClassNotFoundException
	 */
	public Candidato select(String emailLogin, String senhaLogin)
			throws SQLException, IdNotFoundException, ClassNotFoundException {
		PreparedStatement stmt = conexao
				.prepareStatement("select * from T_MERGE_CANDIDATO where DS_EMAIL = ? AND PS_SENHA = ?");
		stmt.setString(1, emailLogin);
		stmt.setString(2, senhaLogin);

		ResultSet result = stmt.executeQuery();

		if (!result.next()) {
			throw new IdNotFoundException("CANDIDATO NÃO ENCONTRADO");
		}
		int codigo = result.getInt("ID_CANDIDATO");
		String nome = result.getString("NM_CANDIDATO");
		String cpf = result.getString("NR_CPF");
		String dataNascim = result.getString("DT_NASCIMENTO");
		String estadoCivil = result.getString("DS_ESTADO_CIVIL");
		String sexo = result.getString("DS_SEXO");
		String email = result.getString("DS_EMAIL");
		String senha = result.getString("PS_SENHA");
		String statusLogin = result.getString("ST_LOGIN");
		String tipoLogin = result.getString("TP_LOGIN");

		EnderecoBo endereco = new EnderecoBo(conexao);
		int codigoEndereco = endereco.listar(codigo).getCodigo();
		String cep = endereco.listar(codigo).getCep();
		String bairro = endereco.listar(codigo).getBairro();
		String numero = endereco.listar(codigo).getNumeroLogradouro();
		String nomeLogradouro = endereco.listar(codigo).getLogradouro();
		String complemento = endereco.listar(codigo).getComplemento();
		String nomeCidade = endereco.listar(codigo).getCidade();
		String nomeEstado = endereco.listar(codigo).getEstado();
		String SiglaEstado = endereco.listar(codigo).getSiglaEstado();

		TelefoneBo telefone = new TelefoneBo(conexao);
		int codigoTelefone = telefone.listar(codigo).getCodigo();
		String ddd = telefone.listar(codigo).getDdd();
		String numeroTelelefone = telefone.listar(codigo).getNumero();
		String tipoTelefone = telefone.listar(codigo).getTipo();

		DiscBo disc = new DiscBo(conexao);
		int codigoDisc = disc.listar(codigo).getCodigo();
		int dominante = disc.listar(codigo).getDominante();
		int estavel = disc.listar(codigo).getEstavel();
		int influente = disc.listar(codigo).getInfluente();
		int condescendente = disc.listar(codigo).getCondescendente();

		Disc discCandidato = new Disc(codigoDisc, dominante, estavel, influente, condescendente);
		Telefone telefoneCandidato = new Telefone(codigoTelefone, ddd, numeroTelelefone, tipoTelefone);
		Endereco enderecoCandidato = new Endereco(codigoEndereco, cep, bairro, numero, nomeLogradouro, complemento,
				nomeCidade, nomeEstado, SiglaEstado);

		CurriculoBo curriculo = new CurriculoBo(conexao);
		int codigoCurriculo = curriculo.listar(codigo).getCodigo();
		List<Curso> cursos = curriculo.listar(codigo).getCursos();
		List<Formacao> formacoes = curriculo.listar(codigo).getFormacoes();
		List<Idiomas> idiomas = curriculo.listar(codigo).getIdiomas();
		String data = curriculo.listar(codigo).getData();

		Curriculo curriculoCandidato = new Curriculo(codigoCurriculo, cursos, formacoes, idiomas, data);

		Candidato candidato = new Candidato(codigo, nome, cpf, sexo, email, senha, estadoCivil, dataNascim,
				telefoneCandidato, enderecoCandidato, curriculoCandidato, statusLogin, tipoLogin, discCandidato);

		return candidato;
	}

	public void remover(String cpf) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_MERGE_CANDIDATO WHERE NR_CPF = ?");

		stmt.setString(1, cpf);

		int quantidadeDadosAfetados = stmt.executeUpdate();

		if (quantidadeDadosAfetados == 0) {
			throw new IdNotFoundException("CPF NÃO ENCONTRADO PARA REMOÇÃO");

		}

	}

}
