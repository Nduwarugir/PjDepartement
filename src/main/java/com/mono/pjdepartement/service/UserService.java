package com.mono.pjdepartement.service;

import com.mono.pjdepartement.entity.metier.User;

import java.util.List;

public interface UserService {
	List<User> getAll();
	User getUser(Long id);
	String delete(Long id);
	List<User> findByNom(String nom);
	List<User> findByNumTel(Long numTel);
}
