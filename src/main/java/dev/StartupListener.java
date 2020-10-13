package dev;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.entity.Chauffeur;
import dev.entity.Collegue;
import dev.entity.RoleCollegue;
import dev.entity.Version;
import dev.repository.ChauffeurRepository;
import dev.repository.CollegueRepo;
import dev.repository.VersionRepo;
import enumeration.Role;

/**
 * Code de démarrage de l'application. Insertion de jeux de données.
 */
@Component
public class StartupListener {

	private String appVersion;
	private VersionRepo versionRepo;
	private PasswordEncoder passwordEncoder;
	private CollegueRepo collegueRepo;
	private ChauffeurRepository chRepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollegueRepo collegueRepo, ChauffeurRepository chRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.chRepo = chRepo;

	}

	@EventListener(ContextRefreshedEvent.class)
	public void onStart() {
		this.versionRepo.save(new Version(appVersion));

		// COLLEGUE
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

		Collegue col3 = new Collegue();
		col3.setNom("Amianto");
		col3.setPrenom("Sylvain");
		col3.setEmail("cql@dev.fr");
		col3.setMotDePasse(passwordEncoder.encode("superpass"));
		col3.setRoles(Arrays.asList(new RoleCollegue(col3, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col3, Role.ROLE_CHAUFFEUR), new RoleCollegue(col3, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col3);

		Collegue col4 = new Collegue();
		col4.setNom("Gelaron");
		col4.setPrenom("Delphine");
		col4.setEmail("gelaron@dev.fr");
		col4.setMotDePasse(passwordEncoder.encode("superpass"));
		col4.setRoles(
				Arrays.asList(new RoleCollegue(col4, Role.ROLE_CHAUFFEUR), new RoleCollegue(col4, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col4);

		Collegue col5 = new Collegue();
		col5.setNom("Dhalor");
		col5.setPrenom("Homer");
		col5.setEmail("dhalor@dev.fr");
		col5.setMotDePasse(passwordEncoder.encode("superpass"));
		col5.setRoles(Arrays.asList(new RoleCollegue(col5, Role.ROLE_CHAUFFEUR)));
		this.collegueRepo.save(col5);
		
		Collegue col6 = new Collegue();
		col6.setNom("Dhalor");
		col6.setPrenom("Homer");
		col6.setEmail("dhalor@dev.fr");
		col6.setMotDePasse(passwordEncoder.encode("superpass"));
		col6.setRoles(Arrays.asList(new RoleCollegue(col6, Role.ROLE_CHAUFFEUR)));
		this.collegueRepo.save(col6);

		Collegue col7 = new Collegue();
		col7.setNom("Woop");
		col7.setPrenom("Sam");
		col7.setEmail("sam@dev.fr");
		col7.setMotDePasse(passwordEncoder.encode("superpass"));
		col7.setRoles(Arrays.asList(new RoleCollegue(col7, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col7, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col7);

		Collegue col8 = new Collegue();
		col8.setNom("Clover");
		col8.setPrenom("Woop");
		col8.setEmail("clover@dev.fr");
		col8.setMotDePasse(passwordEncoder.encode("superpass"));
		col8.setRoles(Arrays.asList(new RoleCollegue(col8, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col8, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col8);

		Collegue col9 = new Collegue();
		col9.setNom("Woop");
		col9.setPrenom("Alex");
		col9.setEmail("admin@dev.fr");
		col9.setMotDePasse(passwordEncoder.encode("superpass"));
		col9.setRoles(Arrays.asList(new RoleCollegue(col9, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col9, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col9);

		// CHAUFFEUR

		Chauffeur ch1 = new Chauffeur();
		ch1.setInfo(col1);
		ch1.setMatricule("sylA2405");
		ch1.setPermis("B");
		ch1.setTelephone("0123456789");
		chRepo.save(ch1);
//		3
//		4
//		5
//		6
		
		
		
		
		// ANNONCE_COVOITURAGE

		// VEHICULE_SOCIETE

		// DEPLACEMENT_PRO

	}
}
