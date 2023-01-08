package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.VendasCabecalho;
import model.VendasItem;


public class VendasDAO {
    public static String url = "jdbc:mysql://localhost:3306/floricultura";
    public static String login = "user";
    public static String senha = "user";
        
    public static boolean salvar(VendasCabecalho objCab){
        Connection conexao = null;
        boolean retorno = false;
        
        try{
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("INSERT INTO Vendas_Cabecalho (FK_CLIENTE, VL_TOTAL, DH_VENDA) VALUES(?,?,?); "
                    , Statement.RETURN_GENERATED_KEYS );
                      
            comandoSQL.setInt(1,objCab.getCodCliente());
            comandoSQL.setDouble(2, objCab.getValorVenda());
            comandoSQL.setTimestamp(3, new java.sql.Timestamp(objCab.getDataVenda().getTime()));
    
            //4º passo - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if (linhasAfetadas > 0){
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if (rs.next()) {
                    int idVenda = rs.getInt(1);
                    
                    for (VendasItem item : objCab.getListaItens()) {
                        PreparedStatement comandoSQLItem = conexao.prepareStatement("INSERT INTO VENDAS_ITEM"
                                + " (FK_VENDA, FK_PRODUTO, QT_MOVIMENTO, VL_PREUNI, VL_PRETOT, VL_DESCONTO) "
                                + "VALUES (?,?,?,?,?,?)");
                        
                        comandoSQLItem.setInt(1, idVenda);
                        comandoSQLItem.setInt(2, item.getCodProduto());
                        comandoSQLItem.setInt(3, item.getQtMovimento());
                        comandoSQLItem.setDouble(4,item.getVlUnitario());
                        comandoSQLItem.setDouble(5,item.getVlTotal());
                        comandoSQLItem.setDouble(6,item.getVlDesconto());
                        
                        
                        int linhasAfetadasItem = comandoSQLItem.executeUpdate();
                        if(linhasAfetadasItem>0){
                            retorno = AtualizaEstoque(item.getCodProduto(), item.getQtMovimento());                          
                        }
                    }
                }
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno; 
       
    }
    
    public static int ValidaQtEstoque(int CodProduto){
        int QtEstoque = 0;
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT QT_ESTOQUE FROM PRODUTOS WHERE PK_ID = ?");
            comandoSQL.setInt(1, CodProduto);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    QtEstoque = rs.getInt("QT_ESTOQUE");                   
                } 
            }          
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return QtEstoque;
    }
    
    public static boolean AtualizaEstoque(int CodProduto, int QtMovimento){
        boolean retorno = false;
        int QtEstoque = 0;
        
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);
            
            QtEstoque = ValidaQtEstoque(CodProduto);
            
            QtEstoque = QtEstoque - QtMovimento;
            
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE PRODUTOS SET QT_ESTOQUE = ? WHERE PK_ID = ?");
            comandoSQL.setInt(1, QtEstoque);
            comandoSQL.setInt(2, CodProduto);
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
        return retorno;
    }
    
    public static boolean ValidaProdutoExistente(int CodProduto){
        boolean retorno = false;
        int Codigo = 0;
       
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT PK_ID FROM PRODUTOS WHERE PK_ID = ?");
            comandoSQL.setInt(1, CodProduto);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Codigo = rs.getInt("PK_ID");                   
                } 
            }          
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(Codigo == CodProduto){
            retorno = true;
        }else{
            retorno = false;
        }
        
        return retorno;
    }
    
    public static String RetornaNomeProduto(int CodProduto){
        String NomeProduto = "";
       
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT DS_MODELO FROM PRODUTOS WHERE PK_ID = ?");
            comandoSQL.setInt(1, CodProduto);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    NomeProduto = rs.getString("DS_MODELO");
                } 
            }          
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return NomeProduto;
    }

    public static Double RetornaValorProduto(int CodProduto){
        Double ValorProd = 0.00;
       
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT VL_PRECO FROM PRODUTOS WHERE PK_ID = ?");
            comandoSQL.setInt(1, CodProduto);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    ValorProd = rs.getDouble("VL_PRECO");
                } 
            }          
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ValorProd;
    }
    
    public static boolean ValidaClienteExistente(int CodCliente){
        boolean retorno = false;
        int Codigo = 0;
       
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT PK_ID FROM CLIENTES WHERE PK_ID = ?");
            comandoSQL.setInt(1, CodCliente);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Codigo = rs.getInt("PK_ID");                   
                } 
            }          
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(Codigo == CodCliente){
            retorno = true;
        }else{
            retorno = false;
        }
        
        return retorno;
    }
    
    public static String RetornaNomeCliente(int CodCliente){
        String NomeCliente = "";
       
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT DS_NOME FROM CLIENTES WHERE PK_ID = ?");
            comandoSQL.setInt(1, CodCliente);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    NomeCliente = rs.getString("DS_NOME");
                } 
            }          
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return NomeCliente;
    }
    
    public static VendasCabecalho buscarVenda(int CodVenda){
        Connection conexao = null;
        boolean retorno = false;
        
        VendasCabecalho objVenda = new VendasCabecalho();
        
        String sql = "";
        

         try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            sql = "SELECT * FROM VENDAS_CABECALHO WHERE PK_ID = ?;";
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setLong(1, CodVenda);
            
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){

                while(rs.next()){                   
                    objVenda.setIdVenda(rs.getInt("PK_ID"));
                    objVenda.setCodCliente(rs.getInt("FK_CLIENTE"));
                    objVenda.setDataVenda(rs.getTimestamp("DH_VENDA"));
                    objVenda.setValorVenda(rs.getDouble("VL_TOTAL"));
                }    
            }                     
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return objVenda;   
    }
    
    public static boolean ValidaVendaExistente(int CodVenda){
        boolean retorno = false;
        int Codigo = 0;
       
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT PK_ID FROM VENDAS_CABECALHO WHERE PK_ID = ?");
            comandoSQL.setInt(1, CodVenda);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Codigo = rs.getInt("PK_ID");                   
                } 
            }          
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(Codigo == CodVenda){
            retorno = true;
        }else{
            retorno = false;
        }
        
        return retorno;
    }
    
    public static boolean CancelarVenda(int CodVenda, String MotivoCanc){
        boolean retorno = false;
        String sql = "";
       
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);
            
            sql = "UPDATE VENDAS_CABECALHO SET TG_CANCELADO = 1, DS_MOTIVOCANCELAMENTO = ? WHERE PK_ID = ?;";
            
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, MotivoCanc);
            comandoSQL.setInt(2, CodVenda);
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return retorno;
    }
}
