package com.exoRelationJPA.exoRelationJpa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nom;
    private String prenom;
    private String email;


    @OneToMany(mappedBy = "professeur", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Classe> classe = new ArrayList<>();

    public Professeur() {
    }

    public Professeur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Classe> getClasse() {
        return classe;
    }

    public void setClasse(List<Classe> classe) {
        this.classe = classe;
    }
}
