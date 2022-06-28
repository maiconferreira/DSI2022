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
public class Dispensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "setor_id")
    private List<SetorDaDispensa> setor = new ArrayList<>();
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public List<SetorDaDispensa> getSetor() {
        return setor;
    }
    public void setSetor(List<SetorDaDispensa> setor) {
        this.setor = setor;
    }
    
}
