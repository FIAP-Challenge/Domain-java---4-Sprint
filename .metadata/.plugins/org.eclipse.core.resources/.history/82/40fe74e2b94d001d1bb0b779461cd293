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

@Path("/vaga/")
public class VagaResource {
	
	private Connection conexao;
	VagaBo vagabo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vaga> listaCandidatos() throws ClassNotFoundException, SQLException, IdNotFoundException {
		conexao = ConnetionFactoy.getConnection();
		vagabo = new 	VagaBo(conexao);
				return vagabo.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vaga listarVagas(@PathParam("id") int id)
			throws ClassNotFoundException, SQLException, IdNotFoundException {
		vagabo = new 	VagaBo(conexao = ConnetionFactoy.getConnection());

		return vagabo.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Vaga vaga, @Context UriInfo uriInfo)
			throws SQLException, ClassNotFoundException, DadoInvalidoException {
		
		try {
			vagabo = new 	VagaBo(conexao = ConnetionFactoy.getConnection());
			vagabo.cadastrar(vaga);

			UriBuilder builder = uriInfo.getAbsolutePathBuilder();

			builder.path(Integer.toString(vaga.getCodigo()));

			return Response.created(builder.build()).entity("\"mensagem\": \"Cadastrado com sucesso\"" ).type(MediaType.APPLICATION_JSON).build(); 
		}catch(DadoInvalidoException e) {

			return Response.status(400, e.getMessage()).entity("\"mensagem\":" + "\"" + e.getMensagem() + "\"").type(MediaType.APPLICATION_JSON).build();
		}
		

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Vaga vaga, @PathParam("id") int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		vagabo = new VagaBo(conexao = ConnetionFactoy.getConnection());
		
		vaga.setCodigo(id);
		vagabo.atualizar(vaga);
		

		return Response.ok().build();
	
	}

	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		vagabo = new VagaBo(conexao = ConnetionFactoy.getConnection());

		vagabo.remover(id);
	}
}
