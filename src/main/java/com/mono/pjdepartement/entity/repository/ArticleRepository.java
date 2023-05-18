package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.app.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
	List<Article> findByTheme(String theme);
	List<Article> findByNameAuteur(String nameAuteur);
}
