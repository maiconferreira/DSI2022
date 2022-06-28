package br.univille.dsi2022.service;

import java.util.List;

import br.univille.dsi2022.dto.ProdutoDTO;

public interface ProdutoService {
    public List<ProdutoDTO> getAll();

    public ProdutoDTO save(ProdutoDTO produto);

    public ProdutoDTO findById(long id);

    public void delete(long id);
}
