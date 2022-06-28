package br.univille.dsi2022.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dsi2022.dto.MembroDaFamiliaDTO;
import br.univille.dsi2022.service.MembroDaFamiliaService;

@Controller
@RequestMapping("/membroDaFamilia")
public class MembroDaFamiliaController {

    @Autowired
    private MembroDaFamiliaService service;

    @GetMapping
    public ModelAndView index() {
        List<MembroDaFamiliaDTO> listaMembroDaFamilia = service.getAll();
        return new ModelAndView("membroDaFamilia/index", "listaMembroDaFamilia", listaMembroDaFamilia);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        MembroDaFamiliaDTO membroDaFamilia = new MembroDaFamiliaDTO();
        return new ModelAndView("membroDaFamilia/form", "membroDaFamilia", membroDaFamilia);
    }

    @PostMapping(params = "form")
    public ModelAndView save(MembroDaFamiliaDTO membroDaFamilia) {
        service.save(membroDaFamilia);
        return new ModelAndView("redirect:/membroDaFamilia");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable long id) {
        MembroDaFamiliaDTO membroDaFamilia = service.findById(id);
        return new ModelAndView("membroDaFamilia/form", "membroDaFamilia", membroDaFamilia);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        service.delete(id);
        return new ModelAndView("redirect:/membroDaFamilia");
    }
}
