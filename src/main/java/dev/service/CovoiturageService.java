package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.TODO;

import dev.controller.vm.CollegueVMResponce;
import dev.controller.vm.CovoiturageVM;
import dev.controller.vm.CovoiturageVmResponse;
import dev.domain.Collegue;
import dev.domain.Covoiturage;
import dev.domain.Vehicule;
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

	public CovoiturageVmResponse getById(Integer id) throws CovoitException {
		Optional<Covoiturage> optCovoit = covoitRepo.findById(id);
		if (optCovoit.isPresent()) {
			return covoiturageToVmResponse(optCovoit.get());
		} else {
			throw new CovoitException("id non trouver");
		}
	}
	
	public CovoiturageVmResponse add(CovoiturageVM covoitQuery) throws vehiculeException, CollegueException{
		Covoiturage newcovoit = covoitRepo.save(createEntity(covoitQuery));
		return covoiturageToVmResponse(newcovoit);
	}
	
	
	
	
	

	private CovoiturageVmResponse covoiturageToVmResponse(Covoiturage c) {

		CovoiturageVmResponse vmResponse = new CovoiturageVmResponse();
		vmResponse.setId(c.getId());
		vmResponse.setDate(c.getDate());
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
		covoit.setDepart(cVmQuery.getDepart());
		covoit.setDestination(cVmQuery.getDestination());
		covoit.setPassagers(new ArrayList<Collegue>());
		covoit.setVehicule(vehiculeServ.getEntityById(cVmQuery.getVehiculeId()));
		return covoit;
	}

}
