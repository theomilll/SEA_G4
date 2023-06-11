package br.gov.cesarschool.projetos.contato;

public class Contato {
	private String email;
    private String redesSociais;
    private String telefone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRedesSociais() {
        return redesSociais;
    }

    public void setRedesSociais(String redesSociais) {
        this.redesSociais = redesSociais;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public Contato(String email, String redesSociais, String telefone) {
		super();
		this.email = email;
		this.redesSociais = redesSociais;
		this.telefone = telefone;
	}
}


