<h1>Instructions</h1>
En vous rappelant que vous me devez un point bonus sur ce projet ou celui précédent.

<h2>A faire</h2>

Créer une base de donnée manuellement sur MySQL workbench (ou au moins disponible sur le port 3306) nommée « quoting ».
<br>
CREATE DATABASE quoting;

<br>
Git clone le projet
<br>
Aller dans le projet api
<br>
Aller dans les properties et changer le root user et root password par celui de votre machine
<br>
Lancer le projet

Aller dans le front 
<br>
Lancer le projet

<br>
Pour lancer un projet : mvn spring-boot:run


http://localhost:8888/

Prérequis
* Java 8 ou version supérieure
* Maven
* MySQL (ou la base de données que vous utilisez)

API endpoints:<br>

/api/getQuote : <br>
Retourne une quote aléatoire de la base de donnée

Pour permettre une meilleure logique l'api possède certe qu'un seul modèle mais partage la même base de donnée avec le front pour la sauvegarde des conversations.

Manque:
Test unitaires