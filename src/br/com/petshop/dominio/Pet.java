package br.com.petshop.dominio;

import java.util.Map;
import java.util.Random;

/**
*
* @author Igor Nascimento <igornascimento@gmail.com>
*/
public class Pet {

	private static int id = 0;
	private String nome;
	private int tipo;
        private int cliente;
	
	public Pet(String nome, int tipo, int cliente) {
            this.nome = nome;
            this.tipo = tipo;
            this.cliente = cliente;
	}
        
        public Pet(int id, String nome, int tipo, int cliente) {
            this.id = id;
            this.nome = nome;
            this.tipo = tipo;
            this.cliente = cliente;
	}

	public int getId() {
		return id;
	}
        
        public void setId(int id) {
                this.id = id;
        }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
        
        public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	
}
