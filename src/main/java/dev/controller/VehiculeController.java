package dev.controller;

import java.util.ArrayList;
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
import dev.controller.vm.VehiculeVMResponse;
import dev.domain.Vehicule;
import dev.exception.vehiculeException;
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
	public List<VehiculeVMResponse> getAll() {
		return this.vehiculeSvr.getAll();
	}

	@GetMapping(params = { "type", "value" })
	public List<VehiculeVMResponse> getBy(@RequestParam String type, String value) {
		List<VehiculeVMResponse> list=new ArrayList<VehiculeVMResponse>();
		try {
			list= vehiculeSvr.getBy(type, value);
		} catch (vehiculeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// ajout d'un vehicule

	@PostMapping
	public ResponseEntity<?> createVehicule(@Valid @RequestBody VehiculeVM vehiculeVm, BindingResult resValid){
		if (!resValid.hasErrors()) {
			return ResponseEntity.ok().body(vehiculeSvr.add(vehiculeVm));
		} else {
			return ResponseEntity.badRequest().body(resValid.getAllErrors());
		}
	}
}
