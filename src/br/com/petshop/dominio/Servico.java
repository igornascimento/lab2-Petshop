package br.com.petshop.dominio;

import java.util.Random;

/**
*
* @author Igor Nascimento <igornascimento@gmail.com>
*/
public class Servico {

	private static int id;
	private String nome;
	private String tipo; // clinico|estetico
	private double preco;
	
	public Servico() {
	}
	
	public Servico(int id, String nome, String tipo, double preco) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}
        
        public Servico(String nome, String tipo, double preco) {
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
}
