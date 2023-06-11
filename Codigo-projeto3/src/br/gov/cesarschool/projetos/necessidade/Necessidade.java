package br.gov.cesarschool.projetos.necessidade;

public class Necessidade {
    private String descricao;
    private int quantidade;
    private CategoriaNecessidade categoria;

    public Necessidade(String descricao, int quantidade) {
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

	public CategoriaNecessidade getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaNecessidade categoria) {
		this.categoria = categoria;
	}
}