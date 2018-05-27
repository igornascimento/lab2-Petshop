package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class Cliente {

    private String rg;
    private String nome;
    private String telefone;
    private Map<Integer, Pet> pets;

    public Cliente() {
    }

    public Cliente(String rg, String nome, String telefone) {
            this.rg = rg;
            this.nome = nome;
            this.telefone = telefone;
            this.pets = new HashMap<>();
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
    
    public Map<Integer, Pet> getPets() {
        return pets;
    }

    public void setPets(Map<Integer, Pet> pets) {
        this.pets = pets;
    }
    
    public Pet buscarPetPorNome(String nomePet) {
        for (int i=0; i < this.pets.size(); i++) {
            if (this.pets.get(i).getNome() == nomePet) {
                return this.pets.get(i);
            }
        }
        return null;
    }
    
}
