package dev.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.Collegue;
import dev.entity.DeplacementPro;
import dev.entity.VehiculeSociete;

public interface DeplacementProRepository extends JpaRepository<DeplacementPro, Integer>{

	List<DeplacementPro> findByReserverPar(Collegue collegueId);
	List<DeplacementPro> findByVehicule(VehiculeSociete id);
	
	List<DeplacementPro> findByVehiculeAndDateRestitutionAfter(VehiculeSociete id, LocalDate date);
	List<DeplacementPro> findByVehiculeAndDateRestitutionBefore(VehiculeSociete v, LocalDate date);
	
	
	
	
	
	
}
