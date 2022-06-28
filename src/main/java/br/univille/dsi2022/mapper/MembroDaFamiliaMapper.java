package br.univille.dsi2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.dsi2022.dto.MembroDaFamiliaDTO;
import br.univille.dsi2022.entity.MembroDaFamilia;

@Mapper
public interface MembroDaFamiliaMapper {
    List<MembroDaFamiliaDTO> mapMembroDaFamilia(List<MembroDaFamilia> membroDaFamilia);
    List<MembroDaFamilia> mapMembroDaFamiliaDTO(List<MembroDaFamiliaDTO> membroDaFamilia);
    MembroDaFamiliaDTO mapMembroDaFamilia(MembroDaFamilia membroDaFamilia);
    MembroDaFamilia mapMembroDaFamiliaDTO(MembroDaFamiliaDTO membroDaFamilia);
}
