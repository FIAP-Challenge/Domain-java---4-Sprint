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
import br.com.merge.bo.VagaBo;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.factory.ConnetionFactoy;
import br.com.merge.model.Vaga;

/**
 * Classe responsável por pelo recurso api da vaga
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
@Path("/vaga/")
public class VagaResource {

	/**
	 * Atributo da conexao
	 */
	private Connection conexao;

	/**
	 * Atributo da business object da classe
	 */
	VagaBo vagabo;

	/**
	 * Metodo para listar
	 * 
	 * @return lista de vagas
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vaga> listaCandidatos() throws ClassNotFoundException, SQLException, IdNotFoundException {
		try {
			conexao = ConnetionFactoy.abrirConexao();
			vagabo = new VagaBo(conexao);
			return vagabo.listar();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conexao.close();
		}
		
		return null;
		
	}

	/**
	 * Metodo para buscar uma vaga pelo id
	 * 
	 * @param id
	 * @return vaga
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vaga listarVagas(@PathParam("id") int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		
		try {
			vagabo = new VagaBo(conexao = ConnetionFactoy.abrirConexao());
			return vagabo.listar(id);
		}finally {
			conexao.close();
		}
	
	}

	/**
	 * Metodo para cadastrar
	 * 
	 * @param vaga
	 * @param uriInfo
	 * @return Response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws DadoInvalidoException
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Vaga vaga, @Context UriInfo uriInfo)
			throws SQLException, ClassNotFoundException, DadoInvalidoException {

		try {
			vagabo = new VagaBo(conexao = ConnetionFactoy.abrirConexao());
			vagabo.cadastrar(vaga);

			UriBuilder builder = uriInfo.getAbsolutePathBuilder();

			builder.path(Integer.toString(vaga.getCodigo()));

			return Response.created(builder.build()).entity("\"mensagem\": \"Cadastrado com sucesso\"")
					.type(MediaType.APPLICATION_JSON).build();
		} catch (DadoInvalidoException e) {

			return Response.status(400, e.getMessage()).entity("\"mensagem\":" + "\"" + e.getMensagem() + "\"")
					.type(MediaType.APPLICATION_JSON).build();
		}finally {
			conexao.close();
		}

	}

	/**
	 * Metodo para atualizar pelo id da vaga
	 * 
	 * @param vaga
	 * @param id
	 * @return Response
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Vaga vaga, @PathParam("id") int id)
			throws ClassNotFoundException, SQLException, IdNotFoundException {
		
		try {
			vagabo = new VagaBo(conexao = ConnetionFactoy.abrirConexao());
			vaga.setCodigo(id);
			vagabo.atualizar(vaga);
			return Response.ok().build();
		}finally {
			conexao.close();
		}
		
		

	}

	/**
	 * Metodo para deletar pelo id da vaga
	 * 
	 * @param id
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IdNotFoundException
	 */
	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		
		try {
			vagabo = new VagaBo(conexao = ConnetionFactoy.abrirConexao());
			vagabo.remover(id);
		}finally {
			conexao.close();
		}
		
	}
}
