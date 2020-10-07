package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.controller.vm.VehiculeVMResponce;
import dev.domain.Vehicule;
import dev.exception.vehiculeException;
import dev.repository.VehiculeRepo;

@Service
public class VehiculeService {

	private VehiculeRepo vehiculeRepo;

	public VehiculeService(VehiculeRepo vehiculeRepo) {
		this.vehiculeRepo = vehiculeRepo;
	}
	
	public List<VehiculeVMResponce> getAll() {
		List<VehiculeVMResponce> list=new ArrayList<VehiculeVMResponce>();
		for (Vehicule v : vehiculeRepo.findAll()) {
			list.add(getVehiculeVmResponse(v));
		}
		return list;
	}
	
	
	VehiculeVMResponce getById(Integer id) throws vehiculeException{
		Optional<Vehicule> v=vehiculeRepo.findById(id);
		if(v.isPresent()) {
			return getVehiculeVmResponse(v.get());
		}else {
			throw new vehiculeException("erreur");
		}		
	}
	
	
	
	private VehiculeVMResponce getVehiculeVmResponse(Vehicule v) {
		VehiculeVMResponce VmResponse= new VehiculeVMResponce();
		VmResponse.setCategorie(v.getCategorie());
		VmResponse.setId(v.getId());
		VmResponse.setImmatriculation(v.getImmatriculation());
		VmResponse.setMarque(v.getMarque());
		VmResponse.setModel(v.getModel());
		VmResponse.setNbr_places(v.getNbr_places());
		VmResponse.setUrlImage(v.getUrlImage());
		return VmResponse;
	}
	
	
}
