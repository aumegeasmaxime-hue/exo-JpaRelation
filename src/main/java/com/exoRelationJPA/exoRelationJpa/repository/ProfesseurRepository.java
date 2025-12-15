package com.exoRelationJPA.exoRelationJpa.repository;

import com.exoRelationJPA.exoRelationJpa.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur,Long> {
}
