package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.app.Publication;
import com.mono.pjdepartement.entity.metier.User;
import com.mono.pjdepartement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @DeleteMapping(path = "/delete/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id, Boolean bool){
        return adminService.gestionInscription(id, bool);
    }

    @GetMapping(path = "/read/all/user")
    public List<User> getAllUser(){
        return adminService.getAllUser();
    }

    @PostMapping(path = "/create/pub")
    public ResponseEntity<String> createPublication(@RequestBody Publication pub){
        return adminService.createPub(pub);
    }

    @GetMapping(path = "/read/all/pub")
    public List<Publication> getAllPublication(){
        return adminService.getAllPub();
    }

    @PutMapping(path = "/update/pub/{id}")
    public ResponseEntity<String> updatePublication(@RequestBody Publication pub, @PathVariable Long id){
        return adminService.updatePub(pub, id);
    }

    @DeleteMapping(path = "/delete/pub/{id}")
    public ResponseEntity<String> deletePublication(@PathVariable Long id, Boolean bool){
        return adminService.deletePub(id, bool);
    }

}
