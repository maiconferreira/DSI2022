package br.univille.dsi2022.dto;

import java.util.ArrayList;
import java.util.List;


public class SetorDaDispensaDTO {
    private long id;
    private String nome;
    private List<ProdutoDTO> produto = new ArrayList<>();
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<ProdutoDTO> getProduto() {
        return produto;
    }
    public void setProduto(List<ProdutoDTO> produto) {
        this.produto = produto;
    }

}
