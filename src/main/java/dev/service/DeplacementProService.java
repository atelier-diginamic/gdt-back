package dev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import dev.dto.AnnonceCovoiturageDtoQuery;
import dev.dto.DeplacementProDtoQuery;
import dev.dto.DeplacementProDtoRep;
import dev.dto.VehiculeReserveDto;
import dev.entity.AnnonceCovoiturage;
import dev.entity.Collegue;
import dev.entity.DeplacementPro;
import dev.entity.VehiculeSociete;
import dev.exception.ChauffeurException;
import dev.exception.CollegueException;
import dev.exception.DeplacementProException;
import dev.exception.vehiculeException;
import dev.repository.DeplacementProRepository;

@Service
public class DeplacementProService {

	private DeplacementProRepository dpRepo;
	private CollegueService colServ;
	private ChauffeurService chauffeurServ;
	private VehiculeService vehiculeServ;

	public DeplacementProService(DeplacementProRepository dpRepo, CollegueService colServ,
			ChauffeurService chauffeurServ, VehiculeService vehiculeServ) {
		super();
		this.dpRepo = dpRepo;
		this.colServ = colServ;
		this.chauffeurServ = chauffeurServ;
		this.vehiculeServ = vehiculeServ;
	}

	public List<DeplacementProDtoRep> getDeplacement(int id) {
		List<DeplacementProDtoRep> list = new ArrayList<DeplacementProDtoRep>();
		for (DeplacementPro dp : dpRepo.findByReserverParId(id)) {
			list.add(this.getDtoRep(dp));
		}

		return list;
	}

	public List<VehiculeReserveDto> getReservationVehicule(int id) throws vehiculeException {

		VehiculeSociete v = vehiculeServ.getEntityById(id);
		List<VehiculeReserveDto> list = new ArrayList<VehiculeReserveDto>();
		for (DeplacementPro dp : dpRepo.findByVehiculeAndDateAfter(v, LocalDate.now().minusDays(1))) {
			list.add(new VehiculeReserveDto(dp.getDate(), dp.getHeureDepart(), vehiculeServ.getDtoRep(dp.getVehicule()),
					colServ.getDtoRep(dp.getReserverPar())));
		}
		return list;
	}

	/**
	 * recupere les informations des vehicule de sofiete reserver avant aujourd'hui
	 * @param id vehivule rechercher
	 * @return un objet contenant les infos du vehivule
	 * @throws vehiculeException si l'id n'existe pas
	 */
	public List<VehiculeReserveDto> getArchiveVehicule(int id) throws vehiculeException {

		VehiculeSociete v = vehiculeServ.getEntityById(id);
		List<VehiculeReserveDto> list = new ArrayList<VehiculeReserveDto>();
		for (DeplacementPro dp : dpRepo.findByVehiculeAndDateBefore(v, LocalDate.now())) {
			list.add(new VehiculeReserveDto(dp.getDate(), dp.getHeureDepart(), vehiculeServ.getDtoRep(dp.getVehicule()),
					colServ.getDtoRep(dp.getReserverPar())));
		}
		return list;
	}

	public DeplacementProDtoRep addPassager(int idDeplacement, int idCollegue)
			throws DeplacementProException, CollegueException {
		Optional<DeplacementPro> dpOpt = dpRepo.findById(idDeplacement);
		if (dpOpt.isPresent()) {
			DeplacementPro dp = dpOpt.get();
			Collegue col = colServ.getEntityById(idCollegue);
			if (!dp.getPassager().contains(col)) {
				dp.getPassager().add(col);
				return this.getDtoRep(dpRepo.save(dp));
			} else {
				throw new DeplacementProException("ce collegue est deja passager");
			}
		} else {
			throw new DeplacementProException("id deplacement pro introuvable !");
		}

	}

	public DeplacementProDtoRep add(DeplacementProDtoQuery dpQuery)
			throws ChauffeurException, CollegueException, vehiculeException {

		DeplacementPro dp = getEntity(dpQuery);

		return getDtoRep(dpRepo.save(dp));
	}

	// transformation dto<-->entite
	protected DeplacementProDtoRep getDtoRep(DeplacementPro dp) {
		DeplacementProDtoRep dpRep = new DeplacementProDtoRep();
		dpRep.setId(dp.getId());
		dpRep.setReserverPar(colServ.getDtoRep(dp.getReserverPar()));

		if (dp.getChauffeur() != null)
			dpRep.setChauffeur(chauffeurServ.getDtoRep(dp.getChauffeur()));

		dpRep.setDate(dp.getDate());
		dpRep.setDepart(dp.getDepart());
		dpRep.setDestination(dp.getDestination());
		dpRep.setHeureDepart(dp.getHeureDepart());

		dpRep.setVehicule(vehiculeServ.getDtoRep(dp.getVehicule()));
		for (Collegue col : dp.getPassager()) {
			dpRep.getPassager().add(colServ.getDtoRep(col));
		}
		return dpRep;
	}

	protected DeplacementPro getEntity(DeplacementProDtoQuery dpQuery)
			throws ChauffeurException, CollegueException, vehiculeException {
		DeplacementPro dp = new DeplacementPro();

		if (dpQuery.getId() != null)
			dp.setId(dpQuery.getId());

		dp.setChauffeur(chauffeurServ.getEntityById(dpQuery.getChauffeurId()));
		dp.setDate(dpQuery.getDate());
		dp.setDepart(dpQuery.getDepart());
		dp.setDestination(dpQuery.getDestination());
		dp.setHeureDepart(dpQuery.getHeureDepart());
		dp.setReserverPar(colServ.getEntityById(dpQuery.getReserverParId()));
		dp.setVehicule(vehiculeServ.getEntityById(dpQuery.getVehiculeId()));
		return dp;
	}

}
