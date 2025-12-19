package com.exoRelationJPA.exoRelationJpa.service;

import com.exoRelationJPA.exoRelationJpa.model.Classe;
import com.exoRelationJPA.exoRelationJpa.repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {
    private ClasseRepository classeRepository;

    public ClasseService (ClasseRepository classeRepository){
        this.classeRepository = classeRepository;
    }
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }
    public Classe findClasseById(Long id){
        return classeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Classe with id " + id + " not found"));
    }
    public void createNewClasse(Classe classe) {
        classeRepository.save(classe);
    }
    public Classe modifyClasse(Classe classe) {
        return classeRepository.save(classe);
    }
    public void deleteClasse(Long id){
        Classe deleteClasse = findClasseById(id);
        classeRepository.delete(deleteClasse);
    }
    public int nbClasses (){
        return getAllClasses().size();
    }
}
