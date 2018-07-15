/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.viewfxcontroller;

import br.com.petshop.dominio.Pet;
import br.com.petshop.dominio.Cliente;
import br.com.petshop.negocio.ClienteNegocio;
import br.com.petshop.negocio.PetNegocio;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class PetController implements Initializable {
    
    private PetNegocio petNegocio = new PetNegocio();
    private ClienteNegocio clienteNegocio = new ClienteNegocio();
    @FXML private TextField txtPetNome;
    @FXML private TextField txtPetTipo;
    @FXML private Text txtPetFeedback;
    @FXML private ComboBox<Cliente> ownerPicker = new ComboBox<>();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Cliente> listaClientes = FXCollections.observableArrayList(clienteNegocio.listar());
        ownerPicker.setItems(listaClientes);
    }
    
    @FXML
    private void cadastrar(ActionEvent event) {
        try {
            petNegocio.salvar(
                    new Pet(txtPetNome.getText(),
                            txtPetTipo.getText()));
            txtPetFeedback.setText("Cliente cadastrado com sucesso!");
        } catch(Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERRO!");
            alerta.setHeaderText("Erro!");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }
    
    public void editar(ActionEvent event, int id) {
        try {
            Pet pet = petNegocio.buscarPorId(id);
            pet.setNome(txtPetNome.getText());
            pet.setTipo(txtPetTipo.getText());
            petNegocio.atualizar(pet);
            txtPetFeedback.setText("Cliente cadastrado com sucesso!");
        } catch(Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERRO!");
            alerta.setHeaderText("Erro!");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }
    
    @FXML
    private void cancelar(ActionEvent event) {
        
    }
    
    public void limpar() {
        txtPetNome.clear();
        txtPetTipo.clear();
    }
    
}
