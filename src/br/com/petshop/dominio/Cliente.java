package br.com.petshop.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class Cliente {

    private int id;
    private String rg;
    private String nome;
    private String telefone;
    private List<Pet> pets;

    public Cliente() {
    }

    public Cliente(int id, String rg, String nome, String telefone) {
            this.id = id;
            this.rg = rg;
            this.nome = nome;
            this.telefone = telefone;
            this.pets = new ArrayList<>();
    }
    
    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
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
    
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    
}
