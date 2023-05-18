package com.mono.pjdepartement.service;

import java.util.List;

import com.mono.pjdepartement.entity.app.Stage;
import org.springframework.http.ResponseEntity;

public interface StageService {
    ResponseEntity<String> createStage(Stage stage);
    ResponseEntity<String> updateStage(Stage  stage, Long id);
    List<Stage> getAll();
    Stage getStage(Long id);
    String deleteStage(Long id);
    List<Stage> findByCompetence(String competencesAttendu);
    List<Stage> findByPoste(String Poste);
}
