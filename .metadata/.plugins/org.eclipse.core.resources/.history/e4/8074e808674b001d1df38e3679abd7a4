package br.com.merge.bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.merge.dao.CandidatoDao;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.model.Candidato;
import br.com.merge.model.Disc;

public class CandidatoBO {

	private CandidatoDao candidato;
	private EnderecoBo enderecobo;
	private TelefoneBo telefonebo;
	private CurriculoBo curriculobo;
	private DiscBo discBo;
	private Connection conexao;

	public CandidatoBO(Connection conexao) {
		this.conexao = conexao;
		candidato = new CandidatoDao(conexao);
		telefonebo = new TelefoneBo(conexao);
		enderecobo = new EnderecoBo(conexao);
		curriculobo = new CurriculoBo(conexao);
		discBo = new DiscBo(conexao);
	}

	public List<Candidato> listar() throws ClassNotFoundException, SQLException, IdNotFoundException {

		return candidato.select();
	}

	public Candidato listar(String cpf) throws SQLException, IdNotFoundException, ClassNotFoundException {

		return candidato.select(cpf);
	}

	public void cadastrar(Candidato cand) throws SQLException, ClassNotFoundException, DadoInvalidoException {

		conexao.setAutoCommit(false);

		try {
			candidato.cadastrar(cand);
			telefonebo.cadastrar(cand.getTelefone());
			enderecobo.cadastrar(cand.getEndereco());
			curriculobo.cadastrar(cand.getCurriculo());

			System.out.println("Qual é esse candidato" + cand.toString());
			
			if (cand.getDisc() == null) {
				Disc disc = new Disc();
				discBo.cadastrar(disc);
			} else {

				discBo.cadastrar(cand.getDisc());
			}
		
		} catch (SQLException e) {
			
			conexao.commit();
			throw new DadoInvalidoException(e.getMessage());
		}

		try {
			conexao.commit();
			System.out.println("comitou");
		} catch (Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar o commit");
		}

	}

	public void atualizar(Candidato cand) throws ClassNotFoundException, SQLException, IdNotFoundException {
		conexao.setAutoCommit(false);

		if (cand.getDisc() != null) {
			candidato.atualizar(cand);
			telefonebo.atualizar(cand.getTelefone(), cand.getCodigo());
			enderecobo.atualizar(cand.getEndereco(), cand.getCodigo());
//			discbo.atualizar(cand.getDisc(), cand.getCodigo());
		} else {
			candidato.atualizar(cand);
			telefonebo.atualizar(cand.getTelefone(), cand.getCodigo());
			enderecobo.atualizar(cand.getEndereco(), cand.getCodigo());
		}

		try {
			conexao.commit();
		} catch (Exception e) {
			conexao.rollback();
			throw new SQLException("Erro ao realizar o commit");
		}
	}

	public void remover(String cpf) throws SQLException, IdNotFoundException, ClassNotFoundException {
		candidato.remover(cpf);

	}

}
