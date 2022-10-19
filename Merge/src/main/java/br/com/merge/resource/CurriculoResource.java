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
import br.com.merge.bo.CurriculoBo;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.factory.ConnetionFactoy;
import br.com.merge.model.Candidatura;
import br.com.merge.model.Curriculo;

/**
 * Classe resource de curriculo
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */
@Path("/curriculo/")
public class CurriculoResource {

	/**
	 * Armazena a conexão
	 */
	private Connection conexao;

	/**
	 * Armazena o curriculoBO
	 */
	CurriculoBo curriculoBo;

	/**
	 * Retorna uma response para o atualizar
	 * 
	 * @param curriculo
	 * @param id
	 * @throws ClassNotFoundException, SQLException, IdNotFoundException
	 * @return response
	 */
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Curriculo curriculo, @PathParam("id") int id)
			throws ClassNotFoundException, SQLException, IdNotFoundException {

		try {

			curriculoBo = new CurriculoBo(conexao = ConnetionFactoy.abrirConexao());
			curriculo.setCodigo(id);
			curriculoBo.atualizar(curriculo);
			return Response.status(200).header("Acess-Control-Allow-Origin", "*")
					.header("Acess-Control-Allow-Credentials", "true")
					.header("Acess-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Acess-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
					.entity("\"mensagem\": \"Atualizado com sucesso\"").type(MediaType.APPLICATION_JSON).build();
		} catch (IdNotFoundException e) {
			return Response.status(404).build();
		} finally {
			conexao.close();
		}

	}

}
