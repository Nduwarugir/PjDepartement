package com.mono.pjdepartement.entity.repository;

import java.util.List;

import com.mono.pjdepartement.entity.app.Emploi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreEmploieRepository extends JpaRepository<Emploi, Long>{

	List<Emploi> findByPoste(String poste);
	Emploi findByDomaineRequis(String domaineRequis);
}
