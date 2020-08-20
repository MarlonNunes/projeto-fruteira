package com.fruteira.repository;
import com.fruteira.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    
}
