package com.fruteira.controller;

import com.fruteira.model.Produto;
import com.fruteira.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping(value = "/cadastrar")
    public String cadastroProduto(){
        return "Produtos/formCadastroProduto";
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
}
