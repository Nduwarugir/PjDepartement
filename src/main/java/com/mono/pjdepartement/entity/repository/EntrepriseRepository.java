package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.metier.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    List<Entreprise> findByNom(String name);
    List<Entreprise> findByLocation(String location);
    List<Entreprise> findByWebSite(String webSite);
}
