package com.fruteira.repository;

import com.fruteira.model.Hortifruti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HortifrutiRepository extends JpaRepository<Hortifruti, Integer> {
    
}
