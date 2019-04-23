# **Ohjelmistotekniikka, harjoitustyö**
## **Yahtzee**

Helsingin yliopiston kurssin Ohjelmistotekniikka aikana luotu ohjelma, jonka tarkoituksena on simuloida yahtzee-noppapeliä. Ensin sovelluksessa valitaan joko yhden tai kahden pelaajan peli, jonka jälkeen pelaajat kirjaavat itselleen nimen ja aloittavat pelin. Heitettyään noppia pelaajat kirjaavat noppien silmälukujen arvoja taulukkoon pelin sääntöjen mukaisesti.

## **Dokumentaatio**

* [Vaatimusmäärittely](https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/Vaatimusmaarittely.md)

* [Arkkitehtuuri](https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/Arkkitehtuuri.md)

* [Käyttöohje](https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/Kayttoohje.md)

* [Tyoaikakirjanpito](https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/Tuntikirjanpito.md)

## **Releaset**

[Viikko 6](https://github.com/Hiisable/ot-harjoitustyo/releases/tag/Viikko6)

[Viikko 5](https://github.com/Hiisable/ot-harjoitustyo/releases/tag/Viikko5)

## **Komentorivikomennot**

### **Testaus**

Testit suoritetaan komennolla<br/>

`mvn test`<br/>

Testikattavuusraportti luodaan komennolla<br/>

`mvn jacoco:report`<br/>

Sekä testit että raportin luominen suoritetaan komennolla<br/>

`mvn test jacoco:report`<br/>

### **Suoritettavan jarin generointi**

Jar-tiedosto luodaan komennolla<br/>

`mvn package`<br/>

Tiedosto generoituu lokaatioon *target/*

### **Checkstyle**

Tiedoston checkstyle.xml mukaiset tarkistukset suoritetaan komennolla<br/>

`mvn jxr:jxr checkstyle:checkstyle`<br/>

Checkstylen luomaa raporttia voi tutkia selaimella, raportti löytyy lokaatiosta *target/site/checkstyle.html*
