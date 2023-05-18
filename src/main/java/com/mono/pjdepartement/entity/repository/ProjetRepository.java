package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.app.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long>{
    List<Projet> findByTheme(String theme);
}
