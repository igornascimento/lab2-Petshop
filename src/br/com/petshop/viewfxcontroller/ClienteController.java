/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petshop.viewfxcontroller;

import br.com.petshop.dominio.Cliente;
import br.com.petshop.negocio.ClienteNegocio;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private void cadastrar() {
        try {
            System.out.println("Chamando CADASTRAR...");
            clienteNegocio.salvar(
                    new Cliente(txtClienteNome.getText(),
                                txtClienteRG.getText(),
                                txtClienteTelefone.getText()));
            System.out.println("Cadastrar finalizado.");
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
