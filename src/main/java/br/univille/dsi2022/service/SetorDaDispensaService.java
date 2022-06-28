package br.univille.dsi2022.service;

import java.util.List;

import br.univille.dsi2022.dto.SetorDaDispensaDTO;

public interface SetorDaDispensaService {
    public List<SetorDaDispensaDTO> getAll();

    public SetorDaDispensaDTO save(SetorDaDispensaDTO setorDaDispensa);

    public SetorDaDispensaDTO findById(long id);

    public void delete(long id);
}
