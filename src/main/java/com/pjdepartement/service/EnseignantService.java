package com.pjdepartement.service;

import com.pjdepartement.entity.Enseignant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EnseignantService {

    ResponseEntity<String> create(Enseignant enseignant);
    ResponseEntity<String> update(Enseignant enseignant, Long id);
    Enseignant getEnseignant(Long id);
    List<Enseignant> getAll();
    String delete(Long id);
}
