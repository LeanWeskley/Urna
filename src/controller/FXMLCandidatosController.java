/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CandidatoDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Candidato;
import model.PartidoTable;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class FXMLCandidatosController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    private TableColumn<PartidoTable, Integer> numeroChapa;

    @FXML
    private TextField tfNumeroDeletar;

    @FXML
    private TableView<PartidoTable> tvMostrarChapa;

    @FXML
    private TableColumn<PartidoTable, String> nome;
    @FXML
    void btDeletar() {

    }
    private CandidatoDAO dao;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNome()));
        numeroChapa.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNumeroChapa()));
        dao = new CandidatoDAO();
        ArrayList<PartidoTable> result = dao.allCandidatos();
        ObservableList dados = FXCollections.observableArrayList(result);
        tvMostrarChapa.setItems(dados);
        };
    }    
    

