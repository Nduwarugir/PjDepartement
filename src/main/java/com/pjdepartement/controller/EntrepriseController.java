package com.pjdepartement.controller;

import com.pjdepartement.entity.Entreprise;
import com.pjdepartement.entity.Etudiant;
import com.pjdepartement.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Entreprise")
public class EntrepriseController {

    @Autowired
    EntrepriseService entrepriseService;

    @PostMapping(path = "/create")
    public ResponseEntity<String> createEntreprise(@RequestBody Entreprise entreprise){
        return entrepriseService.create(entreprise);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateEntreprise(@RequestBody Entreprise entreprise, @PathVariable Long id){
        return entrepriseService.update(entreprise, id);
    }

    @GetMapping(path = "/read")
    public List<Entreprise> readAllEntreprise(){
        return entrepriseService.getAll();
    }
//
//    @GetMapping(path = "/read/{id}")
//    public Entreprise readEntreprise(@PathVariable Long id){
//        return entrepriseService.getEnterprise(id);
//    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEntreprise(@PathVariable Long id){
        return entrepriseService.delete(id);
    }

    @PutMapping(path = "/add/fieul/{id}")
    public ResponseEntity<String> addFieul(@RequestBody Etudiant etudiant, @PathVariable Long id){
        return entrepriseService.addFieul(etudiant, id);
    }


}
