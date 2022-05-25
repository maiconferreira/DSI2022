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
import javax.persistence.OneToOne;

@Entity
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int quantidadeDeMembros;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "membro_id")
    private List<MembroDaFamilia> membro = new ArrayList<>();
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private ListaDeCompras listaDeCompras;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private Dispensa dispensa;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQuantidadeDeMembros() {
        return quantidadeDeMembros;
    }
    public void setQuantidadeDeMembros(int quantidadeDeMembros) {
        this.quantidadeDeMembros = quantidadeDeMembros;
    }
    public ListaDeCompras getListaDeCompras() {
        return listaDeCompras;
    }
    public void setListaDeCompras(ListaDeCompras listaDeCompras) {
        this.listaDeCompras = listaDeCompras;
    }
    public Dispensa getDispensa() {
        return dispensa;
    }
    public void setDispensa(Dispensa dispensa) {
        this.dispensa = dispensa;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public List<MembroDaFamilia> getMembro() {
        return membro;
    }
    public void setMembro(List<MembroDaFamilia> membro) {
        this.membro = membro;
    }    
}
