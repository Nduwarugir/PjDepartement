package com.mono.pjdepartement.entity.repository;

import java.util.List;

import com.mono.pjdepartement.entity.app.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long>{
	@Query("select s from Stage s where s.competencesAttendues like %?1%")
	 List<Stage> findByCompetencesAttendues(String competencesAttendu);

	@Query("select s from Stage s where s.poste like %?1%")
	 List<Stage> findByPoste(String Poste);
}
