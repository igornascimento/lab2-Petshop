/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.negocio;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class NegocioException extends Exception {

    public NegocioException(String s) {
        super(s);
    }

    public NegocioException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NegocioException(Throwable throwable) {
        super(throwable);
    }
}
