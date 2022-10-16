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
import br.com.merge.bo.DiscBo;
import br.com.merge.bo.VagaBo;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.factory.ConnetionFactoy;
import br.com.merge.model.Candidatura;
import br.com.merge.model.Disc;
import br.com.merge.model.Vaga;

@Path("/disc/")
public class DiscResource {
	
	private Connection conexao;
	DiscBo discBo;
	

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Disc listar(@PathParam("id") int id)
			throws ClassNotFoundException, SQLException, IdNotFoundException {
		discBo = new DiscBo(conexao = ConnetionFactoy.getConnection());

		return discBo.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Disc disc, @Context UriInfo uriInfo)
			throws SQLException, ClassNotFoundException, DadoInvalidoException {
		
		
			discBo = new DiscBo(conexao = ConnetionFactoy.getConnection());
			// GERANDO O CÓDIGO DO PRODUTO
			discBo.cadastrar(disc);

			// CONSTRUIR A URI DE RETORNO
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();

			// PARSEANDO E CONCATENANDO O CÓDIGO DO PRODUTO COM A URL
			builder.path(Integer.toString(disc.getCodigo()));
			// RETORNANDO A URL E TESTANDO A SOLICITAÇÃO E REALIZANDO O POST

			return Response.created(builder.build()).entity("\"mensagem\": \"Cadastrado com sucesso\"" ).type(MediaType.APPLICATION_JSON).build();
			
		

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Disc disc, @PathParam("id") int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		discBo = new DiscBo(conexao = ConnetionFactoy.getConnection());
		
		disc.setCodigo(id);
		discBo.atualizar(disc, id);
		
		return Response.ok().build();
	
	}

	@DELETE
	@Path("{id}")
	public void excluir(@PathParam("id") int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		discBo = new DiscBo(conexao = ConnetionFactoy.getConnection());

		discBo.remover(id);
	}
}
