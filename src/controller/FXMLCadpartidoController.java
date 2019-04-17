package controller;

import dao.ChapaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Chapa;
public class FXMLCadpartidoController implements Initializable {

        Chapa chapa;
        ChapaDAO chapaDAO;
    
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtNumero;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    @FXML
    void btCadastrar() {
        chapa = new Chapa();
       chapaDAO = new ChapaDAO();
       chapa.setCodigo(Integer.parseInt(txtNumero.getText()));
       chapa.setNome(txtNome.getText());       
       chapaDAO.salavar(chapa);
    }
}
