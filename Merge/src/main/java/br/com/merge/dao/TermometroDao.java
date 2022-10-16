package br.com.merge.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.merge.model.Termometro;

/**
 *Classe responsável por adicionar, filtrar e listar um Termometro
 *@author Henrique Cesar
 *@author Dennys Nascimenro 
 *@author Luan Reis
 *@author Gustavo Fonseca
 *
 */

public class TermometroDao {
	
	/**
	 * Coleção que armazena os Termometro da aplicacao
	 */
	List<Termometro> listaTermometro = new ArrayList<>();
	
	public void addTermometro(Termometro termometro) {
		listaTermometro.add(termometro);
	}
	
	/**
	 * Método que filtra termometro acima do score 80
	 * @return candidatos com score acima de 80
	 */
	public List<Termometro> filtroAcima80(){
		List<Termometro> acima80 = new ArrayList<>();
		listaTermometro.forEach(e -> {if(e.getNrScore() >= 80){acima80.add(e);}});
		return acima80;
		}
	
	/**
	 * Método que filtra termometro acima do score 70
	 * @return candidatos com score acima de 70
	 */
	public List<Termometro> filtroAcima70(){
		List<Termometro> acima70 = new ArrayList<>();
		listaTermometro.forEach(e -> {if(e.getNrScore() >= 70){acima70.add(e);}});
		return acima70;
		}
	
	/**
	 * Método que filtra termometro acima do score 60
	 * @return lista de termometro acima de 60 de score
	 */
	public List<Termometro> filtroAcima60(){
		List<Termometro> acima60 = new ArrayList<>();
		listaTermometro.forEach(e -> {if(e.getNrScore() >= 60){acima60.add(e);}});
		return acima60;
		}
	
	/**
	 * Método que filtra termometros acima do score 50
	 * @return lista de termometros acima de 50 score
	 */
	public List<Termometro> filtroAcima50(){
		List<Termometro> acima50 = new ArrayList<>();
		listaTermometro.forEach(e -> {if(e.getNrScore() >= 50){acima50.add(e);}});
		return acima50;
		}

	/**
	 * Lista os termometros
	 * @return lista de termometro
	 */
	public List<Termometro> listar(){
		return listaTermometro;
	}
	
}
