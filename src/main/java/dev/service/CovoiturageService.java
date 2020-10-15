package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.dto.AnnonceCovoiturageDtoQuery;
import dev.dto.AnnonceCovoiturageDtoRep;
import dev.entity.AnnonceCovoiturage;
import dev.entity.Collegue;
import dev.exception.CollegueException;
import dev.exception.CovoitException;
import dev.exception.CovoiturageException;
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
		List<AnnonceCovoiturageDtoRep> list = new ArrayList<AnnonceCovoiturageDtoRep>();
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
	public Object add(AnnonceCovoiturageDtoQuery acDtoQuery) {
		AnnonceCovoiturage ac = getEntity(acDtoQuery);
		return getDtoRep(covRepo.save(ac));
	}

	/**
	 * editer un covoiturage
	 * 
	 * @param acDtoQuery dto de requete du covoiturage a modifier
	 * @return un objet dto d'annonce de covoiturage
	 */
	public AnnonceCovoiturageDtoRep edit(AnnonceCovoiturageDtoQuery acDtoQuery) {
		AnnonceCovoiturage ac = this.getEntity(acDtoQuery);
		return this.getDtoRep(covRepo.save(ac));
	}

	/**
	 * supprime un covoiturage
	 * 
	 * @param id id du covoiturage a supprimer
	 * @return
	 * @throws CovoiturageException
	 */
	public List<AnnonceCovoiturageDtoRep> delete(int id) throws CovoiturageException {
		Optional<AnnonceCovoiturage> ac = covRepo.findById(id);
		if (ac.isPresent()) {
			covRepo.delete(ac.get());
			List<AnnonceCovoiturageDtoRep> list = new ArrayList<AnnonceCovoiturageDtoRep>();
			for (AnnonceCovoiturage ac2 : covRepo.findAll()) {
				list.add(this.getDtoRep(ac2));
			}
			return list;
		} else
			throw new CovoiturageException("id covoiturage non trouvé");
	}

	/**
	 * ajoute un passager a un covoiturage
	 * 
	 * @param idCovoit
	 * @param idCollegue
	 * @return
	 * @return
	 * @throws CovoitException
	 * @throws CollegueException
	 * @throws CovoitException
	 */
	public AnnonceCovoiturageDtoRep addPassager(int idCovoit, int idCollegue)
			throws CovoitException, CollegueException, CovoitException {
		AnnonceCovoiturage ac = this.getEntityById(idCovoit);
		Collegue c = colServ.getEntityById(idCollegue);
		if (ac.getPassager().size() < ac.getPlace()) {
			if (!ac.getPassager().contains(c)) {
				ac.getPassager().add(c);
				return this.getDtoRep(covRepo.save(ac));
			} else {
				throw new CovoitException("ajout impossible ! est deja passager");
			}
		} else {
			throw new CovoitException("ajout impossible. plus de place !");
		}
	}

	/**
	 * retire un pasager d'un covoiturage
	 * 
	 * @param idCovoit
	 * @param idCollegue
	 * @return
	 * @throws CovoitException
	 * @throws CollegueException
	 */
	public AnnonceCovoiturageDtoRep remPassager(int idCovoit, int idCollegue)
			throws CovoitException, CollegueException {
		AnnonceCovoiturage ac = this.getEntityById(idCovoit);
		Collegue c = colServ.getEntityById(idCollegue);

		if (ac.getPassager().contains(c)) {
			ac.getPassager().remove(c);
			return this.getDtoRep(covRepo.save(ac));
		} else {
			throw new CovoitException("erreur : n'est pas passager");
		}
	}

	protected AnnonceCovoiturage getEntityById(int id) throws CovoitException {
		Optional<AnnonceCovoiturage> optAc = covRepo.findById(id);
		if (optAc.isPresent())
			return optAc.get();
		else
			throw new CovoitException("id de covoiturage non trouvée");
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

	protected AnnonceCovoiturage getEntity(AnnonceCovoiturageDtoQuery acDtoQuery) {
		AnnonceCovoiturage ac = new AnnonceCovoiturage();

		if (acDtoQuery.getId() != null)
			ac.setId(acDtoQuery.getId());

		ac.setDate(acDtoQuery.getDate());
		ac.setDepart(acDtoQuery.getDepart());
		ac.setArrive(acDtoQuery.getArrive());
		ac.setHeureDepart(acDtoQuery.getHeureDepart());
		ac.setMarqueVoiture(acDtoQuery.getMarqueVoiture());
		ac.setModeleVoiture(acDtoQuery.getModeleVoiture());
		ac.setImageUrl(acDtoQuery.getImageUrl());
		ac.setPlace(acDtoQuery.getPlace());
		ac.setStatus(acDtoQuery.getStatus());
		try {
			ac.setCollegue(colServ.getEntityById(acDtoQuery.getCollegueId()));
			for (Integer i : acDtoQuery.getPassagersId()) {
				ac.getPassager().add(colServ.getEntityById(i));
			}
		} catch (CollegueException e) {
			e.printStackTrace();
		}
		return ac;

	}

}
