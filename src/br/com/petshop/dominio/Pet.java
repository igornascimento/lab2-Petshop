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
	private String tipo;
	private Cliente cliente;
	
	public Pet(String nome, String tipo) {
            this.nome = nome;
            this.tipo = tipo;
	}
        
        public Pet(int id, String nome, String tipo) {
            this.id = id;
            this.nome = nome;
            this.tipo = tipo;
	}
	
	public Pet(int id, String nome, String tipo, Cliente cliente) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.cliente = cliente;
	}
        
        public Pet(String nome, String tipo, Cliente cliente) {
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
