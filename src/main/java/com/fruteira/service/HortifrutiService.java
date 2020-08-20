package com.fruteira.service;

import com.fruteira.model.Hortifruti;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface HortifrutiService {
    
    List<Hortifruti> findAll();    
    Hortifruti findById(Integer id);    
    Hortifruti save(Hortifruti hortifruti);
    
}
