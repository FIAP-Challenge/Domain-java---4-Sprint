package br.com.merge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.merge.bo.EnderecoEmpresaBo;
import br.com.merge.bo.TelefoneEmpresaBo;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Empresa;
import br.com.merge.model.Endereco;
import br.com.merge.model.Telefone;

/**
 * Classe responsável por cadastrar, encontrar, listar
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
public class EmpresaDao {

	/**
	 * Atributo da conexao
	 */
	private Connection conexao;

	/**
	 * Construtor da classe
	 * 
	 * @param conexao
	 */
	public EmpresaDao(Connection conexao) {
		this.conexao = conexao;
	}

	/**
	 * Metodo para cadastrar
	 * 
	 * @param empresa
	 * @throws SQLException
	 * @throws DadoInvalidoException
	 */
	public void cadastrar(Empresa empresa) throws SQLException, DadoInvalidoException {

		PreparedStatement stmt = conexao.prepareStatement(
				"insert into T_MERGE_EMPRESA values " + "(SQ_T_MERGE_EMPRESA.nextval, ?, ?, ?, ?, ?, ?, ?, ? )",
				new String[] { "ID_EMPRESA" });

		stmt.setString(1, empresa.getDescricao());
		stmt.setString(2, empresa.getNome());
		stmt.setString(3, empresa.getCnpj());
		stmt.setString(4, empresa.getResponsavel());
		stmt.setString(5, empresa.getEmail());
		stmt.setString(6, empresa.getSenha());
		stmt.setString(7, "A");
		stmt.setString(8, "E");

		try {
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DadoInvalidoException(e.getMessage());
		}

		ResultSet result = stmt.getGeneratedKeys();
		if (result.next()) {
			int codigo = result.getInt(1);
			empresa.setCodigo(codigo);
		}

	}

	/**
	 * Metodo para atualizar
	 * 
	 * @param empresa
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void atualizar(Empresa empresa) throws SQLException, IdNotFoundException {
		// Criar o PreparedStatement com o comando SQL de update
		PreparedStatement stmt = conexao.prepareStatement(
				"UPDATE T_MERGE_EMPRESA SET DS_EMPRESA = ?, NM_EMPRESA = ?, NR_CNPJ = ?, NM_RESPONSAVEL = ? , DS_EMAIL = ?, PS_SENHA = ?,  ST_LOGIN = ?, TP_LOGIN = ?  where ID_EMPRESA = ?");

		stmt.setString(1, empresa.getDescricao());
		stmt.setString(2, empresa.getNome());
		stmt.setString(3, empresa.getCnpj());
		stmt.setString(4, empresa.getResponsavel());
		stmt.setString(5, empresa.getEmail());
		stmt.setString(6, empresa.getSenha());
		stmt.setString(7, "A");
		stmt.setString(8, "E");
		stmt.setInt(9, empresa.getCodigo());
		System.out.println(empresa.toString());

		int qtd = stmt.executeUpdate();

		if (qtd == 0)
			throw new IdNotFoundException("Não localizado para alterar");

	}

	/**
	 * Método que encontra na lista o candidato pelo cnpj
	 * 
	 * @param cnpj empresa
	 * @return empresa
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws ClassNotFoundException
	 */
	public Empresa select(String cnpj) throws SQLException, IdNotFoundException, ClassNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("select * from T_MERGE_EMPRESA where NR_CNPJ = ?");

		stmt.setString(1, cnpj);

		ResultSet result = stmt.executeQuery();

		if (!result.next()) {
			throw new IdNotFoundException("EMPRESA NÃO ENCONTRADA");
		}
		int codigo = result.getInt("ID_EMPRESA");
		String descricao = result.getString("DS_EMPRESA");
		String nome = result.getString("NM_EMPRESA");
		String numeroCnpj = result.getString("NR_CNPJ");
		String nomeResponsavel = result.getString("NM_RESPONSAVEL");
		String email = result.getString("DS_EMAIL");
		String senha = result.getString("PS_SENHA");
		String statusLogin = result.getString("ST_LOGIN");
		String tipoLogin = result.getString("TP_LOGIN");

		EnderecoEmpresaBo endereco = new EnderecoEmpresaBo(conexao);
		int codigoEndereco = endereco.listar(codigo).getCodigo();
		String cep = endereco.listar(codigo).getCep();
		String bairro = endereco.listar(codigo).getBairro();
		String numero = endereco.listar(codigo).getNumeroLogradouro();
		String nomeLogradouro = endereco.listar(codigo).getLogradouro();
		String complemento = endereco.listar(codigo).getComplemento();
		String nomeCidade = endereco.listar(codigo).getCidade();
		String nomeEstado = endereco.listar(codigo).getEstado();
		String SiglaEstado = endereco.listar(codigo).getSiglaEstado();

		TelefoneEmpresaBo telefone = new TelefoneEmpresaBo(conexao);
		int codigoTelefone = telefone.listar(codigo).getCodigo();
		String ddd = telefone.listar(codigo).getDdd();
		String numeroTelelefone = telefone.listar(codigo).getNumero();
		String tipoTelefone = telefone.listar(codigo).getTipo();

		Telefone telefoneCandidato = new Telefone(codigoTelefone, ddd, numeroTelelefone, tipoTelefone);
		Endereco enderecoCandidato = new Endereco(codigoEndereco, cep, bairro, numero, nomeLogradouro, complemento,
				nomeCidade, nomeEstado, SiglaEstado);

		Empresa empresa = new Empresa(codigo, descricao, nome, numeroCnpj, nomeResponsavel, email, senha,
				enderecoCandidato, telefoneCandidato, statusLogin, tipoLogin);

		return empresa;
	}

	/**
	 * Metodo para selecionar uma empresa
	 * 
	 * @param emailLogin
	 * @param senhaLogin
	 * @return empresa
	 * @throws SQLException
	 * @throws IdNotFoundException
	 * @throws ClassNotFoundException
	 */

	public Empresa select(String emailLogin, String senhaLogin)
			throws SQLException, IdNotFoundException, ClassNotFoundException {

		PreparedStatement stmt = conexao
				.prepareStatement("select * from T_MERGE_EMPRESA where DS_EMAIL = ? and PS_SENHA = ?");

		stmt.setString(1, emailLogin);
		stmt.setString(2, senhaLogin);

		ResultSet result = stmt.executeQuery();

		if (!result.next()) {
			throw new IdNotFoundException("EMPRESA NÃO ENCONTRADA");
		}
		int codigo = result.getInt("ID_EMPRESA");
		String descricao = result.getString("DS_EMPRESA");
		String nome = result.getString("NM_EMPRESA");
		String numeroCnpj = result.getString("NR_CNPJ");
		String nomeResponsavel = result.getString("NM_RESPONSAVEL");
		String email = result.getString("DS_EMAIL");
		String senha = result.getString("PS_SENHA");
		String statusLogin = result.getString("ST_LOGIN");
		String tipoLogin = result.getString("TP_LOGIN");

		EnderecoEmpresaBo endereco = new EnderecoEmpresaBo(conexao);
		int codigoEndereco = endereco.listar(codigo).getCodigo();
		String cep = endereco.listar(codigo).getCep();
		String bairro = endereco.listar(codigo).getBairro();
		String numero = endereco.listar(codigo).getNumeroLogradouro();
		String nomeLogradouro = endereco.listar(codigo).getLogradouro();
		String complemento = endereco.listar(codigo).getComplemento();
		String nomeCidade = endereco.listar(codigo).getCidade();
		String nomeEstado = endereco.listar(codigo).getEstado();
		String SiglaEstado = endereco.listar(codigo).getSiglaEstado();

		TelefoneEmpresaBo telefone = new TelefoneEmpresaBo(conexao);
		int codigoTelefone = telefone.listar(codigo).getCodigo();
		String ddd = telefone.listar(codigo).getDdd();
		String numeroTelelefone = telefone.listar(codigo).getNumero();
		String tipoTelefone = telefone.listar(codigo).getTipo();

		Telefone telefoneCandidato = new Telefone(codigoTelefone, ddd, numeroTelelefone, tipoTelefone);
		Endereco enderecoCandidato = new Endereco(codigoEndereco, cep, bairro, numero, nomeLogradouro, complemento,
				nomeCidade, nomeEstado, SiglaEstado);

		Empresa empresa = new Empresa(codigo, descricao, nome, numeroCnpj, nomeResponsavel, email, senha,
				enderecoCandidato, telefoneCandidato, statusLogin, tipoLogin);

		return empresa;
	}

	/**
	 * Metodo para listar empresas
	 * 
	 * @return lista empresas
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IdNotFoundException
	 */
	public List<Empresa> select() throws SQLException, ClassNotFoundException, IdNotFoundException {
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_MERGE_EMPRESA");
		ResultSet result = stmt.executeQuery();
		List<Empresa> lista = new ArrayList<Empresa>();

		while (result.next()) {

			int codigo = result.getInt("ID_EMPRESA");
			String descricao = result.getString("DS_EMPRESA");
			String nome = result.getString("NM_EMPRESA");
			String numeroCnpj = result.getString("NR_CNPJ");
			String nomeResponsavel = result.getString("NM_RESPONSAVEL");
			String email = result.getString("DS_EMAIL");
			String senha = result.getString("PS_SENHA");
			String statusLogin = result.getString("ST_LOGIN");
			String tipoLogin = result.getString("TP_LOGIN");

			EnderecoEmpresaBo endereco = new EnderecoEmpresaBo(conexao);
			int codigoEndereco = endereco.listar(codigo).getCodigo();
			String cep = endereco.listar(codigo).getCep();
			String bairro = endereco.listar(codigo).getBairro();
			String numero = endereco.listar(codigo).getNumeroLogradouro();
			String nomeLogradouro = endereco.listar(codigo).getLogradouro();
			String complemento = endereco.listar(codigo).getComplemento();
			String nomeCidade = endereco.listar(codigo).getCidade();
			String nomeEstado = endereco.listar(codigo).getEstado();
			String SiglaEstado = endereco.listar(codigo).getSiglaEstado();

			TelefoneEmpresaBo telefone = new TelefoneEmpresaBo(conexao);
			int codigoTelefone = telefone.listar(codigo).getCodigo();
			String ddd = telefone.listar(codigo).getDdd();
			String numeroTelelefone = telefone.listar(codigo).getNumero();
			String tipoTelefone = telefone.listar(codigo).getTipo();

			Telefone telefoneCandidato = new Telefone(codigoTelefone, ddd, numeroTelelefone, tipoTelefone);
			Endereco enderecoCandidato = new Endereco(codigoEndereco, cep, bairro, numero, nomeLogradouro, complemento,
					nomeCidade, nomeEstado, SiglaEstado);

			Empresa empresa = new Empresa(codigo, descricao, nome, numeroCnpj, nomeResponsavel, email, senha,
					enderecoCandidato, telefoneCandidato, statusLogin, tipoLogin);

			lista.add(empresa);

		}

		return lista;
	}

	/**
	 * Metodo para remover pelo cnpj da empresa
	 * 
	 * @param cnpj
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	public void remover(String cnpj) throws SQLException, IdNotFoundException {

		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_MERGE_EMPRESA WHERE NR_CNPJ= ?");

		stmt.setString(1, cnpj);

		int quantidadeDadosAfetados = stmt.executeUpdate();

		if (quantidadeDadosAfetados == 0) {
			throw new IdNotFoundException("CNPJ NÃO ENCONTRADO PARA REMOÇÃO");

		}

	}

}
