package com.fruteira.repository;
import com.fruteira.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByTipoContainingIgnoreCase(String tipo);
    List<Produto> findByNomeContainingIgnoreCase(String tipo);


}
