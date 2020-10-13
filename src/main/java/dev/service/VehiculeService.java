package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import dev.dto.VehiculeSocieteDto;
import dev.entity.VehiculeSociete;
import dev.exception.vehiculeException;
import dev.repository.vehiculeRepository;
import enumeration.CategorieVehicule;
import enumeration.StatusVehicule;

@Service
public class VehiculeService {

	private vehiculeRepository vehiculeRepo;

	public VehiculeService(vehiculeRepository vehiculeRepo) {
		super();
		this.vehiculeRepo = vehiculeRepo;
	}

	public List<VehiculeSocieteDto> getAll() {
		System.err.println("tezst");
		List<VehiculeSocieteDto> list = new ArrayList<VehiculeSocieteDto>();
		for (VehiculeSociete v : vehiculeRepo.findAll()) {
			list.add(getDtoRep(v));
		}
		return list;
	}

	public VehiculeSocieteDto getbyId(Integer id) throws vehiculeException {
		Optional<VehiculeSociete> vOpt = vehiculeRepo.findById(id);
		if (vOpt.isPresent()) {
			return this.getDtoRep(vOpt.get());
		} else {
			throw new vehiculeException("id vehicule non trouvée");
		}
	}

	public List<VehiculeSocieteDto> getby(String type, String value) {
		System.err.println(type + " " + value);
		List<VehiculeSociete> list = null;
		switch (type) {
		case "marque":
			list = vehiculeRepo.findByMarque(value);
			break;
		case "modele":
			list = vehiculeRepo.findByModel(value);
			break;
		case "immatriculation":
			list = vehiculeRepo.findByImmatriculation(value);
			break;
		
		case "categorie":
			value = value.trim();
			value = value.replace(' ', '_');
			value = value.toUpperCase();
			list = vehiculeRepo.findByCategorie(CategorieVehicule.valueOf(value));
			break;

		}
		List<VehiculeSocieteDto> listDto = new ArrayList<VehiculeSocieteDto>();
		for (VehiculeSociete vDto : list) {
			listDto.add(this.getDtoRep(vDto));
		}
		return listDto;
	}

	public VehiculeSocieteDto edit(VehiculeSocieteDto vDto) {
		VehiculeSociete v = this.getEntity(vDto);
		return this.getDtoRep(vehiculeRepo.save(v));
	}

	protected VehiculeSociete getEntityById(int id) throws vehiculeException {
		Optional<VehiculeSociete> optV = vehiculeRepo.findById(id);
		if (optV.isPresent())
			return optV.get();
		else
			throw new vehiculeException("Id vehicule non trouvée");
	}

	// transformation dto<-->entite
	protected VehiculeSocieteDto getDtoRep(VehiculeSociete v) {
		VehiculeSocieteDto vDto = new VehiculeSocieteDto();
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

	protected VehiculeSociete getEntity(VehiculeSocieteDto vDto) {
		VehiculeSociete v = new VehiculeSociete();
		if (vDto.getId() != null)
			v.setId(vDto.getId());
		v.setImmatriculation(vDto.getImmatriculation());
		v.setCategorie(vDto.getCategorie());
		v.setImageUrl(vDto.getImageUrl());
		v.setMarque(vDto.getMarque());
		v.setModel(vDto.getModel());
		v.setPlaces(vDto.getPlaces());
		v.setStatus(vDto.getStatus());
		return v;
	}

}
