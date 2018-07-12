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
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class MainController {
    
    private ClienteNegocio clienteNegocio = new ClienteNegocio();
    private PetNegocio petNegocio = new PetNegocio();
    
    @FXML private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    @FXML private ObservableList<Pet> listaPets = FXCollections.observableArrayList();
    @FXML public Pane tableGeneralResults;
    
    /**
     * Shows the customer form
     * @param event
     * @throws Exception 
     */
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
    
    /**
     * Shows the pet form
     * @param event
     * @throws Exception 
     */
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
     * Prepare customers list
     */
    @FXML
    private void listarClientes() {
//        List<Cliente> lista = clienteNegocio.listar();

        // populando para teste
        List<Cliente> lista = FXCollections.observableArrayList();
        lista.add(new Cliente(1, "23452345", "Igor Nascimento", "5199999999"));
        lista.add(new Cliente(2, "26345634", "Luiz Antonio", "5198798789"));
        lista.add(new Cliente(3, "67896789", "Maria da Silva", "5190868906"));
        lista.add(new Cliente(4, "22292665", "Joao Machado", "51768757677"));
        listaClientes = (ObservableList<Cliente>) lista;
        
        // preparando as colunas
        TableColumn<Cliente, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Cliente, String> rgColumn = new TableColumn<>("RG");
        TableColumn<Cliente, String> nameColumn = new TableColumn<>("Nome");
        TableColumn<Cliente, String> phoneColumn = new TableColumn<>("Telefone");
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        rgColumn.setCellValueFactory(new PropertyValueFactory("rg"));
        nameColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory("telefone"));
        
        List<TableColumn> colNames = new ArrayList();
        colNames.add(idColumn);
        colNames.add(rgColumn);
        colNames.add(nameColumn);
        colNames.add(phoneColumn);
        
        TableView table = new TableView();
        table.getColumns().addAll(colNames);
        populateTable(table, listaClientes);
    }
    
    /**
     * Prepares pets list
     */
    @FXML
    private void listarPets() {
//        listaPets = (ObservableList<Pet>) petNegocio.listar();
        
        // populando para testes
        List<Pet> lista = FXCollections.observableArrayList();
        lista.add(new Pet(1, "Oliver", "Gato"));
        lista.add(new Pet(2, "Pitoco", "Cachorro"));
        lista.add(new Pet(3, "Luna", "Cachorro"));
        lista.add(new Pet(4, "Brutus", "Gato"));
        listaPets = (ObservableList<Pet>) lista;
        
        // preparando as colunas
        TableColumn<Pet, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Pet, String> nameColumn = new TableColumn<>("Nome");
        TableColumn<Pet, String> typeColumn = new TableColumn<>("Tipo");
        idColumn.setCellValueFactory(new PropertyValueFactory("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory("nome"));
        typeColumn.setCellValueFactory(new PropertyValueFactory("tipo"));
        
        List<TableColumn> colNames = new ArrayList();
        colNames.add(idColumn);
        colNames.add(nameColumn);
        colNames.add(typeColumn);
        
        TableView table = new TableView();
        table.getColumns().addAll(colNames);
        populateTable(table, listaPets);
    }
    
    /**
     * Shows the final table in UI
     * @param table
     * @param listItems 
     */
    private void populateTable(TableView table, ObservableList listItems) {
        table.prefWidthProperty().bind(tableGeneralResults.widthProperty());
        table.setItems((ObservableList) listItems);
        table.setEditable(false);
        tableGeneralResults.getChildren().add(table);
        
    }
    
}
