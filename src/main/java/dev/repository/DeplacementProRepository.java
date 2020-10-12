package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.DeplacementPro;

public interface DeplacementProRepository extends JpaRepository<DeplacementPro, Integer>{

	List<DeplacementPro> findAllDeplacementProByPassagerId(int idPassager);
	int countByPassagerId(int id);
	List<DeplacementPro> findByReserverParId(int id);
	
	
}
