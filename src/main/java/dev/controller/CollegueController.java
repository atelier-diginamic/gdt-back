package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.CollegueAddVm;
import dev.controller.vm.CollegueVM;
import dev.controller.vm.LieuVM;
import dev.domain.Collegue;
import dev.domain.Lieu;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.repository.CollegueRepo;

@RestController
@CrossOrigin
@RequestMapping("/collegue")
public class CollegueController {
	private CollegueRepo collegueRepo;

	public CollegueController(CollegueRepo collegueRepo) {
		this.collegueRepo = collegueRepo;
	}
	
	@GetMapping
	public List<Collegue> getAll() {
		return this.collegueRepo.findAll();
	}
	
	@GetMapping(params = "id")
	public ResponseEntity<?> getById(Long id) {
		Optional<Collegue> collegue = this.collegueRepo.findById(id);
		
		if (collegue.isPresent()) {
			return ResponseEntity.ok().body(collegue.get());
		} else {
			return ResponseEntity.badRequest().body("donnée invalide");
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> createCollegue(@Valid @RequestBody CollegueAddVm collegueAddVm, BindingResult resValid) {
		if (!resValid.hasErrors()) {	
			Collegue nouveauCollegue = new Collegue();
			nouveauCollegue.setNom(collegueAddVm.getNom());
			nouveauCollegue.setPrenom(collegueAddVm.getPrenom());
			nouveauCollegue.setEmail(collegueAddVm.getEmail());
			//nouveauCollegue.setMotDePasse(collegueAddVm.getMotDePasse());
			
	
			
			List<RoleCollegue>listRole=new ArrayList<RoleCollegue>();
			for (Role role : collegueAddVm.getRoles()) {
				listRole.add(new RoleCollegue(nouveauCollegue,role));
			}
			nouveauCollegue.setRoles(listRole);

			
			
			
			nouveauCollegue=this.collegueRepo.save(nouveauCollegue);
			

			return ResponseEntity.ok().body(new CollegueVM(nouveauCollegue));
		
		
		
		
		
		
		
		
		
		
		}else {
			return ResponseEntity.badRequest().body(resValid.getAllErrors());
		}
	}
	
}
