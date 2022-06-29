package br.univille.dsi2022.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dsi2022.dto.ProdutoDTO;
import br.univille.dsi2022.dto.SetorDaDispensaDTO;
import br.univille.dsi2022.service.SetorDaDispensaService;

/*
 * 
 * https://github.com/waltercoan/ProjetoSpring
 * 
 */


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
        var novoProduto = new ProdutoDTO();
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("setorDaDispensa", setorDaDispensa);
        dados.put("novoProduto", novoProduto);


        return new ModelAndView("setorDaDispensa/form", dados);
    }

    @PostMapping(params= {"save"})
    public ModelAndView save(SetorDaDispensaDTO setorDaDispensa, ProdutoDTO novoProduto) {
        service.save(setorDaDispensa);
        return new ModelAndView("redirect:/setorDaDispensa");
    }
    @PostMapping(params= {"insertprod"})
    public ModelAndView saveProduto(SetorDaDispensaDTO setorDaDispensa, ProdutoDTO novoProduto) {
        setorDaDispensa.getProduto().add(novoProduto);
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("setorDaDispensa", setorDaDispensa);
        dados.put("novoProduto", new ProdutoDTO());

        return new ModelAndView("setorDaDispensa/form", dados);

    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable long id) {
        HashMap<String,Object> dados = new HashMap<>();
        SetorDaDispensaDTO setorDaDispensa = service.findById(id);
        dados.put("setorDaDispensa", setorDaDispensa);
        dados.put("novoProduto", new ProdutoDTO());
        return new ModelAndView("setorDaDispensa/form", dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        service.delete(id);
        return new ModelAndView("redirect:/setorDaDispensa");
    }
}
