/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.HashMap;
import java.util.Map;
import lab2.petshop.model.Cliente;
import lab2.petshop.model.Pet;
import lab2.petshop.model.Servico;
import lab2.petshop.model.VendaServico;
import util.Console;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class MainUI {
    
    Map<Integer, Pet> petMap = new HashMap<>();
    Map<Integer, Cliente> clienteMap = new HashMap<>();
    Map<Integer, Servico> servicoMap = new HashMap<>();
    Map<Integer, VendaServico> vendaMap = new HashMap<>();
    
    public void executar() {
        int opcao = 0;
        
        do {
            System.out.println("##### MENU #####");
            System.out.println("1- Pets;");
            System.out.println("2- Clientes;");
            System.out.println("3- Serviços;");
            System.out.println("0- Vendas;");
            System.out.println("0- Sair;");
            
            opcao = Console.scanInt("Informe sua opção para prosseguir:");
            
            switch (opcao) {
                case 1:
                    new PetUI().showMenu(petMap);
                    break;
                    
                case 2:
                    new ClienteUI().showMenu(clienteMap);
                    break;
                
                case 3:
                    new ServicoUI().showMenu(servicoMap);
                    break;
                
                case 4:
                    new VendaUI().showMenu(vendaMap);
                    break;
                    
                default:
                    System.out.println("Opção incorreta.");
                    break;
            }
            
        } while(opcao != 0);
        
    }
    
}
