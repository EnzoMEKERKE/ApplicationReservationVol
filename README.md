# AppAirline

ce dépôt contient une application JAVA simulant une réservation de vol.

## Les prérequis

Vous aurez besoin de __JAVA 19__


Pour connaître sa version de JAVA sur terminal (Linux et Windows) :

```bash
java -version
```

Vous pouvez télécharger JAVA 19 sur ce [lien](https://www.oracle.com/java/technologies/downloads/) 

## Exécution
vous pouvez juste ouvrir le fichier avec la commande 

```bash
java -jar AppAirline.jar
```
si vous clônez ce repo, n'oubliez pas de changer le chemin du "src" afin de pouvoir run les classes

## Exécution des tests
Sur IntelliJ IDEA, allez dans "Help", "Edit Custom VM Options" puis ajoutez cette ligne :

```bash
-Deditable.java.test.console=true
```
