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
	private Cliente cliente;
	
	public Pet(String nome, int tipo) {
            this.id = ++this.id;
            this.nome = nome;
            this.tipo = tipo;
	}
	
	public Pet(String nome, int tipo, Cliente cliente) {
		this.id = ++this.id;
		this.nome = nome;
		this.tipo = tipo;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
