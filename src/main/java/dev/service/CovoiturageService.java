package dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.dto.AnnonceCovoiturageDtoRep;
import dev.dto.CovoiturageDtoQuery;
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
	 * 
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
	 * 
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
	
	/**
	 * listes les annonces par createur
	 * 
	 * @param id createur des annonces a rechercher
	 * @return une liste de AnnonceCovoiturageDtoRep
	 * @throws CollegueException 
	 */
	public Object annonces(Integer id) throws CollegueException {
		List<AnnonceCovoiturageDtoRep> list=new ArrayList<AnnonceCovoiturageDtoRep>();
		for (AnnonceCovoiturage ac : covRepo.findByCollegue(colServ.getEntityById(id))) {
			list.add(this.getDtoRep(ac));
		}
		return list;
	}

	/**
	 * enregistre une nouvelle entre dans la table annonce_covoiturage
	 * 
	 * @param cDtoQuery objet envoyer depuis une application exterieur
	 * @return un objet dto suite a l'enregistrement en bdd
	 */
	public Object add(CovoiturageDtoQuery cDtoQuery) {
		AnnonceCovoiturage ac = getEntity(cDtoQuery);
		return getDtoRep(covRepo.save(ac));
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

	protected AnnonceCovoiturage getEntity(CovoiturageDtoQuery cDtoQuery) {
		AnnonceCovoiturage ac = new AnnonceCovoiturage();

		if (cDtoQuery.getId() != null)
			ac.setId(cDtoQuery.getId());

		ac.setDate(cDtoQuery.getDate());
		ac.setDepart(cDtoQuery.getDepart());
		ac.setArrive(cDtoQuery.getArrive());
		ac.setHeureDepart(cDtoQuery.getHeureDepart());
		ac.setMarqueVoiture(cDtoQuery.getMarqueVoiture());
		ac.setModeleVoiture(cDtoQuery.getModeleVoiture());
		ac.setImageUrl(cDtoQuery.getImageUrl());
		ac.setPlace(cDtoQuery.getPlace());
		ac.setStatus(cDtoQuery.getStatus());
		try {
			ac.setCollegue(colServ.getEntityById(cDtoQuery.getCollegueId()));
			for (Integer i : cDtoQuery.getPassagersId()) {
				ac.getPassager().add(colServ.getEntityById(i));
			}
		} catch (CollegueException e) {
			e.printStackTrace();
		}
		return ac;
	}

}
