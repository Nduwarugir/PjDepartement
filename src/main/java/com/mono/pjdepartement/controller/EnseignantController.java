package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.app.Article;
import com.mono.pjdepartement.entity.app.Projet;
import com.mono.pjdepartement.entity.metier.Enseignant;
import com.mono.pjdepartement.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/Enseignant")
public class EnseignantController {
    
    @Autowired
    EnseignantService enseignantService;

    //Page d'affichage de tous les enseignants
    @GetMapping("/")
    public String home(Model model) {
        List<Enseignant> listEnseignant = enseignantService.getAll();
        model.addAttribute("enseignants", listEnseignant);
        return "accueil";
    }
    @PostMapping(path = "/create")
    public ResponseEntity<String> createEnseignant(@RequestBody Enseignant enseignant){
        return enseignantService.create(enseignant);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateEnseignant(@RequestBody Enseignant enseignant, @PathVariable Long id){
        return enseignantService.update(enseignant, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEnseignant(@PathVariable Long id){
        return enseignantService.delete(id);
    }

    @GetMapping(path = "/read")
    public List<Enseignant> readAllEnseignant(){
        return enseignantService.getAll();
    }

    @GetMapping(path = "/read/{id}")
    public Enseignant readenseignant(@PathVariable Long id){
        return enseignantService.getEnseignant(id);
    }

    @PutMapping(path = "/add/article/{id}")
    public ResponseEntity<String> addArticle(@RequestBody Article article, @PathVariable Long id){
        return enseignantService.addArticle(article, id);
    }

    @GetMapping(path = "/read/articles/{id}")
    public List<Article> readAllArticle(@PathVariable Long id){
        return enseignantService.getAllArticles(id);
    }

    @PutMapping(path = "/add/project/{id}")
    public ResponseEntity<String> addProject(@RequestBody Projet projet, @PathVariable Long id){
        return enseignantService.addProjet(projet, id);
    }

    @GetMapping(path = "/read/project/{id}")
    public List<Projet> readAllProject(@PathVariable Long id){
        return enseignantService.getAllProjects(id);
    }

}
