package com.pjdepartement;

import java.util.List;
import java.util.Optional;

import com.pjdepartement.microservice.entity.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.pjdepartement.microservice.entity.repository.ProjetRepository;
import com.pjdepartement.microservice.service.ProjetService;

public class ProjetServiceImplement implements ProjetService{

	
	@Autowired
    ProjetRepository projetRepository;
	@Override
	public ResponseEntity<String> create(Projet projet) {
		try {
            if (projet.getTheme() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer un thème",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (projet.getDescription() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer une description",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            projetRepository.save(projet);
            return new ResponseEntity<>(
                    "Vous avez enregistré un nouveau projet avec succès " + projetRepository.save(projet),
                    HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(
                    "Erreur 500",HttpStatus.INTERNAL_SERVER_ERROR);
        }

	}

	@Override
	public ResponseEntity<String> update(Projet projet, Long id) {
		Optional<Projet> use = projetRepository.findById(id);
        if(use.isEmpty()) {
            return new ResponseEntity<>(
                    "Projet not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        }
        if (projet.getTheme() != null || !use.get().getTheme().equals(projet.getTheme())) {
            use.get().setTheme(projet.getTheme());
        }
        if (projet.getDescription() != null || !use.get().getDescription().equals(projet.getDescription())) {
            use.get().setDescription(projet.getDescription());
        }
        projetRepository.saveAndFlush(use.get());
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
	}

	@Override
	public List<Projet> getAll() {
		// TODO Auto-generated method stub
		return projetRepository.findAll();
	}

	@Override
	public Projet getProjet(Long id) {
		if (projetRepository.findById(id).isPresent())
            return projetRepository.findById(id).get();
        else return null;
	}

	@Override
	public String deleteProjet(Long id) {
		 projetRepository.deleteById(id);
	        return "le projet a été supprimé avec succè";
	}

	@Override
	public List<Projet> findByTheme(String theme) {
		// TODO Auto-generated method stub
		return projetRepository.findByTheme(theme);
	}

}
