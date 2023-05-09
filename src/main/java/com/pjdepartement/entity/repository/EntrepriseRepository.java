package com.pjdepartement.entity.repository;

import com.pjdepartement.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    List<Entreprise> findByNom(String name);
}
