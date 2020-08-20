package com.fruteira.repository;

import com.fruteira.model.Cliente;
import com.fruteira.model.Compra;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
    
    List<Compra> findAllByCliente (Cliente cliente);
    
}
