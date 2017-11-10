# referentiel-personnes-api

[![Build Status](https://travis-ci.org/SofteamOuest/referentiel-personnes-api.svg?branch=master)](https://travis-ci.org/SofteamOuest/referentiel-personnes-api)

## Lancement

- Démarrer container docker mongodb. mongo:latest
- Lancer ApplicationStarter avec l'option suivante: -Ddropbox.token=8s63Ewks0oAAAAAAAAAAB-jVr6Z8XFu-udGNWp3qr7eY37KFGen29jt6vVQTKSmb

## Base de données

Mongeez gère la montée en version de la base mongodb.
Les données d'initialisation de la base sont dans le fichier V1_1__initial_data.js

Pour ajouter de nouvelles données :

1) créer un fichier V1_X_update_data.js.
2) mettre l'entete :

    // mongeez formatted javascript
    
    // changeset system:v1_1
    
où v1_1 doit être remplacé par la version du script et correspond au préfixe du fichier

##Service upload photo 
Compte Dropbox : 
Se connecter avec l'adresse mail softeamsofteam@gmail.com/wwwest987
Le service /photos/{id_personne} permet d'uploader une photo pour uen peronne donnée.
Le service doit être appelé avec une personne dont la date de naissance est valorisée.




