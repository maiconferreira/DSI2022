package br.univille.dsi2022.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dsi2022.dto.DispensaDTO;
import br.univille.dsi2022.service.DispensaService;

@Controller
@RequestMapping("/dispensa")
public class DispensaController {

    @Autowired
    private DispensaService service;

    @GetMapping
    public ModelAndView index() {
        List<DispensaDTO> listaDispensa = service.getAll();
        return new ModelAndView("dispensa/index", "listaDispensa", listaDispensa);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        DispensaDTO dispensa = new DispensaDTO();
        return new ModelAndView("dispensa/form", "dispensa", dispensa);
    }

    @PostMapping(params = "form")
    public ModelAndView save(DispensaDTO dispensa) {
        service.save(dispensa);
        return new ModelAndView("redirect:/dispensa");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable long id) {
        DispensaDTO dispensa = service.findById(id);
        return new ModelAndView("dispensa/form", "dispensa", dispensa);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        service.delete(id);
        return new ModelAndView("redirect:/dispensa");
    }
}
