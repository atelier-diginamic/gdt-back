package dev.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.dto.CollegueDtoRep;
import dev.dto.CollegueDtoQuery;
import dev.entity.Collegue;
import dev.entity.RoleCollegue;
import dev.exception.CollegueException;
import dev.repository.CollegueRepository;
import enumeration.Role;

@Service
public class CollegueService {

	private CollegueRepository colRepo;
	private PasswordEncoder passwordEncoder;

	public CollegueService(CollegueRepository colRepo, PasswordEncoder passwordEncoder) {
		super();
		this.colRepo = colRepo;
		this.passwordEncoder = passwordEncoder;

	}

	public CollegueDtoRep edit(CollegueDtoQuery colDtoQ) throws CollegueException {
		if(colDtoQ.getId()!=null) {
			Collegue col =colRepo.save(this.getEntity(colDtoQ));
			return this.getDtoRep(col);
		}else {
			throw new CollegueException("l'id ne peux etre null");
		}
		
		
		
	}
	
	
	protected Collegue getEntityById(int id) throws CollegueException {
		Optional<Collegue> optCol= colRepo.findById(id);
		if(optCol.isPresent()) return optCol.get();
		else throw new CollegueException("Id non trouvée");
	}
	
	
	
	
	
	
//	transformation dto<-->entite

	protected CollegueDtoRep getDtoRep(Collegue c) {
		return new CollegueDtoRep(c);
	}

	protected Collegue getEntity(CollegueDtoQuery cQuery) {
		Collegue c = new Collegue();
		c.setEmail(cQuery.getEmail());
		c.setNom(cQuery.getNom());
		c.setPrenom(cQuery.getPrenom());
		for (Role role : cQuery.getRoles()) {
			c.getRoles().add(new RoleCollegue(c, role));
		}
		if (cQuery.getMotDePasse() != null)
			c.setMotDePasse(passwordEncoder.encode(cQuery.getMotDePasse()));
		return c;
	}

	







}
