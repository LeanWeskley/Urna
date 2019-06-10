package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Apuracao;
import model.Chapa;

/**
 *
 * @author Aluno
 */
public class VotoDAO {
    Connection con = null;
    public VotoDAO() {
        con = Conexao.abrirConexao();        
    }
    public boolean salvar(int numero){
        if(numero == 0){
            numero = 2;
        }        
        try {          
            int total = 0;            
            String sql = "SELECT TOTAL FROM CHAPA WHERE NUMERO = "+ numero;            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();           
            if(rs.next()){   
                total = rs.getInt("TOTAL");
                total++;  
                
                try {
                    String atualizar = "UPDATE CHAPA SET TOTAL = ? WHERE NUMERO = ?";
                    PreparedStatement ps1 = con.prepareStatement(atualizar);
                    ps1.setInt(1, total);
                    ps1.setInt(2, numero);
                    ps1.executeUpdate();
                      return true;
                } catch (Exception e) {
                    return false;
                }              
               
            }else {
                try {
                    int totalNulo = 0;            
                    String sqlNulo = "SELECT TOTAL FROM CHAPA WHERE NUMERO = 1";            
                    PreparedStatement psNulo = con.prepareStatement(sqlNulo);
                    ResultSet rsNulo = psNulo.executeQuery(); 
                    if(rsNulo.next()){
                        totalNulo = rsNulo.getInt("TOTAL");
                        totalNulo++;
                        try {
                            String atualizar = "UPDATE CHAPA SET TOTAL = ? WHERE NUMERO = 1";
                            PreparedStatement ps1 = con.prepareStatement(atualizar);
                            ps1.setInt(1, totalNulo);
                            ps1.executeUpdate();
                            return true;
                        } catch (Exception e) {
                            return false;
                        }             
                }                    
                    
             } catch (Exception e) {
             }
                return true;
            }            
        } catch (Exception e) {
        }    
        return false;
    }
    public Chapa listar(int numero){        
        Chapa chapa = new Chapa();
        try {
            try (
                Connection con = Conexao.abrirConexao()) {
                String sql = "SELECT NOME FROM CHAPA WHERE NUMERO = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, numero);
                ResultSet rs =  ps.executeQuery();                
                     while(rs.next()){   
                            chapa.setNome(rs.getString("nome"));                         
                          System.out.println(chapa.getNome());
                          return chapa;
                        }
                
                chapa.setNome("NULO");
                return chapa;
               
               
            }            
        } catch (Exception e) {
            return chapa;
        }    
    }
    public ArrayList<Apuracao> getResult(){
       /* if(chapa.size() > 0){
             ArrayList<Apuracao> result = new ArrayList<>();
             for(Chapa dados : chapa){
                 String sql = "select count(voto) as total, candidato from votos where numero_candidato = ?";
                 try {
                     PreparedStatement stmt = con.prepareStatement(sql);
                     stmt.setInt(1, dados.getCodigo());
                     ResultSet rs = stmt.executeQuery();
                     while(rs.next()){
                         Voto votos = new Voto();
                         System.out.println(rs.getString("total"));
                         votos.setVoto(rs.getInt("total"));
                         Apuracao apuracao = new Apuracao();
                         apuracao.setVoto(votos);
                         result.add(apuracao);
                     }
                 } catch (SQLException ex) {
                     Logger.getLogger(VotoDAO.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
            return result;
        }*/
        return null;
    }
    
    public boolean branco(int quantidade){
        Connection con = Conexao.abrirConexao();
        PreparedStatement stmt;
        String sql = "UPDATE chapa SET TOTAL = ? where numero = ?";
        
        try {
            stmt = con.prepareStatement(sql);
            System.out.println("entra");
            quantidade++;
            stmt.setInt(1, quantidade);
            stmt.setInt(2, 2);
            stmt.executeUpdate();
        }catch(SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }   
    
}

