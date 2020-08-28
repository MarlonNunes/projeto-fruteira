package com.fruteira.controller;

import com.fruteira.model.Produto;
import com.fruteira.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping(value = "/cadastrar")
    public String cadastrar(){
        return "produtos/formCadastroProduto";
    }

    @PostMapping(value = "/cadastrar")
    public String cadastrarProduto(@Valid Produto produto){
        try{
            produtoService.save(produto);

            //redirecionamento
            if(produto.getTipo().equalsIgnoreCase("limpeza"))
                return "redirect:/produtos/limpeza";
            else if(produto.getTipo().equalsIgnoreCase("seco"))
                return "redirect:/produtos/secos";
            else if(produto.getTipo().equalsIgnoreCase("miudo"))
                return "redirect:/produtos/miudos";
            else
                return "redirect:/";

        }catch (Exception e){
            return "redirect:/ " + e;
        }
    }

    @PostMapping(value= "/ver")
    public ModelAndView produtoWhere(@RequestParam("nome") String nome){
        ModelAndView view = new ModelAndView("produtos/produtos");
        List<Produto> produto = produtoService.findByNome(nome);
        view.addObject("produtos", produto);
        return view;
    }

    @GetMapping(value = "/limpeza")
    public ModelAndView limpeza(){
        ModelAndView view = new ModelAndView("produtos/produtos");

        List<Produto> produtos = produtoService.findByTipoContainingIgnoreCase("limpeza");

        view.addObject("produtos", produtos);
        view.addObject("mensagem", "limpeza");

        return view;
    }

    @GetMapping(value = "/secos")
    public ModelAndView secos(){
        ModelAndView view = new ModelAndView("produtos/produtos");

        List<Produto> produtos = produtoService.findByTipoContainingIgnoreCase("seco");

        view.addObject("produtos", produtos);
        view.addObject("mensagem", "secos");

        return view;
    }

    @GetMapping(value = "/miudos")
    public ModelAndView miudos(){
        ModelAndView view = new ModelAndView("produtos/produtos");

        List<Produto> produtos = produtoService.findByTipoContainingIgnoreCase("miudo");

        view.addObject("produtos", produtos);
        view.addObject("mensagem", "miudos");

        return view;
    }

    @GetMapping(value = "/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id){
        try{
            produtoService.deleteById(id);
            return "redirect:/produtos/limpeza";
        }catch (Exception e) {
            return "redirect:/index";
        }
    }

    @PostMapping(value = "/atualizar")
    public String atualizar(@Valid Produto produto){
        try {
            if (produtoService.findById(produto.getId()) != null) {
                produtoService.save(produto);
            }
            return "redirect:/produtos/" + produto.getTipo() + "s";
        }catch (Exception e){
            return "redirect:/index";
        }
    }

}
