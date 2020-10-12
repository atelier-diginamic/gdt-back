package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.entity.AnnonceCovoiturage;
import dev.entity.Collegue;

public interface CovoiturageRepository extends JpaRepository<AnnonceCovoiturage, Integer>{

	List<AnnonceCovoiturage> findByCollegue(Collegue collegueEntity);

	List<AnnonceCovoiturage> findAllAnnonceCovoiturageByPassagerId(int idPassager);
	List<AnnonceCovoiturage> findAllAnnonceCovoiturageByPassagerIdNot(int idPassager);


}

