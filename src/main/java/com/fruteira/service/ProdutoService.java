package com.fruteira.service;

import com.fruteira.model.Produto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ProdutoService {
    
    List<Produto> findAll();
    List<Produto> findByTipoContainingIgnoreCase(String tipo);
    Produto findById(Integer id);    
    Produto save(Produto produto);

    
}
