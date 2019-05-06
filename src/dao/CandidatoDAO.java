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
import model.Candidato;

/**
 *
 * @author INF19
 */
public class CandidatoDAO {
    Connection con = null;
    PreparedStatement stmt;
    private ResultSet resultado;

    public CandidatoDAO() {
        con = Conexao.abrirConexao();
    }
    public void salavar(Candidato candidato){
        ChapaDAO a = new ChapaDAO();
        boolean r = a.setCandidatoHasChapa(candidato.getNumero_chapa(), candidato.getNumero());
        if(r){
        try {
            String sql = "INSERT INTO CANDIDATOS(NUMERO, NOME, FUNCAO) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, candidato.getNumero());
            ps.setString(2, candidato.getNome());
            ps.setString(3, candidato.getFuncao());
            ps.execute();
                JOptionPane.showMessageDialog(null, "Candidato cadastrado com sucesso");
                con.close();
            
        } catch (Exception e) {
        }   
       }
    }
    public ArrayList<String> allFuncao(){
        ArrayList<String> result = new ArrayList<>();
        String sql = "SELECT * FROM candidatofuncao ORDER BY FUNCAO ASC";
        try {
            stmt = con.prepareStatement(sql);
            resultado = stmt.executeQuery();
            while(resultado.next()){
                result.add(resultado.getString("FUNCAO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public ArrayList<Candidato> getCandidato(int numero){
        ArrayList<Candidato> result = new ArrayList<>();
        String sql = "SELECT * FROM candidatos where numero = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, numero);
            resultado = stmt.executeQuery();
            while(resultado.next()){
                Candidato dados = new Candidato();
                dados.setFuncao(resultado.getString("funcao"));
                dados.setNome(resultado.getString("nome"));
                result.add(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public ArrayList<Candidato> allCandidato(){
        ArrayList<Candidato> result = new ArrayList<>();
        String sql = "SELECT * FROM candidatos order by nome asc";
        try {
            stmt = con.prepareStatement(sql);
            resultado = stmt.executeQuery();
            while(resultado.next()){
                Candidato dados = new Candidato();
                dados.setFuncao(resultado.getString("funcao"));
                dados.setNome(resultado.getString("nome"));
                dados.setNumero(resultado.getInt("numero"));
                result.add(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
