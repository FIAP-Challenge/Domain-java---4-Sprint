package br.com.merge.resource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import br.com.merge.bo.CandidaturaBo;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.factory.ConnetionFactoy;
import br.com.merge.model.Candidatura;

/**
 * Classe resource de candidatura
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
@Path("/candidatura/")
public class CandidaturaResource {

	/**
	 * Armazena a conexao
	 */
	private Connection conexao;

	/**
	 * Armazena a candidaturaBO
	 */
	CandidaturaBo cand;

	/**
	 * Retorna uma lista de candidatura
	 * 
	 * @throws ClassNotFoundException, SQLException, IdNotFoundException
	 * @return List<Candidatura>
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Candidatura> listaCandidatos() throws ClassNotFoundException, SQLException, IdNotFoundException {
		try {
			conexao = ConnetionFactoy.abrirConexao();
			cand = new CandidaturaBo(conexao);
			return cand.listar();
		} catch (IdNotFoundException e) {
			return (List<Candidatura>) Response.status(400, e.getMessage())
					.entity("\"mensagem\":" + "\"" + e.getMessage() + "\"").type(MediaType.APPLICATION_JSON).build();

		} finally {
			conexao.close();
		}

	}

	/**
	 * Retorna uma response para busca
	 * 
	 * @param codigo vaga
	 * @param codigo do candidato
	 * @throws ClassNotFoundException, SQLException, IdNotFoundException
	 * @return response
	 */
	@GET
	@Path("/vaga={vaga}&candidato={candidato}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response busca(@PathParam("vaga") int codigoVaga, @PathParam("candidato") int codigoCandidato)
			throws ClassNotFoundException, SQLException, IdNotFoundException {

		try {
			conexao = ConnetionFactoy.abrirConexao();
			cand = new CandidaturaBo(conexao);
			cand.listar(codigoVaga, codigoCandidato);
			return Response.status(200, "Já possui").build();
		} catch (IdNotFoundException e) {
			return Response.status(404, e.getMessage()).build();
		} finally {
			conexao.close();
		}

	}

	/**
	 * Retorna uma lista de candidaturas
	 * 
	 * @param id
	 * @throws ClassNotFoundException, SQLException, IdNotFoundException
	 * @return List<Candidatura>
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Candidatura> listaCandidatura(@PathParam("id") int id)
			throws ClassNotFoundException, SQLException, IdNotFoundException {
		cand = new CandidaturaBo(conexao = ConnetionFactoy.abrirConexao());

		return cand.listar(id);
	}

	/**
	 * Retorna uma response para cadastrar
	 * 
	 * @param candidatura
	 * @param uriinfo
	 * @throws SQLException, ClassNotFoundException, DadoInvalidoException
	 * @return response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Candidatura candidatura, @Context UriInfo uriInfo)
			throws SQLException, ClassNotFoundException, DadoInvalidoException {

		try {
			cand = new CandidaturaBo(conexao = ConnetionFactoy.abrirConexao());
			// GERANDO O CÓDIGO DO PRODUTO
			System.out.println(candidatura);
			cand.cadastrar(candidatura);

			// CONSTRUIR A URI DE RETORNO
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();

			// PARSEANDO E CONCATENANDO O CÓDIGO DO PRODUTO COM A URL
			builder.path(Integer.toString(candidatura.getCodigo()));
			// RETORNANDO A URL E TESTANDO A SOLICITAÇÃO E REALIZANDO O POST

			return Response.created(builder.build()).entity("\"mensagem\": \"Cadastrado com sucesso\"")
					.type(MediaType.APPLICATION_JSON).build();
		} catch (DadoInvalidoException e) {

			return Response.status(400, e.getMessage()).entity("\"mensagem\":" + "\"" + e.getMensagem() + "\"")
					.type(MediaType.APPLICATION_JSON).build();
		} finally {
			conexao.close();
		}

	}

	/**
	 * Retorna uma response para atualizar
	 * 
	 * @param candidatura
	 * @param id
	 * @throws ClassNotFoundException, SQLException, IdNotFoundException
	 * @return Response
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Candidatura candidatura, @PathParam("id") int id)
			throws ClassNotFoundException, SQLException, IdNotFoundException {

		try {
			cand = new CandidaturaBo(conexao = ConnetionFactoy.abrirConexao());
			candidatura.setCodigo(id);
			cand.atualizar(candidatura);

			return Response.ok().build();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao.close();
		}
		return null;

	}

	/**
	 * Exclui uma candidatura
	 * 
	 * @param id
	 * @throws ClassNotFoundException, SQLException, IdNotFoundException
	 */
	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		try {
			cand = new CandidaturaBo(conexao = ConnetionFactoy.abrirConexao());
			cand.remover(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			conexao.close();
		}
		
	}
}
