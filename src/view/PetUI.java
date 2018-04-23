/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Map;
import model.Cliente;
import model.Pet;
import util.Console;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class PetUI {

    private static int id = 0;
    private Map<Integer, Pet> petMap;
    private Map<Integer, Cliente> clienteMap;
    private ClienteUI clienteUI;
    
    public PetUI(Map petMap, Map clienteMap) {
        this.petMap = petMap;
        this.clienteMap = clienteMap;
        this.clienteUI = new ClienteUI(clienteMap);
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
        Cliente cliente = selecionarCliente();
        if (cliente != null) {
            Pet pet = new Pet(
                Console.scanString("Nome do pet:"),
                Console.scanInt("Tipo de animal (1-gato|2-cachorro)"),
                cliente);
            petMap.put(++this.id, pet);
            System.out.println("\nPet cadastrado com sucesso!");
        }
    }
    
    public Cliente selecionarCliente() {
        clienteUI.listar();
        String doc = Console.scanString("Para prosseguir, informe o RG do proprietário do pet (ou 0 para voltar):");
        Cliente cliente = clienteUI.buscarPorRg(doc);
        return cliente;
    }
    
    public void listar() {
        System.out.println(
            String.format("%-20s", "|ID") + "\t" +
            String.format("%-20s", "|Nome") + "\t" +
            String.format("%-20s", "|Tipo") + "\t" +
            String.format("%-20s", "|Proprietário")
        );
        
        petMap.forEach((id, pet) -> {
            System.out.println(
                String.format("%-20s", "|" + id) + "\t" +
                String.format("%-20s", "|" + pet.getNome()) + "\t" +
                String.format("%-20s", "|" + (pet.getTipo() == 1 ? "gato" : "cachorro")) + "\t" +
                String.format("%-20s", "|" + pet.getCliente().getNome())
            );
        });
    }
    
    public void remover() {
        listar();
        int id = Console.scanInt("Informe o ID do pet para remover:");
        petMap.remove(id);
        System.out.println("Registro removido com sucesso!");
    }
    
}
