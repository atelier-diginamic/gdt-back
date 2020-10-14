package dev.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.AnnonceCovoiturageDtoQuery;
import dev.exception.CollegueException;
import dev.exception.CovoiturageException;
import dev.service.CovoiturageService;

@RestController
@CrossOrigin
@RequestMapping("/covoiturage")
public class CovoiturageCtrl {

	private CovoiturageService covServ;

	public CovoiturageCtrl(CovoiturageService covServ) {
		super();
		this.covServ = covServ;
	}
	//@GetMapping(params = lieuDepart)
	
	@GetMapping("/reservation")
	public ResponseEntity<?> getReservations(@RequestParam int id) {
		return ResponseEntity.ok().body(covServ.getReservations(id));
	}

	@GetMapping("/no-reservation")
	public ResponseEntity<?> getReservationsNot(@RequestParam int id) {
		return ResponseEntity.ok().body(covServ.getReservationsNot(id));
	}

	@GetMapping("/annonce-covoiturage")
	public ResponseEntity<?> getAnnonces(@RequestParam Integer id) {
		try {
			return ResponseEntity.ok().body(covServ.annonces(id));
		} catch (CollegueException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody AnnonceCovoiturageDtoQuery acDtoQuery, BindingResult resVal) {

		if (!resVal.hasErrors()) {
			return ResponseEntity.ok().body(covServ.add(acDtoQuery));
		} else {
			return ResponseEntity.badRequest().body(resVal.getAllErrors());
		}
	}

	@PutMapping
	public ResponseEntity<?> edit(@Valid @RequestBody AnnonceCovoiturageDtoQuery acDtoQuery, BindingResult resVal) {
		if (!resVal.hasErrors()) {
			return ResponseEntity.ok().body(covServ.edit(acDtoQuery));
		} else {
			return ResponseEntity.badRequest().body(resVal.getAllErrors());
		}
	}

	@DeleteMapping(params = "id")
	public ResponseEntity<?> delete(@RequestParam int id) {
		try {
			return ResponseEntity.ok().body(covServ.delete(id));
		} catch (CovoiturageException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
