package br.univille.dsi2022.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dispensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private SetorDaDispensa setor;

    public SetorDaDispensa getSetor() {
        return setor;
    }

    public void setSetor(SetorDaDispensa setor) {
        this.setor = setor;
    }

    
}
