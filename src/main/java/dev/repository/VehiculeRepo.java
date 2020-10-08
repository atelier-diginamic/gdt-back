package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.domain.Vehicule;

@Repository
public interface VehiculeRepo extends JpaRepository<Vehicule, Integer>{

	
	List<Vehicule> findByMarque(String marque);
	List<Vehicule> findByModel(String model);
	List<Vehicule> findBycategorie(String categorie);
	List<Vehicule> findByImmatriculation(String immat);
	
	
}
