/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.Dao;

import br.com.petshop.dominio.Cliente;
import br.com.petshop.dao.Dao;
import java.util.List;

/**
 *
 * @author 180503743
 */
public interface ClienteDao extends Dao<Cliente> {
    
    public Cliente buscarPorRg(String rg);
    
    public List<Cliente> buscarPorNome(String nome);
    
}
