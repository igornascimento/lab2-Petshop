package lab2.petshop.model;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class Cliente {

    private String rg;
    private String nome;
    private String telefone;

    public Cliente() {
    }

    public Cliente(String rg, String nome, String telefone) {
            this.rg = rg;
            this.nome = nome;
            this.telefone = telefone;
    }

    public String getRg() {
            return rg;
    }

    public void setRg(String rg) {
            this.rg = rg;
    }

    public String getNome() {
            return nome;
    }

    public void setNome(String nome) {
            this.nome = nome;
    }

    public String getTelefone() {
            return telefone;
    }

    public void setTelefone(String telefone) {
            this.telefone = telefone;
    }
    
}