package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.metier.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	List<Etudiant> findByNom(String nom);
	List<Etudiant> findByPrenom(String prenom);
	Etudiant findByMatricule(String matricule);
	List<Etudiant> findByCompetence(String xp);
}
