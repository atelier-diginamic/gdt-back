package dev.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Covoiturage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Temporal(TemporalType.DATE)
	Date date;

	@OneToOne
	@JoinColumn(name = "id_adresse_depart")
	Lieu depart;

	@OneToOne
	@JoinColumn(name = "id_adresse_destination")
	Lieu destination;

	@OneToOne
	@JoinColumn(name = "id_vehicule")
	Vehicule vehicule;

	@OneToOne
	@JoinColumn(name = "id_collaborateur")
	Collegue chauffeur;

	@ManyToMany
	@JoinTable(name = "fk_covoiturage_collaborateur", joinColumns = @JoinColumn(name = "id_covoiturage"), inverseJoinColumns = @JoinColumn(name = "id_collaborateur"))
	List<Collegue> passagers;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Lieu getDepart() {
		return depart;
	}

	public void setDepart(Lieu depart) {
		this.depart = depart;
	}

	public Lieu getDestination() {
		return destination;
	}

	public void setDestination(Lieu destination) {
		this.destination = destination;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Collegue getChauffeur() {
		return chauffeur;
	}

	public void setChauffeur(Collegue chauffeur) {
		this.chauffeur = chauffeur;
	}

	public List<Collegue> getPassagers() {
		return passagers;
	}

	public void setPassagers(List<Collegue> passagers) {
		this.passagers = passagers;
	}

}
