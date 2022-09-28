package br.univille.dsi2022.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.dsi2022.dto.ProdutoDTO;
import br.univille.dsi2022.entity.Produto;
import br.univille.dsi2022.mapper.ProdutoMapper;
import br.univille.dsi2022.repository.ProdutoRepository;
import br.univille.dsi2022.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    private ProdutoMapper mapper = Mappers.getMapper(ProdutoMapper.class);

    @Override
    public List<ProdutoDTO> getAll() {

        return mapper.mapProduto(repository.findAll());
    }

    @Override
    public ProdutoDTO save(ProdutoDTO produto) {
        Produto produtoEntity = mapper.mapProdutoDTO(produto);
        repository.save(produtoEntity);
        return mapper.mapProduto(produtoEntity);
    }

    @Override
    public ProdutoDTO findById(long id) {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isPresent()) {
            Produto produtoEntity = produto.get();
            return mapper.mapProduto(produtoEntity);
        }
        return new ProdutoDTO();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }


    @Override
    public List<ProdutoDTO> getLista() {
        List<ProdutoDTO> listaDeCompras = new ArrayList<>();
        List<ProdutoDTO> listaProdutos = mapper.mapProduto(repository.findAll());
        for (ProdutoDTO produto : listaProdutos) {
            if (produto.getQuantidadeAtual() < produto.getQuantidadeIdeal()) {
                listaDeCompras.add(produto);
            }
        }
        return listaDeCompras;
    }

}
