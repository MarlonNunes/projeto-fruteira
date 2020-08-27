package com.fruteira.service.serviceImpl;

import com.fruteira.model.Hortifruti;
import com.fruteira.repository.HortifrutiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fruteira.service.HortifrutiService;

@Service
public class HortifrutiServiceImpl implements HortifrutiService {

    @Autowired
    HortifrutiRepository hortifrutiRepository;
    
    @Override
    public List<Hortifruti> findAll() {
        return hortifrutiRepository.findAll();
    }

    @Override
    public List<Hortifruti> findByTipoContainingIgnoreCase(String tipo) {
        return hortifrutiRepository.findByTipoContainingIgnoreCase(tipo);
    }

    @Override
    public Hortifruti findById(Integer id) {
        return hortifrutiRepository.findById(id).get();
    }

    @Override
    public Hortifruti save(Hortifruti hortifruti) {
        return hortifrutiRepository.save(hortifruti);
    }

    @Override
    public void deleteById(Integer id) {
        hortifrutiRepository.deleteById(id);
    }

    @Override
    public List<Hortifruti> findByNome(String nome) {
        return hortifrutiRepository.findByNomeContainingIgnoreCase(nome);
    }

}
