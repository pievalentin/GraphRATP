# GraphRATP ISEP 2017 (fr/*en*)
Projet sur l'étude des graphs appliqué au réseau RATP. 

*Project study on graphs, applied to Paris subway (BFS, Dijsktra, diametres, Clusters, etc.)*.

## L'équipe / *the team*
- Sami ABOUT
- Pierre VALENTIN
- Audrey ROUSSEL-ENDICOTT

## Pour lancer le programme / *To Start the program* :
Installez les dependences avec Maven :

*Install maven dependences* : 

``` mvn clean install ``` 

(Le projet a une seule dépendence / *the project has one dependence* : [Jackson](https://github.com/FasterXML/jackson))

*See more lauching details and options in class Main : \src\main\java\Main.java]*

Le programme s’exécute dans la classe Main [situé à ici : \src\main\java\Main.java](https://github.com/Focom/GraphRATP/blob/master/src/main/java/Main.java), il affiche
tout d’abord l’adjacency list puis exécute les exercices.

Pour exécuter le code correspondant à la partie III, dé-commenter les deux premières instanciation
de ShortestPath, ligne 18 et 19.

Pour exécuter le code correspondant à la partie IV, dé-commenter une des deux dernières
instanciation de ShortestPath, ligne 22 et 23 ; activer les deux simultanément ne permet pas
d’afficher l’ensemble de la sortie console avec les réglages de base.
