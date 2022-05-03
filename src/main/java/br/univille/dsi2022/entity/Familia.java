package br.univille.dsi2022.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int quantidadeDeMembros;
    private MembroDaFamilia membro;
    private ListaDeCompras listaDeCompras;
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
    public MembroDaFamilia getMembro() {
        return membro;
    }
    public void setMembro(MembroDaFamilia membro) {
        this.membro = membro;
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


    
}
