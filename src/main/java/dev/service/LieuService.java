package dev.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import dev.controller.vm.LieuVM;
import dev.domain.Lieu;
import dev.repository.LieuRepository;


@Service
public class LieuService {

	private LieuRepository lieuRepo;

	public LieuService(LieuRepository lieuRepo) {
		this.lieuRepo = lieuRepo;
	}

	public List<Lieu> getAll() {
		return this.lieuRepo.findAll();
	}

	public ResponseEntity<?> getById(Integer id) {
		Optional<Lieu> lieu = lieuRepo.findById(id);

		if (lieu.isPresent()) {
			return ResponseEntity.ok().body(lieu.get());
		} else {
			return ResponseEntity.badRequest().body("donnée lieu invalide");
		}
	}

	public ResponseEntity<?> createLieu(@Valid LieuVM lieuVM, BindingResult resValid) {
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
		} else {
			return ResponseEntity.badRequest().body(resValid.getAllErrors());
		}
	}

}
