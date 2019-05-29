/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author INF19
 */
public class Principal extends Application {
    public static Stage stage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent tela = FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml"));
        Scene scene = new Scene(tela);
        primaryStage.setTitle("Tela de Login");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        stage = primaryStage;
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
