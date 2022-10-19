package br.com.merge.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe que representa um telefone
 *@author Henrique Cesar
 *@author Dennys Nascimenro 
 *@author Luan Reis
 *@author Gustavo Fonseca
 *
 */

@XmlRootElement
public class Telefone{
 
	
	private int codigo;
    
    private String ddd;
    
    
    private String numero;
    
    private String  tipo;
    /**
     * Construtor padrão
     */
    public Telefone() {
    }

    /**
     * Construtor que recebe tipo de telefone, o numero do ddd e numero do telefone 
     * @param tipo de Telefone
     * @param numero do Ddd
     * @param numero do Telefone
     */
	public Telefone(int codigo, String ddd, String numero, String tipo) {
		this.codigo = codigo;
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}
	
	/**
	 * Cosntrutor com atributos
	 * @param ddd
	 * @param numero de telefone
	 * @param tipo de telefone
	 */
	public Telefone(String ddd, String numero, String tipo) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		
	}
	
	/**
	 * Retorna o codigo do telefone
	 * @return codigo do telefone
	 */
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Telefone [codigo=" + codigo + ", ddd=" + ddd + ", numero=" + numero + ", tipo=" + tipo + "]";
	}
	
	
        
}