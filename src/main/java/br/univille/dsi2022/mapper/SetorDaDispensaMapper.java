package br.univille.dsi2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.dsi2022.dto.SetorDaDispensaDTO;
import br.univille.dsi2022.entity.SetorDaDispensa;

@Mapper
public interface SetorDaDispensaMapper {
    List<SetorDaDispensaDTO> mapSetorDaDispensa(List<SetorDaDispensa> listaSetoresDaDispensa);
    List<SetorDaDispensa> mapSetorDaDispensaDTO(List<SetorDaDispensaDTO> listaSetoresDaDispensa);
    SetorDaDispensaDTO mapSetorDaDispensa(SetorDaDispensa setorDaDispensa);
    SetorDaDispensa mapSetorDaDispensaDTO(SetorDaDispensaDTO setorDaDispensa);
}
