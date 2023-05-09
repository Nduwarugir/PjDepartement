package com.pjdepartement.entity.repository;

import java.util.List;

import com.pjdepartement.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	List<Etudiant> findByNom(String nom);
	List<Etudiant> findByPrenom(String prenom);
	Etudiant findByMatricule(String matricule);
	List<Etudiant> findByxpLanguage(String xpLanguage);
}
