package com.pjdepartement.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Enseignant")
public class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnseignant;

    @Column(length = 100)
    private String nom;

    @Column(length = 100)
    private String prenom;

    @Column(length = 100)
    private String matricule;

    @Column(length = 100)
    private String domain;

    @Column(length = 100)
    private String titre;

    @Column(length = 100)
    private String mail;

    @Column(length = 100)
    private String password;

    @Column()
    private String photo;

    @Column()
    private long numWhatsApp;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Enseignant> encadrees = new ArrayList<>();

    public Enseignant(Long idEnseignant, String nom, String prenom, String matricule, String domain, String mail, String titre, String password, String photo, long numWhatsApp) {
        this.idEnseignant = idEnseignant;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.domain = domain;
        this.mail = mail;
        this.titre = titre;
        this.password = password;
        this.photo = photo;
        this.numWhatsApp = numWhatsApp;
    }

    public Enseignant() {
        super();
    }

    public void setIdEnseignant(Long idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public Long getIdEnseignant() {
        return idEnseignant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getNumWhatsApp() {
        return numWhatsApp;
    }

    public void setNumWhatsApp(long numWhatsApp) {
        this.numWhatsApp = numWhatsApp;
    }

    public List<Enseignant> getEncadrees() {
        return encadrees;
    }

    public void setEncadrees(List<Enseignant> encadrees) {
        this.encadrees = encadrees;
    }

    @Override
    public String toString() {
        return "Enseignant{" +
                "idEnseignant=" + idEnseignant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", domain='" + domain + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                ", numWhatsApp=" + numWhatsApp +
                ", encadrees=" + encadrees +
                '}';
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
