package com.pjdepartement;

import java.util.List;

import com.pjdepartement.microservice.entity.Article;
import org.springframework.http.ResponseEntity;

public interface ArticleService {

	    ResponseEntity<String> createArticle(Article article);
	    ResponseEntity<String> updateArticle(Article article, Long id);
	    List<Article> getAll();
	    Article getArticle(Long id);
	    String deleteArticle(Long id);
	    List<Article> findByTheme(String theme);
	    List<Article> findByNameAuteur(String nameAuteur);
}
