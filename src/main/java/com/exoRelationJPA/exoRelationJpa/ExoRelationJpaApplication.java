package com.exoRelationJPA.exoRelationJpa;

import com.exoRelationJPA.exoRelationJpa.model.Classe;
import com.exoRelationJPA.exoRelationJpa.model.Professeur;
import com.exoRelationJPA.exoRelationJpa.repository.ClasseRepository;
import com.exoRelationJPA.exoRelationJpa.repository.ProfesseurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExoRelationJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExoRelationJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProfesseurRepository professeurRepository, ClasseRepository classeRepository) {
        return args -> {
            professeurRepository.save(new Professeur("Young", "Angus", "young@gmail.com"));
            professeurRepository.save(new Professeur("Tankian", "Serj", "tankian@gmail.com"));
            professeurRepository.save(new Professeur("Laiho", "Alexi", "laiho@gmail.com"));
            professeurRepository.save(new Professeur("Hendrix", "Jimi", "hendrix@gmail.com"));

            Professeur professeur1 = professeurRepository.findById(1L).get();
            Professeur professeur2 = professeurRepository.findById(2L).get();
            Professeur professeur3 = professeurRepository.findById(3L).get();
            Professeur professeur4 = professeurRepository.findById(4L).get();

            classeRepository.save(new Classe("classe 1 ->", "bac", "math", 5, professeur1));
            classeRepository.save(new Classe("classe 2 ->", "bac+1", "francais", 2, professeur1));
            classeRepository.save(new Classe("classe 3 ->", "bac+2", "anglais", 10, professeur2));
            classeRepository.save(new Classe("classe 4 ->", "bac+3", "sciences", 11, professeur2));
            classeRepository.save(new Classe("classe 5 ->", "bac", "musique", 10, professeur3));
            classeRepository.save(new Classe("classe 6 ->", "bac+2", "sport", 12, professeur3));
            classeRepository.save(new Classe("classe 7 ->", "bac+3", "techno", 20, professeur4));
        };
    }

}