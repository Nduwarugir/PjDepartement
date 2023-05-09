package com.pjdepartement;

import java.util.List;

import com.pjdepartement.microservice.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	List<Etudiant> findByNom(String nom);
	Etudiant findByMatricule(String matricule);
	List<Etudiant> findByxpLanguage(String xpLanguage);
}
