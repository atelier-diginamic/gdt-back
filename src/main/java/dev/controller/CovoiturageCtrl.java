package dev.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.AnnonceCovoiturageDtoRep;
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
	
	@GetMapping("/reservation")
	public ResponseEntity<List<AnnonceCovoiturageDtoRep>> getReservations(@RequestParam int id) {
		return ResponseEntity.ok().body(covServ.getReservations(id));	
	}
	
	@GetMapping("/no-reservation")
	public ResponseEntity<List<AnnonceCovoiturageDtoRep>> getReservationsNot(@RequestParam int id) {
		return ResponseEntity.ok().body(covServ.getReservationsNot(id));	
	}
	
	
	
	
}
