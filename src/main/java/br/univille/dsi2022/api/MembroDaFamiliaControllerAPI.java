package br.univille.dsi2022.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.dsi2022.dto.MembroDaFamiliaDTO;
import br.univille.dsi2022.service.MembroDaFamiliaService;

@RestController
@RequestMapping("/api/v1/membrosDaFamilia")
public class MembroDaFamiliaControllerAPI {

    @Autowired
    private MembroDaFamiliaService service;

    @GetMapping
    ResponseEntity<List<MembroDaFamiliaDTO>> getAll() {
        var listaMembrosDaFamilia = service.getAll();
        return new ResponseEntity<>(listaMembrosDaFamilia, HttpStatus.OK);
    }
}
