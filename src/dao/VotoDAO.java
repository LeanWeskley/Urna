/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Apuracao;
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
    public ArrayList<Apuracao> getResult(){
        CandidatoDAO candidatoDAO = new CandidatoDAO();
        ArrayList<Candidato> candidatos = candidatoDAO.allCandidato();
        if(candidatos.size() > 0){
             ArrayList<Apuracao> result = new ArrayList<>();
             for(Candidato dados : candidatos){
                 System.out.println();
                 String sql = "select count(voto) as total, candidato from votos where numero_candidato = ?";
                 try {
                     PreparedStatement stmt = con.prepareStatement(sql);
                     stmt.setInt(1, dados.getNumero());
                     ResultSet rs = stmt.executeQuery();
                     while(rs.next()){
                         Voto votos = new Voto();
                         Candidato candidato = new Candidato();
                         candidato.setFuncao(dados.getFuncao());
                         candidato.setNome(dados.getNome());
                         candidato.setNumero(dados.getNumero());
                         System.out.println(rs.getString("total"));
                         votos.setVoto(rs.getInt("total"));
                         Apuracao apuracao = new Apuracao();
                         apuracao.setCandidato(candidato);
                         apuracao.setVoto(votos);
                         result.add(apuracao);
                     }
                 } catch (SQLException ex) {
                     Logger.getLogger(VotoDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
            return result;
        }
        return null;
    }
}

