package com.mono.pjdepartement.controller;

import java.util.List;

import com.mono.pjdepartement.entity.app.Emploi;
import com.mono.pjdepartement.service.EmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Emploi")
public class EmploiController {

	@Autowired
    EmploiService offreEmploi;
	
	@PostMapping(path = "/create")
    public ResponseEntity<String> createEmploi(@RequestBody Emploi emploi){
        return offreEmploi.createOffreEmploi(emploi);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateEmploi(@RequestBody Emploi emploi, @PathVariable Long id){
        return offreEmploi.updateEmploi(emploi, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEmploi(@PathVariable Long id){
        return offreEmploi.deleteEmploi(id);
    }

    @GetMapping(path = "/read")
    public List<Emploi> readAllEmploi(){
        return offreEmploi.getAll();
    }

    @GetMapping("/read/poste/{poste}")
    public List<Emploi> getEmploiByPoste(@PathVariable String poste) {
        return offreEmploi.findByPoste(poste);
    }
}
