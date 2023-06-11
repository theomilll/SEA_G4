package br.gov.cesarschool.projetos.doador;

import br.gov.cesarschool.projetos.endereco.Endereco;
import br.gov.cesarschool.projetos.usuario.Usuario;

public class Doador extends Usuario{
	private String CPF;
	private String metodoDePagamento;
	


	public Doador(String nome, String email, String telefone, int id, String senha, Endereco endereco, String cPF,
			String metodoDePagamento) {
		super(nome, email, telefone, id, senha, endereco);
		CPF = cPF;
		this.metodoDePagamento = metodoDePagamento;
	}
	public String getCPF() {
		return CPF;
	}
	public String getMetodoDePagamento() {
		return metodoDePagamento;
	}
	public void setMetodoDePagamento(String metodoDePagamento) {
		this.metodoDePagamento = metodoDePagamento;
	}
	
	public void fazerDoacao(ItemDoacao doacao) {
		
		System.out.println("Doação realizada");
		// atualizar na planilha
	}
	
}
