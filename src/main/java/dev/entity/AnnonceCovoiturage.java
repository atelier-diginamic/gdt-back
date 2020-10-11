package dev.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import enumeration.StatusAnnonce;

@Entity
@Table(name = "annonce_covoiturage")
public class AnnonceCovoiturage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "id_Collegue")
	private Collegue collegue;
	@Column(columnDefinition = "date")
	private LocalDate date;
	private String depart;
	private String arrive;
	@Column(columnDefinition = "time")
	private LocalTime heureDepart;
	private String marqueVoiture;
	private String modeleVoiture;
	private String imageUrl;
	private int place;
	@Enumerated(EnumType.STRING)
	private StatusAnnonce status;
	@ManyToMany
	@JoinTable(name = "reservation_covoiturage", joinColumns = @JoinColumn(name = "id_annonce"), inverseJoinColumns = @JoinColumn(name = "id_passager"))
	private List<Collegue> passager = new ArrayList<Collegue>();

	// getteurSetteur
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collegue getCollegue() {
		return collegue;
	}

	public void setCollegue(Collegue collegue) {
		this.collegue = collegue;
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

	public String getArrive() {
		return arrive;
	}

	public void setArrive(String arrive) {
		this.arrive = arrive;
	}

	public LocalTime getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}

	public String getMarqueVoiture() {
		return marqueVoiture;
	}

	public void setMarqueVoiture(String marqueVoiture) {
		this.marqueVoiture = marqueVoiture;
	}

	public String getModeleVoiture() {
		return modeleVoiture;
	}

	public void setModeleVoiture(String modeleVoiture) {
		this.modeleVoiture = modeleVoiture;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public StatusAnnonce getStatus() {
		return status;
	}

	public void setStatus(StatusAnnonce status) {
		this.status = status;
	}

	public List<Collegue> getPassager() {
		return passager;
	}

	public void setPassager(List<Collegue> passager) {
		this.passager = passager;
	}

}
