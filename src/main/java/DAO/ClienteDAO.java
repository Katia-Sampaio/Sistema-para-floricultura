
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Clientes;

public class ClienteDAO {
   //public static String url = "jdbc:mysql://localhost:3308/floricultura";
   //public static String login = "root";
   //public static String senha = "";
    public static String url = "jdbc:mysql://localhost:3306/floricultura";
    public static String login = "user";
    public static String senha = "user";
    
 public static boolean salvar(Clientes obj){
        Connection conexao = null;
        boolean retorno = false;

        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO CLIENTES (DS_NOME, NR_CPF,DT_NASCIMENTO, DS_EMAIL, DS_TELEFONE, DS_CEP, "+
             "DS_ENDERECO,DS_CIDADE, DS_UF,DS_PAIS,TG_SEXO, TG_ESTADOCIVIL) VALUES(?,?,?,?,?,?,?,?,?,?,?,?); "
                    , Statement.RETURN_GENERATED_KEYS );
            
            comandoSQL.setString(1,obj.getNome());
            comandoSQL.setLong(2, obj.getCpf());
            comandoSQL.setDate(3,new java.sql.Date(obj.getNascimento().getTime()));
            comandoSQL.setString(4, obj.getEmail());
            comandoSQL.setString(5, obj.getTelefone());
            comandoSQL.setString(6, obj.getCep());
            comandoSQL.setString(7, obj.getEndereco());
            comandoSQL.setString(8, obj.getCidade());
            comandoSQL.setString(9, obj.getUf());
            comandoSQL.setString(10, obj.getPais());
            comandoSQL.setString(11, obj.getSexo());
            comandoSQL.setString(12, obj.getEstadoCivil());
                      
            //4º passo - Executar o comando
            int linhasAfetadas = comandoSQL.executeUpdate();
            if(linhasAfetadas>0){
                retorno = true;
                
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if(rs != null){
                    if(rs.next()){
                        obj.setIdCliente(rs.getInt(1)); 
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
  public static boolean excluir(int ID){
        Connection conexao = null;
        boolean retorno = false;
        
         try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("DELETE FROM CLIENTES WHERE PK_ID = ?; "
                    , Statement.RETURN_GENERATED_KEYS );
            
            comandoSQL.setInt(1, ID);
            
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
  
   public static boolean alterar(Clientes obj){
        Connection conexao = null;
        boolean retorno = false;
        int linhas = 0;
        
       try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("UPDATE CLIENTES SET DS_NOME = ?, NR_CPF = ?,DT_NASCIMENTO = ?, DS_EMAIL = ?,"
                    + " DS_TELEFONE = ?, DS_CEP = ?, "+
             "DS_ENDERECO = ?,DS_CIDADE = ?, DS_UF = ?,DS_PAIS = ?,TG_SEXO = ?, TG_ESTADOCIVIL = ? WHERE PK_ID = ? ; "
                    , Statement.RETURN_GENERATED_KEYS );
            
            comandoSQL.setString(1,obj.getNome());
            comandoSQL.setLong(2, obj.getCpf());
            comandoSQL.setDate(3,new java.sql.Date(obj.getNascimento().getTime()));
            comandoSQL.setString(4, obj.getEmail());
            comandoSQL.setString(5, obj.getTelefone());
            comandoSQL.setString(6, obj.getCep());
            comandoSQL.setString(7, obj.getEndereco());
            comandoSQL.setString(8, obj.getCidade());
            comandoSQL.setString(9, obj.getUf());
            comandoSQL.setString(10, obj.getPais());
            comandoSQL.setString(11, obj.getSexo());
            comandoSQL.setString(12, obj.getEstadoCivil());
            comandoSQL.setInt(13,obj.getIdCliente());
    
            //4º passo - Executar o comando
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
   
   public static Clientes buscarDadosClientes(int CodCliente){
        Connection conexao = null;
        
        Clientes objCliente= new Clientes();
       
        String sql = "";

         try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            // NA MINHA SELECT, COLOCO APENAS OS CAMPOS QUE QUERO
            sql = "SELECT DS_NOME, DS_EMAIL, DS_TELEFONE, TG_SEXO, TG_ESTADOCIVIL, DT_NASCIMENTO FROM CLIENTES WHERE PK_ID = ?";
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setInt(1,CodCliente);
            
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){
                while(rs.next()){
                    // COLOCANDO OS CAMPOS DA SELECT DENTRO DO MEU OBJETO
                    objCliente.setNome(rs.getString("DS_NOME"));
                    objCliente.setEmail(rs.getString("DS_EMAIL"));
                    objCliente.setTelefone(rs.getString("DS_TELEFONE"));
                    objCliente.setSexo(rs.getString("TG_SEXO"));
                    objCliente.setEstadoCivil(rs.getString("TG_ESTADOCIVIL"));
                    objCliente.setNascimento(rs.getDate("DT_NASCIMENTO"));
                }    
            }                
           
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         //RETORNANDO OBJETO DA TELA.
         return objCliente;   
    }
   
    
    public static ArrayList<Clientes> listar(){
        Connection conexao = null;
        boolean retorno = false;
        
        ArrayList<Clientes> ListaClientes = new ArrayList<Clientes>();
        
        
         try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = 
            conexao.prepareStatement("SELECT * FROM CLIENTES; "
                    , Statement.RETURN_GENERATED_KEYS );
            
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){

                while(rs.next()){
                    Clientes objCliente= new Clientes();
                   
                    objCliente.setIdCliente(rs.getInt("PK_ID"));
                    objCliente.setNome(rs.getString("DS_NOME"));
                    objCliente.setCpf(rs.getLong("NR_CPF"));
                    objCliente.setEmail(rs.getString("DS_EMAIL"));
                    objCliente.setTelefone(rs.getString("DS_TELEFONE"));
                    objCliente.setCep(rs.getString("DS_CEP"));
                    objCliente.setEndereco(rs.getString("DS_ENDERECO"));
                    objCliente.setCidade(rs.getString("DS_CIDADE"));
                    objCliente.setUf(rs.getString("DS_UF"));
                    objCliente.setPais(rs.getString("DS_PAIS"));
                    
                    ListaClientes.add(objCliente);
                }    
            }                
           
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return ListaClientes;          
    }

    public static ArrayList<Clientes> buscarClientePorNome(String nomeCliente){
        
        Connection conexao = null;
        boolean retorno = false;
        
        ArrayList<Clientes> ListaNome = new ArrayList<Clientes>();
       
        String sql = "";

         try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            sql = "SELECT * FROM CLIENTES WHERE DS_NOME LIKE ?;";
            
            //3º passo - Criar o comando SQL
            
            //correção
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1,"%"+ nomeCliente
                    + "%");
            
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){

                while(rs.next()){
                    Clientes objCliente= new Clientes();
                    
                    objCliente.setIdCliente(rs.getInt("PK_ID"));
                    objCliente.setNome(rs.getString("DS_NOME"));
                    objCliente.setCpf(rs.getLong("NR_CPF"));
                    objCliente.setEmail(rs.getString("DS_EMAIL"));
                    objCliente.setTelefone(rs.getString("DS_TELEFONE"));
                    objCliente.setCep(rs.getString("DS_CEP"));
                    objCliente.setEndereco(rs.getString("DS_ENDERECO"));
                    objCliente.setCidade(rs.getString("DS_CIDADE"));
                    objCliente.setUf(rs.getString("DS_UF"));
                    objCliente.setPais(rs.getString("DS_PAIS"));

                   ListaNome.add(objCliente);
                }    
            }                
           
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return ListaNome;   
    }
    
     public static ArrayList<Clientes> buscarClientePorCPF(long numCpf){
      
        Connection conexao = null;
        boolean retorno = false;
        
        ArrayList<Clientes> ListaCPF = new ArrayList<Clientes>();
        
        String sql = "";
        

         try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            sql = "SELECT * FROM CLIENTES WHERE NR_CPF = ?;";
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setLong(1, numCpf);
            
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){

                while(rs.next()){
                    
                    Clientes objCliente = new Clientes();
                    
                    objCliente.setIdCliente(rs.getInt("PK_ID"));
                    objCliente.setNome(rs.getString("DS_NOME"));
                    objCliente.setCpf(rs.getLong("NR_CPF"));
                    objCliente.setEmail(rs.getString("DS_EMAIL"));
                    objCliente.setTelefone(rs.getString("DS_TELEFONE"));
                    objCliente.setCep(rs.getString("DS_CEP"));
                    objCliente.setEndereco(rs.getString("DS_ENDERECO"));
                    objCliente.setCidade(rs.getString("DS_CIDADE"));
                    objCliente.setUf(rs.getString("DS_UF"));
                    objCliente.setPais(rs.getString("DS_PAIS"));
                    ListaCPF.add(objCliente);
                }    
            }                
           
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return ListaCPF;
        
        
    }
     
     public static ArrayList<Clientes> buscarNomeCPF(long numCpf, String nomeCliente){
       Connection conexao = null;
        boolean retorno = false;
        
        ArrayList<Clientes> ListaNomeCPF = new ArrayList<Clientes>();
        
        String sql = "";  
        
        try {
            //1º passo - Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2º passo - Abrir a conexão
            conexao = DriverManager.getConnection(url, login, senha);
            
            sql = "SELECT * FROM CLIENTES WHERE NR_CPF = ? AND DS_NOME LIKE ?; ";
            
            //3º passo - Criar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setLong(1, numCpf);
            comandoSQL.setString(2,"%"+ nomeCliente+ "%");
            
            //4º passo - Executar o comando
            ResultSet rs = comandoSQL.executeQuery();
                   
            if(rs != null){
                 while(rs.next()){
                    
                    Clientes objCliente = new Clientes();
                    
                    objCliente.setIdCliente(rs.getInt("PK_ID"));
                    objCliente.setNome(rs.getString("DS_NOME"));
                    objCliente.setCpf(rs.getLong("NR_CPF"));
                    objCliente.setEmail(rs.getString("DS_EMAIL"));
                    objCliente.setTelefone(rs.getString("DS_TELEFONE"));
                    objCliente.setCep(rs.getString("DS_CEP"));
                    objCliente.setEndereco(rs.getString("DS_ENDERECO"));
                    objCliente.setCidade(rs.getString("DS_CIDADE"));
                    objCliente.setUf(rs.getString("DS_UF"));
                    objCliente.setPais(rs.getString("DS_PAIS"));
                    
                    ListaNomeCPF.add(objCliente);
                }    
            }                
           
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return ListaNomeCPF;
    }
     
    public static boolean ValidaVendasCliente(int CodCliente){
        boolean retorno = false;
        int Codigo = 0;
       
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(url, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT FK_CLIENTE FROM VENDAS_CABECALHO WHERE FK_CLIENTE = ?");
            comandoSQL.setInt(1, CodCliente);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Codigo = rs.getInt("FK_CLIENTE");                   
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
}
    
        