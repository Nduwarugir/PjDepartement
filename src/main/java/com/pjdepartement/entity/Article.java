package com.pjdepartement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idArticle;
	@Column(length = 50)
	private String theme;
	@Column(length = 50)
	private String description;
	@Column(length = 50)
	private String nameAuteur;
	
	public Article() {
		super();
	}

	public Article(String theme, String description, String nameAuteur) {
		this.theme = theme.toUpperCase();
		this.description = description.toUpperCase();
		this.nameAuteur = nameAuteur.toUpperCase();
	}

	public long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
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

	public String getNameAuteur() {
		return nameAuteur;
	}

	public void setNameAuteur(String nameAuteur) {
		this.nameAuteur = nameAuteur;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", theme=" + theme + ", description=" + description + ", nameAuteur="
				+ nameAuteur + "]";
	}
}
