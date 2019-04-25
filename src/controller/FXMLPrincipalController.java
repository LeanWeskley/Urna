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
import javafx.stage.Stage;
import static view.Principal.stage;

/**
 * FXML Controller class
 *
 * @author INF19
 */
public class FXMLPrincipalController implements Initializable {

     @FXML
    void miSair(ActionEvent event) {
        stage.close();
    }
    @FXML
    void btChapa(ActionEvent event) throws IOException {
        Parent partidos = FXMLLoader.load(getClass().getResource("/view/FXMLPartido.fxml"));
        Scene scene = new Scene(partidos);
            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Chapas");
            stage.show();
    }

        @FXML
    void MiCadastrar(ActionEvent event) throws IOException {
        Parent cadpartidos = FXMLLoader.load(getClass().getResource("/view/FXMLCadpartido.fxml"));
        Scene scene = new Scene(cadpartidos);
        stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Cadastro de Chapa"); 
            stage.show();
    }
     @FXML
    void miCandidatos(ActionEvent event) throws IOException {
        Parent cadCargos = FXMLLoader.load(getClass().getResource("/view/FXMLCadcandidatos.fxml"));
        Scene scene = new Scene(cadCargos);
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Cadastro de Candidatos");
        stage.show();
    }
    
    @FXML
    void btUrna(ActionEvent event) throws IOException {
        Parent urna = FXMLLoader.load(getClass().getResource("/view/FXMLTeladeVotacao.fxml"));
        Scene scene = new Scene(urna);
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Tela de Votação");
        stage.show();
    }

    @FXML
    void btCandidato(ActionEvent event) throws IOException {
        Parent partidos = FXMLLoader.load(getClass().getResource("/view/FXMLApuracao.fxml"));
        Scene scene = new Scene(partidos);
            stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Apuração de votos");
            stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
