package com.pjdepartement.service.implement;


import com.pjdepartement.entity.Entreprise;
import com.pjdepartement.entity.Etudiant;
import com.pjdepartement.entity.repository.EntrepriseRepository;
import com.pjdepartement.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {


    @Autowired
    EntrepriseRepository entrepriseRepository;

    @Override
    public ResponseEntity<String> create(Entreprise entreprise) {
        try {
            if (entreprise.getNom() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre nom",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            if (entreprise.getContributeNumber() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre numéro de contribualble",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            if (entreprise.getLocation() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre Localisation",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            if (entreprise.getNumWhatsApp() == 0L)
                return new ResponseEntity<>(
                        "Vous devez entrer votre numero de telephone",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            if (entreprise.getMail() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre mail",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            if (entreprise.getPassword() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre mot de passe",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            if (entreprise.getPhoto() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre photo",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
            Entreprise etmp = entrepriseRepository.save(entreprise);
            return new ResponseEntity<>(
                    "Enregistrement reussi" + etmp,
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "500 Error",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> update(Entreprise entreprise, Long idE) {
        Optional<Entreprise> uses = entrepriseRepository.findById(idE);
        if (uses.isEmpty())
            return new ResponseEntity<>(
                    "Enterprise not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

        if (entreprise.getNom() != null || !uses.get().getNom().equals(entreprise.getNom()))
            uses.get().setNom(entreprise.getNom());

        if (entreprise.getContributeNumber() != null || !uses.get().getContributeNumber().equals(entreprise.getContributeNumber()))
            uses.get().setContributeNumber(entreprise.getContributeNumber());

        if (entreprise.getLocation() != null || !uses.get().getLocation().equals(entreprise.getLocation()))
            uses.get().setLocation(entreprise.getLocation());

        if (entreprise.getNumWhatsApp() != 0L || !(uses.get().getNumWhatsApp()==entreprise.getNumWhatsApp()))
            uses.get().setNumWhatsApp(entreprise.getNumWhatsApp());

        if (entreprise.getMail() != null || !uses.get().getMail().equals(entreprise.getMail()))
            uses.get().setMail(entreprise.getMail());

        if (entreprise.getPassword() != null || !uses.get().getPassword().equals(entreprise.getPassword()))
            uses.get().setPassword(entreprise.getPassword());

        if (entreprise.getPhoto() != null || !uses.get().getPhoto().equals(entreprise.getPhoto()))
            uses.get().setPhoto(entreprise.getPhoto());

        entrepriseRepository.save(entreprise);
        return new ResponseEntity<>(
                "Modification reussie" ,
                HttpStatus.OK);
    }

    @Override
    public Entreprise getEnterprise(Long id) {
        if (entrepriseRepository.findById(id).isPresent())
            return entrepriseRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<Entreprise> getAll() {
        return entrepriseRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        entrepriseRepository.deleteById(id);
        return "l'entreprise a été supprimée";
    }

    @Override
    public ResponseEntity<String> addFieul(Etudiant etudiant, Long id) {
        Optional<Entreprise> uses = entrepriseRepository.findById(id);
        if (uses.isEmpty())
            return new ResponseEntity<>(
                    "Enterprise not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        List<Etudiant> ens = uses.get().getSponsorisees();
        ens.add(etudiant);
        uses.get().setSponsorisees(ens);

        entrepriseRepository.save(uses.get());
        return new ResponseEntity<>(
                "Ajout reussi" ,
                HttpStatus.OK);
    }
}