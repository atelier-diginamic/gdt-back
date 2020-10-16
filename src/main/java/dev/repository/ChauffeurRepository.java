package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Chauffeur;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Integer>{

	List<Chauffeur> findByMatricule(String value);
	List<Chauffeur> findByNom(String value);
	List<Chauffeur> findByPrenom(String value);

}
