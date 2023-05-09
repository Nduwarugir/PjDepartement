package com.pjdepartement.service;

import com.pjdepartement.entity.Entreprise;
import com.pjdepartement.entity.Etudiant;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface EntrepriseService {

    ResponseEntity<String> create(Entreprise entreprise);
    ResponseEntity<String> update(Entreprise entreprise, Long id);
    Entreprise getEnterprise(Long id);
    List<Entreprise> getAll();
    String delete(Long id);
    ResponseEntity<String> addFieul(Etudiant etudiant, Long id);

}
