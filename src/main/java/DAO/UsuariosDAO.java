
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Usuario;


public class UsuariosDAO {
    
    static String URL = "jdbc:mysql://localhost:3306/floricultura";
    public static String login = "user";
    public static String senha = "user";
    
    //Inclusão de login no BD - Salvar
    //Validação login: -1 = erro na gravação; 0 = Login já existente; 1 = Login gravado com sucesso
    public static int Salvar (Usuario obj){
        int retorno = -1;
        
        if (validarLogin(obj)==true) {
            retorno = 0;
            
            return retorno;
        }
         
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(URL,login,senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO Usuarios (DS_NOME, DS_LOGIN, DS_SENHA) VALUES (?,?,?)");
            comandoSQL.setString(1, obj.getDS_NOME());
            comandoSQL.setString(2, obj.getDS_LOGIN());
            comandoSQL.setString(3, obj.getDS_SENHA());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas > 0){
                retorno = 1;
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
       
        return retorno;
    }
  
    //Validação para não permitir duplicidade de LOGIN - Consulta se já existe o login digitado no BD
    public static boolean validarLogin (Usuario obj){
        boolean retorno = false;
        int linhasEncontradas = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(URL,login,senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM Usuarios WHERE DS_LOGIN = ?");
            comandoSQL.setString(1, obj.getDS_LOGIN());
            
            ResultSet resultado = comandoSQL.executeQuery();
                        
            while(resultado.next()){
                linhasEncontradas++;
            }

            if(linhasEncontradas > 0){
                retorno = true;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    }
    
    public static ArrayList<Usuario> listar(){
        Connection conexao = null;
        boolean retorno = false;
        
        ArrayList<Usuario> ListaUsuarios = new ArrayList<Usuario>();
        
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, login, senha);
            
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("SELECT * FROM Usuarios; "
                    , Statement.RETURN_GENERATED_KEYS );
            
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){
                while(rs.next()){
                    Usuario objUsuario = new Usuario();
                    
                    objUsuario.setPK_ID(rs.getInt("PK_ID"));
                    objUsuario.setDS_NOME(rs.getString("DS_NOME"));
                    objUsuario.setDS_LOGIN(rs.getString("DS_LOGIN"));
                    
                    ListaUsuarios.add(objUsuario);
                }
            }                
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
         return ListaUsuarios;
    }
    
    
    public static ArrayList<Usuario> buscarUsuarios(String loginUsuario){
        Connection conexao = null;
        String sql = "";
        
        ArrayList<Usuario> ListaUsuarios = new ArrayList<Usuario>();

         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, login, senha);
            
            sql = "SELECT * FROM Usuarios WHERE DS_LOGIN LIKE ?";
            
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1,"%" + loginUsuario + "%");
            
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){
                while(rs.next()){
                    Usuario objUsuario = new Usuario();
                    
                    objUsuario.setPK_ID(rs.getInt("PK_ID"));
                    objUsuario.setDS_NOME(rs.getString("DS_NOME"));
                    objUsuario.setDS_LOGIN(rs.getString("DS_LOGIN"));
                    
                    ListaUsuarios.add(objUsuario);
                }    
            }                
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
         return ListaUsuarios;
    }
    
    //Alteração de login no BD - Alterar
    //Validação login: -1 = erro na gravação; 1 = Login alterado com sucesso
    public static int alterar(Usuario obj){
        Connection conexao = null;
        int retorno = -1;
        int linhas = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, login, senha);
            
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("UPDATE Usuarios SET DS_NOME = ?, DS_LOGIN = ?, DS_SENHA = ? WHERE PK_ID = ? ; "
                    , Statement.RETURN_GENERATED_KEYS );
            
            comandoSQL.setString(1,obj.getDS_NOME());
            comandoSQL.setString(2,obj.getDS_LOGIN());
            comandoSQL.setString(3,obj.getDS_SENHA());
            comandoSQL.setInt(4,obj.getPK_ID());
    
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas > 0){
                retorno = 1;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno;   
    }
    
    public static boolean excluir(int ID){
        Connection conexao = null;
        boolean retorno = false;
        
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, login, senha);
            
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("DELETE FROM Usuarios WHERE PK_ID = ?; "
                    , Statement.RETURN_GENERATED_KEYS );
            
            comandoSQL.setInt(1, ID);
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            }    
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return retorno;
    }
}
