package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Produtos;

public class ProdutoDAO {

    public static String url = "jdbc:mysql://localhost:3306/floricultura";
    public static String login = "user";
    public static String senha = "user";

    public static boolean salvar(Produtos obj) {
        Connection conexao = null;
        boolean retorno = false;
        int linhas = 0;

        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);

            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("INSERT INTO PRODUTOS (DS_MODELO, VL_PRECO, QT_ESTOQUE) VALUES(?,?,?); ",
                            Statement.RETURN_GENERATED_KEYS);

            comandoSQL.setString(1, obj.getNomeProduto());
            comandoSQL.setDouble(2, obj.getPrecoProduto());
            comandoSQL.setInt(3, obj.getEstoqueProduto());

            //4º passo - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet rs = comandoSQL.getGeneratedKeys();
                if (rs != null) {
                    if (rs.next()) {
                        obj.setCodigoProduto(rs.getInt(1));
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

    public static boolean excluir(int ID) {
        Connection conexao = null;
        boolean retorno = false;

        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);

            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("DELETE FROM PRODUTOS WHERE PK_ID = ?; ",
                            Statement.RETURN_GENERATED_KEYS);

            comandoSQL.setInt(1, ID);

            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;
    }

    public static boolean alterar(Produtos obj) {
        Connection conexao = null;
        boolean retorno = false;

        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);

            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("UPDATE PRODUTOS SET DS_MODELO =? ,VL_PRECO =? ,QT_ESTOQUE =? WHERE PK_ID =?; ");

            comandoSQL.setString(1, obj.getNomeProduto());
            comandoSQL.setDouble(2, obj.getPrecoProduto());
            comandoSQL.setInt(3, obj.getEstoqueProduto());
            comandoSQL.setInt(4, obj.getCodigoProduto());

            //4º passo - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;

            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;

    }

    public static ArrayList<Produtos> listar(int TG_ESTOQUE) {
        Connection conexao = null;
        String sql = "";
        ArrayList<Produtos> ListaProdutos = new ArrayList<Produtos>();

        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);

            if (TG_ESTOQUE == 1){
                sql = "SELECT * FROM PRODUTOS WHERE QT_ESTOQUE > 0; ";
            } else {
                sql = "SELECT * FROM PRODUTOS;";
            }
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement(sql);

            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    Produtos objProduto = new Produtos();

                    objProduto.setCodigoProduto(rs.getInt("PK_ID"));
                    objProduto.setNomeProduto(rs.getString("DS_MODELO"));
                    objProduto.setPrecoProduto(rs.getDouble("VL_PRECO"));
                    objProduto.setEstoqueProduto(rs.getInt("QT_ESTOQUE"));

                    ListaProdutos.add(objProduto);
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ListaProdutos;
    }

    public static ArrayList<Produtos> buscarProdutoNome(String NomeProduto, int TG_ESTOQUE) {
        
        Connection conexao = null;
        Produtos objProduto = new Produtos();
        String sql = "";
        ArrayList<Produtos> ListaProdutos = new ArrayList<Produtos>();

        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);

            if (TG_ESTOQUE == 1) {
                sql = "SELECT * FROM PRODUTOS WHERE DS_MODELO LIKE ? AND QT_ESTOQUE > 0; ";
            }else{
                sql = "SELECT * FROM PRODUTOS WHERE DS_MODELO LIKE ?;";
            }

            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, "%" + NomeProduto + "%");

            //4º passo - Executar o comando
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    objProduto = new Produtos();

                    objProduto.setCodigoProduto(rs.getInt("PK_ID"));
                    objProduto.setNomeProduto(rs.getString("DS_MODELO"));
                    objProduto.setPrecoProduto(rs.getDouble("VL_PRECO"));
                    objProduto.setEstoqueProduto(rs.getInt("QT_ESTOQUE"));

                    ListaProdutos.add(objProduto);
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ListaProdutos;

    }

    public static ArrayList<Produtos> buscarProdutoNomeCodigo(String NomeProduto, int CodProduto, int TG_ESTOQUE){
        Connection conexao = null;
        Produtos objProduto = new Produtos();
        String sql = "";
        ArrayList<Produtos> ListaProdutos = new ArrayList<Produtos>();

        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            if (TG_ESTOQUE == 1) {
                sql = "SELECT * FROM PRODUTOS WHERE DS_MODELO LIKE ? AND PK_ID = ? AND QT_ESTOQUE > 0; ";
            }else{
                sql = "SELECT * FROM PRODUTOS WHERE DS_MODELO LIKE ? AND PK_ID = ?;";
            }

            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, "%" + NomeProduto + "%");
            comandoSQL.setInt(2, CodProduto);
            //4º passo - Executar o comando
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    objProduto = new Produtos();

                    objProduto.setCodigoProduto(rs.getInt("PK_ID"));
                    objProduto.setNomeProduto(rs.getString("DS_MODELO"));
                    objProduto.setPrecoProduto(rs.getDouble("VL_PRECO"));
                    objProduto.setEstoqueProduto(rs.getInt("QT_ESTOQUE"));

                    ListaProdutos.add(objProduto);
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ListaProdutos;

    }

    public static ArrayList<Produtos> buscarProdutoCodigo(int CodProduto, int TG_ESTOQUE) {
        Connection conexao = null;
        Produtos objProduto = new Produtos();
        String sql = "";
        ArrayList<Produtos> ListaProdutos = new ArrayList<Produtos>();

        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            if (TG_ESTOQUE == 1) {
                sql = "SELECT * FROM PRODUTOS WHERE PK_ID = ? AND QT_ESTOQUE > 0; ";
            }else {
                sql = "SELECT * FROM PRODUTOS WHERE PK_ID = ?;";
            }

            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1, CodProduto);

            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    objProduto = new Produtos();

                    objProduto.setCodigoProduto(rs.getInt("PK_ID"));
                    objProduto.setNomeProduto(rs.getString("DS_MODELO"));
                    objProduto.setPrecoProduto(rs.getDouble("VL_PRECO"));
                    objProduto.setEstoqueProduto(rs.getInt("QT_ESTOQUE"));

                    ListaProdutos.add(objProduto);
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ListaProdutos;

    }
    
    public static boolean ValidaVendasProduto(int CodProduto){
        boolean retorno = false;
        int Codigo = 0;
       
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT FK_PRODUTO FROM VENDAS_ITEM WHERE FK_PRODUTO = ?");
            comandoSQL.setInt(1, CodProduto);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Codigo = rs.getInt("FK_PRODUTO");                   
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
}
