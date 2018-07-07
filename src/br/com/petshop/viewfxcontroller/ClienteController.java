/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.viewfxcontroller;

import br.com.petshop.dominio.Cliente;
import br.com.petshop.negocio.ClienteNegocio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class ClienteController {
    
    private ClienteNegocio clienteNegocio;
    @FXML
    private TextField txtClienteNome;
    @FXML
    private TextField txtClienteRG;
    @FXML
    private TextField txtClienteTelefone;
    @FXML
    private Text txtClienteFeedback;
    
//    public ClienteController(){
//        clienteNegocio = new ClienteNegocio();
//    }
    
    @FXML
    private void cadastrar(ActionEvent event) {
        clienteNegocio = new ClienteNegocio();
        try {
            clienteNegocio.salvar(
                    new Cliente(txtClienteNome.getText(),
                                txtClienteRG.getText(),
                                txtClienteTelefone.getText()));
            txtClienteFeedback.setText("Cliente cadastrado com sucesso!");
        } catch(Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERRO!");
            alerta.setHeaderText("Erro!");
            alerta.setContentText(e.getMessage());
            alerta.showAndWait();
        }
    }
    
    @FXML
    private void cancelar() {
        
    }
    
    public void limpar() {
        txtClienteNome.clear();
        txtClienteRG.clear();
        txtClienteTelefone.clear();
    }
    
}
