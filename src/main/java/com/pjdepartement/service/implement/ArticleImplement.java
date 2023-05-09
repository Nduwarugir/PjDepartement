package com.pjdepartement;

import java.util.List;
import java.util.Optional;

import com.pjdepartement.microservice.entity.Article;
import com.pjdepartement.microservice.entity.repository.ArticleRepository;
import com.pjdepartement.microservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ArticleImplement implements ArticleService {

	@Autowired
	ArticleRepository articleRepository;
	
	@Override
	public ResponseEntity<String> createArticle(Article article) {
		try {
            if (article.getTheme() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer un thème",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (article.getDescription() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer une description",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            articleRepository.save(article);
            return new ResponseEntity<>(
                    "Vous avez enregistré un nouveau article avec succès " + articleRepository.save(article),
                    HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(
                    "Erreur 500",HttpStatus.INTERNAL_SERVER_ERROR);
        }

	}

	@Override
	public ResponseEntity<String> updateArticle(Article article, Long id) {
		Optional<Article> use = articleRepository.findById(id);
        if(use.isEmpty()) {
            return new ResponseEntity<>(
                    "article not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        }
        if (article.getTheme() != null || !use.get().getTheme().equals(article.getTheme())) {
            use.get().setTheme(article.getTheme());
        }
        if (article.getDescription() != null || !use.get().getDescription().equals(article.getDescription())) {
            use.get().setDescription(article.getDescription());
        }
        articleRepository.saveAndFlush(use.get());
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
	}

	@Override
	public List<Article> getAll() {
		return articleRepository.findAll();
	}

	@Override
	public Article getArticle(Long id) {
		if(articleRepository.findById(id).isPresent())
			return articleRepository.findById(id).get();
		else return null;
	}

	@Override
	public String deleteArticle(Long id) {
		articleRepository.deleteById(id);
		return "l'article a été supprimé";
	}

	@Override
	public List<Article> findByTheme(String theme) {
		return articleRepository.findByTheme(theme);
	}

	@Override
	public List<Article> findByNameAuteur(String nameAuteur) {
		return articleRepository.findByNameAuteur(nameAuteur);
	}

}
