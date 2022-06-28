package br.univille.dsi2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.dsi2022.dto.DispensaDTO;
import br.univille.dsi2022.entity.Dispensa;

@Mapper
public interface DispensaMapper {
    List<DispensaDTO> mapDispensa(List<Dispensa> dispensa);
    List<Dispensa> mapDispensaDTO(List<DispensaDTO> dispensa);
    DispensaDTO mapDispensa(Dispensa dispensa);
    Dispensa mapDispensaDTO(DispensaDTO dispensa);
}
