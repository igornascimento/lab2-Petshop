/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
public class VendaServicoUI {
    
    private static int id = 0;
    private Map<Integer, VendaServico> vendaMap;
    private Map<String, Cliente> clienteMap;
    private Map<Integer, Servico> servicoMap;
    private ClienteUI clienteUI;
    private ServicoUI servicoUI;
    
    public VendaServicoUI(Map<Integer, VendaServico> vendaMap, Map<String, Cliente> clienteMap, Map<Integer, Servico> servicoMap) {
        this.vendaMap = vendaMap;
        this.clienteMap = clienteMap;
        this.servicoMap = servicoMap;
        this.clienteUI = new ClienteUI(this.clienteMap);
        this.servicoUI = new ServicoUI(this.servicoMap);
    }
    
    public void showMenu() {
        int opcao = 0;
        
        do {
            System.out.println("##### VENDAS #####");
            System.out.println("1- Registrar venda;");
            System.out.println("2- Listar;");
            System.out.println("3- Remover;");
            System.out.println("0- Sair;");
            
            opcao = Console.scanInt("Informe a opção para prosseguir:");
            
            switch (opcao) {
                case 1:  registrar(); break;
//                case 2:  listar(); break;
//                case 3:  remover(); break;
                default: System.out.println("Opção inválida."); break;
            }
        } while(opcao != 0);
    }
    
    
    
    public void registrar() {
        if (this.servicoMap.size() == 0) {
            System.out.println("Não há SERVIÇOS cadastrados. Cadastre um ou mais serviços para prosseguir.");
        }
        if (this.clienteMap.size() == 0) {
            System.out.println("Não há CLIENTES cadastrados. Cadastre um ou mais clientes para prosseguir.");
        } else {
            
            Cliente cliente = selecionarCliente();
            if (cliente.getPets().size() == 0) {
                System.out.println("Não há PETs cadastrados. Cadastre um ou mais pets para prosseguir.");
            } else {
                // apresenta a lista de pets
                listarPets(cliente);
                // apresenta a lista de servicos
                servicoUI.listar();
                int petId = Console.scanInt("Informe o ID do pet:");

                int servicoId = Console.scanInt("Informe o ID do serviço:");
                // adiciona o servico selecionado a lista
                cliente.getPets().get(petId).getServicos().put(servicoId, servicoMap.get(servicoId));
            }
        }
        
    }
    
    private Cliente selecionarCliente() {
        clienteUI.listar();
        String doc = Console.scanString("Para prosseguir, informe o RG do proprietário do pet (ou 0 para voltar):");
        model.Cliente cliente = clienteUI.buscarPorRg(doc);
        return cliente;
    }
    
    private void listarPets(Cliente cliente) {
        System.out.println(
            String.format("%-20s", "|ID") + "\t" +
            String.format("%-20s", "|Nome") + "\t" +
            String.format("%-20s", "|Tipo") );
        cliente.getPets().forEach((id, pet) -> {
            System.out.println(
                String.format("%-20s", "|" + id) + "\t" +
                String.format("%-20s", "|" + pet.getNome()) + "\t" +
                String.format("%-20s", "|" + (pet.getTipo() == 1 ? "gato" : "cachorro")) );
        });
    }
}
