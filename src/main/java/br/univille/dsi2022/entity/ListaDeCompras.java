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
public class ListaDeCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "item_id")
    private List<ItemDaLista> item = new ArrayList<>();
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public List<ItemDaLista> getItem() {
        return item;
    }
    public void setItem(List<ItemDaLista> item) {
        this.item = item;
    }
    
}
