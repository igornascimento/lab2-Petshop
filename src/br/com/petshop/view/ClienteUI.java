/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.view;

import br.com.petshop.DaoDB.ClienteDaoDB;
import br.com.petshop.dominio.Cliente;
import br.com.petshop.util.Console;
import java.util.List;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class ClienteUI {
    
    private List<Cliente> clienteList;
    private ClienteDaoDB clienteDao = new ClienteDaoDB();
    
    public ClienteUI(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }
    
    public void showMenu() {
        int opcao = 0;
        
        do {
            System.out.println("##### CLIENTES #####");
            System.out.println("1- Cadastrar;");
            System.out.println("2- Listar;");
            System.out.println("3- Deletar;");
            System.out.println("0- Sair;");
            
            opcao = Console.scanInt("Informe a opção para prosseguir:");
            
            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: remover(); break;
                default: System.out.println("Opção inválida."); break;
            }
        } while(opcao != 0);
        
    }

    public void cadastrar() {
        System.out.println("Cadastrando um novo cliente:");
        String doc = Console.scanString("Informe o RG:");
        Cliente cliente = clienteDao.buscarPorRg(doc);
        if (cliente != null) {
            System.out.println("CPF já cadastrado.");
        } else {
            cliente.setRg( doc );
            cliente.setNome( Console.scanString("Nome:") );
            cliente.setTelefone( Console.scanString("Telefone:") );
            clienteDao.salvar(cliente);
        }
    }
    
    public void listar() {
        System.out.println(
            String.format("%-20s", "|RG") + "\t" +
            String.format("%-20s", "|Nome") + "\t" +
            String.format("%-20s", "|Telefone")
        );
        
        for (Cliente cliente : clienteList) {
            System.out.println(
                String.format("%-20s", "|" + cliente.getRg()) + "\t" +
                String.format("%-20s", "|" + cliente.getNome()) + "\t" +
                String.format("%-20s", "|" + cliente.getTelefone())
            );
        }
    }
    
    public void remover() {
        String doc = Console.scanString("Informe o CPF para remover:");
        clienteDao.deletar(clienteDao.buscarPorRg(doc));
    }
    
}
