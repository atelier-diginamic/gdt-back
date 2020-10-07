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
import dev.service.LieuService;

@RestController
@CrossOrigin
@RequestMapping("/lieu")
public class LieuController {

	private LieuService lieuService;


	public LieuController(LieuService lieuService) {
		this.lieuService = lieuService;
	}

	@GetMapping
	public List<Lieu> getAll() {
		return lieuService.getAll();
	}

	@GetMapping(params = "id")
	public ResponseEntity<?> getById(@RequestParam Integer id) {
		return this.lieuService.getById(id);
	}
	
	//ajout
	@PostMapping
	public ResponseEntity<?> createLieu(@Valid @RequestBody LieuVM lieuVM, BindingResult resValid) {
		return this.lieuService.createLieu(lieuVM, resValid);			
	}
	
	

}
