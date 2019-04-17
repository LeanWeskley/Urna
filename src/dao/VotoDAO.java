/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Candidato;
import model.Voto;

/**
 *
 * @author Aluno
 */
public class VotoDAO {
    Connection con = null;
    public VotoDAO() {
        con = Conexao.abrirConexao();        
    }
    public boolean salvar(Voto voto){
        try {
            String sql = "INSERT INTO VOTOS(numero_candidato, CANDIDATO) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, voto.getVoto());
            ps.setString(2, voto.getCandidato());
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Votação concluida, próximo");
                con.close();
                return true;
            }
        } catch (Exception e) {
        }      
        return false;
    
    }
    public ArrayList<Voto> getResult(){
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        ArrayList<Candidato> candidatos = candidatoDAO.allCandidato();
        if(candidatos.size() > 0){
             ArrayList<Voto> result = new ArrayList<>();
             for(Candidato dados : candidatos){
                 String sql = "";
             }
            return result;
        }
        return null;
    }
}

