package dev.controller.vm;

import java.util.Date;
import java.util.List;

import dev.domain.Collegue;
import dev.domain.Covoiturage;
import dev.domain.Lieu;
import dev.domain.Vehicule;

public class CovoiturageVM {
		private Integer id = null;
		
		private Date date;

		private Lieu depart;

		private Lieu destination;

		private Vehicule vehicule;

		private Collegue chauffeur;

		private List<Collegue> passagers;
		
		public CovoiturageVM() {
			System.err.println("bonjour les amis !");
		}
		
		public CovoiturageVM(Covoiturage covoiturage) {
			this.date = covoiturage.getDate();
			this.depart = covoiturage.getDepart();
			this.destination = covoiturage.getDestination();
			this.vehicule = covoiturage.getVehicule();
			this.chauffeur = covoiturage.getChauffeur();
			this.passagers = covoiturage.getPassagers();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

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
