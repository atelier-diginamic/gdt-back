package dev.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deplacement_pro")
public class DeplacementPro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "reserver_par")
	private Collegue reserverPar;
	@ManyToOne
	@JoinColumn(name = "id_chauffeur", nullable = true)
	private Chauffeur chauffeur;
	@ManyToOne
	@JoinColumn(name = "id_vehicule")
	private VehiculeSociete vehicule;

	@Column(name = "date_emprun", columnDefinition = "date")
	private LocalDate dateEmprun;
	@Column(name = "date_restitution", columnDefinition = "date")
	private LocalDate dateRestitution;
	@Column(name = "heure_emprun", columnDefinition = "time")
	private LocalTime heureEmprun;
	@Column(name = "heure_restitution", columnDefinition = "time")
	private LocalTime heureRestitution;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collegue getReserverPar() {
		return reserverPar;
	}

	public void setReserverPar(Collegue reserverPar) {
		this.reserverPar = reserverPar;
	}

	public Chauffeur getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Chauffeur chauffeur) {
		this.chauffeur = chauffeur;
	}

	public VehiculeSociete getVehicule() {
		return vehicule;
	}

	public void setVehicule(VehiculeSociete vehicule) {
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
