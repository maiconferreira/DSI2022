package br.univille.dsi2022.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dsi2022.dto.SetorDaDispensaDTO;
import br.univille.dsi2022.service.SetorDaDispensaService;

@Controller
@RequestMapping("/setorDaDispensa")
public class SetorDaDispensaController {

    @Autowired
    private SetorDaDispensaService service;

    @GetMapping
    public ModelAndView index() {
        List<SetorDaDispensaDTO> listaSetorDaDispensa = service.getAll();
        return new ModelAndView("setorDaDispensa/index", "listaSetorDaDispensa", listaSetorDaDispensa);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        SetorDaDispensaDTO setorDaDispensa = new SetorDaDispensaDTO();
        return new ModelAndView("setorDaDispensa/form", "setorDaDispensa", setorDaDispensa);
    }

    @PostMapping(params = "form")
    public ModelAndView save(SetorDaDispensaDTO setorDaDispensa) {
        service.save(setorDaDispensa);
        return new ModelAndView("redirect:/setorDaDispensa");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable long id) {
        SetorDaDispensaDTO setorDaDispensa = service.findById(id);
        return new ModelAndView("setorDaDispensa/form", "setorDaDispensa", setorDaDispensa);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        service.delete(id);
        return new ModelAndView("redirect:/setorDaDispensa");
    }
}
