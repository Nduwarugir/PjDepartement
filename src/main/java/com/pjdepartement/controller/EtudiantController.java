package com.pjdepartement.controller;

import java.util.List;

import com.pjdepartement.entity.Etudiant;
import com.pjdepartement.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

}
