/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author INF19
 */
public class FXMLLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField psSenha;

    @FXML
    void btEntrar(ActionEvent event) throws IOException {
        
        if (tfLogin.getText().equals("usuario") && psSenha.getText().equals("123")) {
            Parent principal = FXMLLoader.load(getClass().getResource("/view/FXMLPrincipal.fxml"));
            Scene scene = new Scene(principal);
            view.Principal.stage.setScene(scene);
            view.Principal.stage.setTitle("Tela Principal");
            view.Principal.stage.show();
            
            
        }else{
        JOptionPane.showMessageDialog(null, "Dados inválidos!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
