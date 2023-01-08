package model;

public class VendasItem {
    private int IdItem;
    private int IdVenda;
    private int CodProduto;
    private int QtMovimento;
    private double VlUnitario;
    private double VlTotal;
    private double vlDesconto;
    private String NomeProduto;
    
    public VendasItem() {
    }

    public VendasItem(int IdItem, int IdVenda, int CodProduto, int QtMovimento, double VlUnitario, double VlTotal, double vlDesconto, String NomeProduto) {
        this.IdItem = IdItem;
        this.IdVenda = IdVenda;
        this.CodProduto = CodProduto;
        this.QtMovimento = QtMovimento;
        this.VlUnitario = VlUnitario;
        this.VlTotal = VlTotal;
        this.vlDesconto = vlDesconto;
        this.NomeProduto = NomeProduto;
    }   

    public VendasItem(int IdVenda, int CodProduto, int QtMovimento, double VlUnitario, double VlTotal, double vlDesconto, String NomeProduto) {
        this.IdVenda = IdVenda;
        this.CodProduto = CodProduto;
        this.QtMovimento = QtMovimento;
        this.VlUnitario = VlUnitario;
        this.VlTotal = VlTotal;
        this.vlDesconto = vlDesconto;
        this.NomeProduto = NomeProduto;
    }

    public int getIdItem() {
        return IdItem;
    }

    public void setIdItem(int IdItem) {
        this.IdItem = IdItem;
    }

    public int getIdVenda() {
        return IdVenda;
    }

    public void setIdVenda(int IdVenda) {
        this.IdVenda = IdVenda;
    }

    public int getCodProduto() {
        return CodProduto;
    }

    public void setCodProduto(int CodProduto) {
        this.CodProduto = CodProduto;
    }

    public int getQtMovimento() {
        return QtMovimento;
    }

    public void setQtMovimento(int QtMovimento) {
        this.QtMovimento = QtMovimento;
    }

    public double getVlUnitario() {
        return VlUnitario;
    }

    public void setVlUnitario(double VlUnitario) {
        this.VlUnitario = VlUnitario;
    }

    public double getVlTotal() {
        return VlTotal;
    }

    public void setVlTotal(double VlTotal) {
        this.VlTotal = VlTotal;
    }

    public double getVlDesconto() {
        return vlDesconto;
    }

    public void setVlDesconto(double vlDesconto) {
        this.vlDesconto = vlDesconto;
    }
    
    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }
    
    public VendasItem retornarItem(){
        VendasItem NovoItem = new VendasItem();
        
        NovoItem.getCodProduto();

        return NovoItem;   
    }  
}
