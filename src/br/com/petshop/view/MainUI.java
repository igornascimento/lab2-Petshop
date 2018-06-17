/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.view;

import br.com.petshop.dominio.Cliente;
import br.com.petshop.dominio.Pet;
import br.com.petshop.dominio.Servico;
import br.com.petshop.dominio.VendaServico;
import br.com.petshop.util.Console;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class MainUI {
    
    List<Pet> petList = new ArrayList<>();
    List<Cliente> clienteList = new ArrayList<>();
    List<Servico> servicoList = new ArrayList<>();
    List<VendaServico> vendaList = new ArrayList<>();
    
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
                    new PetUI(petList, clienteList).showMenu();
                    break;
                    
                case 2:
                    new ClienteUI(clienteList).showMenu();
                    break;
                
                case 3:
                    new ServicoUI(servicoList).showMenu();
                    break;
                
                case 4:
                    new VendaServicoUI(vendaList, clienteList, servicoList).showMenu();
                    break;
                    
                default:
                    System.out.println("Opção incorreta.");
                    break;
            }
            
        } while(opcao != 0);
        
    }
    
}
