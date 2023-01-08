package model;

import java.util.ArrayList;
import java.util.Date;

public class VendasCabecalho {
   
    
    
    private int IdVenda;
    private int CodCliente;
    private double ValorVenda;
    private Date DataVenda;

    private ArrayList<VendasItem> listaItens = null;
    
    public VendasCabecalho(){     
    }
    
    public VendasCabecalho(int FK_CLIENTE, double VL_VENDA, Date DH_VENDA, ArrayList listaItens){
       
        this.CodCliente = FK_CLIENTE;
        this.ValorVenda = VL_VENDA;
        this.DataVenda = DH_VENDA;
        this.listaItens = listaItens;
    }
    
    
    public VendasCabecalho(int PK_ID, int FK_CLIENTE, double VL_VENDA, Date DH_VENDA, ArrayList listaItens) {
       this.IdVenda = PK_ID;
        this.CodCliente = FK_CLIENTE;
        this.ValorVenda = VL_VENDA;
        this.DataVenda = DH_VENDA;
        this.listaItens = listaItens;
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
    
    public ArrayList<VendasItem> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<VendasItem> listaItens) {
        this.listaItens = listaItens;
    }
}

