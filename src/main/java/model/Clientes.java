package model;

import java.util.Date;

public class Clientes {
    //Atributos
    private int idCliente;
    private long Cpf;
    private String Nome, Email, Telefone,Cep,Endereco,Cidade,Uf,Pais, Sexo, EstadoCivil;
    private Date Nascimento;
    
   
    public Clientes() {

}
    public Clientes(int Id, String Nome, long Cpf, String Email, String Telefone, 
            String Cep, String Endereco,String Cidade, String Uf, String Pais,Date Nascimento, 
             String Sexo, String EstadoCivil){
	
        this.idCliente = Id;
	this.Nome = Nome;
        this.Cpf = Cpf;
        this.Email = Email;
        this.Telefone = Telefone;
        this.Cep = Cep;
        this.Endereco = Endereco;
        this.Cidade = Cidade;
        this.Uf = Uf;
        this.Pais = Pais;
        this.Nascimento = Nascimento;
        this.Sexo = Sexo;
        this.EstadoCivil = EstadoCivil;
        
}   
    public Clientes(String Nome, long Cpf, String Email, String Telefone, 
            String Cep, String Endereco,String Cidade, String Uf, String Pais,Date Nascimento, 
             String Sexo, String EstadoCivil){
	
	this.Nome = Nome;
        this.Cpf = Cpf;
        this.Email = Email;
        this.Telefone = Telefone;
        this.Cep = Cep;
        this.Endereco = Endereco;
        this.Cidade = Cidade;
        this.Uf = Uf;
        this.Pais = Pais;
        this.Nascimento = Nascimento;
        this.Sexo = Sexo;
        this.EstadoCivil = EstadoCivil;
}

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public long getCpf() {
        return Cpf;
    }

    public void setCpf(long Cpf) {
        this.Cpf = Cpf;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getUf() {
        return Uf;
    }

    public void setUf(String Uf) {
        this.Uf = Uf;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public Date getNascimento() {
        return Nascimento;
    }

    public void setNascimento(Date Nascimento) {
        this.Nascimento = Nascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }    
}
