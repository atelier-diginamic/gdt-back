package dev;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import dev.entity.AnnonceCovoiturage;
import dev.entity.Chauffeur;
import dev.entity.Collegue;
import dev.entity.DeplacementPro;
import dev.entity.RoleCollegue;
import dev.entity.VehiculeSociete;
import dev.entity.Version;
import dev.repository.ChauffeurRepository;
import dev.repository.CollegueRepo;
import dev.repository.CovoiturageRepository;
import dev.repository.DeplacementProRepository;
import dev.repository.VersionRepo;
import dev.repository.vehiculeRepository;
import enumeration.CategorieVehicule;
import enumeration.Role;
import enumeration.StatusAnnonce;
import enumeration.StatusVehicule;

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
	private CovoiturageRepository acRepo;
	private vehiculeRepository vehicRepo;
	private DeplacementProRepository dpRepo;

	public StartupListener(@Value("${app.version}") String appVersion, VersionRepo versionRepo,
			PasswordEncoder passwordEncoder, CollegueRepo collegueRepo, ChauffeurRepository chRepo,
			CovoiturageRepository acRepo, vehiculeRepository vehicRepo, DeplacementProRepository dpRepo) {
		this.appVersion = appVersion;
		this.versionRepo = versionRepo;
		this.passwordEncoder = passwordEncoder;
		this.collegueRepo = collegueRepo;
		this.chRepo = chRepo;
		this.acRepo = acRepo;
		this.vehicRepo = vehicRepo;
		this.dpRepo = dpRepo;

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
		col4.setRoles(Arrays.asList(new RoleCollegue(col4, Role.ROLE_CHAUFFEUR),
				new RoleCollegue(col4, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col4);

		Collegue col5 = new Collegue();
		col5.setNom("Dhalor");
		col5.setPrenom("Homer");
		col5.setEmail("dhalor@dev.fr");
		col5.setMotDePasse(passwordEncoder.encode("superpass"));
		col5.setRoles(Arrays.asList(new RoleCollegue(col5, Role.ROLE_CHAUFFEUR)));
		this.collegueRepo.save(col5);

		Collegue col6 = new Collegue();
		col6.setNom("Kroche");
		col6.setPrenom("Sarah");
		col6.setEmail("kroche@dev.fr");
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
		col8.setNom("Woop");
		col8.setPrenom("Clover");
		col8.setEmail("clover@dev.fr");
		col8.setMotDePasse(passwordEncoder.encode("superpass"));
		col8.setRoles(Arrays.asList(new RoleCollegue(col8, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col8, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col8);

		Collegue col9 = new Collegue();
		col9.setNom("Woop");
		col9.setPrenom("Alex");
		col9.setEmail("alex@dev.fr");
		col9.setMotDePasse(passwordEncoder.encode("superpass"));
		col9.setRoles(Arrays.asList(new RoleCollegue(col9, Role.ROLE_ADMINISTRATEUR),
				new RoleCollegue(col9, Role.ROLE_UTILISATEUR)));
		this.collegueRepo.save(col9);

		// CHAUFFEUR

		Chauffeur ch1 = new Chauffeur();
		ch1.setInfo(col3);
		ch1.setMatricule("sylA2405");
		ch1.setPermis("B");
		ch1.setTelephone("0123456789");
		chRepo.save(ch1);

		Chauffeur ch2 = new Chauffeur();
		ch2.setInfo(col4);
		ch2.setMatricule("sylA2405");
		ch2.setPermis("B");
		ch2.setTelephone("0123456789");
		chRepo.save(ch2);

		Chauffeur ch3 = new Chauffeur();
		ch3.setInfo(col5);
		ch3.setMatricule("sylA2405");
		ch3.setPermis("B");
		ch3.setTelephone("0123456789");
		chRepo.save(ch3);

		Chauffeur ch4 = new Chauffeur();
		ch4.setInfo(col6);
		ch4.setMatricule("sylA2405");
		ch4.setPermis("B");
		ch4.setTelephone("0123456789");
		chRepo.save(ch4);

		// ANNONCE_COVOITURAGE

		AnnonceCovoiturage ac1 = new AnnonceCovoiturage();
		ac1.setArrive("adrArrive1");
		ac1.setCollegue(col1);
		ac1.setDate(LocalDate.of(2020, 12, 10));
		ac1.setDepart("adrDepart1");
		ac1.setHeureDepart(LocalTime.of(8, 0));
		ac1.setImageUrl("imgVoiture");
		ac1.setMarqueVoiture("Opel");
		ac1.setModeleVoiture("Corsa");
		ac1.getPassager().add(col1);
		ac1.getPassager().add(col2);
		ac1.setPlace(5);
		ac1.setStatus(StatusAnnonce.EN_COURS);
		acRepo.save(ac1);

		AnnonceCovoiturage ac2 = new AnnonceCovoiturage();
		ac2.setArrive("adrArrive2");
		ac2.setCollegue(col9);
		ac2.setDate(LocalDate.of(2020, 12, 9));
		ac2.setDepart("adrDepart2");
		ac2.setHeureDepart(LocalTime.of(8, 0));
		ac2.setImageUrl("imgVoiture");
		ac2.setMarqueVoiture("Peugeot");
		ac2.setModeleVoiture("209");
		ac2.getPassager().add(col3);
		ac2.getPassager().add(col2);
		ac2.setPlace(2);
		ac2.setStatus(StatusAnnonce.EN_COURS);
		acRepo.save(ac2);

		AnnonceCovoiturage ac3 = new AnnonceCovoiturage();
		ac3.setArrive("adrArrive3");
		ac3.setCollegue(col8);
		ac3.setDate(LocalDate.of(2020, 12, 20));
		ac3.setDepart("adrDepart3");
		ac3.setHeureDepart(LocalTime.of(8, 0));
		ac3.setImageUrl("imgVoiture");
		ac3.setMarqueVoiture("Renault");
		ac3.setModeleVoiture("Laguna");
		ac3.getPassager().add(col3);
		ac3.getPassager().add(col4);
		ac3.getPassager().add(col5);
		ac3.setPlace(5);
		ac3.setStatus(StatusAnnonce.EN_COURS);
		acRepo.save(ac3);

		AnnonceCovoiturage ac4 = new AnnonceCovoiturage();
		ac4.setArrive("adrArrive4");
		ac4.setCollegue(col8);
		ac4.setDate(LocalDate.of(2020, 12, 20));
		ac4.setDepart("adrDepart4");
		ac4.setHeureDepart(LocalTime.of(16, 0));
		ac4.setImageUrl("imgVoiture");
		ac4.setMarqueVoiture("Renault");
		ac4.setModeleVoiture("Laguna");
		ac4.setPlace(5);
		ac4.setStatus(StatusAnnonce.EN_COURS);
		acRepo.save(ac4);

		AnnonceCovoiturage ac5 = new AnnonceCovoiturage();
		ac5.setArrive("adrArrive5");
		ac5.setCollegue(col7);
		ac5.setDate(LocalDate.of(2020, 12, 10));
		ac5.setDepart("adrDepart1");
		ac5.setHeureDepart(LocalTime.of(8, 0));
		ac5.setImageUrl("imgVoiture");
		ac5.setMarqueVoiture("Seat");
		ac5.setModeleVoiture("Ibiza");
		ac5.getPassager().add(col5);
		ac5.getPassager().add(col4);
		ac5.setPlace(5);
		ac5.setStatus(StatusAnnonce.EN_COURS);
		acRepo.save(ac5);

		// VEHICULE_SOCIETE

		VehiculeSociete vs1 = new VehiculeSociete();
		vs1.setCategorie(CategorieVehicule.BERLINES_TAILLE_L);
		vs1.setImageUrl(
				"https://images.caradisiac.com/logos-ref/modele/modele--opel-meriva/S7-modele--opel-meriva.jpg");
		vs1.setImmatriculation("AA-123-BB");
		vs1.setMarque("Opel");
		vs1.setModel("Meriva");
		vs1.setPlaces(5);
		vs1.setStatus(StatusVehicule.EN_SERVICE);
		vehicRepo.save(vs1);

		VehiculeSociete vs2 = new VehiculeSociete();
		vs2.setCategorie(CategorieVehicule.BERLINES_TAILLE_M);
		vs2.setImageUrl("https://www.largus.fr/images/images/volkswagen-passat-restylee-2019-0.jpg");
		vs2.setImmatriculation("AB-123-BB");
		vs2.setMarque("Wolk Wagen");
		vs2.setModel("Passat");
		vs2.setPlaces(5);
		vs2.setStatus(StatusVehicule.EN_SERVICE);
		vehicRepo.save(vs2);

		VehiculeSociete vs3 = new VehiculeSociete();
		vs3.setCategorie(CategorieVehicule.BERLINES_TAILLE_S);
		vs3.setImageUrl(
				"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Renault_Laguna_III_Phase_I.JPG/280px-Renault_Laguna_III_Phase_I.JPG");
		vs3.setImmatriculation("AC-123-CC");
		vs3.setMarque("Renault");
		vs3.setModel("Laguna");
		vs3.setPlaces(5);
		vs3.setStatus(StatusVehicule.HORS_SERVICE);
		vehicRepo.save(vs3);

		VehiculeSociete vs4 = new VehiculeSociete();
		vs4.setCategorie(CategorieVehicule.CITADINES_POLYVALENTES);
		vs4.setImageUrl(
				"https://www.viinz.com/wp-content/uploads/2017/09/essai-citroen-c3-shine-110-bvm-exterieur-93.jpg");
		vs4.setImmatriculation("AD-123-DD");
		vs4.setMarque("Citroen");
		vs4.setModel("C3");
		vs4.setPlaces(4);
		vs4.setStatus(StatusVehicule.EN_REPARATION);
		vehicRepo.save(vs4);

		VehiculeSociete vs5 = new VehiculeSociete();
		vs5.setCategorie(CategorieVehicule.MICRO_URBAINES);
		vs5.setImageUrl(
				"https://images.caradisiac.com/images/4/2/5/8/174258/S0-salon-de-geneve-2019-toyota-aygo-nouvelles-versions-x-style-et-x-cite-580611.jpg");
		vs5.setImmatriculation("AE-123-EE");
		vs5.setMarque("Toyota");
		vs5.setModel("Aygo");
		vs5.setPlaces(4);
		vs5.setStatus(StatusVehicule.EN_SERVICE);
		vehicRepo.save(vs5);

		VehiculeSociete vs6 = new VehiculeSociete();
		vs6.setCategorie(CategorieVehicule.MINI_CITADINES);
		vs6.setImageUrl(
				"https://www.turbo.fr/sites/default/files/styles/article_690x405/public/migration/newscast/field_image/000000007967837.jpg");
		vs6.setImmatriculation("AF-123-FF");
		vs6.setMarque("Renault");
		vs6.setModel("Twizy");
		vs6.setPlaces(1);
		vs6.setStatus(StatusVehicule.EN_SERVICE);
		vehicRepo.save(vs6);

		VehiculeSociete vs7 = new VehiculeSociete();
		vs7.setCategorie(CategorieVehicule.SUV_TOUT_TERRAINS_PICK_UP);
		vs7.setImageUrl("https://www.asphalte.ch/news/wp-content/uploads/2019/07/BMW-X6-2020-04.jpg");
		vs7.setImmatriculation("AG-123-GG");
		vs7.setMarque("BMW");
		vs7.setModel("X6");
		vs7.setPlaces(5);
		vs7.setStatus(StatusVehicule.EN_REPARATION);
		vehicRepo.save(vs7);

		VehiculeSociete vs8 = new VehiculeSociete();
		vs8.setCategorie(CategorieVehicule.BERLINES_TAILLE_S);
		vs8.setImageUrl(
				"https://images.caradisiac.com/images/7/0/5/6/177056/S0-essai-video-mercedes-classe-a-berline-595128.jpg");
		vs8.setImmatriculation("AH-123-HH");
		vs8.setMarque("Mercedes");
		vs8.setModel("Classe A");
		vs8.setPlaces(5);
		vs8.setStatus(StatusVehicule.EN_SERVICE);
		vehicRepo.save(vs8);

		VehiculeSociete vs9 = new VehiculeSociete();
		vs9.setCategorie(CategorieVehicule.SUV_TOUT_TERRAINS_PICK_UP);
		vs9.setImageUrl("https://cdn.carizy.com/carphotos/2299/wide/opel-zafira-occasion-2011-avant-gauche.jpg");
		vs9.setImmatriculation("AI-123-II");
		vs9.setMarque("Opel");
		vs9.setModel("Zafira");
		vs9.setPlaces(7);
		vs9.setStatus(StatusVehicule.EN_SERVICE);
		vehicRepo.save(vs9);
		// DEPLACEMENT_PRO
//		(chauff : 3 4 5 6)
		DeplacementPro dp1 = new DeplacementPro();
		dp1.setChauffeur(ch1);
		dp1.setDateEmprun(LocalDate.of(2020, 12, 1));
		dp1.setDateRestitution(LocalDate.of(2020, 12, 31));
		dp1.setHeureEmprun(LocalTime.of(8, 0));
		dp1.setHeureRestitution(LocalTime.of(18, 0));
		dp1.setReserverPar(col9);
		dp1.setVehicule(vs1);
		dpRepo.save(dp1);

		DeplacementPro dp2 = new DeplacementPro();
		dp2.setDateEmprun(LocalDate.of(2020, 11, 1));
		dp2.setDateRestitution(LocalDate.of(2020, 11, 30));
		dp2.setHeureEmprun(LocalTime.of(8, 0));
		dp2.setHeureRestitution(LocalTime.of(18, 0));
		dp2.setReserverPar(col8);
		dp2.setVehicule(vs2);
		dpRepo.save(dp2);

		DeplacementPro dp3 = new DeplacementPro();
		dp3.setChauffeur(ch2);
		dp3.setDateEmprun(LocalDate.of(2020, 12, 10));
		dp3.setDateRestitution(LocalDate.of(2020, 12, 20));
		dp3.setHeureEmprun(LocalTime.of(8, 0));
		dp3.setHeureRestitution(LocalTime.of(18, 0));
		dp3.setReserverPar(col7);
		dp3.setVehicule(vs9);
		dpRepo.save(dp3);

		DeplacementPro dp4 = new DeplacementPro();
		dp4.setDateEmprun(LocalDate.of(2019, 12, 1));
		dp4.setDateRestitution(LocalDate.of(2019, 12, 31));
		dp4.setHeureEmprun(LocalTime.of(8, 0));
		dp4.setHeureRestitution(LocalTime.of(18, 0));
		dp4.setReserverPar(col9);
		dp4.setVehicule(vs1);
		dpRepo.save(dp4);

		DeplacementPro dp5 = new DeplacementPro();
		dp5.setChauffeur(ch3);
		dp5.setDateEmprun(LocalDate.of(2020, 01, 1));
		dp5.setDateRestitution(LocalDate.of(2020, 03, 15));
		dp5.setHeureEmprun(LocalTime.of(8, 0));
		dp5.setHeureRestitution(LocalTime.of(18, 0));
		dp5.setReserverPar(col7);
		dp5.setVehicule(vs1);
		dpRepo.save(dp5);

	}
}
