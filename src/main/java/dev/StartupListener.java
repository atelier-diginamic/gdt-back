package dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.domain.Collegue;
import dev.domain.Covoiturage;
import dev.domain.EtatVehicule;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.domain.Vehicule;
import dev.domain.Version;
import dev.repository.CollegueRepo;
import dev.repository.CovoiturageRepository;
import dev.repository.VehiculeRepo;
import dev.repository.VersionRepo;

/**
 * Code de démarrage de l'application. Insertion de jeux de données.
 */
@Component
public class StartupListener {

	private String appVersion;
	private VersionRepo versionRepo;
	private PasswordEncoder passwordEncoder;
	private CollegueRepo collegueRepo;
	private VehiculeRepo vehiculeRepo;
	private CovoiturageRepository covoiturageRepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollegueRepo collegueRepo, VehiculeRepo vehiculeRepo,
			CovoiturageRepository covoiturageRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.vehiculeRepo = vehiculeRepo;
		this.covoiturageRepo = covoiturageRepo;
	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {
		this.versionRepo.save(new Version(appVersion));

		// Création de deux utilisateurs

		Collegue col1 = new Collegue();
		col1.setNom("Admin");
		col1.setPrenom("DEV");
		col1.setEmail("admin@dev.fr");
		col1.setMotDePasse(passwordEncoder.encode("superpass"));
		col1.setRoles(Arrays.asList(new RoleCollegue(col1, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col1, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col1);

		Collegue col2 = new Collegue();
		col2.setNom("User");
		col2.setPrenom("DEV");
		col2.setEmail("user@dev.fr");
		col2.setMotDePasse(passwordEncoder.encode("superpass"));
		col2.setRoles(Arrays.asList(new RoleCollegue(col2, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col2);

		Vehicule vehicule1 = new Vehicule();
		vehicule1.setImmatriculation("IMMAT-123");
		vehicule1.setMarque("Renault");
		vehicule1.setModel("Clio");
		vehicule1.setCategorie("Citadine");
		vehicule1.setNbr_places(3);
		vehicule1.setEtat(EtatVehicule.EN_SERVICE);
		vehicule1.setUrlImage("image");
		this.vehiculeRepo.save(vehicule1);
		
		Vehicule vehicule2 = new Vehicule();
		vehicule2.setImmatriculation("2405-cql-86");
		vehicule2.setMarque("Opel");
		vehicule2.setModel("Zafira");
		vehicule2.setCategorie("Monospace");
		vehicule2.setNbr_places(6);
		vehicule2.setEtat(EtatVehicule.EN_REPARATION);
		vehicule2.setUrlImage("image");
		this.vehiculeRepo.save(vehicule2);
		
		Vehicule vehicule3 = new Vehicule();
		vehicule3.setImmatriculation("AP-900-YY");
		vehicule3.setMarque("Aoyota");
		vehicule3.setModel("Aygo");
		vehicule3.setCategorie("Citadine");
		vehicule3.setNbr_places(2);
		vehicule3.setEtat(EtatVehicule.HORS_SERVICE);
		vehicule3.setUrlImage("image");
		this.vehiculeRepo.save(vehicule3);
		
		
		

		Covoiturage covoiturage = new Covoiturage();
		covoiturage.setDate(new Date());
		covoiturage.setDepart("ici");
		covoiturage.setDestination("la-bas");
		covoiturage.setVehicule(vehicule1);
		covoiturage.setChauffeur(col1);
		covoiturage.setPassagers(new ArrayList<Collegue>());
		this.covoiturageRepo.save(covoiturage);
	}
}
