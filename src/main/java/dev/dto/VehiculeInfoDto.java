package dev.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class VehiculeInfoDto {
	private CollegueDtoRep ReserverPar;
	private VehiculeSocieteDto vehicule;
	private LocalDate date;
	private LocalTime heureDepart;

	public VehiculeInfoDto(LocalDate date, LocalTime heureDepart, VehiculeSocieteDto dtoVehicule,
			CollegueDtoRep dtoCol) {
		this.vehicule = dtoVehicule;
		this.ReserverPar = dtoCol;
		this.date = date;
		this.heureDepart = heureDepart;
	}

	public CollegueDtoRep getReserverPar() {
		return ReserverPar;
	}

	public void setReserverPar(CollegueDtoRep reserverPar) {
		ReserverPar = reserverPar;
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

	public LocalTime getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}

}
