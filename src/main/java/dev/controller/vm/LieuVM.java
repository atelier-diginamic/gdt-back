package dev.controller.vm;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LieuVM {

	private Integer id = null;
	String libelle;
	int numero;
	String voie;
	String adresse;
	int code_postal;
	String ville;
	String coordonnee;

	public LieuVM( String libelle, int numero, String voie, String adresse, int code_postal, String ville,
			String coordonnee) {
		this.libelle = libelle;
		this.numero = numero;
		this.voie = voie;
		this.adresse = adresse;
		this.code_postal = code_postal;
		this.ville = ville;
		this.coordonnee = coordonnee;
	}

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
