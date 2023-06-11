package br.gov.cesarschool.projetos.doador;

public class ItemDoacao {
    private String item;
    private int quantidade;

    public ItemDoacao(String item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void atualizarQuantidade(int novaQuantidade) {
        quantidade = novaQuantidade;
    }

    public void atualizarItemDoacao(ItemDoacao novoItemDoacao) {
        item = novoItemDoacao.getItem();
        quantidade = novoItemDoacao.getQuantidade();
    }

    public void removerItemDoacao(ItemDoacao itemRemovido) {
        if (item.equals(itemRemovido.getItem())) {
            quantidade -= itemRemovido.getQuantidade();
            if (quantidade < 0) {
                quantidade = 0;
            }
        }
    }
}