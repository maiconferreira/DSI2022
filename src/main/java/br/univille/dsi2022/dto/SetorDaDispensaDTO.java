package br.univille.dsi2022.dto;

import java.util.ArrayList;
import java.util.List;
import br.univille.dsi2022.entity.Produto;

public class SetorDaDispensaDTO {
    private long id;
    private String nome;
    private List<Produto> produto = new ArrayList<>();
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
    public List<Produto> getProduto() {
        return produto;
    }
    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

}
