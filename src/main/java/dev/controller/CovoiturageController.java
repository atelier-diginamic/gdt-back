package dev.controller;

import java.util.List;

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

import dev.controller.vm.CovoiturageVM;
import dev.controller.vm.CovoiturageVmResponse;
import dev.exception.CollegueException;
import dev.exception.CovoitException;
import dev.exception.vehiculeException;
import dev.service.CovoiturageService;

@RestController
@CrossOrigin
@RequestMapping("/covoiturages")
public class CovoiturageController {

	private CovoiturageService covoitServ;

	public CovoiturageController(CovoiturageService covoitServ) {
		this.covoitServ = covoitServ;
	}

	@GetMapping
	public List<CovoiturageVmResponse> getAll() {
		return covoitServ.getAll();
	}
	
	
	
	@GetMapping(params = {"type","value"})
	public List<CovoiturageVmResponse> getBy(@RequestParam String type, @RequestParam String value) {
		try {
			return covoitServ.getBy(type, value);
		} catch (CovoitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> createCovoiturage(@Valid @RequestBody CovoiturageVM covoiturageVM, BindingResult resValid) {
		if (!resValid.hasErrors()) {
			try {
				return ResponseEntity.ok().body(covoitServ.add(covoiturageVM));
			} catch (vehiculeException | CollegueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			return ResponseEntity.badRequest().body(resValid.getAllErrors());
		}
		return null;
	}
	
	
	
	
	
//
//	@GetMapping(params = { "type", "value" })
//	public ResponseEntity<?> getById(@RequestParam String type, String value) {
//
//		List<Covoiturage> listCovoit = new ArrayList<Covoiturage>();
//		Optional<Covoiturage> covoit = null;
//		switch (type) {
//		case "id":
//			covoit = covoitRepo.findById(Integer.parseInt(value));
//			if (covoit.isPresent())
//				listCovoit.add(covoit.get());
//			break;
//		case "date":
//			listCovoit = covoitRepo.findByDate(new Date(value));
//			break;
//		case "depart":
//			listCovoit = covoitRepo.findByDepart(Integer.parseInt(value));
//			break;
//		case "destination":
//			listCovoit = covoitRepo.findByDestination(Integer.parseInt(value));
//			break;
//		case "vehicule":
//			listCovoit = covoitRepo.findByVehicule(Integer.parseInt(value));
//			break;
//		case "chauffeur":
//			listCovoit = covoitRepo.findByChauffeur(Integer.parseInt(value));
//			break;
//		}
//
//		return ResponseEntity.ok().body(listCovoit);
//
//	}
//	
//	@PostMapping
//	@Transactional
//	public ResponseEntity<?> createCovoiturage(@Valid @RequestBody CovoiturageVM covoiturageVM, BindingResult resValid) {
//		if (!resValid.hasErrors()) {
//			Covoiturage nouveauCovoiturage = new Covoiturage();
//			nouveauCovoiturage.setDate(covoiturageVM.getDate());
//			nouveauCovoiturage.setDepart(covoiturageVM.getDepart());
//			nouveauCovoiturage.setDestination(covoiturageVM.getDestination());
//			nouveauCovoiturage.setChauffeur(covoiturageVM.getChauffeur());
//			nouveauCovoiturage.setPassagers(covoiturageVM.getPassagers());
//			nouveauCovoiturage = this.covoitRepo.save(nouveauCovoiturage);
//			CovoiturageVM covoiturageResponse = new CovoiturageVM(nouveauCovoiturage);
//			return ResponseEntity.ok().body(covoiturageResponse);
//		} else {
//			return ResponseEntity.badRequest().body(resValid.getAllErrors());
//		}
//	}

}
