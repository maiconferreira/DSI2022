package br.univille.dsi2022.dto;

public class ProdutoDTO {
    private long id;
    private String produtoNome;
    private int quantidadeAtual;
    private int quantidadeIdeal;
    private int quantidadeMinima;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getProdutoNome() {
        return produtoNome;
    }
    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }
    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }
    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }
    public int getQuantidadeIdeal() {
        return quantidadeIdeal;
    }
    public void setQuantidadeIdeal(int quantidadeIdeal) {
        this.quantidadeIdeal = quantidadeIdeal;
    }
    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }
    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    
}
