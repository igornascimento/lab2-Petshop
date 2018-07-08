/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.viewfxcontroller;

import br.com.petshop.dominio.Pet;
import br.com.petshop.negocio.PetNegocio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class PetController {
    
    private PetNegocio clienteNegocio;
    @FXML private TextField txtPetNome;
    @FXML private TextField txtPetTipo;
    @FXML private Text txtPetFeedback;
    
    
    @FXML
    private void cadastrar(ActionEvent event) {
        clienteNegocio = new PetNegocio();
        try {
            clienteNegocio.salvar(
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
    
    @FXML
    private void cancelar(ActionEvent event) {
        
    }
    
    public void limpar() {
        txtPetNome.clear();
        txtPetTipo.clear();
    }
    
}
