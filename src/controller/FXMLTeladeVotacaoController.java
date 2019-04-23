package controller;

import dao.CandidatoDAO;
import dao.ChapaDAO;
import dao.VotoDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.Candidato;
import model.Voto;

public class FXMLTeladeVotacaoController implements Initializable {
    private Object voto;
    @FXML
    void bt7() {
        tfVotacao.setText(tfVotacao.getText() +"7");
        request();
    }

    @FXML
    void bt8() {
        tfVotacao.setText(tfVotacao.getText() +"8");
        request();
    }

    @FXML
    void bt9() {
        tfVotacao.setText(tfVotacao.getText() +"9");
        request();
    }

    @FXML
    void bt6() {
        tfVotacao.setText(tfVotacao.getText() +"6");
        request();
    }

    @FXML
    void bt5() {
        tfVotacao.setText(tfVotacao.getText() +"5");
        request();
    }

    @FXML
    void bt4() {
        tfVotacao.setText(tfVotacao.getText() +"4");
        request();
    }

    @FXML
    void bt1() {
        tfVotacao.setText(tfVotacao.getText() +"1");
        request();
    }

    @FXML
    void bt2() {
        tfVotacao.setText(tfVotacao.getText() +"2");
        request();
    }

    @FXML
    void bt3() {
        tfVotacao.setText(tfVotacao.getText() +"3");
        request();
    }

    @FXML
    void bt0() {
        tfVotacao.setText(tfVotacao.getText() +"0");
        request();
        
    }
     @FXML
    void btCorrige() {
        tfVotacao.setText("");
        tfCandidato.setText("");
        tfCargo.setText("");
        tfChapa.setText("");
    }
    @FXML
    void btBranco() {
        tfVotacao.setText("00000");
        tfCandidato.setText("");
        tfCargo.setText("");
        tfChapa.setText("");
    }
      @FXML
    void btConfirma() {
        VotoDAO votoDAO = new VotoDAO();
        Voto voto = new Voto();
       voto.setVoto(Integer.parseInt(tfVotacao.getText().substring(2, tfVotacao.getLength())));
       voto.setCandidato(tfCandidato.getText());       
       boolean result = votoDAO.salvar(voto);
       if(result){
           tfVotacao.setText("");
           tfCargo.setText("");
           tfChapa.setText("");
           tfCandidato.setText("");
       }
    }
    @FXML
    private TextField tfVotacao;
    @FXML
    private Pane pane;
    @FXML
    private TextField tfCargo;
    @FXML
    private TextField tfChapa;
    @FXML
    private TextField tfCandidato;
    private ChapaDAO chapaDAO;
    private CandidatoDAO candidatoDAO;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfVotacao.setDisable(true);
        tfCargo.setDisable(true);
        tfChapa.setDisable(true);
        tfCandidato.setDisable(true);
        pane.setOnKeyReleased((KeyEvent e)->{
            if(e.getCode() == KeyCode.NUMPAD0 ||e.getCode() == KeyCode.NUMPAD1 ||e.getCode() == KeyCode.NUMPAD2 ||e.getCode() == KeyCode.NUMPAD3 ||e.getCode() == KeyCode.NUMPAD4 ||e.getCode() == KeyCode.NUMPAD5 ||e.getCode() == KeyCode.NUMPAD6 ||e.getCode() == KeyCode.NUMPAD7 ||e.getCode() == KeyCode.NUMPAD8 ||e.getCode() == KeyCode.NUMPAD9){
                tfVotacao.setText(tfVotacao.getText() + e.getText());
                request();
            }else if(e.getCode() == KeyCode.DELETE || e.getCode() == KeyCode.BACK_SPACE){
                if(tfVotacao.getLength() - 1 >= 0){
                tfVotacao.setText(tfVotacao.getText().substring(0, tfVotacao.getLength() -1));
                request();
                }
            }
        });
    }    
    private void request(){
        if(tfVotacao.getLength() <= 2){
            chapaDAO = new ChapaDAO();
            ArrayList<String> nome = chapaDAO.getChapa(Integer.parseInt(tfVotacao.getText()));
            if(nome.size() > 0){
            tfChapa.setText(nome.get(0));
            }else{
            tfChapa.setText("");
            
            }
        }else if(tfVotacao.getLength() > 2){
            candidatoDAO = new CandidatoDAO();
            System.out.println(tfVotacao.getText().substring(2, tfVotacao.getLength()));
            ArrayList<Candidato> result = candidatoDAO.getCandidato(Integer.parseInt(tfVotacao.getText().substring(2, tfVotacao.getLength())));
            if(result.size() > 0){
                tfCargo.setText(result.get(0).getFuncao());
                tfCandidato.setText(result.get(0).getNome());
            }else{
                tfCargo.setText("");
                tfCandidato.setText("");
                
            }
        }
    }
}
