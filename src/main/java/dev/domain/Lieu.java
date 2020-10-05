package dev.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lieu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(length = 50, nullable = false, unique = true)
	String libelle;

	@Column(length = 5, nullable = false)
	int numero;

	@Column(length = 25, nullable = false)
	String voie;

	@Column(columnDefinition = "text", nullable = false)
	String adresse;

	@Column(length = 5, nullable = false)
	int code_postal;

	@Column(length = 255, nullable = false)
	String ville;

	@Column(length = 255, nullable = false)
	String coordonnee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(String coordonnee) {
		this.coordonnee = coordonnee;
	}

}
