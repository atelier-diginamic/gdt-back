# spring-boot-jenkinsfile
## API chauffeur
### [GET POST PUT] "/chauffeur" 
CRUD chauffeur

## API covoiturage
### [GET]/covoiturage/reservation?id=x
liste les covoiturage ou id est passager
### [GET]/covoiturage/no-reservation?id=x
liste les covoiturage ou id n'est pas passager
### [GET]/covoiturage/annonce-covoiturage?id=x
affiche les covoiturage de id
### [POST PUT DELETE]/covoiturage
ajoute/edite/supprime un covoiturage

## API deplacement pro
### [GET] /deplacement-pro/deplacement?id=x
affiche les deplacement pro créé par id
### [POST PUT] /deplacement-pro
ajoute/edite des deplacement pro

## API vehicule
### [GET] /vehicule
affiche tous les vehicule
### [GET] /vehicule?type=xxx&value=xxx
affiche tous les vehicule avec filtres
### [GET] /vehicule?id=x
affiche un vehicule par son id
### [PUT] /vehicule
edite un vehicule
