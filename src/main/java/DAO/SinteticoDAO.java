package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.RelSintetico;

public class SinteticoDAO {
    public static String url = "jdbc:mysql://localhost:3306/Floricultura";
    public static String login = "user";
    public static String senha = "user";
    
    public static ArrayList<RelSintetico> buscarRelatorio(boolean CB_VerCancelados){
        Connection conexao = null;
        
        String sql = "";
        ArrayList<RelSintetico> ListaRelatorio= new ArrayList<RelSintetico>();
        

        if(CB_VerCancelados){
            sql = "SELECT * FROM VW_RelSintetico ORDER BY DH_VENDA;";
        }else{
            sql = "SELECT * FROM VW_RelSintetico WHERE TG_CANCELADO = 0 ORDER BY DH_VENDA;";
        }
         
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);
            
            
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){

                while(rs.next()){
                    RelSintetico objRelatorio = new RelSintetico();
                    objRelatorio.setIdVenda(rs.getInt("PK_ID"));
                    objRelatorio.setCodCliente(rs.getInt("FK_CLIENTE"));
                    objRelatorio.setValorVenda(rs.getInt("VL_TOTAL"));
                    objRelatorio.setDataVenda(rs.getTimestamp("DH_VENDA"));
                    objRelatorio.setNomeCliente(rs.getString("DS_NOME"));
                    objRelatorio.setQtProdutos(rs.getInt("QT_Produtos"));
                    objRelatorio.setTG_CANCELADO(rs.getInt("TG_CANCELADO"));
                    objRelatorio.setDS_CANCELADO(rs.getString("DS_CANCELADO"));
                    objRelatorio.setDS_MOTIVOCANCELAMENTO(rs.getString("DS_MOTIVOCANCELAMENTO"));
                    ListaRelatorio.add(objRelatorio);
                }    
            }                    
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return ListaRelatorio;
  
    }
    
    public static ArrayList<RelSintetico> buscarRelatorioFiltros(boolean VerCancelados, int IdCliente){
        Connection conexao = null;
        String sql = "";
        ArrayList<RelSintetico> ListaRelatorio= new ArrayList<RelSintetico>();
             
        if(VerCancelados && IdCliente > 0){
            sql = "SELECT * FROM VW_RELSINTETICO WHERE FK_CLIENTE = " + String.valueOf(IdCliente);
        }else if(!VerCancelados && IdCliente > 0){
            sql = "SELECT * FROM VW_RELSINTETICO WHERE FK_CLIENTE = " + String.valueOf(IdCliente) + " AND TG_CANCELADO = 0";
        }else if(VerCancelados && IdCliente == 0){
            sql = "SELECT * FROM VW_RELSINTETICO;";
        }else if(!VerCancelados && IdCliente == 0){
            sql = "SELECT * FROM VW_RELSINTETICO WHERE TG_CANCELADO = 0;";
        }
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){

                while(rs.next()){
                    RelSintetico objRelatorio = new RelSintetico();
                    objRelatorio.setIdVenda(rs.getInt("PK_ID"));
                    objRelatorio.setCodCliente(rs.getInt("FK_CLIENTE"));
                    objRelatorio.setValorVenda(rs.getInt("VL_TOTAL"));
                    objRelatorio.setDataVenda(rs.getTimestamp("DH_VENDA"));
                    objRelatorio.setNomeCliente(rs.getString("DS_NOME"));
                    objRelatorio.setQtProdutos(rs.getInt("QT_Produtos"));
                    objRelatorio.setTG_CANCELADO(rs.getInt("TG_CANCELADO"));
                    objRelatorio.setDS_CANCELADO(rs.getString("DS_CANCELADO"));
                    objRelatorio.setDS_MOTIVOCANCELAMENTO(rs.getString("DS_MOTIVOCANCELAMENTO"));
                    ListaRelatorio.add(objRelatorio);
                }    
            }                
           
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return ListaRelatorio;
        
    }
    
}
