package com.fruteira.controller;

import com.fruteira.model.Cliente;
import com.fruteira.model.Compra;
import com.fruteira.service.ClienteService;
import com.fruteira.service.CompraService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompraController {
    
    @Autowired
    CompraService compraService;   
    
    @Autowired
    ClienteService clienteService;
    
    
    @PostMapping(value = "/compra")
    public String adicionarConta(@RequestParam("id") Integer idCliente, @RequestParam("valor") BigDecimal valor){
        Compra compra = new Compra();
        try{
                Cliente cliente = clienteService.findById(idCliente);  
                cliente.setAumentadivida(valor);
                clienteService.save(cliente);
                
                
                compra.setCliente(cliente);
                compra.setValor(valor);
                compra.setData();                
                compraService.save(compra);
                
                
            
            return "redirect:/clientes";
        
        }catch(Exception e){
            return "redirect:/" + e;
        }
        
    }
    
    @PostMapping(value="/pagar")
    public String pagamento(@RequestParam("id") Integer idCliente, @RequestParam("valor") BigDecimal valor){
        
        try{
            Cliente cliente = clienteService.findById(idCliente);        
            cliente.setDiminuidivida(valor);        
            clienteService.save(cliente);
            return "redirect:/clientes";
        }catch(Exception e){
            return "redirect:/" + e;
        }
    }
        
     @GetMapping(value="detalhesCompras/{id}")
     public ModelAndView detalhesCompras(@PathVariable Integer id){
        
        Cliente cliente = clienteService.findById(id);
        ModelAndView view = new ModelAndView("clientes/detalhesCompras");
        List<Compra> compras = compraService.findAllByCliente(cliente);
        view.addObject("detalhesCompras", compras);    
        return view;
        
    }
    
    
}
