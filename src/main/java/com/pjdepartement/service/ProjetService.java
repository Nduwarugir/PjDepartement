package com.pjdepartement.service;

import java.util.List;

import com.pjdepartement.entity.Projet;
import org.springframework.http.ResponseEntity;

public interface ProjetService {
	    ResponseEntity<String> create(Projet projet);
	    ResponseEntity<String> update(Projet projet, Long id);
	    List<Projet> getAll();
	    Projet getProjet(Long id);
	    String deleteProjet(Long id);
	    List<Projet> findByTheme(String theme);
}
