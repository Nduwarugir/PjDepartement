package com.pjdepartement;

import java.util.List;

import com.pjdepartement.microservice.service.ArticleService;
import com.pjdepartement.microservice.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ArticleController {

	@Autowired
    ArticleService articleService;
	
	@PostMapping(path = "/create")
    public ResponseEntity<String> creatArticle(@RequestBody Article article){
        return articleService.createArticle(article);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateArticle(@RequestBody Article article, @PathVariable Long id){
        return articleService.updateArticle(article, id);
    }

    @GetMapping(path = "/read")
    public List<Article> readAllArticle(){
        return articleService.getAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteArticle(@PathVariable Long id){
        return articleService.deleteArticle(id);
    }

    @GetMapping("/theme/{theme}")
    public List<Article> getArticleBytheme(@PathVariable String theme) {
        return articleService.findByTheme(theme);
    }

    @GetMapping("/nameAuteur/{nom}")
    public List<Article> getArticleByAuteur(@PathVariable String nom) {
        return articleService.findByNameAuteur(nom);
    }
}
