# M06_UF3_ACTIVITAT_02
API REACTIVA, SPRINGBOOT I MONGODB

Captures de swagger

![image](https://github.com/user-attachments/assets/b7aca900-4c76-4511-953e-299120c655f7)


1. Afegiu un endpoint que cerqui per un camp de tipus String on feu servir regex. Afegiu el que calgui al servei, repositori, etc.

![image](https://github.com/user-attachments/assets/7b3cd870-9ece-4266-913d-8159f5a7da54)

2. Què caracteritza una api reactiva com aquesta i què la fa diferent d’una api síncrona amb MVC com les treballades anteriorment?

Una API reactiva se basa en un model asíncron i no bloquejant , a diferència de les APIs MVC tradicionals, que són síncrones i bloquejants . Aquest tipus d’API utilitza Reactor amb Mono i Flux per gestionar dades de manera asíncrona, permetent que l’aplicació continuï processant altres tasques sense esperar que una operació finalitzi. Això la fa especialment útil per manejar grans càrregues i operacions d’entrada/sortida (I/O), com ara accedir a bases de dades o cridar a APIs externes.

En canvi, en una API MVC convencional, cada sol·licitud atura la connexió fins que es rep una resposta , cosa que pot limitar l’eficiència i escalabilitat. Gràcies al seu disseny no bloquejant, una API reactiva pot gestionar moltes més connexions simultànies amb menys fils (threads ), fent-la molt més eficient i adequada per a aplicacions modernes amb altes demandes de rendiment.

3. Què signifiquen Mono i Flux? Per a què penseu que serveixen i per què són útils en aquest tipus de programació?

Mono i Flux són tipus proporcionats per la biblioteca Project Reactor , que s’utilitza en la programació reactiva amb Spring WebFlux . Aquests tipus permeten gestionar dades de manera asíncrona i no bloquejant, essencials per aconseguir una API eficient i escalable.

- Mono representa una seqüència asíncrona que pot contenir 0 o 1 element. S'utilitza quan esperem un sol resultat, com ara buscar un estudiant per id.
- Flux , en canvi, representa una seqüència asíncrona que pot contenir 0, 1 o múltiples elements. És ideal per obtenir més d’un resultat, com ara una llista completa d’estudiants.

Aquests tipus són molt útils en la programació reactiva perquè permeten gestionar operacions sense bloquejar l’execució del programa. Això vol dir que l’aplicació pot seguir processant altres tasques mentre espera el resultat d’una consulta a la base de dades o d’una crida externa, millorant significativament el rendiment i l’escalabilitat, especialment en aplicacions amb molta càrrega o que fan servir moltes operacions d’entrada/sortida (I/O).

En aquest projecte, Mono i Flux es fan servir als controladors, serveis i repositoris per treballar amb les dades procedents de MongoDB de manera reactiva.

4. Què és record? Un record utilitza getters i setters? Justifiqueu la resposta

Un record és una nova funcionalitat introduïda a Java 16 que permet declarar classes immutables , és a dir, que no poden ser modificades un cop creades. És especialment útil per crear classes senzilles amb pocs camps, com és el cas dels DTO (Data Transfer Objects) , utilitzats per transferir dades entre diferents capes d’una aplicació.
Utilitza getters i setters?
No, els records no tenen setters , ja que són immutables per definició. Cada atribut disposa d’un getter automàtic , però el seu valor no es pot modificar després de la creació de l’objecte.

Justificació:
Els records estan dissenyats per emmagatzemar dades que no han de canviar durant l’execució de l’aplicació. Això els fa ideals per a objectes com DTOs, on només es requereix llegir les dades, sense necessitat de modificar-los. A més, aquesta immmutabilitat ajuda a evitar errors i millora la seguretat i neteja del codi.
