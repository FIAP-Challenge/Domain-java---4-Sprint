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

@Path("/candidatura/")
public class CandidaturaResource {
	
	private Connection conexao;
	CandidaturaBo cand;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Candidatura> listaCandidatos() throws ClassNotFoundException, SQLException, IdNotFoundException {
		conexao = ConnetionFactoy.getConnection();
		cand = new CandidaturaBo(conexao);
				return cand.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Candidatura> listaCandidatura(@PathParam("id") int id)
			throws ClassNotFoundException, SQLException, IdNotFoundException {
		cand = new 	CandidaturaBo(conexao = ConnetionFactoy.getConnection());

		return cand.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Candidatura candidatura, @Context UriInfo uriInfo)
			throws SQLException, ClassNotFoundException, DadoInvalidoException {
		
		try {
			cand = new 	CandidaturaBo(conexao = ConnetionFactoy.getConnection());
			// GERANDO O CÓDIGO DO PRODUTO
			System.out.println(candidatura);
			cand.cadastrar(candidatura);

			// CONSTRUIR A URI DE RETORNO
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();

			// PARSEANDO E CONCATENANDO O CÓDIGO DO PRODUTO COM A URL
			builder.path(Integer.toString(candidatura.getCodigo()));
			// RETORNANDO A URL E TESTANDO A SOLICITAÇÃO E REALIZANDO O POST

			return Response.created(builder.build()).entity("\"mensagem\": \"Cadastrado com sucesso\"" ).type(MediaType.APPLICATION_JSON).build(); 
		}catch(DadoInvalidoException e) {

			return Response.status(400, e.getMessage()).entity("\"mensagem\":" + "\"" + e.getMensagem() + "\"").type(MediaType.APPLICATION_JSON).build();
		}
		

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Candidatura candidatura, @PathParam("id") int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		cand = new 	CandidaturaBo(conexao = ConnetionFactoy.getConnection());
		candidatura.setCodigo(id);
		cand.atualizar(candidatura);
		

		return Response.ok().build();
	
	}

	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		cand = new 	CandidaturaBo(conexao = ConnetionFactoy.getConnection());

		cand.remover(id);
	}
}
