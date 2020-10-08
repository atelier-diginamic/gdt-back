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

		// Création de 5 utilisateurs

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
		col2.setRoles(Arrays.asList(
				new RoleCollegue(col2, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col2);
		
		Collegue col3 = new Collegue();
		col3.setNom("Amianto");
		col3.setPrenom("Sylvain");
		col3.setEmail("cql@dev.fr");
		col3.setMotDePasse(passwordEncoder.encode("superpass"));
		col3.setRoles(Arrays.asList(
				new RoleCollegue(col3, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col3, Role.ROLE_CHAUFFEUR)));
		this.collegueRepo.save(col3);

		Collegue col4 = new Collegue();
		col4.setNom("Gelaron");
		col4.setPrenom("Delphine");
		col4.setEmail("gelarondelphine@dev.fr");
		col4.setMotDePasse(passwordEncoder.encode("superpass"));
		col4.setRoles(Arrays.asList(new RoleCollegue(col4, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col4);
		
		Collegue col5 = new Collegue();
		col5.setNom("Merdalhor");
		col5.setPrenom("Robin");
		col5.setEmail("aze@dev.fr");
		col5.setMotDePasse(passwordEncoder.encode("superpass"));
		col5.setRoles(Arrays.asList(
				new RoleCollegue(col5, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col5);



		
		//creation de 5 vehicules
		
		Vehicule vehicule1 = new Vehicule();
		vehicule1.setImmatriculation("IMMAT-123");
		vehicule1.setMarque("Renault");
		vehicule1.setModel("Clio");
		vehicule1.setCategorie("Citadine");
		vehicule1.setNbr_places(3);
		vehicule1.setEtat(EtatVehicule.EN_SERVICE);
		vehicule1.setUrlImage("https://www.automobile-magazine.fr/asset/cms/167386/config/116199/leclairage-100-diodes-est-de-serie-sur-cette-clio-dacces.jpg");
		this.vehiculeRepo.save(vehicule1);
		
		Vehicule vehicule2 = new Vehicule();
		vehicule2.setImmatriculation("2405-cql-86");
		vehicule2.setMarque("Opel");
		vehicule2.setModel("Zafira");
		vehicule2.setCategorie("Monospace");
		vehicule2.setNbr_places(6);
		vehicule2.setEtat(EtatVehicule.EN_REPARATION);
		vehicule2.setUrlImage("https://images.caradisiac.com/images/0/3/0/6/40306/S1-Opel-Zafira-I-1-26550.jpg");
		this.vehiculeRepo.save(vehicule2);
		
		Vehicule vehicule3 = new Vehicule();
		vehicule3.setImmatriculation("AP-900-YY");
		vehicule3.setMarque("Toyota");
		vehicule3.setModel("Aygo");
		vehicule3.setCategorie("Citadine");
		vehicule3.setNbr_places(2);
		vehicule3.setEtat(EtatVehicule.HORS_SERVICE);
		vehicule3.setUrlImage("https://images.caradisiac.com/images/4/2/5/8/174258/S0-salon-de-geneve-2019-toyota-aygo-nouvelles-versions-x-style-et-x-cite-580611.jpg");
		this.vehiculeRepo.save(vehicule3);
		
		Vehicule vehicule4 = new Vehicule();
		vehicule4.setImmatriculation("az-123-ze");
		vehicule4.setMarque("Renault");
		vehicule4.setModel("Espace");
		vehicule4.setCategorie("Monospace");
		vehicule4.setNbr_places(6);
		vehicule4.setEtat(EtatVehicule.EN_SERVICE);
		vehicule4.setUrlImage("https://www.largus.fr/images/images/renault-espace-2-restyle-av.jpg");
		this.vehiculeRepo.save(vehicule4);
		
		Vehicule vehicule5 = new Vehicule();
		vehicule5.setImmatriculation("AP-709-NB");
		vehicule5.setMarque("Peugeot");
		vehicule5.setModel("207 GT turbo");
		vehicule5.setCategorie("Citadine");
		vehicule5.setNbr_places(2);
		vehicule5.setEtat(EtatVehicule.EN_SERVICE);
		vehicule5.setUrlImage("https://www.rally24.fr/media/cache/thumb_og/res/img/products/38928/1/1/peugeot-gt.jpeg");
		this.vehiculeRepo.save(vehicule5);
		
		
		//creation de 5 covoiturages

		Covoiturage covoiturage = new Covoiturage();
		covoiturage.setDate(new Date());
		covoiturage.setDepart("adresseDepart");
		covoiturage.setDestination("adresseArrive");
		covoiturage.setVehicule(vehicule1);
		covoiturage.setChauffeur(col1);
		covoiturage.setPassagers(new ArrayList<Collegue>());
		this.covoiturageRepo.save(covoiturage);
		
		Covoiturage covoiturage2 = new Covoiturage();
		covoiturage2.setDate(new Date());
		covoiturage2.setDepart("adresseDepart");
		covoiturage2.setDestination("adresseArrive");
		covoiturage2.setVehicule(vehicule4);
		covoiturage2.setChauffeur(col2);
		covoiturage2.setPassagers(new ArrayList<Collegue>());
		this.covoiturageRepo.save(covoiturage2);
		
		Covoiturage covoiturage3 = new Covoiturage();
		covoiturage3.setDate(new Date());
		covoiturage3.setDepart("adresseDepart");
		covoiturage3.setDestination("adresseArrive");
		covoiturage3.setVehicule(vehicule5);
		covoiturage3.setChauffeur(col5);
		covoiturage3.setPassagers(new ArrayList<Collegue>());
		this.covoiturageRepo.save(covoiturage3);
		
		Covoiturage covoiturage4 = new Covoiturage();
		covoiturage4.setDate(new Date());
		covoiturage4.setDepart("adresseDepart");
		covoiturage4.setDestination("adresseArrive");
		covoiturage4.setVehicule(vehicule1);
		covoiturage4.setChauffeur(col4);
		covoiturage4.setPassagers(new ArrayList<Collegue>());
		this.covoiturageRepo.save(covoiturage4);
		
		Covoiturage covoiturage5 = new Covoiturage();
		covoiturage5.setDate(new Date());
		covoiturage5.setDepart("adresseDepart");
		covoiturage5.setDestination("adresseArrive");
		covoiturage5.setVehicule(vehicule4);
		covoiturage5.setChauffeur(col1);
		covoiturage5.setPassagers(new ArrayList<Collegue>());
		this.covoiturageRepo.save(covoiturage5);
	}
}
