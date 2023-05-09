package com.pjdepartement;

import java.util.List;

import com.pjdepartement.microservice.entity.Etudiant;
import org.springframework.http.ResponseEntity;

public interface EtudiantService {

	    ResponseEntity<String> create(Etudiant etudiant);
	    ResponseEntity<String> update(Etudiant etudiant, Long id);
	    List<Etudiant> getAll();
	    Etudiant getEtudiant(Long id);
	    String delete(Long id);
		List<Etudiant> findByNom(String nom);
		Etudiant findByMatricule(String matricule);
		List<Etudiant> findByxpLanguage(String xpLanguage);
}
