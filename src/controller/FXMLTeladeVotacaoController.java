package controller;
import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;


import dao.Conexao;
import dao.VotoDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.Chapa;
import view.Principal;
import static view.Principal.stage;


public class FXMLTeladeVotacaoController implements Initializable {   
    @FXML    
    private Label nome;
    @FXML
    private Pane pane;
    @FXML
    private TextField c1;
    @FXML
    private TextField c2;    
    String n1;
    String n2;
    String total;
    
    int branco = 0;

    public void initialize(URL url, ResourceBundle rb) {
        //Click no primeiro campo
        c1.requestFocus();
        c1.setOnKeyReleased((KeyEvent e) ->{ 
            if (e.getCode() == KeyCode.ENTER) {               
                    branco();
                     som();
                    Principal.trocaVotoFim();
                    
                    
                    c1.requestFocus();
                
            }
            if (c1.getLength() > 0) {
                    n1 = c1.getText();
                    c2.requestFocus();
            } 
        });
        //Click no segundo campo
        c2.setOnKeyReleased((KeyEvent e) ->{
            if (c2.getLength() > 0) {
                    n2 = c2.getText();                    
            }
             total = n1 + n2;
            try {
                if(e.getCode() == KeyCode.BACK_SPACE){
                   limpar();
                   c1.requestFocus();
                }
                if(e.getCode() != KeyCode.BACK_SPACE) {
                    listar();
                }
                 if(e.getCode() == KeyCode.ENTER){
                   if(votar()){
                       limpar();
                       som();
                       Principal.trocaVotoFim();
                       
                       
                       c1.requestFocus();
                   } else{
                        System.out.println("não votou");
                   }           
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLTeladeVotacaoController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        });
        pane.setOnKeyReleased((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                
            }else if(e.getCode() == KeyCode.COMMA){
                nome.setText("");
                c1.setText("");
                c2.setText("");
                c1.requestFocus();
            }
        }); 
    }
    public boolean votar(){
        VotoDAO dao = new VotoDAO();
        return dao.salvar(Integer.parseInt(total));
    }
    public void limpar(){
        c1.setText("");
        c2.setText("");
        nome.setText("");
    }
    
    
    public void listar() throws SQLException{
        VotoDAO dao = new VotoDAO();
        Chapa chapa = new Chapa();        
       chapa = dao.listar(Integer.parseInt(total));
        nome.setText(chapa.getNome());
        
    }
    public boolean branco(){
        Connection con = Conexao.abrirConexao();
        try {
                    int totalBranco = 0;
                    String sqlBranco = "SELECT TOTAL FROM CHAPA WHERE NUMERO = 2";            
                    PreparedStatement psBranco = con.prepareStatement(sqlBranco);
                    ResultSet rsBranco = psBranco.executeQuery(); 
                    if(rsBranco.next()){
                        totalBranco = rsBranco.getInt("TOTAL");
                        totalBranco++;
                        try {
                            String atualizar = "UPDATE CHAPA SET TOTAL = ? WHERE NUMERO = 2";
                            PreparedStatement ps1 = con.prepareStatement(atualizar);
                            ps1.setInt(1, totalBranco);
                            ps1.executeUpdate();
                            return true;
                        } catch (Exception e) {
                            return false;
                        }     
               
                }
                    
                    
             } catch (Exception e) {
             }
        return false;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*Connection con = Conexao.abrirConexao();
        PreparedStatement stmt;
        String sql = "UPDATE chapa SET TOTAL = ? where numero = 2";
        try {
            stmt = con.prepareStatement(sql);
            quantidade++;
            stmt.setInt(1, quantidade); 
            stmt.executeUpdate();
        }catch(SQLException ex) {
            System.out.println(ex);
        }*/
        
        
        
    }
    public void som(){
        System.out.println("Chamou o som");
        try {
            File file = new File("src/util/som.mp3");
            FileInputStream fs = new FileInputStream(file);
            BufferedInputStream bf = new BufferedInputStream(fs);
            try {
                Player player = new Player(bf);
                player.play();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }
}    

