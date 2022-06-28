package br.univille.dsi2022.dto;

import java.util.ArrayList;
import java.util.List;

import br.univille.dsi2022.entity.Dispensa;


public class DispensaDTO {
    private long id;
    private List<Dispensa> setor = new ArrayList<>();
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public List<Dispensa> getSetor() {
        return setor;
    }
    public void setSetor(List<Dispensa> setor) {
        this.setor = setor;
    }
    
}
