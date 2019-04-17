/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CandidatoDAO;
import dao.ChapaDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Candidato;

/**
 * FXML Controller class
 *
 * @author INF19
 */
public class FXMLCadcandidatosController implements Initializable { 
    Candidato candidato;
    CandidatoDAO candidatoDAO;
    

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfNumero;
     @FXML
    private ComboBox<String> cargos;
     @FXML
    private ComboBox<Integer> PartiBox;
     private ChapaDAO chapaDAO;

    @FXML
    void cbCargo() {
        
    }

    @FXML
    void btCadastrar() {
        candidato = new Candidato();
       candidatoDAO = new CandidatoDAO();
       candidato.setNumero(Integer.parseInt(tfNumero.getText()));
       candidato.setNome(tfNome.getText()); 
       candidato.setFuncao(cargos.getValue());
       candidato.setNumero_chapa(PartiBox.getValue());
       candidatoDAO.salavar(candidato);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chapaDAO = new ChapaDAO();
        candidatoDAO = new CandidatoDAO();
        ArrayList<String> result =  candidatoDAO.allFuncao();
        ObservableList dados = FXCollections.observableArrayList(result);
        cargos.setItems(dados);
        ArrayList<Integer> r = chapaDAO.allChapa();
        ObservableList d =FXCollections.observableArrayList(r);
        PartiBox.setItems(d);
    }    
    
}
