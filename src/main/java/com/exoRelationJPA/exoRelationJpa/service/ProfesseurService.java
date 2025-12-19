package com.exoRelationJPA.exoRelationJpa.service;

import com.exoRelationJPA.exoRelationJpa.model.Classe;
import com.exoRelationJPA.exoRelationJpa.model.Professeur;
import com.exoRelationJPA.exoRelationJpa.repository.ProfesseurRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService {
    int count;
    private ProfesseurRepository professeurRepository;

    public ProfesseurService (ProfesseurRepository professeurRepository){
        this.professeurRepository = professeurRepository;
    }
    public List<Professeur> getAllProfesseur() {
        Sort sort = Sort.by("nom").ascending();
        return professeurRepository.findAll(sort);
    }
    public Professeur findProfesseurById(Long id){
        return professeurRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Professeur with id " + id + " not found"));
    }
    public void createNewProfesseur(Professeur professeur) {
        professeurRepository.save(professeur);
    }
    public Professeur modifyProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }
    public void deleteProfesseur(Long id){
        Professeur deleteProfesseur = findProfesseurById(id);
        professeurRepository.delete(deleteProfesseur);
    }
    public int countClasses(Long id){
        Professeur countProfesseur = findProfesseurById(id);
        return countProfesseur.getClasses().size();
        }
    public int countEleves(Long id){
        this.count=0;
        Professeur countElevesProfesseur = findProfesseurById(id);
        for (Classe classe : countElevesProfesseur.getClasses()){
            count += classe.getNbEleve();
        }
        return count;
    }
    public int averageEleveProf (long id){
        this.count=0;
        int i = 0;
        Professeur averageEleveProf = findProfesseurById(id);
        for (Classe classe : averageEleveProf.getClasses()){
            count+= classe.getNbEleve();
            i++;

        }
        return count/i;
    }
}
