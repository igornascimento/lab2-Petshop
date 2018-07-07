/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2petshopjavafx;

import br.com.petshop.viewfxcontroller.MainController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Igor Nascimento <igornascimento@gmail.com>
 */
public class Lab2PetshopJavaFX extends Application {
    
    private Stage mainStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/petshop/viewfx/MainStage.fxml"));
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Petshop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
