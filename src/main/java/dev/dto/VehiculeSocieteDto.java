package dev.dto;

import enumeration.CategorieVehicule;
import enumeration.StatusVehicule;

public class VehiculeSocieteDto {
	private Integer id=null;
	private String marque;
	private String model;
	private String immatriculation;
	private String imageUrl;
	private StatusVehicule status;
	private CategorieVehicule categorie;
	private int places;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
