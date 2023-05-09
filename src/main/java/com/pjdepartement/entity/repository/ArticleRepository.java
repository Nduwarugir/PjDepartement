package com.pjdepartement;

import java.util.List;

import com.pjdepartement.microservice.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>{
 
	List<Article> findByTheme(String theme);	
	List<Article> findByNameAuteur(String nameAuteur);
}
