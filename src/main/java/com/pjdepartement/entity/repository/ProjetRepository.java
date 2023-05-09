package com.pjdepartement.entity.repository;

import java.util.List;

import com.pjdepartement.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Long>{
    List<Projet> findByTheme(String theme);
}
