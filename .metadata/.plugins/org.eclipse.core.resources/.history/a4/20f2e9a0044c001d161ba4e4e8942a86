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

import br.com.merge.bo.EmpresaBo;
import br.com.merge.bo.EnderecoBo;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.factory.ConnetionFactoy;
import br.com.merge.model.Empresa;

@Path("/empresa/")
public class EmpresaResource {
	
	private Connection conexao;
	EmpresaBo emp;
	EnderecoBo end;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Empresa> listaEmpresas() throws ClassNotFoundException, SQLException, IdNotFoundException {
		conexao = ConnetionFactoy.getConnection();
		emp = new 	EmpresaBo(conexao);
				return emp.listar();
	}
	
	@GET
	@Path("/{cnpj}")
	@Produces(MediaType.APPLICATION_JSON)
	public Empresa listaCNPJ(@PathParam("cnpj") String cnpj)
			throws ClassNotFoundException, SQLException, IdNotFoundException {
		emp = new EmpresaBo(conexao = ConnetionFactoy.getConnection());

		return emp.listar(cnpj);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Empresa empresa, @Context UriInfo uriInfo)
			throws SQLException, ClassNotFoundException, DadoInvalidoException {
		
		try {
			emp = new EmpresaBo(conexao = ConnetionFactoy.getConnection());
			// GERANDO O CÓDIGO DO PRODUTO
			emp.cadastrar(empresa);

			// CONSTRUIR A URI DE RETORNO
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();

			// PARSEANDO E CONCATENANDO O CÓDIGO DO PRODUTO COM A URL
			builder.path(Integer.toString(empresa.getCodigo()));
			// RETORNANDO A URL E TESTANDO A SOLICITAÇÃO E REALIZANDO O POST

			return Response.created(builder.build()).entity("\"mensagem\": \"Cadastrado com sucesso\"" ).type(MediaType.APPLICATION_JSON).build(); 
		}catch(DadoInvalidoException e) {

			return Response.status(400, e.getMessage()).entity("\"mensagem\":" + "\"" + e.getMensagem() + "\"").type(MediaType.APPLICATION_JSON).build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Empresa empresa, @PathParam("id") int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		emp = new EmpresaBo(conexao = ConnetionFactoy.getConnection());
		empresa.setCodigo(id);
		emp.atualizar(empresa);
		

		return Response.ok().build();
	
	}
	@DELETE
	@Path("{cnpj}")
	public void excluir(@PathParam("cnpj") String cnpj) throws ClassNotFoundException, SQLException, IdNotFoundException {
		emp = new EmpresaBo(conexao = ConnetionFactoy.getConnection());

		emp.remover(cnpj);
	}
}
