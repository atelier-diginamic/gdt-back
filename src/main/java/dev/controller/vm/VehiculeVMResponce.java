package dev.controller.vm;

public class VehiculeVMResponce {

	int id;
	String marque;
	String model;
	int nbr_places;
	String immatriculation;
	String categorie;
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
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}
