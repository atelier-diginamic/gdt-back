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

import dev.controller.vm.VehiculeVM;
import dev.domain.Vehicule;

import dev.service.VehiculeService;

@RestController
@CrossOrigin
@RequestMapping("/vehicule")
public class VehiculeController {	
	private VehiculeService vehiculeService;
	
	
	public VehiculeController(VehiculeService vehiculeService) {
		this.vehiculeService = vehiculeService;
	}

	@GetMapping
	public List<Vehicule> getAll() {
		return this.vehiculeService.getAll();
	}
	
	@GetMapping(params= "id")
	public ResponseEntity<?> getById(@RequestParam Integer id) {
		return this.vehiculeService.getById(id);
	}
	
	// ajout d'un vehicule
	@Transactional
	@PostMapping
	public ResponseEntity<?> createVehicule(@Valid @RequestBody VehiculeVM vehiculeVm, BindingResult resValid) {
		return this.vehiculeService.createVehicule(vehiculeVm, resValid);
	}
}
