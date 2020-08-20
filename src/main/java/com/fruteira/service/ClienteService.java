package com.fruteira.service;

import com.fruteira.model.Cliente;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {
    
    List<Cliente> findAll();
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    Cliente findById(Integer id);    
    Cliente save(Cliente cliente);
    void deleteById(Integer id);   
   
}
