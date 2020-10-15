package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.dto.ChauffeurDtoQuery;
import dev.dto.ChauffeurDtoRep;
import dev.entity.Chauffeur;
import dev.entity.Collegue;
import dev.entity.RoleCollegue;
import dev.exception.ChauffeurException;
import dev.exception.CollegueException;
import dev.repository.ChauffeurRepository;
import dev.repository.RoleCollegueRepository;

@Service
public class ChauffeurService {

	private ChauffeurRepository chaufRepo;
	private CollegueService colServ;
	private RoleCollegueRepository rcRepo;

	public ChauffeurService(ChauffeurRepository chaufRepo, CollegueService colServ, RoleCollegueRepository rcRepo) {
		super();
		this.chaufRepo = chaufRepo;
		this.colServ = colServ;
		this.rcRepo=rcRepo;
	}

	public List<ChauffeurDtoRep> getAll() {
		List<ChauffeurDtoRep> list = new ArrayList<ChauffeurDtoRep>();
		for (Chauffeur ch : chaufRepo.findAll()) {
			list.add(this.getDtoRep(ch));
		}
		return list;
	}

	@Transactional
	public ChauffeurDtoRep add(ChauffeurDtoQuery chQuery) throws CollegueException, ChauffeurException {
		Chauffeur ch = this.getEntity(chQuery);
		List<enumeration.Role> listRole=ch.getInfo().getRoles().stream().map(roleCollegue -> roleCollegue.getRole()).collect(Collectors.toList());
		if (listRole.contains(enumeration.Role.ROLE_CHAUFFEUR)) {
			throw new ChauffeurException("ce collegue est deja chauffeur");
		} else {
			rcRepo.save(new RoleCollegue(ch.getInfo(),enumeration.Role.ROLE_CHAUFFEUR));
		}
		chaufRepo.save(ch);
		return this.getDtoRep(ch);
	}

	protected Chauffeur getEntityById(Integer id) throws ChauffeurException {
		Optional<Chauffeur> chOpt = chaufRepo.findById(id);
		if (chOpt.isPresent())
			return chOpt.get();
		else
			throw new ChauffeurException("id non trouvée");
	}

	// transformation dto<-->entite
	protected ChauffeurDtoRep getDtoRep(Chauffeur c) {
		ChauffeurDtoRep cDto = new ChauffeurDtoRep();
		cDto.setId(c.getId());
		cDto.setMatricule(c.getMatricule());
		cDto.setPermis(c.getPermis());
		cDto.setTelephone(c.getTelephone());
		cDto.setUrlImage(c.getUrlImage());
		cDto.setInfo(colServ.getDtoRep(c.getInfo()));

		return cDto;
	}

	protected Chauffeur getEntity(ChauffeurDtoQuery chDtoQ) throws CollegueException {
		Chauffeur ch = new Chauffeur();
		if (chDtoQ.getId() != null)
			ch.setId(chDtoQ.getId());
		ch.setInfo(colServ.getEntityById(chDtoQ.getCollegueId()));
		ch.setMatricule(chDtoQ.getMatricule());
		ch.setPermis(chDtoQ.getPermis());
		ch.setTelephone(chDtoQ.getTelephone());
		ch.setUrlImage(chDtoQ.getUrlImage());
		return ch;
	}

}
