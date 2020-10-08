package dev.controller.vm;

import java.util.Date;
import java.util.List;

import dev.domain.Covoiturage;

public class CovoiturageVmResponse {

	private Integer id;
	private Date date;
	private String depart;
	private String destination;
	private VehiculeVMResponse vehicule;
	private CollegueVMResponce chauffeur;
	private List<CollegueVMResponce> passagers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public VehiculeVMResponse getVehicule() {
		return vehicule;
	}

	public void setVehicule(VehiculeVMResponse vehicule) {
		this.vehicule = vehicule;
	}

	public CollegueVMResponce getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(CollegueVMResponce chauffeur) {
		this.chauffeur = chauffeur;
	}

	public List<CollegueVMResponce> getPassagers() {
		return passagers;
	}

	public void setPassagers(List<CollegueVMResponce> passagers) {
		this.passagers = passagers;
	}

}
