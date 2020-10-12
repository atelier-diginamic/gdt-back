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
	@JoinColumn(name = "id_chauffeur",nullable = true)
	private Chauffeur chauffeur;
	@ManyToOne
	@JoinColumn(name = "id_vehicule")
	private VehiculeSociete vehicule;
	@Column(columnDefinition = "date")
	private LocalDate date;
	private String depart;
	private String destination;
	@Column(name = "heure_depart", columnDefinition = "time")
	private LocalTime heureDepart;
	@ManyToMany
	@JoinTable(name = "reservation_deplacement_pro", joinColumns = @JoinColumn(name = "id_deplacement_pro"), inverseJoinColumns = @JoinColumn(name = "id_passager"))
	private List<Collegue> passager = new ArrayList<Collegue>();

	// getteurSetteur

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

	public List<Collegue> getPassager() {
		return passager;
	}

	public void setPassager(List<Collegue> passager) {
		this.passager = passager;
	}

}
