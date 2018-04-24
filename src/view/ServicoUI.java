/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Map;
import model.Servico;
import util.Console;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class ServicoUI {

    private static int id = 0;
    private Map<Integer, Servico> servicoMap;
    
    public ServicoUI(Map servicoMap) {
        this.servicoMap = servicoMap;
    }
    
    public void showMenu() {
        int opcao = 0;
        
        do {
            System.out.println("##### SERVIÇOS #####");
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
        Servico servico = new Servico(
            Console.scanString("Nome do serviço:"),
            Console.scanString("Tipo:"),
            Console.scanDouble("Preço:")
        );
        servicoMap.put(servico.getId(), servico);
    }
    
    public void listar() {
        System.out.println(
            String.format("%-20s", "|ID") + "\t" +
            String.format("%-20s", "|Nome") + "\t" +
            String.format("%-20s", "|Tipo") + "\t" +
            String.format("%-20s", "|Preço")
        );
        servicoMap.forEach((id, servico) -> {
            System.out.println(
                String.format("%-20s", "|" + servico.getNome()) + "\t" +
                String.format("%-20s", "|" + servico.getTipo()) + "\t" +
                String.format("%-20s", "|" + servico.getPreco())
            );
        });
    }
    
    public Servico buscarPorId(int id) {
        if (servicoMap.containsKey(id)) {
            return servicoMap.get(id);
        }
        return null;
    }
    
    public void remover() {
        String id = Console.scanString("Informe o ID:");
        this.servicoMap.remove(id);
    }
    
}
