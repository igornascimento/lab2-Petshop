/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.viewfxcontroller;

import br.com.petshop.dominio.Cliente;
import br.com.petshop.dominio.Pet;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class MainController {

    @FXML
    private TableView tableGeneralResults;
    
    private ObservableList<Cliente> listaClientes;
    private ObservableList<Pet> listaPets;
    
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
    private void listarClientes() {
        Scene scene = new Scene(new Group());
        
    }
    
}
