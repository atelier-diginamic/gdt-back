package dev.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import dev.controller.vm.VehiculeVM;
import dev.domain.Vehicule;
import dev.repository.VehiculeRepo;

@Service
public class VehiculeService {
	private VehiculeRepo vehiculeRepo;

	public VehiculeService(VehiculeRepo vehiculeRepo) {
		this.vehiculeRepo = vehiculeRepo;
	}

	public List<Vehicule> getAll() {
		return this.vehiculeRepo.findAll();
	}

	public ResponseEntity<?> getById(Integer id) {
		Optional<Vehicule> vehicule = this.vehiculeRepo.findById(id);

		if (vehicule.isPresent()) {
			return ResponseEntity.ok().body(vehicule.get());
		} else {
			return ResponseEntity.badRequest().body("donnée invalide");
		}
	}

	public ResponseEntity<?> createVehicule(@Valid VehiculeVM vehiculeVm, BindingResult resValid) {
		if (!resValid.hasErrors()) {
			Vehicule nouveauVehicule = new Vehicule();
			nouveauVehicule.setImmatriculation(vehiculeVm.getImmatriculation());
			nouveauVehicule.setMarque(vehiculeVm.getMarque());
			nouveauVehicule.setModel(vehiculeVm.getModel());
			nouveauVehicule.setCategorie(vehiculeVm.getCategorie());
			nouveauVehicule.setNbr_places(vehiculeVm.getNbr_places());
			nouveauVehicule.setUrlImage(vehiculeVm.getUrlImage());
			nouveauVehicule.setId(this.vehiculeRepo.save(nouveauVehicule).getId());
			return ResponseEntity.ok().body(nouveauVehicule);
		} else {
			return ResponseEntity.badRequest().body(resValid.getAllErrors());
		}
	}

}
