package dev.controller.vm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class CovoiturageVmResponse {

	private Integer id;

	private LocalDate date;
	private LocalTime heureDepart;
	private LocalTime heureArrive;

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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}

	public LocalTime getHeureArrive() {
		return heureArrive;
	}

	public void setHeureArrive(LocalTime heureArrive) {
		this.heureArrive = heureArrive;
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
