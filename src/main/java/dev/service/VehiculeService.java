package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.controller.vm.VehiculeVM;
import dev.controller.vm.VehiculeVMResponse;
import dev.domain.Vehicule;
import dev.exception.vehiculeException;
import dev.repository.VehiculeRepo;

@Service
public class VehiculeService {

	private VehiculeRepo vehiculeRepo;

	public VehiculeService(VehiculeRepo vehiculeRepo) {
		this.vehiculeRepo = vehiculeRepo;
	}

	public List<VehiculeVMResponse> getAll() {
		List<VehiculeVMResponse> list = new ArrayList<VehiculeVMResponse>();
		for (Vehicule v : vehiculeRepo.findAll()) {
			list.add(getVehiculeVmResponse(v));
		}
		return list;
	}

	public List<VehiculeVMResponse> getBy(String type, String value) throws vehiculeException {
		List<VehiculeVMResponse> list = new ArrayList<VehiculeVMResponse>();
		switch (type) {
		case "id":
			Optional<Vehicule> v = vehiculeRepo.findById(Integer.parseInt(value));
			if (v.isPresent())
				list.add(getVehiculeVmResponse(v.get()));
			else
				throw new vehiculeException("erreur id inconu !");
			break;
		case "marque":
			for (Vehicule v2 : vehiculeRepo.findByMarque(value)) {
				list.add(getVehiculeVmResponse(v2));
			}
			break;
		case "model":
			for (Vehicule v3 : vehiculeRepo.findByModel(value)) {
				list.add(getVehiculeVmResponse(v3));
			}
			break;
		case "categorie":
			for (Vehicule v4 : vehiculeRepo.findBycategorie(value)) {
				list.add(getVehiculeVmResponse(v4));
			}
			break;
		}

		return list;
	}

	
	public VehiculeVMResponse add(VehiculeVM vehicumeVm) {
		Vehicule nouveau=createEntity(vehicumeVm);
		return getVehiculeVmResponse(vehiculeRepo.save(nouveau));
	}
	
	
	
	
	
	
	
	
	
	
//methodes prive de la class
	private VehiculeVMResponse getVehiculeVmResponse(Vehicule v) {
		VehiculeVMResponse VmResponse = new VehiculeVMResponse();
		VmResponse.setCategorie(v.getCategorie());
		VmResponse.setId(v.getId());
		VmResponse.setImmatriculation(v.getImmatriculation());
		VmResponse.setMarque(v.getMarque());
		VmResponse.setModel(v.getModel());
		VmResponse.setNbr_places(v.getNbr_places());
		VmResponse.setUrlImage(v.getUrlImage());
		return VmResponse;
	}
	
	private Vehicule createEntity(VehiculeVM vVm) {
		Vehicule v=new Vehicule();
		v.setCategorie(vVm.getCategorie());
		v.setImmatriculation(vVm.getImmatriculation());
		v.setMarque(vVm.getMarque());
		v.setModel(vVm.getModel());
		v.setNbr_places(vVm.getNbr_places());
		v.setUrlImage(vVm.getUrlImage());
		return v;
	}

}
