package dev.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.CollegueAddVm;
import dev.controller.vm.CovoiturageVM;
import dev.domain.Covoiturage;
import dev.repository.CovoiturageRepository;

@RestController
@CrossOrigin
@RequestMapping("/covoiturage")
public class CovoiturageController {

	private CovoiturageRepository covoitRepo;

	public CovoiturageController(CovoiturageRepository covoitRepo) {
		this.covoitRepo = covoitRepo;
	}

	@GetMapping
	public List<Covoiturage> getAll() {
		return covoitRepo.findAll();
	}

	@GetMapping(params = { "type", "value" })
	public ResponseEntity<?> getById(@RequestParam String type, String value) {

		List<Covoiturage> listCovoit = new ArrayList<Covoiturage>();
		Optional<Covoiturage> covoit = null;
		switch (type) {
		case "id":
			covoit = covoitRepo.findById(Integer.parseInt(value));
			if (covoit.isPresent())
				listCovoit.add(covoit.get());
			break;
		case "date":
			listCovoit = covoitRepo.findByDate(new Date(value));
			break;
		case "depart":
			listCovoit = covoitRepo.findByDepart(Integer.parseInt(value));
			break;
		case "destination":
			listCovoit = covoitRepo.findByDestination(Integer.parseInt(value));
			break;
		case "vehicule":
			listCovoit = covoitRepo.findByVehicule(Integer.parseInt(value));
			break;
		case "chauffeur":
			listCovoit = covoitRepo.findByChauffeur(Integer.parseInt(value));
			break;
		}

		return ResponseEntity.ok().body(listCovoit);

	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> createCovoiturage(@Valid @RequestBody CovoiturageVM covoiturageVM, BindingResult resValid) {
		if (!resValid.hasErrors()) {
			Covoiturage nouveauCovoiturage = new Covoiturage();
			nouveauCovoiturage.setDate(covoiturageVM.getDate());
			nouveauCovoiturage.setDepart(covoiturageVM.getDepart());
			nouveauCovoiturage.setDestination(covoiturageVM.getDestination());;
			nouveauCovoiturage.setChauffeur(covoiturageVM.getChauffeur());
			nouveauCovoiturage.setPassagers(covoiturageVM.getPassagers());
			nouveauCovoiturage = this.covoitRepo.save(nouveauCovoiturage);
			CovoiturageVM covoiturageResponse = new CovoiturageVM(nouveauCovoiturage);
			return ResponseEntity.ok().body(covoiturageResponse);
		} else {
			return ResponseEntity.badRequest().body(resValid.getAllErrors());
		}
	}

}
