package com.mono.pjdepartement.entity.app;

import jakarta.persistence.*;

@Entity(name="Offre")
@Table(name="Offre")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Offre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOffre;

	@Column(length = 50)
	private String poste;

	@Column(length = 100)
	private String description;

	@Column(length = 50)
	private String periode;

	@Column(length = 150)
	private String competences;

	@Column(length = 150)
	private Boolean etat;

	public Offre() {
		super();
	}

	public Offre(String poste, String description, String periode, String competences, Boolean etat) {
		this.poste = poste;
		this.description = description;
		this.periode = periode;
		this.competences = competences;
		this.etat = etat;
	}

	public long getIdOffre() {
		return idOffre;
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

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public String getCompetences() {
		return competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Offre{" +
				"idOffre=" + idOffre +
				", poste='" + poste + '\'' +
				", description='" + description + '\'' +
				", periode='" + periode + '\'' +
				", competences='" + competences + '\'' +
				", etat=" + etat +
				'}';
	}
}
