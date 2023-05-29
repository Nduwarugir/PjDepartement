package com.mono.pjdepartement.service.implement;


import com.mono.pjdepartement.entity.metier.User;
import com.mono.pjdepartement.entity.repository.UserRepository;
import com.mono.pjdepartement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        userRepository.deleteById(id);
        return "l'user a été supprimé";
    }

    @Override
    public User getUser(Long id) {
        if (userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<User> findByNom(String nom) {
        return userRepository.findByNom(nom);
    }

    @Override
    public List<User> findByNumTel(Long numTel) {
        return userRepository.findByNumTel(numTel);
    }
}