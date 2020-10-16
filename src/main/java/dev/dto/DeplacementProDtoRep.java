package dev.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeplacementProDtoRep {

	private int id;
	private CollegueDtoRep reserverPar;
	private ChauffeurDtoRep chauffeur;
	private boolean avecChauffeur;
	private VehiculeSocieteDto vehicule;
	private LocalDate dateEmprun;
	private LocalDate dateRestitution;
	private LocalTime heureEmprun;
	private LocalTime heureRestitution;

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

	public boolean isAvecChauffeur() {
		return avecChauffeur;
	}

	public void setAvecChauffeur(boolean avecChauffeur) {
		this.avecChauffeur = avecChauffeur;
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

	public LocalDate getDateRestitution() {
		return dateRestitution;
	}

	public void setDateRestitution(LocalDate dateRestitution) {
		this.dateRestitution = dateRestitution;
	}

	public LocalTime getHeureEmprun() {
		return heureEmprun;
	}

	public void setHeureEmprun(LocalTime heureEmprun) {
		this.heureEmprun = heureEmprun;
	}

	public LocalTime getHeureRestitution() {
		return heureRestitution;
	}

	public void setHeureRestitution(LocalTime heureRestitution) {
		this.heureRestitution = heureRestitution;
	}

}
