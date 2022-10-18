package br.univille.dsi2022.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public ResponseEntity<MembroDaFamiliaDTO> save(@RequestBody MembroDaFamiliaDTO membroDaFamilia){
        if(membroDaFamilia.getId() == 0){
            membroDaFamilia = service.save(membroDaFamilia);
            return new ResponseEntity<MembroDaFamiliaDTO>(membroDaFamilia,HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembroDaFamiliaDTO> getById(@PathVariable("id") long id) {
        var umMembroDaFamilia = service.findById(id);
        if (umMembroDaFamilia.getId() == 0) {
            return ResponseEntity.notFound().build();
        }
        return
            new ResponseEntity<MembroDaFamiliaDTO>(umMembroDaFamilia,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembroDaFamiliaDTO> update(@PathVariable("id") long id, @RequestBody MembroDaFamiliaDTO membroDaFamilia){
        var membroDaFamiliaAntigo = service.findById(id);
        if (membroDaFamiliaAntigo.getId() == 0) {
            return ResponseEntity.notFound().build();   
        }
        membroDaFamiliaAntigo.setNome(membroDaFamilia.getNome());
        membroDaFamiliaAntigo.setDataDeNascimento(membroDaFamilia.getDataDeNascimento());
        membroDaFamiliaAntigo.setUsuario(membroDaFamilia.getUsuario());
        membroDaFamiliaAntigo.setSenha(membroDaFamilia.getSenha());

        service.save(membroDaFamilia);
        return new ResponseEntity<MembroDaFamiliaDTO>(membroDaFamiliaAntigo, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MembroDaFamiliaDTO> delete(@PathVariable("id") long id){
        var membroDaFamiliaAntigo = service.findById(id);
        if (membroDaFamiliaAntigo.getId() == 0) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new
            ResponseEntity<MembroDaFamiliaDTO>(membroDaFamiliaAntigo, HttpStatus.OK);
    }
}
