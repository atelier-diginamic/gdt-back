package dev.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import dev.entity.Chauffeur;
import dev.entity.Collegue;
import dev.entity.DeplacementPro;
import dev.entity.VehiculeSociete;

public class DeplacementProDtoRep {

	private int id;
	private CollegueDtoRep reserverPar;
	private ChauffeurDtoRep chauffeur;
	private VehiculeSocieteDto vehicule;
	private LocalDate date;
	private String depart;
	private String destination;
	private LocalTime heureDepart;
	private List<CollegueDtoRep> passager = new ArrayList<CollegueDtoRep>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CollegueDtoRep getReserverPar() {
		return reserverPar;
	}

	public void setReserverPar(CollegueDtoRep reserverPar) {
		this.reserverPar = reserverPar;
	}

	public ChauffeurDtoRep getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(ChauffeurDtoRep chauffeur) {
		this.chauffeur = chauffeur;
	}

	public VehiculeSocieteDto getVehicule() {
		return vehicule;
	}

	public void setVehicule(VehiculeSocieteDto vehicule) {
		this.vehicule = vehicule;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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

	public LocalTime getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}

	public List<CollegueDtoRep> getPassager() {
		return passager;
	}

	public void setPassager(List<CollegueDtoRep> passager) {
		this.passager = passager;
	}

}
