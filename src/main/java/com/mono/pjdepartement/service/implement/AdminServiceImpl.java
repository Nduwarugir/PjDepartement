package com.mono.pjdepartement.service.implement;

import com.mono.pjdepartement.entity.app.Publication;
import com.mono.pjdepartement.entity.metier.User;
import com.mono.pjdepartement.service.AdminService;
import com.mono.pjdepartement.service.PublicationService;
import com.mono.pjdepartement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserService userService;

    @Autowired
    PublicationService publicationService;

    @Override
    public ResponseEntity<String> gestionInscription(Long id, Boolean bool) {
        try {
            User user = userService.getUser(id);
            if (!bool) {
                userService.delete(id);
                return new ResponseEntity<>(
                        "User supprimé: " + user,
                        HttpStatus.OK);
            } else return new ResponseEntity<>(
                    "User conservé: " + user,
                    HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public ResponseEntity<String> createPub(Publication pub) {
        return publicationService.create(pub);
    }

    @Override
    public List<User> getAllUser() {
        return userService.getAll();
    }

    @Override
    public List<Publication> getAllPub() {
        return publicationService.getAll();
    }

    @Override
    public ResponseEntity<String> updatePub(Publication pub, Long id) {
        return publicationService.update(pub, id);
    }

    @Override
    public ResponseEntity<String> deletePub(Long id, Boolean bool) {
        try {
            Publication pub = publicationService.getPub(id);
            if (!bool) {
                publicationService.delete(id);
                return new ResponseEntity<>(
                        "Publication supprimée: " + pub,
                        HttpStatus.OK);
            } else return new ResponseEntity<>(
                    "Publication conservée: " + pub,
                    HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
