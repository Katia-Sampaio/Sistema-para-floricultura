package model;

public class Produtos {

    private int CodigoProduto;
    private String NomeProduto;
    private double PrecoProduto;
    private int EstoqueProduto;

    public Produtos() {
    }

    public Produtos(String DS_MODELO, double VL_PRECO, int QT_ESTOQUE) {
        
        this.NomeProduto = DS_MODELO;
        this.PrecoProduto = VL_PRECO;
        this.EstoqueProduto = QT_ESTOQUE;
    }

    public Produtos(int PK_ID, String DS_MODELO, double VL_PRECO, int QT_ESTOQUE) {
        
        this.CodigoProduto = PK_ID;
        this.NomeProduto = DS_MODELO;
        this.PrecoProduto = VL_PRECO;
        this.EstoqueProduto = QT_ESTOQUE;

    }

    public int getCodigoProduto() {
        return CodigoProduto;
    }

    public void setCodigoProduto(int CodigoProduto) {
        this.CodigoProduto = CodigoProduto;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String NomeProduto) {
        this.NomeProduto = NomeProduto;
    }

    public double getPrecoProduto() {
        return PrecoProduto;
    }

    public void setPrecoProduto(double PrecoProduto) {
        this.PrecoProduto = PrecoProduto;
    }

    public int getEstoqueProduto() {
        return EstoqueProduto;
    }

    public void setEstoqueProduto(int EstoqueProduto) {
        this.EstoqueProduto = EstoqueProduto;
    }

    
    

}
