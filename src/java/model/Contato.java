
package model;


public class Contato{
    private String nome;
    private String email;
    private Empresa empresa;

    public Contato() {
    }

    public Contato(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Contato(String nome, String email, Empresa empresa) {
        this.nome = nome;
        this.email = email;
        this.empresa = empresa;
    }
    
    public Contato(String nome) {
        this.nome=nome;
    }

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    
    
}
