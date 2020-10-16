package dev.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class DeplacementProDtoQuery {

	private Integer id = null;
	private Integer collaborateurId;
	private Integer chauffeurId = null;
	private boolean avecChauffeur=false;
	private Integer vehiculeId;
	private LocalDate dateEmprun;
	private LocalDate dateRestitution;
	private LocalTime heureEmprun;
	private LocalTime heureRestiturion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCollaborateurId() {
		return collaborateurId;
	}

	public void setCollaborateurId(Integer collaborateurId) {
		this.collaborateurId = collaborateurId;
	}

	public Integer getChauffeurId() {
		return chauffeurId;
	}

	public void setChauffeurId(Integer chauffeurId) {
		this.chauffeurId = chauffeurId;
	}

	public boolean isAvecChauffeur() {
		return avecChauffeur;
	}

	public void setAvecChauffeur(boolean avecChauffeur) {
		this.avecChauffeur = avecChauffeur;
	}

	public Integer getVehiculeId() {
		return vehiculeId;
	}

	public void setVehiculeId(Integer vehiculeId) {
		this.vehiculeId = vehiculeId;
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

	public LocalTime getHeureRestiturion() {
		return heureRestiturion;
	}

	public void setHeureRestiturion(LocalTime heureRestiturion) {
		this.heureRestiturion = heureRestiturion;
	}

}
