package com.pjdepartement;

import java.util.List;

import com.pjdepartement.microservice.entity.Etudiant;
import com.pjdepartement.microservice.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


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

	    @GetMapping(path = "/read")
	    public List<Etudiant> readAllEtudiant(){
	        return etudiantService.getAll();
	    }

	    @DeleteMapping(path = "/delete/{id}")
	    public String deleteEtudiant(@PathVariable Long id){
	        return etudiantService.delete(id);
	    }
	    @GetMapping("/nom/{nom}")
	    public List<Etudiant> getStudentByNom(@PathVariable String nom) {
	        return etudiantService.findByNom(nom);
	    }

}
