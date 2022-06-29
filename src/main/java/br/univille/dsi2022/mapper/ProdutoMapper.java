package br.univille.dsi2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.univille.dsi2022.dto.ProdutoDTO;
import br.univille.dsi2022.entity.Produto;

@Mapper
public interface ProdutoMapper {
    @Mapping(source = "nome", target = "produtoNome")
    List<ProdutoDTO> mapProduto(List<Produto> produto);
    @Mapping(source = "produtoNome", target = "nome")
    List<Produto> mapProdutoDTO(List<ProdutoDTO> produto);
    @Mapping(source = "nome", target = "produtoNome")
    ProdutoDTO mapProduto(Produto produto);
    @Mapping(source = "produtoNome", target = "nome")
    Produto mapProdutoDTO(ProdutoDTO produto);
}
