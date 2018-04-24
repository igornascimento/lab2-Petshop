/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.HashMap;
import java.util.Map;
import model.Cliente;
import model.Pet;
import model.Servico;
import model.VendaServico;
import util.Console;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class MainUI {
    
    Map<Integer, Pet> petMap = new HashMap<>();
    Map<String, Cliente> clienteMap = new HashMap<>();
    Map<Integer, Servico> servicoMap = new HashMap<>();
    Map<Integer, VendaServico> vendaMap = new HashMap<>();
    
    public void executar() {
        int opcao = 0;
        
        do {
            System.out.println("##### MENU #####");
            System.out.println("1- Pets;");
            System.out.println("2- Clientes;");
            System.out.println("3- Serviços;");
            System.out.println("4- Vendas;");
            System.out.println("0- Sair;");
            
            opcao = Console.scanInt("Informe sua opção para prosseguir:");
            
            switch (opcao) {
                case 1:
                    new PetUI(petMap, clienteMap).showMenu();
                    break;
                    
                case 2:
                    new ClienteUI(clienteMap).showMenu();
                    break;
                
                case 3:
                    new ServicoUI(servicoMap).showMenu();
                    break;
                
                case 4:
                    new VendaServicoUI(vendaMap, clienteMap, servicoMap).showMenu();
                    break;
                    
                default:
                    System.out.println("Opção incorreta.");
                    break;
            }
            
        } while(opcao != 0);
        
    }
    
}
