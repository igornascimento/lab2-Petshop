package br.com.petshop.dominio;

import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class Cliente {

    private SimpleIntegerProperty id;
    private SimpleStringProperty rg;
    private SimpleStringProperty nome;
    private SimpleStringProperty telefone;
    private Map<Integer, Pet> pets;

    public Cliente() {
    }

    public Cliente(int id, String rg, String nome, String telefone) {
            this.id = new SimpleIntegerProperty(id);
            this.rg = new SimpleStringProperty(rg);
            this.nome = new SimpleStringProperty(nome);
            this.telefone = new SimpleStringProperty(telefone);
            this.pets = new HashMap<>();
    }
    
    public Cliente(String rg, String nome, String telefone) {
            this.rg = new SimpleStringProperty(rg);
            this.nome = new SimpleStringProperty(nome);
            this.telefone = new SimpleStringProperty(telefone);
    }
    
    public int getId() {
            return id.get();
    }

    public void setId(int id) {
            this.id.set(id);
    }

    public String getRg() {
            return rg.get();
    }

    public void setRg(String rg) {
            this.rg.set(rg);
    }

    public String getNome() {
            return nome.get();
    }

    public void setNome(String nome) {
            this.nome.set(nome);
    }

    public String getTelefone() {
            return telefone.get();
    }

    public void setTelefone(String telefone) {
            this.telefone.set(telefone);
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
