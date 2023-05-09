package com.pjdepartement.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Entreprise")
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nom;

    @Column(length = 100)
    private Long contributeNumber;

    @Column(length = 100)
    private String Location;

    @Column(length = 100)
    private long numWhatsApp;

    @Column(length = 100)
    private String mail;

    @Column(length = 100)
    private String password;

    @Column(length = 100)
    private String photo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Etudiant> sponsorisees = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Etudiant> stagiaires = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Etudiant> employees = new ArrayList<>();

    public Entreprise() {
        super();
    }

    public Entreprise(Long id, String nom, Long contributeNumber, String location, long numWhatsApp, String mail, String password, String photo) {
        this.id = id;
        this.nom = nom;
        this.contributeNumber = contributeNumber;
        Location = location;
        this.numWhatsApp = numWhatsApp;
        this.mail = mail;
        this.password = password;
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getContributeNumber() {
        return contributeNumber;
    }

    public void setContributeNumber(Long contributeNumber) {
        this.contributeNumber = contributeNumber;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public long getNumWhatsApp() {
        return numWhatsApp;
    }

    public void setNumWhatsApp(long numWhatsApp) {
        this.numWhatsApp = numWhatsApp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", contributeNumber=" + contributeNumber +
                ", Location='" + Location + '\'' +
                ", numWhatsApp=" + numWhatsApp +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    public List<Etudiant> getSponsorisees() {
        return sponsorisees;
    }

    public void setSponsorisees(List<Etudiant> sponsorisees) {
        this.sponsorisees = sponsorisees;
    }

    public List<Etudiant> getStagiaires() {
        return stagiaires;
    }

    public void setStagiaires(List<Etudiant> stagiaires) {
        this.stagiaires = stagiaires;
    }

    public List<Etudiant> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Etudiant> employees) {
        this.employees = employees;
    }
}
