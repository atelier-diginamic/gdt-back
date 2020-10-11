package dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.dto.AnnonceCovoiturageDtoQuery;
import dev.dto.AnnonceCovoiturageDtoRep;
import dev.entity.AnnonceCovoiturage;
import dev.entity.Collegue;
import dev.exception.CollegueException;
import dev.repository.CovoiturageRepository;

@Service
public class CovoiturageService {

	private CovoiturageRepository covRepo;
	private CollegueService colServ;

	public CovoiturageService(CovoiturageRepository covRepo, CollegueService colServ) {
		super();
		this.covRepo = covRepo;
		this.colServ = colServ;
	}

	
	
	
	
	
	/**
	 * recherche les covoiturages ou l'id d'un collegue est passager
	 * @param id l'id du collegue a rechercher
	 * @return unt liste de dto annonceCovoiturage
	 */
	public List<AnnonceCovoiturageDtoRep> getReservations(int id) {
		List<AnnonceCovoiturageDtoRep> list = new ArrayList<AnnonceCovoiturageDtoRep>();
		for (AnnonceCovoiturage ac : covRepo.findAllAnnonceCovoiturageByPassagerId(id)) {
			list.add(getDtoRep(ac));
		}
		return list;
	}

	/**
	 * recherche les covoiturages ou l'id d'un collegue n'est pas passager
	 * @param id l'id du collegue a rechercher
	 * @return unt liste de dto annonceCovoiturage
	 */
	public List<AnnonceCovoiturageDtoRep> getReservationsNot(int id) {
		List<AnnonceCovoiturageDtoRep> list = new ArrayList<AnnonceCovoiturageDtoRep>();
		for (AnnonceCovoiturage ac : covRepo.findAllAnnonceCovoiturageByPassagerIdNot(id)) {
			list.add(getDtoRep(ac));
		}
		return list;
	}
	
	
	
//	transformation  Objet <--> Dto
	protected AnnonceCovoiturageDtoRep getDtoRep(AnnonceCovoiturage ac) {
		AnnonceCovoiturageDtoRep acRep = new AnnonceCovoiturageDtoRep();
		acRep.setId(ac.getId());
		acRep.setCollegue(colServ.getDtoRep(ac.getCollegue()));
		acRep.setDate(ac.getDate());
		acRep.setDepart(ac.getDepart());
		acRep.setArrive(ac.getArrive());
		acRep.setHeureDepart(ac.getHeureDepart());
		acRep.setMarqueVoiture(ac.getMarqueVoiture());
		acRep.setModeleVoiture(ac.getModeleVoiture());
		acRep.setImageUrl(ac.getImageUrl());
		acRep.setPlace(ac.getPlace());
		acRep.setStatus(ac.getStatus());
		for (Collegue c : ac.getPassager()) {
			acRep.getPassager().add(colServ.getDtoRep(c));
		}
		return acRep;
	}

	protected AnnonceCovoiturage getEntity(AnnonceCovoiturageDtoQuery acQuery) {
		AnnonceCovoiturage ac = new AnnonceCovoiturage();

		if (acQuery.getId() != null)
			ac.setId(acQuery.getId());

		ac.setDate(acQuery.getDate());
		ac.setDepart(acQuery.getDepart());
		ac.setArrive(acQuery.getArrive());
		ac.setHeureDepart(acQuery.getHeureDepart());
		ac.setMarqueVoiture(acQuery.getMarqueVoiture());
		ac.setModeleVoiture(acQuery.getModeleVoiture());
		ac.setImageUrl(acQuery.getImageUrl());
		ac.setPlace(acQuery.getPlace());
		ac.setStatus(acQuery.getStatus());
		try {
			ac.setCollegue(colServ.getEntityById(acQuery.getCollegueId()));
			for (Integer i : acQuery.getPassagersId()) {
				ac.getPassager().add(colServ.getEntityById(i));
			}
		} catch (CollegueException e) {
			e.printStackTrace();
		}
		return ac;
	}

}
