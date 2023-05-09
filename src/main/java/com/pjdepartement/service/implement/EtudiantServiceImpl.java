package com.pjdepartement;

import java.util.List;
import java.util.Optional;

import com.pjdepartement.microservice.entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.pjdepartement.microservice.entity.repository.EtudiantRepository;
import com.pjdepartement.microservice.service.EtudiantService;

public class EtudiantServiceImpl implements EtudiantService{

	@Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public ResponseEntity<String> create(Etudiant etudiant) {
        try {
            if (etudiant.getNom() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer Votre nom",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (etudiant.getPrenom() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer Votre Prénom",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            else if (etudiant.getMatricule() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer votre matricule",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
          else if (etudiant.getNiveau() == null) {
                return new ResponseEntity<>(
                        "Vous devez entrer votre niveau",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            }
            etudiantRepository.save(etudiant);
            return new ResponseEntity<>(
                    "Vous avez été enregistré avec succès " + etudiantRepository.save(etudiant),
                    HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(
                    "Erreur 500",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @Override
    public ResponseEntity<String> update(Etudiant etudiant, Long id) {
        Optional<Etudiant> use = etudiantRepository.findById(id);
        if(use.isEmpty()) {
            return new ResponseEntity<>(
                    "Student not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        }
        if (etudiant.getNom() != null || !use.get().getNom().equals(etudiant.getNom())) {
            use.get().setNom(etudiant.getNom());
        }
        if (etudiant.getPrenom() != null || !use.get().getPrenom().equals(etudiant.getPrenom())) {
            use.get().setPrenom(etudiant.getPrenom());
        }
        if (etudiant.getMatricule() != null || !use.get().getMatricule().equals(etudiant.getMatricule())) {
            use.get().setMatricule(etudiant.getMatricule());
        }
        if (etudiant.getNiveau() != null || !use.get().getNiveau().equals(etudiant.getNiveau())) {
            use.get().setNiveau(etudiant.getMatricule());
        }
        if (etudiant.getPhoto() != null || !use.get().getPhoto().equals(etudiant.getPhoto())) {
            use.get().setPhoto(etudiant.getPhoto());
        }
        if (etudiant.getPassword() != null || !use.get().getPassword().equals(etudiant.getPassword())) {
            use.get().setPassword(etudiant.getPassword());
        }
        etudiantRepository.save(etudiant);
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
    }


    @Override
    public List<Etudiant> getAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiant(Long id) {
        if (etudiantRepository.findById(id).isPresent())
            return etudiantRepository.findById(id).get();
        else return null;
    }
    @Override
    public String delete(Long id) {
        etudiantRepository.deleteById(id);
        return "l'etudiant a été supprimé";
    }
	@Override
	public List<Etudiant> findByNom(String nom) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByNom(nom);
	}
	@Override
	public Etudiant findByMatricule(String matricule) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByMatricule(matricule);
	}
	@Override
	public List<Etudiant> findByxpLanguage(String xpLanguage) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByxpLanguage(xpLanguage);
	}
}
