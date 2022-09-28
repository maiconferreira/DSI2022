package br.univille.dsi2022.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dsi2022.dto.ProdutoDTO;
import br.univille.dsi2022.service.ProdutoService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProdutoService service;
    
    @GetMapping
    public ModelAndView index() {
        List<ProdutoDTO> listaProdutos = service.getLista();
        return new ModelAndView("home/index", "listaProdutos", listaProdutos);
    }
}
