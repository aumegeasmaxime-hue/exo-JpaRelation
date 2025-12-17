package com.exoRelationJPA.exoRelationJpa.service;

import com.exoRelationJPA.exoRelationJpa.model.Classe;
import com.exoRelationJPA.exoRelationJpa.model.Professeur;
import com.exoRelationJPA.exoRelationJpa.repository.ProfesseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService {
    private ProfesseurRepository professeurRepository;

    public ProfesseurService (ProfesseurRepository professeurRepository){
        this.professeurRepository = professeurRepository;
    }
    public List<Professeur> getAllProfesseur() {
        return professeurRepository.findAll();
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
        int count=0;
        Professeur countElevesProfesseur = findProfesseurById(id);
        for (Classe classe : countElevesProfesseur.getClasses()){
            count += classe.getNbEleve();
        }
        return count;
    }
}
