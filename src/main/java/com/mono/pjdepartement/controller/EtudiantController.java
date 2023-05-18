package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.app.Article;
import com.mono.pjdepartement.entity.app.Projet;
import com.mono.pjdepartement.entity.metier.Etudiant;
import com.mono.pjdepartement.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Etudiant")
public class EtudiantController {

	@Autowired
	EtudiantService etudiantService;

	@PostMapping(path = "/create")
	public ResponseEntity<String> createEtudiant(@RequestBody Etudiant etudiant){
		return etudiantService.create(etudiant);
	}

	@PutMapping(path = "/update/{id}")
	public ResponseEntity<String> updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable Long id){
		return etudiantService.update(etudiant, id);
	}

	@DeleteMapping(path = "/delete/{id}")
	public String deleteEtudiant(@PathVariable Long id){
		return etudiantService.delete(id);
	}

	@GetMapping(path = "/read")
	public List<Etudiant> readAllEtudiant(){
		return etudiantService.getAll();
	}

	@GetMapping(path = "/read/id/{id}")
	public Etudiant readEtudiant(@PathVariable Long id){
		return etudiantService.getEtudiant(id);
	}

	@GetMapping("/read/name/{name}")
	public List<Etudiant> getEtudiantByNom(@PathVariable String name) {
		return etudiantService.findByNom(name);
	}

	@GetMapping("/read/surname/{surname}")
	public List<Etudiant> getEtudiantByPrenom(@PathVariable String surname) {
		return etudiantService.findByPrenom(surname);
	}

	@GetMapping("/read/matricule/{mat}")
	public Etudiant getEtudiantByMatricule(@PathVariable String mat) {
		return etudiantService.findByMatricule(mat);
	}

	@GetMapping("/read/xpLang/{xpL}")
	public List<Etudiant> getEtudiantByxpLanguage(@PathVariable String xpL) {
		return etudiantService.findByxpLanguage(xpL);
	}

    @PutMapping(path = "/add/article/{id}")
    public ResponseEntity<String> addArticle(@RequestBody Article article, @PathVariable Long id){
        return etudiantService.addArticle(article, id);
    }

    @GetMapping(path = "/read/articles/{id}")
    public List<Article> readAllArticle(@PathVariable Long id){
        return etudiantService.getAllArticles(id);
    }

    @PutMapping(path = "/add/project/{id}")
    public ResponseEntity<String> addProject(@RequestBody Projet projet, @PathVariable Long id){
        return etudiantService.addProjet(projet, id);
    }

    @GetMapping(path = "/read/project/{id}")
    public List<Projet> readAllProject(@PathVariable Long id){
        return etudiantService.getAllProjects(id);
    }

}
