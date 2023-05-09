package com.pjdepartement.controller;

import com.pjdepartement.entity.Enseignant;
import com.pjdepartement.service.EnseignantService;
import com.pjdepartement.service.implement.EnseignantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Enseignant")
public class EnseignantController {
    
    @Autowired
    EnseignantService enseignantService;


    @PostMapping(path = "/create")
    public ResponseEntity<String> createEnseignant(@RequestBody Enseignant enseignant){
        return enseignantService.create(enseignant);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateEnseignant(@RequestBody Enseignant enseignant, @PathVariable Long id){
        return enseignantService.update(enseignant, id);
    }

    @GetMapping(path = "/read")
    public List<Enseignant> readAllEnseignant(){
        return enseignantService.getAll();
    }
//
//    @GetMapping(path = "/read/{id}")
//    public enseignant readenseignant(@PathVariable Long id){
//        return enseignantService.getEnterprise(id);
//    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteEnseignant(@PathVariable Long id){
        return enseignantService.delete(id);
    }

}
