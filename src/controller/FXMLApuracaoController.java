/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VotoDAO;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Apuracao;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class FXMLApuracaoController implements Initializable {
    private VotoDAO votoDAO;
    private void getResult(){
        votoDAO = new VotoDAO();
        ArrayList<Apuracao> dados = votoDAO.getResult();
        ObservableList model = FXCollections.observableArrayList(dados);
        table.setItems(model);
        table.getSortOrder().add(votos);
    }
    @FXML
    private TableColumn<Apuracao, String> funcao;

    @FXML
    private TableColumn<Apuracao, String> nome;

    @FXML
    private TableColumn<Apuracao, Integer> votos;

    @FXML
    private TableView<Apuracao> table;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        funcao.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getCandidato().getFuncao()));
        nome.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getCandidato().getNome()));
        votos.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getVoto().getVoto()));
        AnimationTimer time = new AnimationTimer() {

            @Override
            public void handle(long now) {
                getResult();
            }
        };
        time.start();
    }    
    
}
