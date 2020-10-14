package dev.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.DeplacementPro;
import dev.entity.VehiculeSociete;

public interface DeplacementProRepository extends JpaRepository<DeplacementPro, Integer>{

	List<DeplacementPro> findAllDeplacementProByPassagerId(int idPassager);
	int countByPassagerId(int id);
	List<DeplacementPro> findByReserverParId(int id);
	
	List<DeplacementPro> findByVehicule(VehiculeSociete id);
	
	List<DeplacementPro> findByVehiculeAndDateAfter(VehiculeSociete id, LocalDate date);
	List<DeplacementPro> findByVehiculeAndDateBefore(VehiculeSociete v, LocalDate date);
	
	
	
	
	
	
}
