package br.gov.cesarschool.projetos.ong;

import br.gov.cesarschool.projetos.endereco.Endereco;
import br.gov.cesarschool.projetos.usuario.Usuario;



public class ONG extends Usuario{
	

	private String CNPJ;
	private String descricao;
	private int numeroVoluntarios;
	

	public String getDescricao() {
		return descricao;
	}
	
	public ONG(String nome, String email, String telefone, int id, String senha, Endereco endereco, String cNPJ,
			String descricao, int numeroVoluntarios) {
		super(nome, email, telefone, id, senha, endereco);
		CNPJ = cNPJ;
		this.descricao = descricao;
		this.numeroVoluntarios = numeroVoluntarios;
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
