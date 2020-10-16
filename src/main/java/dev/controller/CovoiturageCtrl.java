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
import dev.exception.CovoitException;
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

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(covServ.getAll());
	}

	@GetMapping(params = { "type", "value" })
	public ResponseEntity<?> getBy(@RequestParam String type, @RequestParam String value) {
		return ResponseEntity.ok().body(covServ.getBy(type, value));
	}

	@GetMapping(params = { "depart", "arrive", "date" })
	public ResponseEntity<?> search(@RequestParam String depart, @RequestParam String arrive, @RequestParam String date) {
		return ResponseEntity.ok().body(covServ.search(depart, arrive,date));
	}
	
	@GetMapping("/reservation")
	public ResponseEntity<?> getReservations(@RequestParam int id) {
		return ResponseEntity.ok().body(covServ.getReservations(id));
	}

	@PutMapping("/reservation")
	public ResponseEntity<?> addPassager(@RequestParam int idCovoit, @RequestParam int idCollegue) {
		try {
			return ResponseEntity.ok().body(covServ.addPassager(idCovoit, idCollegue));
		} catch (CovoitException | CollegueException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}

	@PutMapping("/annulation")
	public ResponseEntity<?> annulerPassager(@RequestParam int idCovoit, @RequestParam int idCollegue) {
		try {
			return ResponseEntity.ok().body(covServ.remPassager(idCovoit, idCollegue));
		} catch (CovoitException | CollegueException e) {
			return ResponseEntity.badRequest().body(e.getMessage());

		}
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
