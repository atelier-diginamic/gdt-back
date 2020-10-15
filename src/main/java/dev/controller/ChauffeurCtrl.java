package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
import dev.dto.ChauffeurDtoQuery;
import dev.exception.ChauffeurException;
import dev.exception.CollegueException;
import dev.service.ChauffeurService;

@RestController
@CrossOrigin
@RequestMapping("/chauffeur")
public class ChauffeurCtrl {

	private ChauffeurService chServ;

	public ChauffeurCtrl(ChauffeurService chServ) {
		this.chServ = chServ;
	}

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(chServ.getAll());
	}

	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody ChauffeurDtoQuery chQuery, BindingResult resVal) {
		if (!resVal.hasErrors()) {
			try {
				return ResponseEntity.ok().body(chServ.add(chQuery));
			} catch (CollegueException | ChauffeurException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		} else {
			return ResponseEntity.badRequest().body(resVal.getAllErrors());
		}
	}

}
