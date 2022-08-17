package br.univille.dsi2022.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.univille.dsi2022.dto.ProdutoDTO;
import br.univille.dsi2022.dto.SetorDaDispensaDTO;
import br.univille.dsi2022.service.ProdutoService;
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

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ModelAndView index() {
        List<SetorDaDispensaDTO> listaSetorDaDispensa = service.getAll();
        return new ModelAndView("setorDaDispensa/index", "listaSetorDaDispensa", listaSetorDaDispensa);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        SetorDaDispensaDTO setorDaDispensa = new SetorDaDispensaDTO();
        List<ProdutoDTO> listaProdutos = produtoService.getAll();
        ProdutoDTO novoProduto = new ProdutoDTO();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("setorDaDispensa", setorDaDispensa);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoProduto", novoProduto);

        return new ModelAndView("setorDaDispensa/form", dados);
    }

    @PostMapping(params = "incitem")
    public ModelAndView incluirProc(@ModelAttribute("setorDaDispensa") SetorDaDispensaDTO setorDaDispensa,
            @ModelAttribute("novoProduto") ProdutoDTO novoProduto) {

        setorDaDispensa.getListaProdutos().add(novoProduto);

        HashMap<String, Object> dados = new HashMap<>();
        List<ProdutoDTO> listaProdutos = produtoService.getAll();
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoProduto", new ProdutoDTO());
        return new ModelAndView("setorDaDispensa/form", dados);
    }

    @PostMapping(params = "removeitem")
    public ModelAndView removerProduto(@ModelAttribute("setorDaDispensa") SetorDaDispensaDTO setorDaDispensa,
            @RequestParam(name = "removeitem") int index) {
        setorDaDispensa.getListaProdutos().remove(index);

        HashMap<String, Object> dados = new HashMap<>();
        List<ProdutoDTO> listaProdutos = produtoService.getAll();
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoProduto", new ProdutoDTO());
        return new ModelAndView("setorDaDispensa/form", dados);
    }

    @PostMapping(params = "save")
    public ModelAndView save(@ModelAttribute("setorDaDispensa") SetorDaDispensaDTO setorDaDispensa) {
        service.save(setorDaDispensa);
        return new ModelAndView("redirect:/setorDaDispensa");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        SetorDaDispensaDTO setorDaDispensa = service.findById(id);
        List<ProdutoDTO> listaProdutos = produtoService.getAll();
        ProdutoDTO novoProduto = new ProdutoDTO();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("setorDaDispensa", setorDaDispensa);
        dados.put("listaProdutos", listaProdutos);
        dados.put("novoProduto", novoProduto);

        return new ModelAndView("setorDaDispensa/form", dados);
    }
}
