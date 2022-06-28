package br.univille.dsi2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dsi2022.dto.DispensaDTO;
import br.univille.dsi2022.entity.Dispensa;
import br.univille.dsi2022.mapper.DispensaMapper;
import br.univille.dsi2022.repository.DispensaRepository;
import br.univille.dsi2022.service.DispensaService;

@Service
public class DispensaServiceImpl implements DispensaService {

    @Autowired
    private DispensaRepository repository;

    private DispensaMapper mapper = Mappers.getMapper(DispensaMapper.class);

    @Override
    public List<DispensaDTO> getAll() {

        return mapper.mapDispensa(repository.findAll());
    }

    @Override
    public DispensaDTO save(DispensaDTO dispensa) {
        Dispensa dispensaEntity = mapper.mapDispensaDTO(dispensa);
        repository.save(dispensaEntity);
        return mapper.mapDispensa(dispensaEntity);
    }

    @Override
    public DispensaDTO findById(long id) {
        Optional<Dispensa> dispensa = repository.findById(id);
        if (dispensa.isPresent()) {
            Dispensa dispensaEntity = dispensa.get();
            return mapper.mapDispensa(dispensaEntity);
        }
        return new DispensaDTO();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

}
