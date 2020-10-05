package dev.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(length = 50, nullable = false)
	String marque;

	@Column(length = 50, nullable = false)
	String model;

	@Column(length = 2, nullable = false)
	int nbr_places;

	@Column(length = 25, nullable = false)
	String immatriculation;

	@Column(length = 50, nullable = false)
	String catregorie;

	@Column(name="url_image", length = 255, nullable = false)
	String urlImage;

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

	public int getNbr_places() {
		return nbr_places;
	}

	public void setNbr_places(int nbr_places) {
		this.nbr_places = nbr_places;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getCatregorie() {
		return catregorie;
	}

	public void setCatregorie(String catregorie) {
		this.catregorie = catregorie;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}
