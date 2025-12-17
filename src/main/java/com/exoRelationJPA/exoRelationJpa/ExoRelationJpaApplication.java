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
            professeurRepository.save(new Professeur("Prof1", "max", "max@gmail.com"));
            professeurRepository.save(new Professeur("Prof2", "bob", "bob@gmail.com"));

            Professeur professeur1 = professeurRepository.findById(1L).get();
            Professeur professeur2 = professeurRepository.findById(2L).get();

            classeRepository.save(new Classe("classe1", "bac", "Math", 5, professeur1));
            classeRepository.save(new Classe("classe2", "bac+1", "francais", 2, professeur1));
            classeRepository.save(new Classe("classe3", "bac+2", "anglais", 10, professeur1));
        };
    }

}