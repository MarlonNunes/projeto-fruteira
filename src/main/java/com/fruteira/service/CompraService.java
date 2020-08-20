package com.fruteira.service;

import com.fruteira.model.Cliente;
import com.fruteira.model.Compra;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CompraService {
    
    List<Compra> findAll();    
    Compra findById(Integer id);    
    Compra save(Compra compra);
    List<Compra> findAllByCliente(Cliente cliente);
}
