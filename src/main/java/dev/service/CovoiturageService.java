package dev.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.controller.vm.CollegueVMResponce;
import dev.controller.vm.CovoiturageVM;
import dev.controller.vm.CovoiturageVmResponse;
import dev.domain.Collegue;
import dev.domain.Covoiturage;
import dev.exception.CollegueException;
import dev.exception.CovoitException;
import dev.exception.vehiculeException;
import dev.repository.CovoiturageRepository;

@Service
public class CovoiturageService {

	private CovoiturageRepository covoitRepo;
	private VehiculeService vehiculeServ;
	private CollegueService colServ;

	public CovoiturageService(CovoiturageRepository covoitRepo, VehiculeService vehiculeServ, CollegueService colServ) {
		this.covoitRepo = covoitRepo;
		this.vehiculeServ = vehiculeServ;
		this.colServ = colServ;
	}

	public List<CovoiturageVmResponse> getAll() {

		List<CovoiturageVmResponse> list = new ArrayList<CovoiturageVmResponse>();
		for (Covoiturage c : covoitRepo.findAll()) {
			list.add(covoiturageToVmResponse(c));
		}
		return list;
	}

	public List<CovoiturageVmResponse> getBy(String type, String value) throws CovoitException {
		List<CovoiturageVmResponse> list = new ArrayList<CovoiturageVmResponse>();
		switch (type) {
		case "id":
			Optional<Covoiturage> cId = covoitRepo.findById(Integer.parseInt(value));
			if (cId.isPresent()) {
				list.add(covoiturageToVmResponse(cId.get()));
			} else {
				throw new CovoitException("id non trouver");
			}
			break;
		case "date":
			// format value : "yyyy-MM-dd"
			for (Covoiturage cDate : covoitRepo
					.findByDate(LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd")))) {
				list.add(covoiturageToVmResponse(cDate));
			}
			break;
		case "date-before":
			// format value : "yyyy-MM-dd HH:mm"
			for (Covoiturage cDateBefore : covoitRepo
					.findByDateBefore(LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd")))) {
				list.add(covoiturageToVmResponse(cDateBefore));
			}

			break;
		case "date-after":
			// format value : "yyyy-mm-dd"
			for (Covoiturage cDateAfter : covoitRepo
					.findByDateAfter(LocalDate.parse(value, DateTimeFormatter.ofPattern("yyyy-MM-dd")))) {
				list.add(covoiturageToVmResponse(cDateAfter));
			}

			break;
		case "depart":
			for (Covoiturage cDepart : covoitRepo.findByDepart(value)) {
				list.add(covoiturageToVmResponse(cDepart));
			}
			break;
		case "destination":
			for (Covoiturage cDestination : covoitRepo.findByDestination(value)) {
				list.add(covoiturageToVmResponse(cDestination));
			}
			break;
		case "vehicule":
			for (Covoiturage cVehicule : covoitRepo.findByVehicule(Integer.parseInt(value))) {
				list.add(covoiturageToVmResponse(cVehicule));
			}
			break;
		case "chauffeur":
			for (Covoiturage cChauffeur : covoitRepo.findByChauffeur(Long.parseLong(value))) {
				list.add(covoiturageToVmResponse(cChauffeur));
			}
			break;
		}
		return list;

	}

	public Covoiturage getEntityById(Integer id) throws CovoitException {
		Optional<Covoiturage> optCovoit = covoitRepo.findById(id);
		if (optCovoit.isPresent()) {
			return optCovoit.get();
		} else {
			throw new CovoitException("id non trouver");
		}
	}

	public CovoiturageVmResponse add(CovoiturageVM covoitQuery) throws vehiculeException, CollegueException {
		Covoiturage newcovoit = covoitRepo.save(createEntity(covoitQuery));
		return covoiturageToVmResponse(newcovoit);
	}

//	methodes privé de la classe

	private CovoiturageVmResponse covoiturageToVmResponse(Covoiturage c) {

		CovoiturageVmResponse vmResponse = new CovoiturageVmResponse();
		vmResponse.setId(c.getId());
		vmResponse.setDate(c.getDate());
		vmResponse.setHeureDepart(c.getHeureDepart());
		vmResponse.setHeureArrive(c.getHeureArriver());
		vmResponse.setDepart(c.getDepart());
		vmResponse.setDestination(c.getDestination());
		try {
			vmResponse.setVehicule(vehiculeServ.getById(c.getId()));
		} catch (vehiculeException e) {
			e.printStackTrace();
		}

		vmResponse.setChauffeur(colServ.collegueToVMResponse(c.getChauffeur()));

		List<CollegueVMResponce> listPassagerVm = new ArrayList<CollegueVMResponce>();
		for (Collegue col : c.getPassagers()) {
			listPassagerVm.add(colServ.collegueToVMResponse(col));
		}
		vmResponse.setPassagers(listPassagerVm);
		return vmResponse;
	}

	private Covoiturage createEntity(CovoiturageVM cVmQuery) throws vehiculeException, CollegueException {
		Covoiturage covoit = new Covoiturage();
		covoit.setChauffeur(colServ.getEntityById(cVmQuery.getChauffeurId()));
		covoit.setDate(cVmQuery.getDate());
		covoit.setHeureDepart(cVmQuery.getHeureDepart());
		covoit.setHeureArriver(cVmQuery.getHeureArrive());
		
		
		
		
		covoit.setDepart(cVmQuery.getDepart());
		covoit.setDestination(cVmQuery.getDestination());
		covoit.setPassagers(new ArrayList<Collegue>());
		covoit.setVehicule(vehiculeServ.getEntityById(cVmQuery.getVehiculeId()));
		return covoit;
	}

}
