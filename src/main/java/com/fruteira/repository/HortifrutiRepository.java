package com.fruteira.repository;

import com.fruteira.model.Hortifruti;
import com.fruteira.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HortifrutiRepository extends JpaRepository<Hortifruti, Integer> {

    List<Hortifruti> findByTipoContainingIgnoreCase(String tipo);
    List<Hortifruti> findByNomeContainingIgnoreCase(String nome);
}