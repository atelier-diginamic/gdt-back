package dev.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.domain.Covoiturage;

public interface CovoiturageRepository extends JpaRepository<Covoiturage, Integer>{

	
	public List<Covoiturage> findByDepart(String depart);
	public List<Covoiturage> findByDestination(String destination);

	@Query("select c from Covoiturage c where c.vehicule.id=?1")
	public List<Covoiturage> findByVehicule(Integer vehiculeId);
	
	@Query("select c from Covoiturage c where c.chauffeur.id=?1")
	public List<Covoiturage> findByChauffeur(Long collegueId);
	
	
	public List<Covoiturage> findByDate(LocalDate dateTime);
	public List<Covoiturage> findByDateBefore(LocalDate date);
	public List<Covoiturage> findByDateAfter(LocalDate date);
	public List<Covoiturage> findByDateBetween(LocalDate date,LocalDate date2);
}
