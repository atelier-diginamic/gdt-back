package dev.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import dev.entity.DeplacementPro;
import dev.entity.VehiculeSociete;

public class VehiculeReserveDto {

	private VehiculeSociete vehicule;
	private LocalDate date;
	private LocalTime heureDepart;
	
	
	
	public VehiculeReserveDto(DeplacementPro dp) {
		this.vehicule = dp.getVehicule();
		this.date = dp.getDate();
		this.heureDepart = dp.getHeureDepart();
	}
	
	public VehiculeSociete getVehicule() {
		return vehicule;
	}
	public void setVehicule(VehiculeSociete vehicule) {
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
