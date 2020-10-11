-- collegues
insert into collegue(email,mot_de_passe,nom,prenom) values
('cql@dev.fr','2a$10$pM8.nSHiHe11QwV2V0nk2.xEOPlhBMKGOWAaKak1nSerKsJp0AV8m','Amianto','Sylvain'),   
('marchumbut@dev.fr','$2a$10$pM8.nSHiHe11QwV2V0nk2.xEOPlhBMKGOWAaKak1nSerKsJp0AV8m','Humbut','Marc'),   
('gelarondelphine@dev.fr','$2a$10$pM8.nSHiHe11QwV2V0nk2.xEOPlhBMKGOWAaKak1nSerKsJp0AV8m','Gelaron','Delphine'),   
('robinmerdhalor@dev.fr','$2a$10$pM8.nSHiHe11QwV2V0nk2.xEOPlhBMKGOWAaKak1nSerKsJp0AV8m','Merdhalor','Robin'), 
('sarahkroche@dev.fr','$2a$10$pM8.nSHiHe11QwV2V0nk2.xEOPlhBMKGOWAaKak1nSerKsJp0AV8m','kroche','Sarah')
;
-- chauffeur
insert into chauffeur(matricule, permis, telephone, id_collegue) values('cql0001','B', '0123456789',1);
insert into chauffeur(matricule, permis, telephone, id_collegue) values('mat0002','B', '0987654321',2);
insert into chauffeur(matricule, permis, telephone, id_collegue) values('mat0003','B', '0456789123',3);

--Annonce covoiturage
insert into annonce_covoiturage(arrive,date,depart,heure_depart,image_url,marque_voiture,modele_voiture,place,status,id_collegue) values
('montpellier gare','2020-12-10','Carnon centre','08:00','img','Opel','Zafira', 6,'EN_COURS',4),
('Carnon centre','2020-12-10','montpellier gare','17:00','img','Opel','Zafira', 6,'EN_COURS',4),
('Clermont centre','2020-12-24','Beziers centre','08:00','img','Peugeot','206', 6,'EN_COURS',3),
('montpellier gare','2020-05-10','Carnon centre','08:00','img','Opel','Zafira', 6,'TERMINER',4),
('Carnon centre','2020-05-10','montpellier gare','17:00','img','Opel','Zafira', 6,'TERMINER',4)
;  

--vehicule Pro
insert into VEHICULE_SOCIETE  (CATEGORIE,IMMATRICULATION,MARQUE,MODEL,PLACES,STATUS,IMAGE_URL) values
('MICRO_URBAINES',			'AA-123-AA','Smart',	'Smart',	1,'EN_SERVICE',		'img'),
('Citadines_POLYVALENTES',	'BB-123-BB','Toyota',	'Aygo',		2,'EN_SERVICE',		'img'),
('COMPACTES',				'CC-123-CC','Peugeot',	'206',		2,'EN_SERVICE',		'img'),
('COMPACTES',				'DD-123-DD','Citroen',	'Saxo',		2,'EN_SERVICE',		'img'),
('COMPACTES',				'EE-123-EE','Renautl',	'Megane',	2,'EN_SERVICE',		'img'),
('BERLINES_TAILLE_S',		'FF-123-FF','Toyota',	'Yaris',	2,'EN_SERVICE',		'img'),
('BERLINES_TAILLE_M',		'GG-123-GG','Peugeot',	'607',		2,'EN_REPARATION',	'img'),
('BERLINES_TAILLE_L',		'HH-123-HH','Hundai',	'i30',		2,'HORS_SERVICE',	'img')
;


--deplacement professionnel
insert into deplacement_pro (reserver_par,date,depart,destination,heure_depart,id_chauffeur,id_vehicule) values
(1,'2020-12-10','montpellier centre',	'Lyon gare',			'09:00',1	,1),
(1,'2020-12-10','Lyon gare',			'montpellier centre',	'16:00',null,1),
(1,'2020-12-16','montpellier centre',	'Paris centre',			'09:00',2	,2),
(2,'2020-12-17','Paris centre',			'montpellier centre',	'16:00',2	,2),
(2,'2020-12-18','montpellier centre',	'carnon gare',			'09:00',2	,3),
(2,'2020-12-18','carnon gare',			'palavas',				'12:00',2	,3),
(3,'2020-12-18','palavas',				'le cres',				'14:00',2	,3),
(3,'2020-12-18','le cres ',				'montpellier centre',	'16:00',null,3),
(4,'2020-05-10','montpellier centre',	'Lyon gare',			'09:00',3	,5),
(4,'2020-05-11','montpellier centre',	'Lyon gare',			'09:00',3	,5),
(1,'2020-05-12','montpellier centre',	'Lyon gare',			'09:00',3	,4),
(1,'2020-05-13','montpellier centre',	'Lyon gare',			'09:00',3	,4)
;  
-- RESERVATION_COVOITURAGE 

insert into reservation_covoiturage  (id_annonce, id_passager) values
(1,1),
(1,2),
(2,3),
(2,1),
(2,2),
(3,3),
(4,3),
(4,4)
;
-- 
insert into reservation_deplacement_pro(ID_DEPLACEMENT_PRO,ID_PASSAGER) values
(1,1),
(2,2),
(3,3),
(4,4),
(5,2)
;
