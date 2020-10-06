package dev.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.vm.CollegueAddVm;
import dev.controller.vm.CollegueVM;
import dev.domain.Collegue;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.repository.CollegueRepo;

@RestController
@CrossOrigin
@RequestMapping("/collegue")
public class CollegueController {
	private CollegueRepo collegueRepo;
	private PasswordEncoder passwordEncoder;

	public CollegueController(CollegueRepo collegueRepo, PasswordEncoder passwordEncoder) {
		this.collegueRepo = collegueRepo;
		this.passwordEncoder = passwordEncoder;
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
			nouveauCollegue.setMotDePasse(this.passwordEncoder.encode(collegueAddVm.getMotDePasse()));
			List<RoleCollegue> listeRoleCollegues = new ArrayList<RoleCollegue>();
			for (Role role : collegueAddVm.getRoles()) {
				listeRoleCollegues.add(new RoleCollegue(nouveauCollegue, role));
			}
			nouveauCollegue.setRoles(listeRoleCollegues);
			nouveauCollegue = this.collegueRepo.save(nouveauCollegue);
			CollegueVM collegueVm = new CollegueVM(nouveauCollegue);

			return ResponseEntity.ok().body(collegueVm);

		} else {
			return ResponseEntity.badRequest().body(resValid.getAllErrors());
		}
	}

}
