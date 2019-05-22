package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import model.Chapa;
import model.PartidoTable;

public class ChapaDAO {
    Connection con = null;
    private int tfNumeroDeletar;
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
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
                con.close();
            }
        } catch (Exception e) {
        }      
    
    }     
    public void deletar(int numero) throws Exception {
	    Connection con = Conexao.abrirConexao();
	    PreparedStatement st;
	    try {
	      String sql = "delete from chapa where numero = ?";
              st = con.prepareStatement(sql);
              st.setInt(1, numero);
	      st.execute(sql);
	    }
	    catch (SQLException e) {
	      throw new Exception("Erro ao deletar" + e.getMessage(), e);
	    
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
                dados.setNumeroChapa(rs.getInt("chapa.numero"));
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
    public ArrayList<PartidoTable> todas(){
        ArrayList<PartidoTable> result = new ArrayList<>();
        String sql = "select * from chapa";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                PartidoTable dados = new PartidoTable();
                dados.setNome(rs.getString("nome"));
                dados.setNumeroChapa(rs.getInt("numero"));
                result.add(dados);
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

    public void deletar(Chapa chapa) throws Exception {
       Connection con = Conexao.abrirConexao();
	    try {
	      String sql = "DELETE FROM candidatos WHERE numero = ?";
              PreparedStatement ps = con.prepareStatement(sql);
              ps.setInt(1, chapa.getCodigo());
              ps.execute();
              JOptionPane.showMessageDialog(null, "Chapa deletada com sucesso");
	    }
	    catch (SQLException e) {
	      throw new Exception("Erro ao deletar " + e.getErrorCode(), e);
	    
	  }
    }
    public boolean updateChapa(int newCodigo, String nome){
        Connection con = Conexao.abrirConexao();
        String sql = "update chapa set nome = ? where numero = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, newCodigo);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ChapaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
