package com.mono.pjdepartement.service;

import java.util.List;

import com.mono.pjdepartement.entity.app.Emploi;
import org.springframework.http.ResponseEntity;

public interface EmploiService {

	    ResponseEntity<String> createOffreEmploi(Emploi emploie);
	    ResponseEntity<String> updateEmploi(Emploi emploie, Long id);
	    List<Emploi> getAll();
	    Emploi getEmploi(Long id);
	    String deleteEmploi(Long id);
		List<Emploi> findByPoste(String poste);
		Emploi findByDomainRequis(String domaineRequis);
}
