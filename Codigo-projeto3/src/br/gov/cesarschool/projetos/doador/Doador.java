package br.gov.cesarschool.projetos.doador;

import br.gov.cesarschool.projetos.usuario.Usuario;

public class Doador extends Usuario{
	private String CPF;
	private String metodoDePagamento;
	
	public Doador(String nome, String email, String telefone, int id, String senha) {
		super(nome, email, telefone, id, senha);
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getMetodoDePagamento() {
		return metodoDePagamento;
	}
	public void setMetodoDePagamento(String metodoDePagamento) {
		this.metodoDePagamento = metodoDePagamento;
	}
	
	public void fazerDoacao(Doacao doacao) {
		System.out.println("Doação realizada com sucesso");
		// atualizar na planilha
	}
	
}
