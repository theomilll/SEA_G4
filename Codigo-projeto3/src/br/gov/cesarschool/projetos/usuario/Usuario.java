package br.gov.cesarschool.projetos.usuario;

public abstract class Usuario {
	private String nome;
	private String email;
	private String telefone;
	private int id;
	private String senha;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Usuario(String nome, String email, String telefone, int id, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.id = id;
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
