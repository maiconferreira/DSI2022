package br.univille.dsi2022.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ListaDeCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private ItemDaLista item;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public ItemDaLista getItem() {
        return item;
    }
    public void setItem(ItemDaLista item) {
        this.item = item;
    }

    
}
