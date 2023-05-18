package com.mono.pjdepartement.entity.repository;

import com.mono.pjdepartement.entity.app.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{
	@Query("select a from Article a where a.theme like %?1%")
	List<Article> findByTheme(String theme);

	@Query("select a from Article a where a.nameAuteur like %?1%")
	List<Article> findByNameAuteur(String nameAuteur);
}
