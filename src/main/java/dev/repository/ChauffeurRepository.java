package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.entity.Chauffeur;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Integer>{

	List<Chauffeur> findByMatricule(String value);
	
	@Query("select ch from Chauffeur ch where ch.info.nom=?1")
	List<Chauffeur> findByNom(String value);
	@Query("select ch from Chauffeur ch where ch.info.prenom=?1")
	List<Chauffeur> findByPrenom(String value);

}
