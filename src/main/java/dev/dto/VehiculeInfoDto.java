package dev.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class VehiculeInfoDto {
	private CollegueDtoRep ReserverPar;
	private VehiculeSocieteDto vehicule;
	private LocalDate dateEmprun;
	private LocalTime heureEmprun;
	private LocalDate dateRestitution;
	private LocalTime heureRestitution;

	public VehiculeInfoDto(LocalDate dateEmprun, LocalTime heureEmprun, LocalDate dateRestitution,
			LocalTime heureRestitution, VehiculeSocieteDto dtoRep, CollegueDtoRep dtoRep2) {
		this.ReserverPar=dtoRep2;
		this.vehicule=dtoRep;
		this.dateEmprun=dateEmprun;
		this.heureEmprun=heureEmprun;
		this.dateRestitution=dateRestitution;
		this.heureRestitution=heureRestitution;
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

	public LocalDate getDateEmprun() {
		return dateEmprun;
	}

	public void setDateEmprun(LocalDate dateEmprun) {
		this.dateEmprun = dateEmprun;
	}

	public LocalTime getHeureEmprun() {
		return heureEmprun;
	}

	public void setHeureEmprun(LocalTime heureEmprun) {
		this.heureEmprun = heureEmprun;
	}

	public LocalDate getDateRestitution() {
		return dateRestitution;
	}

	public void setDateRestitution(LocalDate dateRestitution) {
		this.dateRestitution = dateRestitution;
	}

	public LocalTime getHeureRestitution() {
		return heureRestitution;
	}

	public void setHeureRestitution(LocalTime heureRestitution) {
		this.heureRestitution = heureRestitution;
	}

}
