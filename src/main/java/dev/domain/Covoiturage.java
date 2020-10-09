package dev.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Covoiturage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

//	@Temporal(TemporalType.DATE)
//	LocalDateTime date;

	@Column(name = "date", columnDefinition = "DATE")
	private LocalDate date;

	@Column(name = "heure_depart", columnDefinition = "time")
	private LocalTime heureDepart;

	@Column(name = "heure_arrive", columnDefinition = "time")
	private LocalTime heureArriver;

//	@OneToOne
//	@JoinColumn(name = "id_adresse_depart")
	@Column(nullable = false)
	String depart;

//	@OneToOne
//	@JoinColumn(name = "id_adresse_destination")
	@Column(nullable = false)
	String destination;

	@OneToOne
	@JoinColumn(name = "id_vehicule")
	Vehicule vehicule;

	@OneToOne
	@JoinColumn(name = "id_collaborateur")
	Collegue chauffeur;

	@ManyToMany
	@JoinTable(name = "fk_covoiturage_collaborateur", joinColumns = @JoinColumn(name = "id_covoiturage"), inverseJoinColumns = @JoinColumn(name = "id_collaborateur"))
	List<Collegue> passagers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalTime getHeureArriver() {
		return heureArriver;
	}

	public void setHeureArriver(LocalTime heureArriver) {
		this.heureArriver = heureArriver;
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

	@Override
	public String toString() {
		return "Covoiturage [id=" + id + ", date=" + date + ", depart=" + depart + ", destination=" + destination
				+ ", vehicule=" + vehicule + ", chauffeur=" + chauffeur + ", passagers=" + passagers + "]";
	}

}
