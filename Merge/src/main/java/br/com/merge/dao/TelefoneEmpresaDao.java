package br.com.merge.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Telefone;

public class TelefoneEmpresaDao {
	
	
private Connection conexao; 
	
	/**
	 * Coleção que armazena os Endereço da aplicacao
	 */	
	
	public TelefoneEmpresaDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrar(Telefone telefone) throws SQLException {		
	
		PreparedStatement stmt = conexao.prepareStatement("insert into T_MERGE_TELEFONE_EMPRESA values "
				+ "(sq_t_merge_EMPRESA.currval, sq_T_MERGE_TELEFONE_EMPRESA.nextval, ?, ?, ?)");
		
		
		stmt.setString(1, telefone.getDdd());
		stmt.setString(2, telefone.getNumero());
		stmt.setString(3, telefone.getTipo());
	
		stmt.executeUpdate();
	}
	
	
	public void atualizar(Telefone telefone, int id) throws SQLException, IdNotFoundException {
		//Criar o PreparedStatement com o comando SQL de update
		PreparedStatement stmt = conexao.prepareStatement("update T_MERGE_TELEFONE_EMPRESA set "
				+ "NR_DDD = ?, NR_TELEFONE = ?, TP_TELEFONE = ? where id_EMPRESA = ?");
		
		//Setar os valores na query
		stmt.setString(1, telefone.getDdd());
		stmt.setString(2, telefone.getNumero());
		stmt.setString(3, telefone.getTipo());
		
		
		stmt.setInt(4, id);
	
		
		
		//Executar a query e recuperar a qtd de linhas afetadas no banco
		int qtd = stmt.executeUpdate();
		
		//Verifica se algum registro foi modificado no banco
		if (qtd == 0)
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA ATUALIZAR");
	}


	public Telefone select(int id) throws SQLException, IdNotFoundException {
		
		PreparedStatement stmt = conexao.prepareStatement("select * from T_MERGE_TELEFONE_EMPRESA where ID_EMPRESA = ?");
		
		stmt.setInt(1, id);
		
		ResultSet result = stmt.executeQuery();
		
		if(!result.next()) {
			throw new IdNotFoundException("TELEFONE NAO ENCONTRADO");
		}
		int codigo = result.getInt("ID_TELEFONE_EMPRESA");
		String ddd = result.getString("NR_DDD");
		String numero = result.getString("NR_TELEFONE");
		String tipo = result.getString("TP_TELEFONE");

				
		
		
		Telefone telefone = new Telefone(codigo, ddd, numero, tipo);		
		return telefone;
	}


	public List<Telefone> select() throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM T_MERGE_TELEFONE_EMPRESA");
		ResultSet result = stmt.executeQuery();		
		List<Telefone> lista = new ArrayList<Telefone>();
		
		while(result.next()) {
			
			int codigo = result.getInt("ID_TELEFONE_EMPRESA");
			String ddd = result.getString("NR_DDD");
			String numero = result.getString("NR_TELEFONE");
			String tipo = result.getString("TP_TELEFONE");

			
			
			Telefone telefone = new Telefone(codigo, ddd,numero, tipo);	
			
			lista.add(telefone);
			
		}
		
		return lista;
	}
	
	
	
	public void remover(int id) throws SQLException, IdNotFoundException{
		
		PreparedStatement stmt = conexao.prepareStatement("DELETE FROM T_MERGE_TELEFONE_EMPRESA WHERE ID_EMPRESA = ?");
		
		stmt.setInt(1, id);
		
		int quantidadeDadosAfetados = stmt.executeUpdate();		
		
		if(quantidadeDadosAfetados == 0) {
			throw new IdNotFoundException("ID NÃO ENCONTRADO PARA REMOÇÃO");
		}
	}
	

	
	
	
}
