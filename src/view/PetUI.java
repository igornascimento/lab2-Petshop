/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Map;
import lab2.petshop.model.Pet;
import util.Console;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class PetUI {

    Map<Integer, Pet> petMap;
    
    public void showMenu(Map petMap) {
        this.petMap = petMap;
        int opcao = 0;
        
        do {
            System.out.println("##### PETS #####");
            System.out.println("1- Cadastrar;");
            System.out.println("2- Listar;");
            System.out.println("3- Remover;");
            System.out.println("0- Sair;");
            
            opcao = Console.scanInt("Informe a opção para prosseguir:");
            
            switch (opcao) {
                case 1:
                    cadastrarPet();
                    break;
                    
                default:
                    System.out.println("Opção inválida.");
                    break;
                    
            }
            
        } while(opcao != 0);
        
    }
    
    public void cadastrarPet() {
        Pet pet = new Pet(Console.scanString("Nome:"),
                          Console.scanString("Tipo de animal (gato|cachorro)"),
                          Console.scanString("Cliente"));
    }
    
}
