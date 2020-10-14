package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.DeplacementProDtoQuery;
import dev.dto.DeplacementProDtoRep;
import dev.exception.ChauffeurException;
import dev.exception.CollegueException;
import dev.exception.DeplacementProException;
import dev.exception.vehiculeException;
import dev.service.DeplacementProService;

@RestController
@CrossOrigin
@RequestMapping("/deplacement-pro")
public class DeplacementProCtrl {

	private DeplacementProService dpServ;

	public DeplacementProCtrl(DeplacementProService dpServ) {
		super();
		this.dpServ = dpServ;
	}
	
	@GetMapping("/deplacement")
	public ResponseEntity<?> mesDeplacement (@RequestParam int id) {
			return ResponseEntity.ok().body(dpServ.getDeplacement(id));	
	}
	@GetMapping("/vehicule-reserve")
	public ResponseEntity<?> vehiculeReserve(@RequestParam int id) {
		try {
			return ResponseEntity.ok().body(dpServ.getReservationVehicule(id));
		} catch (vehiculeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
	
	@GetMapping("/vehicule-archive")
	public ResponseEntity<?> vehiculeArchive(@RequestParam int id) {
		try {
			return ResponseEntity.ok().body(dpServ.getArchiveVehicule(id));
		} catch (vehiculeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}	
	}
	
	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody DeplacementProDtoQuery dpQuery, BindingResult resValid){
		if(!resValid.hasErrors())
			try {
				return ResponseEntity.ok().body(dpServ.add(dpQuery));
			} catch (ChauffeurException | CollegueException | vehiculeException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		else return ResponseEntity.badRequest().body(resValid.getAllErrors());
	
	}
	
	@PutMapping("/passager")
	public ResponseEntity<?> addPassager(@RequestParam int idDeplacement,@RequestParam int idCollegue) {
		try {
			return ResponseEntity.ok().body(dpServ.addPassager(idDeplacement, idCollegue));
		} catch (DeplacementProException | CollegueException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	
}
