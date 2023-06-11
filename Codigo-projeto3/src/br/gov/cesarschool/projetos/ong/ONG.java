package br.gov.cesarschool.projetos.ong;

import br.gov.cesarschool.projetos.usuario.Usuario;



public class ONG extends Usuario{
	
	public ONG(String nome, String email, String telefone, int id, String senha) {
		super(nome, email, telefone, id, senha);
		
	}
	private String CNPJ;
	private String descricao;
	private int numeroVoluntarios;
	

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public int getNumeroVoluntarios() {
		return numeroVoluntarios;
	}
	public void setNumeroVoluntarios(int numeroVoluntarios) {
		this.numeroVoluntarios = numeroVoluntarios;
	}
}
