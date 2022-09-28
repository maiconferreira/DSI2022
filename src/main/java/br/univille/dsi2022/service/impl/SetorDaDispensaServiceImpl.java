package br.univille.dsi2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dsi2022.dto.SetorDaDispensaDTO;
import br.univille.dsi2022.entity.SetorDaDispensa;
import br.univille.dsi2022.mapper.SetorDaDispensaMapper;
import br.univille.dsi2022.repository.ProdutoRepository;
import br.univille.dsi2022.repository.SetorDaDispensaRepository;
import br.univille.dsi2022.service.SetorDaDispensaService;

@Service
public class SetorDaDispensaServiceImpl implements SetorDaDispensaService {

    @Autowired
    private SetorDaDispensaRepository repository;
    @Autowired
    private ProdutoRepository produtoRepository;

    private SetorDaDispensaMapper mapper = Mappers.getMapper(SetorDaDispensaMapper.class);

    @Override
    public List<SetorDaDispensaDTO> getAll() {

        return mapper.mapSetorDaDispensa(repository.findAll());
    }

    @Override
    public SetorDaDispensaDTO save(SetorDaDispensaDTO setorDaDispensa) {
        var setorAntigo = repository.findById(setorDaDispensa.getId());
        if (setorAntigo.isPresent()){
            for(var umProdAntigo : setorAntigo.get().getListaProdutos()){
                var umProdutoEncontrado = setorDaDispensa.getListaProdutos().stream().filter(o -> o.getId() == umProdAntigo.getId()).findAny()
                .orElse(null);
                if(umProdutoEncontrado ==  null){
                    produtoRepository.delete(umProdAntigo);
                }
            }
        }
        SetorDaDispensa setorDaDispensaEntity = mapper.mapSetorDaDispensaDTO(setorDaDispensa);
        for (var umProd : setorDaDispensaEntity.getListaProdutos()) {
            produtoRepository.save(umProd);
        }


        repository.save(setorDaDispensaEntity);
        return mapper.mapSetorDaDispensa(setorDaDispensaEntity);
    }

    @Override
    public SetorDaDispensaDTO findById(long id) {
        Optional<SetorDaDispensa> setorDaDispensa = repository.findById(id);
        if (setorDaDispensa.isPresent()) {
            SetorDaDispensa setorDaDispensaEntity = setorDaDispensa.get();
            return mapper.mapSetorDaDispensa(setorDaDispensaEntity);
        }
        //return new SetorDaDispensaDTO();
        return null;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

}
