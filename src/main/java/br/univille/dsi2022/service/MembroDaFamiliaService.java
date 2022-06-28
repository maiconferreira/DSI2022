package br.univille.dsi2022.service;

import java.util.List;

import br.univille.dsi2022.dto.MembroDaFamiliaDTO;

public interface MembroDaFamiliaService {
    public List<MembroDaFamiliaDTO> getAll();

    public MembroDaFamiliaDTO save(MembroDaFamiliaDTO membroDaFamilia);

    public MembroDaFamiliaDTO findById(long id);

    public void delete(long id);
}
