package com.mono.pjdepartement.service.implement;


import com.mono.pjdepartement.entity.metier.Entreprise;
import com.mono.pjdepartement.entity.metier.Etudiant;
import com.mono.pjdepartement.entity.repository.EntrepriseRepository;
import com.mono.pjdepartement.service.EntrepriseService;
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
                        "Vous devez entrer Votre nom",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (entreprise.getRoles() == null)
                entreprise.setRoles("Entreprise");

            if (entreprise.getNumTel() == null)
                return new ResponseEntity<>(
                    "Vous devez entrer Votre numero de téléphone",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (entreprise.getMail() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer Votre mail",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (entreprise.getPassword() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer Votre Password",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (entreprise.getContributeNumber() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre numéro de contribualble",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (entreprise.getLocation() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre Localisation",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            if (entreprise.getCreationDate() == null)
                return new ResponseEntity<>(
                        "Vous devez entrer votre Date de creation",
                        HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500

            Entreprise etmp = entrepriseRepository.save(entreprise);
            return new ResponseEntity<>(
                    "Enregistrement reussi" + etmp,
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "An exception has occured: "+e.getMessage(),
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

        if (entreprise.getNumTel() != 0L || !(uses.get().getNumTel().equals(entreprise.getNumTel())))
            uses.get().setNumTel(entreprise.getNumTel());

        if (entreprise.getMail() != null || !uses.get().getMail().equals(entreprise.getMail()))
            uses.get().setMail(entreprise.getMail());

        if (entreprise.getPassword() != null || !uses.get().getPassword().equals(entreprise.getPassword()))
            uses.get().setPassword(entreprise.getPassword());

        if (entreprise.getPhoto() != null || !uses.get().getPhoto().equals(entreprise.getPhoto()))
            uses.get().setPhoto(entreprise.getPhoto());

        if (entreprise.getContributeNumber() != null || !uses.get().getContributeNumber().equals(entreprise.getContributeNumber()))
            uses.get().setContributeNumber(entreprise.getContributeNumber());

        if (entreprise.getLocation() != null || !uses.get().getLocation().equals(entreprise.getLocation()))
            uses.get().setLocation(entreprise.getLocation());

        if (entreprise.getWebSite() != null || !uses.get().getWebSite().equals(entreprise.getWebSite()))
            uses.get().setWebSite(entreprise.getWebSite());

        if (entreprise.getCreationDate() != null || !uses.get().getCreationDate().equals(entreprise.getCreationDate()))
            uses.get().setCreationDate(entreprise.getCreationDate());

        entrepriseRepository.saveAndFlush(uses.get());
        return new ResponseEntity<>(
                "Modification reussie: " + entreprise,
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
    public ResponseEntity<String> delete(Long id) {
        try {
            entrepriseRepository.deleteById(id);
            return new ResponseEntity<>(
                    "l'entreprise a été supprimée",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            return new ResponseEntity<>(
                    "An error has occured: "+e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Entreprise> findByName(String name) {
        return entrepriseRepository.findByNom(name);
    }

    @Override
    public List<Entreprise> findByLocation(String location) {
        return entrepriseRepository.findByLocation(location);
    }

    @Override
    public List<Entreprise> findByWebSite(String webSite) {
        return entrepriseRepository.findByWebSite(webSite);
    }

    @Override
    public ResponseEntity<String> addParraine(Etudiant etudiant, Long id) {
        Optional<Entreprise> uses = entrepriseRepository.findById(id);
        if (uses.isEmpty())
            return new ResponseEntity<>(
                    "Enterprise not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        List<Etudiant> ens = uses.get().getParraines();
        ens.add(etudiant);
        uses.get().setParraines(ens);

        entrepriseRepository.save(uses.get());
        return new ResponseEntity<>(
                "Ajout reussi parrainés: " + etudiant,
                HttpStatus.OK);
    }

    @Override
    public List<Etudiant> getAllParraines(Long id) {
        Optional<Entreprise> uses = entrepriseRepository.findById(id);
        List<Etudiant> etudiantList = null;
        if (uses.isPresent())
            etudiantList = uses.get().getParraines();
        return etudiantList;
    }

    @Override
    public ResponseEntity<String> addStagiaire(Etudiant etudiant, Long id) {
        Optional<Entreprise> uses = entrepriseRepository.findById(id);
        if (uses.isEmpty())
            return new ResponseEntity<>(
                    "Enterprise not found",
                    HttpStatus.INTERNAL_SERVER_ERROR);//renvoie une erreur 500
        List<Etudiant> ens = uses.get().getStagiaires();
        ens.add(etudiant);
        uses.get().setStagiaires(ens);

        entrepriseRepository.save(uses.get());
        return new ResponseEntity<>(
                "Ajout reussi stagiaire: " + etudiant,
                HttpStatus.OK);
    }

    @Override
    public List<Etudiant> getAllStagiaires(Long id) {
        Optional<Entreprise> uses = entrepriseRepository.findById(id);
        List<Etudiant> etudiantList = null;
        if (uses.isPresent())
            etudiantList = uses.get().getStagiaires();
        return etudiantList;
    }

}