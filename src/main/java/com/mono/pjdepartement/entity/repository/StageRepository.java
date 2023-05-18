package com.mono.pjdepartement.entity.repository;

import java.util.List;

import com.mono.pjdepartement.entity.app.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long>{
	 List<Stage> findByCompetencesAttendues(String competencesAttendu);
	 List<Stage> findByPoste(String Poste);
}
