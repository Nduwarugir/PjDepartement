package com.mono.pjdepartement.service;

import com.mono.pjdepartement.entity.app.Article;
import com.mono.pjdepartement.entity.app.Projet;
import com.mono.pjdepartement.entity.metier.Enseignant;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EnseignantService {
    ResponseEntity<String> create(Enseignant enseignant);
    ResponseEntity<String> update(Enseignant enseignant, Long id);
    Enseignant getEnseignant(Long id);
    List<Enseignant> getAll();
    String delete(Long id);
    ResponseEntity<String> addArticle(Article article, Long id);
    List<Article> getAllArticles(Long id);
    ResponseEntity<String> addProjet(Projet projet, Long id);
    List<Projet> getAllProjects(Long id);
}
