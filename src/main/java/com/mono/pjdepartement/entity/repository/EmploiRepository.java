package com.mono.pjdepartement.entity.repository;

import java.util.List;

import com.mono.pjdepartement.entity.app.Emploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmploiRepository extends JpaRepository<Emploi, Long>{
	@Query("select e from Emploi e where e.poste like %?1%")
	List<Emploi> findByPoste(String poste);

	@Query("select e from Emploi e where e.domaineRequis like %?1%")
	Emploi findByDomaineRequis(String domaineRequis);
}
