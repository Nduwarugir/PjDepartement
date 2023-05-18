package com.mono.pjdepartement.entity.app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Emploi")
public class Emploi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmploi;

	@Column(length = 50)
	private String poste;

	@Column(length = 100)
	private String description;

	@Column(length = 50)
	private String domaineRequis;

	public Emploi() {
		super();
	}
	/*L'objet offre d'emploie*/
	public Emploi(String poste, String description, String domaineRequis) {
		super();
		this.poste = poste;
		this.description = description;
		this.domaineRequis = domaineRequis;
	}
	public long getIdEmploi() {
		return idEmploi;
	}
	public void setIdEmploi(long idEmploi) {
		this.idEmploi = idEmploi;
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
	public String getDomaineRequis() {
		return domaineRequis;
	}
	public void setDomaineRequis(String domaineRequis) {
		this.domaineRequis = domaineRequis;
	}
	@Override
	public String toString() {
		return "Emploi [idEmploi=" + idEmploi + ", poste=" + poste + ", description=" + description
				+ ", domaineRequis=" + domaineRequis + "]";
	}
}
