package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

public class TelaLoginDAO {
    public static String url = "jdbc:mysql://localhost:3306/Floricultura";
    public static String login = "user";
    public static String senha = "user";
    
    public static Usuario buscarLogin(String LoginUsuario){
        Connection conexao = null;
        Usuario objUsuario = new Usuario();
        String sql = "";
        boolean Login = false;

         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, login, senha);
            
            sql = "SELECT * FROM USUARIOS WHERE DS_LOGIN = ?";
            
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1,LoginUsuario);
            
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){

                while(rs.next()){
                    objUsuario.setDS_LOGIN(rs.getString("DS_LOGIN"));
                    objUsuario.setDS_SENHA(rs.getString("DS_SENHA"));
                    objUsuario.setDS_NOME(rs.getString("DS_NOME"));
                    Login = true;
                }    
            }          
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
        if(!Login){
            objUsuario.setDS_LOGIN("");
            objUsuario.setDS_SENHA("");
            objUsuario.setDS_NOME("");
        }
         
         
         return objUsuario;
    }
}
