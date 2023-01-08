package model;

//declaração das variáveis
public class Usuario {
    private int PK_ID;
    private String DS_LOGIN;
    private String DS_SENHA;
    private String DS_NOME;
    
    //Construtor vazio
    public Usuario(){
    }
    
    //Construtores sem ID (para inclusão)
    public Usuario(String DS_LOGIN, String DS_SENHA, String DS_NOME) {
        this.DS_LOGIN = DS_LOGIN;
        this.DS_SENHA = DS_SENHA;
        this.DS_NOME = DS_NOME;
    }
    
    //Construtores com ID (para consultar/alterar)
    public Usuario(int PK_ID, String DS_LOGIN, String DS_SENHA, String DS_NOME) {
        this.PK_ID = PK_ID;
        this.DS_LOGIN = DS_LOGIN;
        this.DS_SENHA = DS_SENHA;
        this.DS_NOME = DS_NOME;
    }

    public int getPK_ID() {
        return PK_ID;
    }

    public void setPK_ID(int PK_ID) {
        this.PK_ID = PK_ID;
    }

    public String getDS_LOGIN() {
        return DS_LOGIN;
    }

    public void setDS_LOGIN(String DS_LOGIN) {
        this.DS_LOGIN = DS_LOGIN;
    }

    public String getDS_SENHA() {
        return DS_SENHA;
    }

    public void setDS_SENHA(String DS_SENHA) {
        this.DS_SENHA = DS_SENHA;
    }

    public String getDS_NOME() {
        return DS_NOME;
    }

    public void setDS_NOME(String DS_NOME) {
        this.DS_NOME = DS_NOME;
    }
    
    
}
