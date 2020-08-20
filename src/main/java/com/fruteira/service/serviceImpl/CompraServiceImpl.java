package com.fruteira.service.serviceImpl;

import com.fruteira.model.Cliente;
import com.fruteira.model.Compra;
import com.fruteira.repository.CompraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fruteira.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService{

    @Autowired
    CompraRepository compraRepository;
    
    @Override
    public List<Compra> findAll() {
       return compraRepository.findAll();
    }

    @Override
    public Compra findById(Integer id) {
        return compraRepository.findById(id).get();
    }

    @Override
    public Compra save(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public List<Compra> findAllByCliente(Cliente cliente) {
        return compraRepository.findAllByCliente(cliente);
    }
    
}
