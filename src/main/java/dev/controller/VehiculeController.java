package dev.controller;

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

import dev.controller.vm.VehiculeVM;
import dev.controller.vm.VehiculeVMResponce;
import dev.domain.Vehicule;

import dev.repository.VehiculeRepo;
import dev.service.VehiculeService;

@RestController
@CrossOrigin
@RequestMapping("/vehicule")
public class VehiculeController {	
	private VehiculeService vehiculeSvr;
	
	public VehiculeController(VehiculeService vehiculeSvr) {
		this.vehiculeSvr = vehiculeSvr;
	}
	
	@GetMapping
	public List<VehiculeVMResponce> getAll() {
		return this.vehiculeSvr.getAll();
	}
	
//	@GetMapping(params= "id")
//	public ResponseEntity<?> getById(@RequestParam Integer id) {
//		Optional<Vehicule> vehicule = this.vehiculeRepo.findById(id);
//		
//		if(vehicule.isPresent()) {
//			return ResponseEntity.ok().body(vehicule.get());
//		} else {
//			return ResponseEntity.badRequest().body("donnée invalide");
//		}	
//	}
//	
//	// ajout d'un vehicule
//	@Transactional
//	@PostMapping
//	public ResponseEntity<?> createVehicule(@Valid @RequestBody VehiculeVM vehiculeVm, BindingResult resValid){
//		if (!resValid.hasErrors()) {
//			Vehicule nouveauVehicule = new Vehicule();
//			nouveauVehicule.setImmatriculation(vehiculeVm.getImmatriculation());
//			nouveauVehicule.setMarque(vehiculeVm.getMarque());
//			nouveauVehicule.setModel(vehiculeVm.getModel());
//			nouveauVehicule.setCategorie(vehiculeVm.getCategorie());
//			nouveauVehicule.setNbr_places(vehiculeVm.getNbr_places());
//			nouveauVehicule.setUrlImage(vehiculeVm.getUrlImage());
//			nouveauVehicule.setId(this.vehiculeRepo.save(nouveauVehicule).getId());
//			return ResponseEntity.ok().body(nouveauVehicule);
//		} else {
//			return ResponseEntity.badRequest().body(resValid.getAllErrors());
//		}
//	}
}
