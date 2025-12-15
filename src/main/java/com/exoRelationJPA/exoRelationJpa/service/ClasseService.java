package com.exoRelationJPA.exoRelationJpa.service;

import com.exoRelationJPA.exoRelationJpa.repository.ClasseRepository;
import org.springframework.stereotype.Service;

@Service
public class ClasseService {
    private ClasseRepository classeRepository;

    public ClasseService (ClasseRepository classeRepository){
        this.classeRepository = classeRepository;
    }
}
