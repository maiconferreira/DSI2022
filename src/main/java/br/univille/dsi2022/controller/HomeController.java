package br.univille.dsi2022.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping()
    public ModelAndView index(){
        String nome = "zezinho";
        String sobrenome = "da Silva";
        HashMap<String,String> mapa_da_dados = new HashMap<>();
        mapa_da_dados.put("nomenatela", nome);
        mapa_da_dados.put("sobrenomenatela", sobrenome);
        return new ModelAndView("home/index", mapa_da_dados);
    }
}
