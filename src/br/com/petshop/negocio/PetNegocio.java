/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.negocio;

import br.com.petshop.DaoDB.PetDaoDB;
import br.com.petshop.dominio.Cliente;
import br.com.petshop.dominio.Pet;
import java.util.List;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class PetNegocio {
    
    private PetDaoDB petDao;
    
    public PetNegocio() {
        petDao = new PetDaoDB();
    }
    
    public void salvar(Pet p) throws NegocioException {
        this.validarCamposObrigatorios(p);
        petDao.salvar(p);
    }
    
    public List<Pet> listar() {
        return petDao.listar();
    }
    
    public void deletar(Pet pet) throws NegocioException {
        if (pet == null || pet.getNome() == null) {
            throw new NegocioException("Pet não existe.");
        }
        petDao.deletar(pet);
    }
    
    public void atualizar(Pet pet) throws NegocioException {
        if (pet == null || pet.getNome() == null) {
            throw new NegocioException("Pet nao existe!");
        }
        this.validarCamposObrigatorios(pet);
        petDao.atualizar(pet);
    }
    
    public List<Pet> buscarPorNome(String nome) throws NegocioException {
        if (nome == null || nome.isEmpty()) {
            throw new NegocioException("Campo nome nao informado");
        }
        return(petDao.buscarPorNome(nome));
    }
    
    public boolean petExisteParaCliente(Cliente cliente, String nomePet) {
        List<Pet> petList = petDao.buscarPorNomeParaCliente(cliente, nomePet);
        if (petList.size() > 0) {
            return true;
        }
        return false;
    }

    private void validarCamposObrigatorios(Pet p) throws NegocioException {
        if (p.getNome() == null || p.getNome().isEmpty()) {
            throw new NegocioException("Campo nome nao informado");
        }
    }
    
}
