package br.gov.cesarschool.projetos.endereco;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Endereco implements Serializable{


	private String logradouro;
	private int numero;
	private String complemento;
	private String CEP;
	private String cidade;
	private String estado;
	private String pais;
	
	public Endereco(String logradouro, int numero, String complemento, String CEP, String cidade, String estado, String pais){
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.CEP = CEP;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public void setCEP(String CEP) {
		this.CEP = CEP;
				
	}
	
	
	public int getNumero() {
		return this.numero;
	}
	
	public String getComplemento() {
		return this.complemento;
	}
	
	public String getLogradouro() {
		return this.logradouro;
	}
	
	
	public String getCidade() {
		return this.cidade;
	}
	
	
	public String getEstado() {
		return this.estado;
	}
	
	
	public String getPais() {
		return this.pais;
	}
	
	public String getCEP() {
		return this.CEP;
	}

}