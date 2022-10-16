package br.com.merge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Endereco;

public class EnderecoEmpresaDao {
	
	
private Connection conexao; 
	
	/**
	 * Coleção que armazena os Endereço da aplicacao
	 */
	List<Endereco> listaEndereco = new ArrayList<>();
	
	
	public EnderecoEmpresaDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrar(Endereco endereco) throws SQLException {		
	
		PreparedStatement stmt = conexao.prepareStatement("insert into T_MERGE_ENDERECO_EMPRESA values "
				+ "(sq_t_merge_empresa.currval, sq_t_merge_endereco_empresa.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		
		stmt.setString(1, endereco.getCep());
		stmt.setString(2, endereco.getBairro());
		stmt.setString(3, endereco.getLogradouro());
		stmt.setInt(4, endereco.getNumeroLogradouro());
		stmt.setString(5, endereco.getComplemento());
		stmt.setString(6, endereco.getPontoReferencia());
		stmt.setString(7, endereco.getCidade());
		stmt.setString(8, endereco.getEstado());
		stmt.setString(9, endereco.getSiglaEstado());
	
		stmt.executeUpdate();
	}
	
	
	public void atualizar(Endereco endereco, int id) throws SQLException, IdNotFoundException {
		//Criar o PreparedStatement com o comando SQL de update
		PreparedStatement stmt = conexao.prepareStatement("update T_MERGE_ENDERECO_EMPRESA set "
				+ "DS_CEP = ?, NM_BAIRRO = ?, NM_LOGRADOURO = ?, NR_LOGRADOURO = ?, DS_COMPLEMENTO = ? , DS_PONTO_REFERENCIA = ?, NM_CIDADE = ?, NM_ESTADO = ?, SG_ESTADO = ? where  id_empresa = ?");
		
		//Setar os valores na query
		stmt.setString(1, endereco.getCep());
		stmt.setString(2, endereco.getBairro());
		stmt.setString(3, endereco.getLogradouro());
		stmt.setInt(4, endereco.getNumeroLogradouro());
		stmt.setString(5, endereco.getComplemento());
		stmt.setString(6, endereco.getPontoReferencia());
		stmt.setString(7, endereco.getCidade());
		stmt.setString(8, endereco.getEstado());
		stmt.setString(9, endereco.getSiglaEstado());
		
		
		stmt.setInt(10, id);
		System.out.println(endereco.toString());
		
		
		
		//Executar a query e recuperar a qtd de linhas afetadas no banco
		int qtd = stmt.executeUpdate();
		
		//Verifica se algum registro foi modificado no banco
		if (qtd == 0)
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA ATUALIZAR");
	}


	public Endereco select(int id) throws SQLException, IdNotFoundException {
		
		PreparedStatement stmt = conexao.prepareStatement("select * from T_MERGE_ENDERECO_empresa where ID_empresa = ?");
		
		stmt.setInt(1, id);
		
		ResultSet result = stmt.executeQuery();
		
		if(!result.next()) {
			throw new IdNotFoundException("ENDEREÇO NAO ENCONTRADO");
		}
		int codigo = result.getInt("ID_ENDERECO_EMPRESA");
		String cep = result.getString("DS_CEP");
		String bairro = result.getString("NM_BAIRRO");
		String nomeLogradouro = result.getString("NM_LOGRADOURO");
		int numeroLogradouro = result.getInt("NR_LOGRADOURO");
		String complemento = result.getString("DS_COMPLEMENTO");
		String pontoReferencia = result.getString("DS_PONTO_REFERENCIA");
		String cidade = result.getString("NM_CIDADE");
		String estado = result.getString("NM_ESTADO");
		String siglaEstado = result.getString("SG_ESTADO");
		
				
		
		
		Endereco endereco = new Endereco(codigo, cep, bairro , numeroLogradouro, nomeLogradouro, complemento, pontoReferencia, cidade, estado, siglaEstado);		
		return endereco;
	}


	public List<Endereco> select() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_MERGE_ENDERECO_EMPRESA");
		ResultSet result = stmt.executeQuery();		
		List<Endereco> lista = new ArrayList<Endereco>();
		
		while(result.next()) {
			
			int codigo = result.getInt("ID_ENDERECO_EMPRESA");
			String cep = result.getString("DS_CEP");
			String bairro = result.getString("NM_BAIRRO");
			String nomeLogradouro = result.getString("NM_LOGRADOURO");
			int numeroLogradouro = result.getInt("NR_LOGRADOURO");
			String complemento = result.getString("DS_COMPLEMENTO");
			String pontoReferencia = result.getString("DS_PONTO_REFERENCIA");
			String cidade = result.getString("NM_CIDADE");
			String estado = result.getString("NM_ESTADO");
			String siglaEstado = result.getString("SG_ESTADO");
			
			Endereco endereco = new Endereco(codigo, cep, bairro, numeroLogradouro, nomeLogradouro, complemento, pontoReferencia, cidade, estado, siglaEstado);	
			
			lista.add(endereco);
			
		}
		
		return lista;
	}
	
	
	
	
	
	
	public void remover(int id) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_MERGE_ENDERECO WHERE ID_ENDERECO_CANDIDATO = ?");
		
		stmt.setInt(1, id);
		
		int quantidadeDadosAfetados = stmt.executeUpdate();		
		
		if(quantidadeDadosAfetados == 0) {
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA REMOÇÃO");
		}
	}
	

	
	
	
}
