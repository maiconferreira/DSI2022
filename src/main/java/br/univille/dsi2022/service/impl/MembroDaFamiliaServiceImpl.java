package br.univille.dsi2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dsi2022.dto.MembroDaFamiliaDTO;
import br.univille.dsi2022.entity.MembroDaFamilia;
import br.univille.dsi2022.mapper.MembroDaFamiliaMapper;
import br.univille.dsi2022.repository.MembroDaFamiliaRepository;
import br.univille.dsi2022.service.MembroDaFamiliaService;

@Service
public class MembroDaFamiliaServiceImpl implements MembroDaFamiliaService {

    @Autowired
    private MembroDaFamiliaRepository repository;

    private MembroDaFamiliaMapper mapper = Mappers.getMapper(MembroDaFamiliaMapper.class);

    @Override
    public List<MembroDaFamiliaDTO> getAll() {

        return mapper.mapMembroDaFamilia(repository.findAll());
    }

    @Override
    public MembroDaFamiliaDTO save(MembroDaFamiliaDTO membroDaFamilia) {
        MembroDaFamilia membroDaFamiliaEntity = mapper.mapMembroDaFamiliaDTO(membroDaFamilia);
        repository.save(membroDaFamiliaEntity);
        return mapper.mapMembroDaFamilia(membroDaFamiliaEntity);
    }

    @Override
    public MembroDaFamiliaDTO findById(long id) {
        Optional<MembroDaFamilia> membroDaFamilia = repository.findById(id);
        if (membroDaFamilia.isPresent()) {
            MembroDaFamilia membroDaFamiliaEntity = membroDaFamilia.get();
            return mapper.mapMembroDaFamilia(membroDaFamiliaEntity);
        }
        return new MembroDaFamiliaDTO();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

}
