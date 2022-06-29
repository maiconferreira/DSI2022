package br.univille.dsi2022.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class SetorDaDispensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "setor_id")
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
