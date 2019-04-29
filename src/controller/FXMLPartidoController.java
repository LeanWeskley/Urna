package controller;

import dao.ChapaDAO;
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
import model.Chapa;
import model.PartidoTable;

/**
 * FXML Controller class
 *
 * @author INF19
 */
public class FXMLPartidoController implements Initializable {
        Chapa chapa;
        ChapaDAO chapaDAO;

     @FXML
    private TableColumn<PartidoTable, String> funcao;

    @FXML
    private TableColumn<PartidoTable, Integer> numero;

    @FXML
    private TableColumn<PartidoTable, String> canditado;

    @FXML
    private TableColumn<PartidoTable, String> nome;

    @FXML
    private TableView<PartidoTable> tvChapas;
    @FXML
    private TextField tfNumeroDeletar;
    
    @FXML
    void btDeletar() throws Exception {
        chapa = new Chapa();
       chapaDAO = new ChapaDAO();
       chapa.setCodigo(Integer.parseInt(tfNumeroDeletar.getText()));      
       chapaDAO.deletar(chapa);
       
    }
    private ChapaDAO dao;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nome.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNome()));
        canditado.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getCanditado()));
        funcao.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getFuncao()));
        numero.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNumero()));
       dao = new ChapaDAO();
        ArrayList<PartidoTable> result = dao.allChapas();
        ObservableList dados = FXCollections.observableArrayList(result);
        tvChapas.setItems(dados);
        
    }


    }    

    

