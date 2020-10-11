package dev.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeplacementProDtoQuery {

	private Integer id = null;
	private Integer reserverParId;
	private Integer chauffeurId;
	private Integer vehiculeId;
	private LocalDate date;
	private String depart;
	private String destination;
	private LocalTime heureDepart;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReserverParId() {
		return reserverParId;
	}

	public void setReserverParId(Integer reserverParId) {
		this.reserverParId = reserverParId;
	}

	public Integer getChauffeurId() {
		return chauffeurId;
	}

	public void setChauffeurId(Integer chauffeurId) {
		this.chauffeurId = chauffeurId;
	}

	public Integer getVehiculeId() {
		return vehiculeId;
	}

	public void setVehiculeId(Integer vehiculeId) {
		this.vehiculeId = vehiculeId;
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

}
