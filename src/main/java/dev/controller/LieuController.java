package dev.controller;

import java.util.List;
import java.util.Optional;

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

import dev.controller.vm.LieuVM;
import dev.domain.Lieu;
import dev.repository.LieuRepository;

@RestController
@CrossOrigin
@RequestMapping("/lieu")
public class LieuController {

	private LieuRepository lieuRepo;

	public LieuController(LieuRepository lieuRepo) {
		this.lieuRepo = lieuRepo;
	}

	@GetMapping
	public List<Lieu> getAll() {
		return lieuRepo.findAll();
	}

	@GetMapping(params = "id")
	public ResponseEntity<?> getById(@RequestParam Integer id) {
		Optional<Lieu> lieu = lieuRepo.findById(id);

		if (lieu.isPresent()) {
			return ResponseEntity.ok().body(lieu.get());
		} else {
			return ResponseEntity.badRequest().body("donnée invalide");
		}
	}
	
	//ajout
	@PostMapping
	public ResponseEntity<?> createLieu(@Valid @RequestBody LieuVM lieuVM, BindingResult resValid) {
		if (!resValid.hasErrors()) {
			Lieu nouveauLieu = new Lieu();
			nouveauLieu.setLibelle(lieuVM.getLibelle());
			nouveauLieu.setNumero(lieuVM.getNumero());
			nouveauLieu.setVoie(lieuVM.getVoie());
			nouveauLieu.setAdresse(lieuVM.getAdresse());
			nouveauLieu.setCode_postal(lieuVM.getCode_postal());
			nouveauLieu.setVille(lieuVM.getVille());
			nouveauLieu.setCoordonnee(lieuVM.getCoordonnee());
			nouveauLieu.setId(lieuRepo.save(nouveauLieu).getId());
			return ResponseEntity.ok().body(nouveauLieu);
		}else {
			return ResponseEntity.badRequest().body(resValid.getAllErrors());
		}		
	}
	
	

}
