package dev.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Covoiturage;
import dev.domain.Lieu;
import dev.domain.Vehicule;

public interface CovoiturageRepository extends JpaRepository<Covoiturage, Integer>{

	public List<Covoiturage> findByDate(Date date);
	
	public List<Covoiturage> findByDepart(Integer lieuId);
	public List<Covoiturage> findByDestination(Integer lieuId);
	public List<Covoiturage> findByVehicule(Integer vehiculeId);
	public List<Covoiturage> findByChauffeur(Integer collegueId);

}
