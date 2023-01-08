package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.VendasItem;


public class AnaliticoDAO {
    
    public static String url = "jdbc:mysql://localhost:3306/floricultura";
    public static String login = "user";
    public static String senha = "user";
    
    
    public static ArrayList<VendasItem> listar(int CodVenda){
        Connection conexao = null;
        boolean retorno = false;
        
        ArrayList<VendasItem> ListaItens = new ArrayList<VendasItem>();
        
         try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("SELECT * FROM VENDAS_ITEM WHERE FK_VENDA = ?; "
                    , Statement.RETURN_GENERATED_KEYS );
            comandoSQL.setInt(1, CodVenda);
            
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){

                while(rs.next()){
                    VendasItem objVendas = new VendasItem();
                    
                    objVendas.setIdItem(rs.getInt("PK_ID"));
                    objVendas.setIdVenda(rs.getInt("FK_VENDA"));
                    objVendas.setCodProduto(rs.getInt("FK_PRODUTO"));
                    objVendas.setQtMovimento(rs.getInt("QT_MOVIMENTO"));
                    objVendas.setVlUnitario(rs.getDouble("VL_PREUNI"));
                    objVendas.setVlTotal(rs.getDouble("VL_PRETOT"));
                   // objVendas.setvlDesconto(rs.getDouble("VL_DESCONTO"));
 
                    ListaItens.add(objVendas);
                }    
            }                
                
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return ListaItens;          
    }
    
}
