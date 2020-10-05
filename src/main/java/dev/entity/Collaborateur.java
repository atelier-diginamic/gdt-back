package dev.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collaborateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(length = 50, nullable = false)
	String nom;

	@Column(length = 50, nullable = false)
	String prenom;

	@Column(length = 10, nullable = false)
	String telephone;

	@Column(length = 70, nullable = false, unique = true)
	String email;

	@Column(name = "mot_de_passe", length = 100, nullable = false)
	String motDePasse;

	@Column(name = "date_de_naissance", nullable = false)
	Date dateDeNaissance;
	
	@Column(nullable = false)
	boolean chauffeur;
	
	@Column(nullable = false)
	boolean admin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public boolean isChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(boolean chauffeur) {
		this.chauffeur = chauffeur;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	

}
