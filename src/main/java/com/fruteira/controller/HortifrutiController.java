package com.fruteira.controller;

import com.fruteira.model.Hortifruti;
import com.fruteira.service.HortifrutiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/hortifruti")
public class HortifrutiController {

    @Autowired
    HortifrutiService hortifrutiService;

    @GetMapping(value = "/cadastrar")
    public String cadastrar(){
        return "hortifruti/formCadastroHortifruti";
    }

    @PostMapping(value = "/cadastrar")
    public String cadastro(@Valid Hortifruti hortifruti){
        try{
            hortifrutiService.save(hortifruti);

            if(hortifruti.getTipo().equalsIgnoreCase("fruta"))
                return "redirect:/hortifruti/frutas";
            else if(hortifruti.getTipo().equalsIgnoreCase("legume"))
                return "redirect:/hortifruti/legumes";
            else if(hortifruti.getTipo().equalsIgnoreCase("verdura"))
                return "redirect:/hortifruti/verduras";
            else
                return "redirect:/hortifruti/cadastrar";
        }catch (Exception e){
            return "redirect:/index";
        }
    }

    @GetMapping(value = "/frutas")
    public ModelAndView frutas(){
        ModelAndView view = new ModelAndView("hortifruti/hortifruti");
        List<Hortifruti> hortifruti = hortifrutiService.findByTipoContainingIgnoreCase("fruta");
        view.addObject("hortifruti",hortifruti);
        view.addObject("mensagem", "Frutas");
        return view;
    }

    @GetMapping(value = "/legumes")
    public ModelAndView legumes(){
        ModelAndView view = new ModelAndView("hortifruti/hortifruti");
        List<Hortifruti> hortifruti = hortifrutiService.findByTipoContainingIgnoreCase("legume");
        view.addObject("hortifruti",hortifruti);
        view.addObject("mensagem", "Legumes");
        return view;
    }

    @GetMapping(value = "/verduras")
    public ModelAndView verduras(){
        ModelAndView view = new ModelAndView("hortifruti/hortifruti");
        List<Hortifruti> hortifruti = hortifrutiService.findByTipoContainingIgnoreCase("verdura");
        view.addObject("hortifruti",hortifruti);
        view.addObject("mensagem", "Verduras");
        return view;
    }
}
