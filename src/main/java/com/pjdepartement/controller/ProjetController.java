package com.pjdepartement;

import java.util.List;

import com.pjdepartement.microservice.entity.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.pjdepartement.microservice.service.ProjetService;

public class ProjetController {

	@Autowired
    ProjetService projetService;
	
	@PostMapping(path = "/create")
    public ResponseEntity<String> creatProjet(@RequestBody Projet projet){
        return projetService.create(projet);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateProjet(@RequestBody Projet projet, @PathVariable Long id){
        return projetService.update(projet, id);
    }

    @GetMapping(path = "/read")
    public List<Projet> readAllProjet(){
        return projetService.getAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteProjet(@PathVariable Long id){
        return projetService.deleteProjet(id);
    }
    @GetMapping("/theme/{theme}")
    public List<Projet> getProjetBytheme(@PathVariable String theme) {
        return projetService.findByTheme(theme);
    }

}
