
package model;

import java.util.Date;

public class RelSintetico {
      
    private int IdVenda;
    private int CodCliente;
    private double ValorVenda;
    private Date DataVenda;
    private String NomeCliente;
    private int QtProdutos;
    private int TG_CANCELADO;
    private String DS_CANCELADO;
    private String DS_MOTIVOCANCELAMENTO;

    
    public RelSintetico(){     
    }
    
    public int getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(int CodCliente) {
        this.CodCliente = CodCliente;
    }

    public Date getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(Date DataVenda) {
        this.DataVenda = DataVenda;
    }

    
    public int getIdVenda() {
        return IdVenda;
    }

    public void setIdVenda(int IdVenda) {
        this.IdVenda = IdVenda;
    }

    public double getValorVenda() {
        return ValorVenda;
    }

    public void setValorVenda(double ValorVenda) {
        this.ValorVenda = ValorVenda;
    }  

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public int getQtProdutos() {
        return QtProdutos;
    }

    public void setQtProdutos(int QtProdutos) {
        this.QtProdutos = QtProdutos;
    }

    public String getDS_MOTIVOCANCELAMENTO() {
        return DS_MOTIVOCANCELAMENTO;
    }

    public void setDS_MOTIVOCANCELAMENTO(String DS_MOTIVOCANCELAMENTO) {
        this.DS_MOTIVOCANCELAMENTO = DS_MOTIVOCANCELAMENTO;
    }

    public int getTG_CANCELADO() {
        return TG_CANCELADO;
    }

    public void setTG_CANCELADO(int TG_CANCELADO) {
        this.TG_CANCELADO = TG_CANCELADO;
    }

    public String getDS_CANCELADO() {
        return DS_CANCELADO;
    }

    public void setDS_CANCELADO(String DS_CANCELADO) {
        this.DS_CANCELADO = DS_CANCELADO;
    }
    
    
}

