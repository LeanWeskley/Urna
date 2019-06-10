package controller;

import dao.ChapaDAO;
import dao.VotoDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Apuracao;
import model.Chapa;
import model.PartidoTable;

/**
 * FXML Controller class
 *
 * @author weskley
 */
public class FXMLApuracaoController implements Initializable {
     @FXML private TableColumn<Chapa, Integer> numero;
     @FXML private TableColumn<Chapa, String> nome;
     @FXML private TableColumn<Chapa, Integer> total;
     @FXML private TableView<Chapa> tabela;
    
    
    
    
    private VotoDAO votoDAO;
   /* private void getResult(){
        votoDAO = new VotoDAO();
        ArrayList<Apuracao> dados = votoDAO.getResult();
        ObservableList model = FXCollections.observableArrayList(dados);
        table.setItems(model);
        table.getSortOrder().add(votos);
    }*/


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       mostrarTabela();
        
        
        /*nome.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNome()));
       votos.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getNome()));
        chapaDAO = new ChapaDAO();
        ArrayList<PartidoTable> result = chapaDAO.todas();
        ObservableList dados = FXCollections.observableArrayList(result);
        tvMostrarChapa.setItems(dados);
        tvMostrarChapa.setOnMouseClicked((MouseEvent)->{
            delete.setVisible(true);
        });
        }; 

            @Override
            public void handle(long now) {
                getResult();
            }
        };*/
       
    }

    public void mostrarTabela(){
        numero.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));  
        tabela.setItems(listaChapas());
    }
    public ObservableList<Chapa> listaChapas(){
        int total = 0;
        ChapaDAO dao = new ChapaDAO();
        List<Chapa> lista =  dao.listarAll();
        for(Chapa a : lista){
            total += a.getTotal();
        }
        System.out.println("Total Geral" + total);
        return FXCollections.observableArrayList(lista);        
    }
    
    

}
