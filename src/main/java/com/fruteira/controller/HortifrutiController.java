package com.fruteira.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/hortifruti")
public class HortifrutiController {

    @GetMapping(value = "/cadastrar")
    public String cadastrar(){
        return "hortifruti/formCadastroHortifruti";
    }

    @PostMapping(value = "/cadastrar")
    public ModelAndView cadastro(){
        ModelAndView view = new ModelAndView("/hortifruti/hortifruti");
        return view;
    }
}
