/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CandidatoDAO;
import dao.ChapaDAO;
import dao.Conexao;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;
import model.Candidato;

/**
 * FXML Controller class
 *
 * @author INF19
 */
public class FXMLCadcandidatosController implements Initializable { 
    Candidato candidato;
    CandidatoDAO candidatoDAO;
    Connection con = null;

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
     @FXML
    void btDeletar() {
        try {
            con = Conexao.abrirConexao();
            String sql = "DELETE FROM candidatos WHERE numero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tfNumero.getText()));
            ps.execute();
            String sql1 = "DELETE FROM votos WHERE numero_candidato = ?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, Integer.parseInt(tfNumero.getText()));
            ps1.execute();
                JOptionPane.showMessageDialog(null, "Candidato deletado com sucesso");
                con.close();
            
        } catch (Exception e) {
        }   
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
        tfNumero.setOnKeyReleased((KeyEvent e)->{
            mascaraCandidato(e);
        });
    }    

    private void mascaraCandidato(KeyEvent e) {
         if (e.getCode() != KeyCode.BACK_SPACE || KeyCode.DELETE != e.getCode()) {
                if (tfNumero.getLength() > 3) {
                    tfNumero.setText(tfNumero.getText().substring(0,3));
                }
                    tfNumero.positionCaret(tfNumero.getLength());
            }   
    }
    
}
