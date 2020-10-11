package dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enumeration.CategorieVehicule;
import enumeration.StatusVehicule;

@Entity
@Table(name = "vehicule_societe")
public class VehiculeSociete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String marque;
	private String model;
	private String immatriculation;
	@Column(name = "image_url")
	private String imageUrl;
	@Enumerated(EnumType.STRING)
	private StatusVehicule status;
	@Enumerated(EnumType.STRING)
	private CategorieVehicule categorie;
	private int places;

	// getteurSetteur

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public StatusVehicule getStatus() {
		return status;
	}

	public void setStatus(StatusVehicule status) {
		this.status = status;
	}

	public CategorieVehicule getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieVehicule categorie) {
		this.categorie = categorie;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}

}
