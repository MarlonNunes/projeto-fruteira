package com.fruteira.service.serviceImpl;

import com.fruteira.model.Produto;
import com.fruteira.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fruteira.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;
    
    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> findByTipoContainingIgnoreCase(String tipo) {
        return produtoRepository.findByTipoContainingIgnoreCase(tipo);
    }

    @Override
    public Produto findById(Integer id) {
        return produtoRepository.findById(id).get();
    }

    @Override
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }
    
}
