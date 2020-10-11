package dev.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.dto.DeplacementProDtoRep;
import dev.dto.VehiculeSocieteDtoRep;
import dev.entity.Collegue;
import dev.entity.DeplacementPro;
import dev.entity.VehiculeSociete;
import dev.exception.CollegueException;
import dev.exception.vehiculeException;
import dev.repository.vehiculeRepository;

@Service
public class VehiculeService {

	private vehiculeRepository vehiculeRepo;

	public VehiculeService(vehiculeRepository vehiculeRepo) {
		super();
		this.vehiculeRepo = vehiculeRepo;
	}

	protected VehiculeSociete getEntityById(int id) throws vehiculeException {
		Optional<VehiculeSociete> optV = vehiculeRepo.findById(id);
		if (optV.isPresent())
			return optV.get();
		else
			throw new vehiculeException("Id vehicule non trouvée");
	}

	// transformation dto<-->entite
	protected VehiculeSocieteDtoRep getDtoRep(VehiculeSociete v) {
		VehiculeSocieteDtoRep vDto = new VehiculeSocieteDtoRep();
		vDto.setId(v.getId());
		vDto.setCategorie(v.getCategorie());
		vDto.setImageUrl(v.getImageUrl());
		vDto.setImmatriculation(v.getImmatriculation());
		vDto.setMarque(v.getMarque());
		vDto.setModel(v.getModel());
		vDto.setPlaces(v.getPlaces());
		vDto.setStatus(v.getStatus());
		return vDto;
	}

}
