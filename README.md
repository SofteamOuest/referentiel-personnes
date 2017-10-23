

Pour lancement du back :
- démarrer container docker mongodb. mongo:latest
- lancer ApplicationStarter

Mongeez gère la montée en version de la base mongodb.
Les données d'initialisation de la base sont dans le fichier V1_1__initial_data.js
Pour ajouter de nouvelles données :
1) créer un fichier V1_X_update_data.js.
2) mettre l'entete :
// mongeez formatted javascript
// changeset system:v1_1
où v1_1 doit être remplacé par la version du script et correspond au préfixe du fichier


