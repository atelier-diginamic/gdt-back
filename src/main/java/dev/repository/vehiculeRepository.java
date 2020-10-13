package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.VehiculeSociete;
import enumeration.CategorieVehicule;
import enumeration.StatusVehicule;

public interface vehiculeRepository extends JpaRepository<VehiculeSociete, Integer>{
	
	List<VehiculeSociete> findByMarque(String marque);
	List<VehiculeSociete> findByModel(String modele);
	List<VehiculeSociete> findByCategorie(CategorieVehicule categorie);
	List<VehiculeSociete> findByImmatriculation(String value);

	
	

}
