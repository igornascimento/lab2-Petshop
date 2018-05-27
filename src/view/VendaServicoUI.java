/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        
        // populando itens para teste
        this.clienteMap.put("12341234", new Cliente("12341234", "José da Silva", "56785678"));
        Map<Integer, Pet> pets1 = new HashMap<>();
        pets1.put(1, new Pet("Oliver", 1));
        pets1.put(2, new Pet("Maneco", 2));
        this.clienteMap.get("12341234").setPets(pets1);
        this.clienteMap.put("23452345", new Cliente("23452345", "Maria Almeida", "85687589"));
        Map<Integer, Pet> pets2 = new HashMap<>();
        pets2.put(1, new Pet("Nica", 2));
        this.clienteMap.get("23452345").setPets(pets2);
        this.servicoMap.put(1, new Servico("Banho", "banho", 50.00));
        this.servicoMap.put(2, new Servico("Tosa", "tosa", 70.00));
    }
    
    public void showMenu() {
        int opcao = 0;
        
        do {
            System.out.println("##### VENDAS #####");
            System.out.println("1- Registrar venda;");
            System.out.println("2- Exibir registro de vendas;");
            System.out.println("3- Remover venda;");
            System.out.println("0- Sair;");
            
            opcao = Console.scanInt("Informe a opção para prosseguir:");
            
            switch (opcao) {
                case 1:  registrar(); break;
                case 2:  verRegistroVendas(); break;
                case 3:  remover(); break;
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
            if (cliente != null) {
                if (cliente.getPets().size() == 0) {
                    System.out.println("Não há PETs cadastrados. Cadastre um ou mais pets para prosseguir.");
                } else {
                    // apresenta a lista de pets
                    listarPets(cliente);
                    int petId = Console.scanInt("Informe o ID do pet:");

                    int servicoId = 0;
                    Map<Integer, Servico> servicosSelecionadosMap = new HashMap<>();
                    do {
                        // apresenta a lista de servicos
                        servicoUI.listar();
                        servicoId = Console.scanInt("Informe o ID do serviço desejado ou 0 para sair:");
                        servicosSelecionadosMap.put(servicoId, servicoMap.get(servicoId));
                        VendaServico venda = new VendaServico(
                            LocalDateTime.now(),
                            cliente,
                            cliente.getPets().get(petId),
                            servicosSelecionadosMap
                        );
                        this.vendaMap.put(venda.getId(), venda);
                    } while(servicoId != 0);
                }
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
    
    private void verRegistroVendas() {
        if (vendaMap.isEmpty()) {
            System.out.println("Nenhuma venda cadastrada.");
        } else {
            double total = 0;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            System.out.println(
                String.format("%-20s", "|ID") + "\t" +
                String.format("%-20s", "|CLIENTE") + "\t" +
                String.format("%-20s", "|NOME PET") + "\t" +
                String.format("%-20s", "|TIPO PET") + "\t" +
                String.format("%-20s", "|SERVIÇO") + "\t" +
                String.format("%-20s", "|DATA") + "\t" +
                String.format("%-20s", "|VALOR") );
            
            vendaMap.forEach((id, venda) -> {
                venda.getServicoMap().forEach((servicoId, servico) -> {
                    System.out.println(
                        String.format("%-20s", "|" + id) + "\t" +
                        String.format("%-20s", "|" + venda.getCliente().getNome()) + "\t" +
                        String.format("%-20s", "|" + venda.getPet().getNome()) + "\t" +
                        String.format("%-20s", "|" + (venda.getPet().getTipo() == 1 ? "Gato" : "Cachorro")) + "\t" +
                        String.format("%-20s", "|" + (servico != null ? servico.getNome() : "")) + "\t" +
                        String.format("%-20s", "|" + venda.getDatahora().format(formatter)) + "\t" +
                        String.format("%-20s", "|" + (servico != null ? servico.getPreco() : "")) );
                    //total =+ servico.getPreco();
                });
            });

//            for (int i=1; i<=vendaMap.size(); i++) {
//                VendaServico venda = vendaMap.get(i);
//                for (int j=1; j<=venda.getServicoMap().size(); j++) {
//                    System.out.println(
//                        String.format("%-20s", "|" + venda.getId()) + "\t" +
//                        String.format("%-20s", "|" + venda.getCliente().getNome()) + "\t" +
//                        String.format("%-20s", "|" + venda.getPet().getNome()) + "\t" +
//                        String.format("%-20s", "|" + (venda.getPet().getTipo() == 1 ? "gato" : "cachorro")) + "\t" +
//                        //servico
//                        String.format("%-20s", "|" + (venda.getServicoMap().get(j) == null ? "" : venda.getServicoMap().get(j).getNome())) + "\t" +
//                        String.format("%-20s", "|" + (venda.getServicoMap().get(j) == null ? "" : venda.getServicoMap().get(j).getPreco())) );
//                    if (venda.getServicoMap().get(j) != null) {
//                        total += venda.getServicoMap().get(j).getPreco();
//                    }
//                }
//            }
//            System.out.println("Total dos serviços: " + total);
        }
    }
    
    private void remover() {
        if (vendaMap.isEmpty()) {
            System.out.println("Nenhuma venda cadastrada.");
        } else {
            int id = Console.scanInt("Informe o ID da venda para remover:");
            vendaMap.remove(id);
            verRegistroVendas();
            System.out.println("Registro removido com sucesso.");
        }
    }
}
