package dev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.service.CollegueService;
import enumeration.Role;

@RestController
@CrossOrigin
@RequestMapping("/collegue")
public class CollegueCtrl {

	private CollegueService colServ;

	public CollegueCtrl(CollegueService colServ) {
		this.colServ = colServ;
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok().body(colServ.getAll());
	}
	@GetMapping("/is")
	public ResponseEntity<?> is(@RequestParam String role){
		return ResponseEntity.ok().body(colServ.is(Role.valueOf(role)));
	}
	@GetMapping("/isNot")
	public ResponseEntity<?> isNot(@RequestParam String role){
		return ResponseEntity.ok().body(colServ.isNot(Role.valueOf(role)));
	}
	
	
	
	
	
}
