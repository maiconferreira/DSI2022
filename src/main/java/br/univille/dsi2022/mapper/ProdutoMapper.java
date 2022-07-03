package br.univille.dsi2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.dsi2022.dto.ProdutoDTO;
import br.univille.dsi2022.entity.Produto;

@Mapper
public interface ProdutoMapper {
    List<ProdutoDTO> mapProduto(List<Produto> listaProdutos);
    List<Produto> mapProdutoDTO(List<ProdutoDTO> listaProdutos);
    ProdutoDTO mapProduto(Produto produto);
    Produto mapProdutoDTO(ProdutoDTO produto);
}
