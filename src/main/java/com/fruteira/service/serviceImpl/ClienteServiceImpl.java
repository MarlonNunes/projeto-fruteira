package com.fruteira.service.serviceImpl;

import com.fruteira.model.Cliente;
import com.fruteira.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fruteira.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    ClienteRepository clienteRepository;
    
    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findByNomeContainingIgnoreCase(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public void deleteById(Integer id) {
         clienteRepository.deleteById(id);
    }
    
}
