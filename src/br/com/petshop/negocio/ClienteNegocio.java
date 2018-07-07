/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.negocio;

import br.com.petshop.DaoDB.ClienteDaoDB;
import br.com.petshop.dominio.Cliente;
import java.util.List;


/**
 *
 * @author 180503743
 */
public class ClienteNegocio {
    
    private ClienteDaoDB clienteDao;
    
    public ClienteNegocio() {
        clienteDao = new ClienteDaoDB();
    }
    
    public void salvar(Cliente c) throws NegocioException {
        this.validarCamposObrigatorios(c);
        this.validarRgExistente(c);
        clienteDao.salvar(c);
    }
    
    public List<Cliente> listar() {
        return clienteDao.listar();
    }
    
    public void deletar(Cliente cliente) throws NegocioException {
        if (cliente == null || cliente.getRg() == null) {
            throw new NegocioException("Cliente não existe.");
        }
        clienteDao.deletar(cliente);
    }
    
    public void atualizar(Cliente cliente) throws NegocioException {
        if (cliente == null || cliente.getRg() == null) {
            throw new NegocioException("Cliente nao existe!");
        }
        this.validarCamposObrigatorios(cliente);
        clienteDao.atualizar(cliente);
    }
    
    public Cliente buscarPorRg(String rg) throws NegocioException {
        if (rg == null || rg.isEmpty()) {
            throw new NegocioException("Campo RG nao informado");
        }
        Cliente cliente = clienteDao.buscarPorRg(rg);
        if (cliente == null) {
            throw new NegocioException("Cliente nao encontrado");
        }
        return (cliente);
    }
    
    public List<Cliente> listarPorNome(String nome) throws NegocioException {
        if (nome == null || nome.isEmpty()) {
            throw new NegocioException("Campo nome nao informado");
        }
        return(clienteDao.buscarPorNome(nome));
    }
    
    public boolean clienteExiste(String rg) {
        Cliente cliente = clienteDao.buscarPorRg(rg);
        return (cliente != null);
    }

    private void validarCamposObrigatorios(Cliente c) throws NegocioException {
        if (c.getRg() == null || c.getRg().isEmpty()) {
            throw new NegocioException("Campo RG nao informado");
        }
        if (c.getNome() == null || c.getNome().isEmpty()) {
            throw new NegocioException("Campo nome nao informado");
        }
    }

    private void validarRgExistente(Cliente c) throws NegocioException {
        if (clienteExiste(c.getRg())) {
            throw new NegocioException("RG ja existente");
        }
    }
    
}
