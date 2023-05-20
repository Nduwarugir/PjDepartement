package com.mono.pjdepartement.controller;

import com.mono.pjdepartement.entity.metier.User;
import com.mono.pjdepartement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/User")
public class UserController {

	@Autowired
	UserService userService;

	@DeleteMapping(path = "/delete/{id}")
	public String deleteEtudiant(@PathVariable Long id){
		return userService.delete(id);
	}

	@GetMapping(path = "/read")
	public List<User> readAllUser(){
		return userService.getAll();
	}

	@GetMapping(path = "/read/id/{id}")
	public User readUser(@PathVariable Long id){
		return userService.getUser(id);
	}

	@GetMapping("/read/name/{name}")
	public List<User> getEtudiantByNom(@PathVariable String name) {
		return userService.findByNom(name);
	}

	@GetMapping("/read/numtel/{numTel}")
	public List<User> getUserByNumTel(@PathVariable Long numTel) {
		return userService.findByNumTel(numTel);
	}

}
