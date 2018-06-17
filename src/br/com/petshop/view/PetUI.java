/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.view;

import br.com.petshop.DaoDB.ClienteDaoDB;
import br.com.petshop.DaoDB.PetDaoDB;
import br.com.petshop.dominio.Cliente;
import br.com.petshop.dominio.Pet;
import br.com.petshop.util.Console;
import java.util.List;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class PetUI {

    private List<Pet> petList;
    private List<Cliente> clienteList;
    private ClienteUI clienteUI;
    ClienteDaoDB clienteDao = new ClienteDaoDB();
    PetDaoDB petDao = new PetDaoDB();
    
    public PetUI(List<Pet> petList, List<Cliente> clienteList) {
        this.petList = petList;
        this.clienteList = clienteList;
        this.clienteUI = new ClienteUI(clienteList);
    }
    

    public PetUI(List<Pet> petList) {
        this.petList = petList;
    }
    
    public void showMenu() {
        int opcao = 0;
        
        do {
            System.out.println("##### PETS #####");
            System.out.println("1- Cadastrar;");
            System.out.println("2- Listar;");
            System.out.println("3- Remover;");
            System.out.println("0- Sair;");
            
            opcao = Console.scanInt("Informe a opção para prosseguir:");
            
            switch (opcao) {
                case 1:  cadastrar(); break;
                case 2:  listar(); break;
                case 3:  remover(); break;
                default: System.out.println("Opção inválida."); break;
            }
        } while(opcao != 0);
    }
    
    public void cadastrar() {
        Cliente cliente = clienteDao.buscarPorRg(Console.scanString("Informe o RG do proprietário:"));
        if (cliente != null) {
            String nomePet = Console.scanString("Informe o nome do pet:");
            if (petDao.buscarPorNomeParaCliente(cliente, nomePet).size() > 0) {
                System.out.println("Pet já cadastrado para este cliente!");
            } else {
                Pet pet = new Pet(
                        Console.scanString("Nome do pet:"),
                        Console.scanInt("Tipo (1-gato; 2-cachorro):"),
                        cliente.getId()
                );
                petDao.salvar(pet);
                System.out.println("\nPet cadastrado com sucesso!");
            }
        }
    }
    
    public void listar() {
        System.out.println(
            String.format("%-20s", "|ID") + "\t" +
            String.format("%-20s", "|Nome") + "\t" +
            String.format("%-20s", "|Tipo") + "\t" +
            String.format("%-20s", "|Proprietário") );

        List<Pet> petList = petDao.listar();
        for (Pet pet : petList) {
            Cliente cliente = clienteDao.buscarPorId(pet.getCliente());
            System.out.println(
                String.format("%-20s", "|" + pet.getId()) + "\t" +
                String.format("%-20s", "|" + pet.getNome()) + "\t" +
                String.format("%-20s", "|" + (pet.getTipo() == 1 ? "gato" : "cachorro")) + "\t" +
                String.format("%-20s", "|" + cliente.getNome()) );
        }
    }
    
    public void remover() {
        listar();
        int id = Console.scanInt("Informe o ID do pet para remover:");
        Pet pet = petDao.buscarPorId(id);
        petDao.deletar(pet);
        System.out.println("Registro removido com sucesso!");
    }
    
}
