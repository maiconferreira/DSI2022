package br.univille.dsi2022.service;

import java.util.List;

import br.univille.dsi2022.dto.DispensaDTO;

public interface DispensaService {
    public List<DispensaDTO> getAll();

    public DispensaDTO save(DispensaDTO dispensa);

    public DispensaDTO findById(long id);

    public void delete(long id);
}
