package dev.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entity.AnnonceCovoiturage;
import dev.entity.Collegue;

public interface CovoiturageRepository extends JpaRepository<AnnonceCovoiturage, Integer>{

	List<AnnonceCovoiturage> findByCollegue(Collegue collegueEntity);

	List<AnnonceCovoiturage> findAllAnnonceCovoiturageByPassagerId(int idPassager);
	List<AnnonceCovoiturage> findAllAnnonceCovoiturageByPassagerIdNot(int idPassager);

	List<AnnonceCovoiturage> findByDepart(String depart);

	List<AnnonceCovoiturage> findByArrive(String arrive);

	List<AnnonceCovoiturage> findByDate(LocalDate date);

	List<AnnonceCovoiturage> findByDepartAndArriveAndDate(String depart, String arrive, LocalDate parse);


}

