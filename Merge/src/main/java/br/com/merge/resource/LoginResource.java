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
import br.com.merge.bo.EmpresaBo;
import br.com.merge.bo.EnderecoBo;
import br.com.merge.excetion.DadoInvalidoException;
import br.com.merge.excetion.IdNotFoundException;
import br.com.merge.factory.ConnetionFactoy;
import br.com.merge.model.Candidato;
import br.com.merge.model.Empresa;
import br.com.merge.model.LoginUser;

/**
 * Classe responsável por pelo recurso api do login do candidato e empresa
 * 
 * @author Henrique Cesar
 * @author Dennys Nascimenro
 * @author Luan Reis
 * @author Gustavo Fonseca
 *
 */

@Path("/login/")
public class LoginResource {

	/**
	 * Atributo da conexao
	 */
	private Connection conexao;

	/**
	 * Atributo do candidatoBO
	 */
	CandidatoBO cand;

	/**
	 * Atributo da empresaBo
	 */
	EmpresaBo empr;

	/**
	 * Atributo da enderecoBo
	 */
	EnderecoBo end;

	/**
	 * Metodo para cadastrar
	 * 
	 * @param login
	 * @param uriInfo
	 * @return Response
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws DadoInvalidoException
	 * @throws IdNotFoundException
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(LoginUser login, @Context UriInfo uriInfo)
			throws SQLException, ClassNotFoundException, DadoInvalidoException, IdNotFoundException {

		try {

			cand = new CandidatoBO(conexao = ConnetionFactoy.abrirConexao());
			Candidato cadndit = cand.listar(login.getEmail(), login.getSenha());
			System.out.println(cadndit);

			return Response.ok(200).entity(cadndit).type(MediaType.APPLICATION_JSON).build();
		} catch (IdNotFoundException e) {

			try {

				empr = new EmpresaBo(conexao = ConnetionFactoy.abrirConexao());
				Empresa empres = empr.listar(login.getEmail(), login.getSenha());
				System.out.println(empres);
				return Response.ok(200).entity(empres).type(MediaType.APPLICATION_JSON).build();
			} catch (IdNotFoundException err) {
				return Response.status(400, e.getMessage()).entity("\"mensagem\":" + "\"" + e.getMessage() + "\"")
						.type(MediaType.APPLICATION_JSON).build();
			}

		} finally {
			conexao.close();
		}

	}

}
