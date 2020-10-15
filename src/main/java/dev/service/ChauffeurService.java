package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import dev.dto.ChauffeurDtoQuery;
import dev.dto.ChauffeurDtoRep;
import dev.entity.Chauffeur;
import dev.exception.ChauffeurException;
import dev.repository.ChauffeurRepository;

@Service
public class ChauffeurService {

	private ChauffeurRepository chaufRepo;
	private CollegueService colServ;

	public ChauffeurService(ChauffeurRepository chaufRepo,CollegueService colServ) {
		super();
		this.chaufRepo = chaufRepo;
		this.colServ=colServ;
	}
	
	protected Chauffeur getEntityById(Integer id) throws ChauffeurException {
		Optional<Chauffeur> chOpt=chaufRepo.findById(id);
		if(chOpt.isPresent())return chOpt.get();
		else throw new ChauffeurException("id non trouvée");
	}
	
	public ChauffeurDtoRep addEdit(@Valid ChauffeurDtoQuery chQuery) {
		
		return null;
	}
	
	// transformation dto<-->entite
		protected ChauffeurDtoRep getDtoRep(Chauffeur c) {
			ChauffeurDtoRep cDto=new ChauffeurDtoRep();
			cDto.setId(c.getId());
			cDto.setMatricule(c.getMatricule());
			cDto.setPermis(c.getPermis());
			cDto.setTelephone(c.getTelephone());
			cDto.setInfo(colServ.getDtoRep(c.getInfo()));
			return cDto;
			
		}

		public List<ChauffeurDtoRep> getAll() {
			List<ChauffeurDtoRep> list =new ArrayList<ChauffeurDtoRep>();
			for (Chauffeur ch :  chaufRepo.findAll()) {
				list.add(this.getDtoRep(ch));
			}
			return list;
		}

		
}
