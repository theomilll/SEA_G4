package br.gov.cesarschool.projetos.necessidade;

public class CategoriaNecessidade {
 private String nome;
 private String descricao;

 public CategoriaNecessidade(String nome, String descricao) {
     this.nome = nome;
     this.descricao = descricao;
 }

 public String getNome() {
     return nome;
 }

 public void setNome(String nome) {
     this.nome = nome;
 }

 public String getDescricao() {
     return descricao;
 }

 public void setDescricao(String descricao) {
     this.descricao = descricao;
 }
}
