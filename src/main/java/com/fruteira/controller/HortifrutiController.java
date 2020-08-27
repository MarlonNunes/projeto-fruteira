package com.fruteira.controller;

import com.fruteira.model.Hortifruti;
import com.fruteira.service.HortifrutiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(value = "/ver")
    public ModelAndView hortifrutiWhere(@RequestParam("nome") String nome){
        ModelAndView view = new ModelAndView("hortifruti/hortifruti");
        List<Hortifruti> hortifruti = hortifrutiService.findByNome(nome);
        view.addObject("hortifruti", hortifruti);
        return view;
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

    @GetMapping(value = "/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id){
        try {
            hortifrutiService.deleteById(id);
                return "redirect:/hortifruti/frutas";
        }catch(Exception e){
            return "redirect:/";
        }
    }

    @PostMapping(value = "/atualizar")
    public String atualizar(@Valid Hortifruti hortifruti){
        try {
            hortifrutiService.save(hortifruti);
            return "redirect:/hortifruti" + hortifruti.getTipo() + "s";
        }catch (Exception e){
            return "redirect:/";
        }
    }
}
