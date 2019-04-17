package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.Chapa;
import model.PartidoTable;

public class ChapaDAO {
    Connection con = null;
    public ChapaDAO() {
        con = Conexao.abrirConexao();        
    }
    
    
    
    
    public void salavar(Chapa chapa){
        try {
            String sql = "INSERT INTO CHAPA(NUMERO, NOME) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, chapa.getCodigo());
            ps.setString(2, chapa.getNome());
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Chapa cadastrada com sucesso");
                con.close();
            }
        } catch (Exception e) {
        }      
    
    }
    public boolean setCandidatoHasChapa(int numero_chapa, int numero_canditado){
        try {
            String sql = "INSERT INTO candidatos_has_chapa(candidato_numero, chapa_numero) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numero_canditado);
            ps.setInt(2, numero_chapa);
            ps.execute();
                con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getCause());
        } 
        return false;
    }
    public ArrayList<PartidoTable> allChapas(){
        ArrayList<PartidoTable> result = new ArrayList<>();
        String sql = "select * from candidatos_has_chapa inner join chapa on candidatos_has_chapa.chapa_numero = chapa.numero inner join candidatos on candidatos_has_chapa.candidato_numero = candidatos.numero group by candidatos.numero";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                PartidoTable dados = new PartidoTable();
                dados.setCanditado(rs.getString("candidatos.nome"));
                dados.setFuncao(rs.getString("candidatos.funcao"));
                dados.setNome(rs.getString("nome"));
                dados.setNumero(rs.getInt("candidatos.numero"));
                result.add(dados);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<Integer> allChapa(){
        ArrayList<Integer> result = new ArrayList<>();
        String sql = "select * from chapa";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                result.add(rs.getInt("numero"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public ArrayList<String> getChapa(int codigo){
        ArrayList<String> result = new ArrayList<>();
        String sql = "select * from chapa where numero = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                result.add(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    } 
}
