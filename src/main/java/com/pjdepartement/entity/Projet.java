package com.pjdepartement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Projet")
public class Projet {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProjet;
	 @Column(length = 50)
	private String theme;
	 @Column(length = 200)
	private String description;
	 
	 public Projet() {
		 super();
	 }

	public Projet(String theme, String description) {
		super();
		this.theme = theme;
		this.description = description;
	}

	public long getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(long idProjet) {
		this.idProjet = idProjet;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Projet [idProjet=" + idProjet + ", theme=" + theme + ", description=" + description
				+ "]";
	}
}
