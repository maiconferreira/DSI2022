package br.univille.dsi2022.dto;

import java.util.ArrayList;
import java.util.List;

public class SetorDaDispensaDTO {
    private long id;
    private String nome;
    private List<ProdutoDTO> listaProdutos = new ArrayList<>();
    private long produtoId;

    public long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(long produtoId) {
        this.produtoId = produtoId;
    }

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

    public List<ProdutoDTO> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProduto(List<ProdutoDTO> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

}
