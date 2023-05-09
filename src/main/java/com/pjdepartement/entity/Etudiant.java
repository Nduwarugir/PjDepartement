package com.pjdepartement.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity()
	@Table(name = "Etudiant")
	public class Etudiant {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long idEtudiant;

	    @Column(length = 100)
	    private String nom;

	    @Column(length = 100)
	    private String prenom;

	    @Column(length = 100)
	    private String matricule;

	    @Column(length = 100)
	    private String numFiche;

	    @Column(length = 100)
	    private String xpLanguage;

	    @Column(length = 100)
	    private String password;

	    @Column()
	    private String photo;

	    @Column(length = 10)
	    private String niveau;

	    @Column()
	    private long numWhatsApp;

	    public Etudiant() {
	        super();
	    }

	    public Etudiant(long idEtudiant, String nom, String prenom, String matricule, String numFiche, String xpLanguage, String password, String photo, String niveau, long numWhatsApp) {
	        this.idEtudiant = idEtudiant;
	        this.nom = nom;
	        this.prenom = prenom;
	        this.matricule = matricule;
			this.numFiche = numFiche;
			this.xpLanguage = xpLanguage;
	        this.password = password;
	        this.photo = photo;
	        this.niveau = niveau;
	        this.numWhatsApp = numWhatsApp;
	    }

	    public long getIdEtudiant() {
	        return idEtudiant;
	    }

	    public void setIdEtudiant(long idEtudiant) {
	        this.idEtudiant = idEtudiant;
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

	    public String getXpLanguage() {
	        return xpLanguage;
	    }

	    public void setXpLanguage(String xpLanguage) {
	        this.xpLanguage = xpLanguage;
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

	    public String getNiveau() {
	        return niveau;
	    }

	    public void setNiveau(String niveau) {
	        this.niveau = niveau;
	    }

	    public long getNumWhatsApp() {
	        return numWhatsApp;
	    }

	    public void setNumWhatsApp(long numWhatsApp) {
	        this.numWhatsApp = numWhatsApp;
	    }
	    @Override
	    public String toString() {
	        return "Etudiant{" +
	                "idEtudiant=" + idEtudiant +
	                ", nom='" + nom + '\'' +
	                ", prenom='" + prenom + '\'' +
	                ", matricule='" + matricule + '\'' +
	                ", xpLanguage='" + xpLanguage + '\'' +
	                ", password='" + password + '\'' +
	                ", photo='" + photo + '\'' +
	                ", niveau='" + niveau + '\'' +
	                ", numWhatsApp=" + numWhatsApp +
	                '}';
	    }

		public String getNumFiche() {
			return numFiche;
		}

		public void setNumFiche(String numFiche) {
			this.numFiche = numFiche;
		}
	}
