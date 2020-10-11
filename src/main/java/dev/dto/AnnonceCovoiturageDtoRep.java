package dev.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import enumeration.StatusAnnonce;

public class AnnonceCovoiturageDtoRep {

	private int id;
	private CollegueDtoRep collegue;
	private LocalDate date;
	private String depart;
	private String arrive;
	private LocalTime heureDepart;
	private String marqueVoiture;
	private String modeleVoiture;
	private String imageUrl;
	private int place;
	private StatusAnnonce status;
	private List<CollegueDtoRep> passager = new ArrayList<CollegueDtoRep>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CollegueDtoRep getCollegue() {
		return collegue;
	}

	public void setCollegue(CollegueDtoRep collegue) {
		this.collegue = collegue;
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

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public LocalTime getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}

	public String getMarqueVoiture() {
		return marqueVoiture;
	}

	public void setMarqueVoiture(String marqueVoiture) {
		this.marqueVoiture = marqueVoiture;
	}

	public String getModeleVoiture() {
		return modeleVoiture;
	}

	public void setModeleVoiture(String modeleVoiture) {
		this.modeleVoiture = modeleVoiture;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public StatusAnnonce getStatus() {
		return status;
	}

	public void setStatus(StatusAnnonce status) {
		this.status = status;
	}

	public List<CollegueDtoRep> getPassager() {
		return passager;
	}

	public void setPassager(List<CollegueDtoRep> passager) {
		this.passager = passager;
	}

}
