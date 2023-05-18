package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.metier.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
}
