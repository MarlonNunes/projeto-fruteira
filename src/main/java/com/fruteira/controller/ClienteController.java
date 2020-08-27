package com.fruteira.controller;

import com.fruteira.model.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.fruteira.service.ClienteService;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "clientes")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping(value = "/ver")
    public ModelAndView getClientes(){
        ModelAndView mv = new ModelAndView("clientes/clientes");
        List<Cliente> clientes = clienteService.findAll();
        mv.addObject("clientes", clientes);
        return mv;
    
    }
    
    @PostMapping(value="/ver")
    public ModelAndView getClientesWhere(@RequestParam("nome") String nome){
        ModelAndView mv = new ModelAndView("clientes/clientes");
        List<Cliente> clientes = clienteService.findByNomeContainingIgnoreCase(nome);
        mv.addObject("clientes", clientes);
        return mv;
    
    }
    
   @GetMapping(value = "/cadastrar")
   public String getFormCadastroCliente(){
       return "clientes/FormCadastroCliente";
   
   }
   
   @PostMapping(value = "/cadastrar")
   public String saveCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes){
       if(result.hasErrors()){
           return "redirect:/clientes/cadastrar";
       }
       
       clienteService.save(cliente);
       return "redirect:/clientes/ver";
   
   }
   
   
   @GetMapping(value="/excluircliente/{id}")
    public String excluirAluno(@PathVariable Integer id, RedirectAttributes atributo){
        try{
            clienteService.deleteById(id);
            return "redirect:/clientes/ver";
        }catch(Exception e){
            return "redirect:/home/";
        }        
       
        }
    
   @GetMapping(value="/editar/{id}")
   public ModelAndView editarCliente(@PathVariable Integer id){
       ModelAndView view = new ModelAndView("clientes/formCadastroCliente");
       Cliente cliente = clienteService.findById(id);
       view.addObject("teste", cliente);
       return view;
   }

    
    
}