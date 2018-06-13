/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.dao;

import java.util.List;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 * @param <T>
 */
public interface Dao<T> {
    
    public void salvar(T obj);
    
    public void deletar(T obj);
    
    public void atualizar(T obj);
    
    public List<T> listar();
    
    public T buscarPorId(int id);
    
}
