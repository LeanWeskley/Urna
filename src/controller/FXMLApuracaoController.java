/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class FXMLApuracaoController implements Initializable {
    private void getResult(){
      
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AnimationTimer time = new AnimationTimer() {

            @Override
            public void handle(long now) {
                getResult();
            }
        };
        time.start();
    }    
    
}
