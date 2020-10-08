package dev.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.controller.vm.CollegueVMQuerry;
import dev.controller.vm.CollegueVMResponce;
import dev.domain.Collegue;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.exception.CollegueException;
import dev.repository.CollegueRepo;

@Service
public class CollegueService {

	private CollegueRepo colRepo;
	private PasswordEncoder passwordEncoder;

	public CollegueService(CollegueRepo colRepo, PasswordEncoder passwordEncoder) {
		this.colRepo = colRepo;
		this.passwordEncoder = passwordEncoder;
	}

	public List<CollegueVMResponce> getAll() {

		List<CollegueVMResponce> list = new ArrayList<CollegueVMResponce>();
		for (Collegue collegue : colRepo.findAll()) {
			list.add(collegueToVMResponse(collegue));
		}
		return list;

	}
	public Collegue getEntityById(Long id) throws CollegueException {
		Optional<Collegue> optCol = colRepo.findById(id);
		if (optCol.isPresent())
			return optCol.get();
		else
			throw new CollegueException("id inconnu");
	}
	

	public List<CollegueVMResponce> getBy(String type, String value) throws CollegueException {
		List<CollegueVMResponce> list = new ArrayList<CollegueVMResponce>();
		switch (type) {
		case "id":
			Optional<Collegue> optCol = colRepo.findById(Long.parseLong(value));
			if (optCol.isPresent())
				list.add(collegueToVMResponse(optCol.get()));
			else
				throw new CollegueException("id inconnu");
			break;
		case "nom":
			for (Collegue collegue : colRepo.findByNom(value)) {
				list.add(collegueToVMResponse(collegue));
			}
			break;
		case "email":
			Optional<Collegue> optColEmail = colRepo.findByEmail(value);
			if (optColEmail.isPresent())
				list.add(collegueToVMResponse(optColEmail.get()));
			else
				throw new CollegueException("email inconnu");
			break;
		}

		return list;
	}

	public CollegueVMResponce add(CollegueVMQuerry colVMQ) {
		Collegue col=queryToEntity(colVMQ);
		return collegueToVMResponse(colRepo.save(col));
	}

	
	
	// methode de la class

	protected CollegueVMResponce collegueToVMResponse(Collegue collegue) {
		CollegueVMResponce cVMResponse = new CollegueVMResponce();
		cVMResponse.setId(collegue.getId());
		cVMResponse.setEmail(collegue.getEmail());
		cVMResponse.setNom(collegue.getNom());
		cVMResponse.setPrenom(collegue.getPrenom());
		cVMResponse.setRoles(
				collegue.getRoles().stream().map(roleCollegue -> roleCollegue.getRole()).collect(Collectors.toList()));
		return cVMResponse;

	}

	private Collegue queryToEntity(CollegueVMQuerry colVMQ) {
		Collegue newCol = new Collegue();
		newCol.setNom(colVMQ.getNom());
		newCol.setPrenom(colVMQ.getPrenom());
		newCol.setEmail(colVMQ.getEmail());
		newCol.setMotDePasse(passwordEncoder.encode(colVMQ.getMotDePasse()));
		List<RoleCollegue> listRoleCollegue = new ArrayList<RoleCollegue>();
		for (Role role : colVMQ.getRoles()) {			
			listRoleCollegue.add(new RoleCollegue(newCol, role));
		}
		newCol.setRoles(listRoleCollegue);
		return newCol;
	}


	
}
