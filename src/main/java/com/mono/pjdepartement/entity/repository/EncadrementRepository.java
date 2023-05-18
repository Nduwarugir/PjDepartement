package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.metier.Encadrement;
import com.mono.pjdepartement.entity.metier.Enseignant;
import com.mono.pjdepartement.entity.metier.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EncadrementRepository extends JpaRepository<Encadrement, Long>{

	List<Encadrement> findByEnseignant(Enseignant enseignant);

	List<Encadrement> findByEtudiant(Etudiant etudiant);

}
