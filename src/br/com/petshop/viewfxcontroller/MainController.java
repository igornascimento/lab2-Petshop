/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.viewfxcontroller;

import br.com.petshop.dominio.Cliente;
import br.com.petshop.dominio.Pet;
import br.com.petshop.negocio.ClienteNegocio;
import br.com.petshop.negocio.PetNegocio;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class MainController {
    
    private ClienteNegocio clienteNegocio;
    private PetNegocio petNegocio;
    private ObservableList<Cliente> listaClientes;
    private ObservableList<Pet> listaPets;
    
    @FXML public Pane tableGeneralResults;
    
    @FXML
    private void showFormCliente(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/petshop/viewfx/ClienteForm.fxml"));
        Scene scene = new Scene(root, 600, 400);
        Stage cadastrarCliente = new Stage();
        cadastrarCliente.initModality(Modality.WINDOW_MODAL);
        cadastrarCliente.setTitle("Cadastro de Clientes");
        cadastrarCliente.setScene(scene);
        cadastrarCliente.show();
    }
    
    @FXML
    private void showFormPet(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/petshop/viewfx/PetForm.fxml"));
        Scene scene = new Scene(root, 600, 400);
        Stage cadastrarCliente = new Stage();
        cadastrarCliente.initModality(Modality.WINDOW_MODAL);
        cadastrarCliente.setTitle("Cadastro de Pets");
        cadastrarCliente.setScene(scene);
        cadastrarCliente.show();
    }
    
    /**
     * Mounts the table with the clients list
     */
    @FXML
    private void listarClientes() {
        listaClientes = (ObservableList<Cliente>) clienteNegocio.listar();
        
        TableView table = new TableView();
        TableColumn idColumn = new TableColumn("ID");
        TableColumn rgColumn = new TableColumn("RG");
        TableColumn nameColumn = new TableColumn("Nome");
        TableColumn phoneColumn = new TableColumn("Telefone");
        table.getColumns().setAll(idColumn, rgColumn, nameColumn, phoneColumn);
        table.setItems(listaClientes);
        
        tableGeneralResults.getChildren().add(table);
    }
    
    /**
     * Mounts the table with the pets list
     */
    @FXML
    private void listarPets() {
        listaPets = (ObservableList<Pet>) petNegocio.listar();
        
        TableView table = new TableView();
        TableColumn idColumn = new TableColumn("ID");
        TableColumn nameColumn = new TableColumn("Nome");
        TableColumn typeColumn = new TableColumn("Tipo");
        table.getColumns().setAll(idColumn, nameColumn, typeColumn);
        table.setItems(listaPets);
        
        tableGeneralResults.getChildren().add(table);
    }
    
}
