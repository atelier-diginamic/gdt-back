package dev.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import enumeration.StatusAnnonce;

public class CovoiturageDtoQuery {

	private Integer id = null;
	private Integer collegueId;
	private LocalDate date;
	private String depart;
	private String arrive;
	private LocalTime heureDepart;
	private String marqueVoiture;
	private String modeleVoiture;
	private String imageUrl;
	private int place;
	private StatusAnnonce status;
	private List<Integer> passagersId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCollegueId() {
		return collegueId;
	}

	public void setCollegueId(Integer collegueId) {
		this.collegueId = collegueId;
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

	public List<Integer> getPassagersId() {
		return passagersId;
	}

	public void setPassagersId(List<Integer> passagersId) {
		this.passagersId = passagersId;
	}

	
}
