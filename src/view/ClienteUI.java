/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Map;
import model.Cliente;
import util.Console;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class ClienteUI {
    
    private Map<String, Cliente> clienteMap;
    
    public ClienteUI(Map clienteMap) {
        this.clienteMap = clienteMap;
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
        String doc = Console.scanString("RG:");
        Cliente cliente = new Cliente(
            doc,
            Console.scanString("Nome:"),
            Console.scanString("Telefone:")
        );
        clienteMap.put(doc, cliente);
    }
    
    public void listar() {
        System.out.println(
            String.format("%-20s", "|RG") + "\t" +
            String.format("%-20s", "|Nome") + "\t" +
            String.format("%-20s", "|Telefone")
        );
        
        clienteMap.forEach((doc, cliente) -> {
            System.out.println(
                String.format("%-20s", "|" + cliente.getRg()) + "\t" +
                String.format("%-20s", "|" + cliente.getNome()) + "\t" +
                String.format("%-20s", "|" + cliente.getTelefone())
            );
        });
    }
    
    public Cliente buscarPorRg(String doc) {
        if (clienteMap.containsKey(doc)) {
            return clienteMap.get(doc);
        }
        return null;
    }
    
    public void remover() {
        String doc = Console.scanString("Informe o RG:");
        this.clienteMap.remove(doc);
    }
    
}
