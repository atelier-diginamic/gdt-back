package dev;

import dev.domain.Collegue;
import dev.domain.Covoiturage;
import dev.domain.Lieu;
import dev.domain.Role;
import dev.domain.RoleCollegue;
import dev.domain.Vehicule;
import dev.domain.Version;
import dev.repository.CollegueRepo;
import dev.repository.CovoiturageRepository;
import dev.repository.LieuRepository;
import dev.repository.VehiculeRepo;
import dev.repository.VersionRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Code de démarrage de l'application. Insertion de jeux de données.
 */
@Component
public class StartupListener {

	private String appVersion;
	private VersionRepo versionRepo;
	private PasswordEncoder passwordEncoder;
	private CollegueRepo collegueRepo;
	private LieuRepository lieuRepo;
	private VehiculeRepo vehiculeRepo;
	private CovoiturageRepository covoiturageRepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollegueRepo collegueRepo, LieuRepository lieuRepo,
			VehiculeRepo vehiculeRepo, CovoiturageRepository covoiturageRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.lieuRepo = lieuRepo;
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

		Lieu lieu1 = new Lieu();
		lieu1.setNumero(2);
		lieu1.setVoie("voie sur ton chemin");
		lieu1.setAdresse("Quelque part dans le monde");
		lieu1.setCode_postal(60);
		lieu1.setCoordonnee("x = 1, y = 2, z = -8000");
		lieu1.setLibelle("Quelque part ...");
		lieu1.setVille("Trouville");
		this.lieuRepo.save(lieu1);

		Lieu lieu2 = new Lieu();
		lieu2.setNumero(3);
		lieu2.setVoie("voie sur ton cheminnn");
		lieu2.setAdresse("Quelque part dans le mondeee");
		lieu2.setCode_postal(29);
		lieu2.setCoordonnee("x = 202, y = 404, z = -800");
		lieu2.setLibelle("Quelque parttt ...");
		lieu2.setVille("Trouvilleeeee");
		this.lieuRepo.save(lieu2);

		Vehicule vehicule1 = new Vehicule();
		vehicule1.setImmatriculation("IMMAT-123");
		vehicule1.setMarque("Ferrari");
		vehicule1.setModel("Clio");
		vehicule1.setCategorie("Citadine");
		vehicule1.setNbr_places(3);
		vehicule1.setUrlImage("image");
		this.vehiculeRepo.save(vehicule1);

		Covoiturage covoiturage = new Covoiturage();
		covoiturage.setDate(new Date());
		covoiturage.setDepart(lieu1);
		covoiturage.setDestination(lieu2);
		covoiturage.setVehicule(vehicule1);
		covoiturage.setChauffeur(col1);
		covoiturage.setPassagers(new ArrayList<Collegue>());
		this.covoiturageRepo.save(covoiturage);
	}
}
