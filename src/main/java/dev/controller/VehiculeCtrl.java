package dev.controller;

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

import dev.dto.VehiculeSocieteDto;
import dev.exception.vehiculeException;
import dev.service.VehiculeService;

@RestController
@CrossOrigin
@RequestMapping("/vehicule")
public class VehiculeCtrl {

	private VehiculeService vehiculeServ;

	public VehiculeCtrl(VehiculeService vehiculeServ) {
		super();
		this.vehiculeServ = vehiculeServ;
	}
	
	@GetMapping
	public ResponseEntity<?> getVehicule(){
		return ResponseEntity.ok().body(vehiculeServ.getAll());
	}
	
	@GetMapping(params = {"type", "value"})
	public ResponseEntity<?> getVehiculeBy(@RequestParam String type,@RequestParam String value){
		return ResponseEntity.ok().body(vehiculeServ.getby(type, value));
	}
	
	@GetMapping(params = "id")
	public ResponseEntity<?> getVehiculeById(@RequestParam Integer id){
		try {
			return ResponseEntity.ok().body(vehiculeServ.getbyId(id));
		} catch (vehiculeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody VehiculeSocieteDto vDto, BindingResult resVal) {
		if(!resVal.hasErrors()) {
			return ResponseEntity.ok().body(vehiculeServ.edit(vDto));
		}
		else {
			return ResponseEntity.badRequest().body(resVal.getAllErrors());
		}
	}
	
	@PutMapping
	public ResponseEntity<?> edit(@Valid @RequestBody VehiculeSocieteDto vDto, BindingResult resVal) {
		if(!resVal.hasErrors()) {
			return ResponseEntity.ok().body(vehiculeServ.edit(vDto));
		}
		else {
			return ResponseEntity.badRequest().body(resVal.getAllErrors());
		}
	}
	
}
