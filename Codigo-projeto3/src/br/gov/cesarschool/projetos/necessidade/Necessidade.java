package br.gov.cesarschool.projetos.necessidade;

public class Necessidade {
    private int quantidade;
    private String categoria;

    public Necessidade( int quantidade, String categoria) {
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

  
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void atualizarQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}