package dev.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.dto.DeplacementProDtoQuery;
import dev.dto.DeplacementProDtoRep;
import dev.dto.VehiculeInfoDto;
import dev.entity.Collegue;
import dev.entity.DeplacementPro;
import dev.entity.VehiculeSociete;
import dev.exception.ChauffeurException;
import dev.exception.CollegueException;
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

	/**
	 * liste les reservztion de vehicule pro de id
	 * 
	 * @param id
	 * @return
	 * @throws CollegueException
	 */
	public List<DeplacementProDtoRep> getDeplacement(int id) throws CollegueException {
		List<DeplacementProDtoRep> list = new ArrayList<DeplacementProDtoRep>();
		Collegue c = colServ.getEntityById(id);
		for (DeplacementPro dp : dpRepo.findByReserverPar(c)) {
			list.add(this.getDtoRep(dp));
		}
		return list;
	}

	/**
	 * liste les reservation de vehicule
	 * 
	 * @param id
	 * @return
	 * @throws vehiculeException
	 */
	public List<VehiculeInfoDto> getReservationVehicule(int id) throws vehiculeException {

		VehiculeSociete v = vehiculeServ.getEntityById(id);
		List<VehiculeInfoDto> list = new ArrayList<VehiculeInfoDto>();
		for (DeplacementPro dp : dpRepo.findByVehiculeAndDateRestitutionAfter(v, LocalDate.now().minusDays(1))) {
			list.add(new VehiculeInfoDto(dp.getDateEmprun(), dp.getHeureEmprun(), dp.getDateRestitution(),
					dp.getHeureRestitution(), vehiculeServ.getDtoRep(dp.getVehicule()),
					colServ.getDtoRep(dp.getReserverPar())));
		}
		return list;
	}

	/**
	 * recupere les informations des vehicule de sofiete reserver avant aujourd'hui
	 * 
	 * @param id vehivule rechercher
	 * @return un objet contenant les infos du vehivule
	 * @throws vehiculeException si l'id n'existe pas
	 */
	public List<VehiculeInfoDto> getArchiveVehicule(int id) throws vehiculeException {

		VehiculeSociete v = vehiculeServ.getEntityById(id);
		List<VehiculeInfoDto> list = new ArrayList<VehiculeInfoDto>();
		for (DeplacementPro dp : dpRepo.findByVehiculeAndDateRestitutionBefore(v, LocalDate.now())) {
			list.add(new VehiculeInfoDto(dp.getDateEmprun(), dp.getHeureEmprun(), dp.getDateRestitution(),
					dp.getHeureRestitution(), vehiculeServ.getDtoRep(dp.getVehicule()),
					colServ.getDtoRep(dp.getReserverPar())));
		}
		return list;
	}

	/**
	 * ajoute un depladement pro
	 * @param dpQuery
	 * @return
	 * @throws ChauffeurException
	 * @throws CollegueException
	 * @throws vehiculeException
	 */
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
		dpRep.setAvecChauffeur(dp.isAvecChauffeur());
		dpRep.setDateEmprun(dp.getDateEmprun());
		dpRep.setDateRestitution(dp.getDateRestitution());
		dpRep.setHeureEmprun(dp.getHeureEmprun());
		dpRep.setHeureRestitution(dp.getHeureRestitution());
		dpRep.setVehicule(vehiculeServ.getDtoRep(dp.getVehicule()));
		return dpRep;
	}

	protected DeplacementPro getEntity(DeplacementProDtoQuery dpQuery)
			throws ChauffeurException, CollegueException, vehiculeException {
		DeplacementPro dp = new DeplacementPro();
		if (dpQuery.getId() != null)
			dp.setId(dpQuery.getId());
		dp.setChauffeur(chauffeurServ.getEntityById(dpQuery.getChauffeurId()));
		dp.setAvecChauffeur(dpQuery.isAvecChauffeur());
		dp.setDateEmprun(dpQuery.getDateEmprun());
		dp.setDateRestitution(dpQuery.getDateRestitution());
		dp.setHeureEmprun(dpQuery.getHeureEmprun());
		dp.setHeureRestitution(dpQuery.getHeureRestiturion());
		dp.setReserverPar(colServ.getEntityById(dpQuery.getCollaborateurId()));
		dp.setVehicule(vehiculeServ.getEntityById(dpQuery.getVehiculeId()));
		return dp;
	}

}
