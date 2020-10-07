package dev.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
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

import dev.controller.vm.CollegueVMQuerry;
import dev.controller.vm.CollegueVMResponce;
import dev.exception.CollegueException;
import dev.service.CollegueService;

@RestController
@CrossOrigin
@RequestMapping("/collegue")
public class CollegueController {
	private CollegueService colServ;

	public CollegueController(CollegueService colServ) {
		this.colServ = colServ;
	}

	@GetMapping
	public List<CollegueVMResponce> getAll() {
		return this.colServ.getAll();
	}

	@GetMapping(params = {"type", "value"})
	public ResponseEntity<?>getBy(@RequestParam String type, @RequestParam String value) {
		try {
			return ResponseEntity.ok().body(colServ.getBy(type, value));
		} catch (CollegueException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> createCollegue(@Valid @RequestBody CollegueVMQuerry collegueAddVm, BindingResult resValid) {
		if (!resValid.hasErrors()) {
			return ResponseEntity.ok().body(colServ.add(collegueAddVm));
		} else {
			return ResponseEntity.badRequest().body(resValid.getAllErrors());
		}
		
	}

}
