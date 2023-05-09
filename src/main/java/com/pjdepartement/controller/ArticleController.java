package com.pjdepartement.controller;

import java.util.List;

import com.pjdepartement.service.ArticleService;
import com.pjdepartement.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/Article")
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

    @DeleteMapping(path = "/delete/{id}")
    public String deleteArticle(@PathVariable Long id){
        return articleService.deleteArticle(id);
    }

    @GetMapping(path = "/read")
    public List<Article> readAllArticle(){
        return articleService.getAll();
    }

    @GetMapping("/read/theme/{theme}")
    public List<Article> getArticleBytheme(@PathVariable String theme) {
        return articleService.findByTheme(theme);
    }

    @GetMapping("/read/name/{name}")
    public List<Article> getArticleByAuteur(@PathVariable String name) {
        return articleService.findByNameAuteur(name);
    }
}
