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

import br.com.merge.bo.CandidatoBO;
import br.com.merge.bo.EnderecoBo;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.factory.ConnetionFactoy;
import br.com.merge.model.Candidato;

/**
 * Classe resource de candidato
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
@Path("/candidato/")
public class CandidatoResource {

	/**
	 * armazena a conexao
	 */
	private Connection conexao;

	/**
	 * Armazena o candidatoBO
	 */
	CandidatoBO cand;

	/**
	 * Armazena o enderecoBO
	 */
	EnderecoBo end;

	/**
	 * Retorna uma lista de candidatos
	 * 
	 * @return List<candidato>
	 * @throws ClassNotFoundException, SQLException, IdNotFoundException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Candidato> listaCandidatos() throws ClassNotFoundException, SQLException, IdNotFoundException {

		try {
			conexao = ConnetionFactoy.abrirConexao();
			cand = new CandidatoBO(conexao);
			return cand.listar();
		} catch (IdNotFoundException e) {
			return (List<Candidato>) Response.status(400, e.getMessage())
					.entity("\"mensagem\":" + "\"" + e.getMessage() + "\"").type(MediaType.APPLICATION_JSON).build();

		} finally {
			conexao.close();
		}

	}

	/**
	 * Retorna um candidato pelo cpf
	 * 
	 * @param cpf
	 * @throws ClassNotFoundException, SQLException, IdNotFoundException
	 * @return Candidato
	 */
	@GET
	@Path("/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Candidato listaProdutos(@PathParam("cpf") String cpf)
			throws ClassNotFoundException, SQLException, IdNotFoundException {
		
		try {
			cand = new CandidatoBO(conexao = ConnetionFactoy.abrirConexao());
			return cand.listar(cpf);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conexao.close();
		}
		return null;
		
	}

	/**
	 * Retorna um Reposnse para cadastrar
	 * 
	 * @param Candidaato, uriInfo
	 * @throws SQLException, ClassNotFoundException, DadoInvalidoException,
	 *                       IdNotFoundException
	 * @return Response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Candidato candidato, @Context UriInfo uriInfo)
			throws SQLException, ClassNotFoundException, DadoInvalidoException, IdNotFoundException {

		try {
			cand = new CandidatoBO(conexao = ConnetionFactoy.abrirConexao());
			// GERANDO O CÓDIGO DO PRODUTO
			cand.cadastrar(candidato);
			System.out.println(candidato.toString());

			// CONSTRUIR A URI DE RETORNO
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();

			// PARSEANDO E CONCATENANDO O CÓDIGO DO PRODUTO COM A URL
			builder.path(Integer.toString(candidato.getCodigo()));
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
	 * Retorna uma response de atualizar
	 * 
	 * @param Candidato
	 * @throws ClassNotFoundException, SQLException, IdNotFoundException
	 * @return Response
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Candidato candidato, @PathParam("id") int id)
			throws ClassNotFoundException, SQLException, IdNotFoundException {

		try {
			cand = new CandidatoBO(conexao = ConnetionFactoy.abrirConexao());
			CandidatoBO candidatoBO = new CandidatoBO(conexao);
			candidato.setCodigo(id);
			candidatoBO.atualizar(candidato);

			return Response.status(200).header("Acess-Control-Allow-Origin", "*")
					.header("Acess-Control-Allow-Credentials", "true")
					.header("Acess-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Acess-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").entity("").build();

		} catch (IdNotFoundException e) {
			return Response.status(400, e.getMessage()).entity("\"mensagem\":" + "\"" + e.getMessage() + "\"")
					.type(MediaType.APPLICATION_JSON).build();

		} finally {
			conexao.close();
		}

	}

	/**
	 * Exclui um candidato por cpf
	 * 
	 * @param cpf
	 * @throws ClassNotFoundException, SQLException, IdNotFoundException
	 */
	@DELETE
	@Path("{cpf}")
	public void excluir(@PathParam("cpf") String cpf) throws ClassNotFoundException, SQLException, IdNotFoundException {
		try{
			cand = new CandidatoBO(conexao = ConnetionFactoy.abrirConexao());
			cand.remover(cpf);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conexao.close();
		}
		
	}
}
