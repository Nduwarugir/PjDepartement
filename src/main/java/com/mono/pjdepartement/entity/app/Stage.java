package com.mono.pjdepartement.entity.app;

import com.mono.pjdepartement.entity.metier.Entreprise;
import com.mono.pjdepartement.entity.metier.Etudiant;

import jakarta.persistence.*;

@Entity(name="Stage")
@Table(name="Stage")
public class Stage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStage;

	@Column(length = 50)
	private String poste;

	@Column
	private String description;

	@Column(length = 150)
	private String competencesAttendues;

	@Column(length = 200)
	private String image;

	@Column(length = 50)
	private String periode;

	@OneToOne(cascade = CascadeType.ALL)
	private Entreprise employeurs;

	@OneToOne(cascade = CascadeType.ALL)
	private Etudiant employes;

	public Stage() {
		super();
	}

	public Stage(String poste, String description, String competencesAttendues, String image, String periode) {
		super();
		this.poste = poste;
		this.description = description;
		this.competencesAttendues = competencesAttendues;
		this.image = image;
		this.periode = periode;
	}

	public Stage(String poste, String description, String competencesAttendues, String image, String periode,
			Entreprise employeurs) {
		this.poste = poste;
		this.description = description;
		this.competencesAttendues = competencesAttendues;
		this.image = image;
		this.periode = periode;
		this.employeurs = employeurs;
	}

	public Stage(String poste, String description, String competencesAttendues, String image, String periode,
			Entreprise employeurs, Etudiant employes) {
		this.poste = poste;
		this.description = description;
		this.competencesAttendues = competencesAttendues;
		this.image = image;
		this.periode = periode;
		this.employeurs = employeurs;
		this.employes = employes;
	}

	public long getIdStage() {
		return idStage;
	}

	public void setIdStage(long idStage) {
		this.idStage = idStage;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompetencesAttendues() {
		return competencesAttendues;
	}

	public void setCompetencesAttendues(String competencesAttendues) {
		this.competencesAttendues = competencesAttendues;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public Entreprise getEmployeurs() {
		return employeurs;
	}

	public void setEmployeurs(Entreprise employeurs) {
		this.employeurs = employeurs;
	}

	public Etudiant getEmployes() {
		return employes;
	}

	public void setEmployes(Etudiant employes) {
		this.employes = employes;
	}

	@Override
	public String toString() {
		return "Stage [idStage=" + idStage + ", poste=" + poste + ", description=" + description
				+ ", competencesAttendu=" + competencesAttendues + ", image=" + image + ", periode=" + periode + "]";
	}	
}
