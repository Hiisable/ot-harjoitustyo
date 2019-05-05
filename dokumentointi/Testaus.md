# Testausdokumentti

Ohjelmaa on testattu automatisoiduilla JUnit-testeillä sekä manuaalisesti testaamalla ohjelmaa sen käytössä.

## Automatisoidut testit

### Sovelluslogiikka

Sovelluslogiikka on koodattu pakkauksen yahtzee.domain viidessä eri luokassa. Näitä luokkia testataan testeillä:

* [YahtzeeControllerTest](https://github.com/Hiisable/ot-harjoitustyo/blob/master/Yahtzee/src/test/java/yahtzee/domain/YahtzeeControllerTest.java)
* [ScoreCheckerTest](https://github.com/Hiisable/ot-harjoitustyo/blob/master/Yahtzee/src/test/java/yahtzee/domain/ScoreCheckerTest.java)
* [PlayerTest](https://github.com/Hiisable/ot-harjoitustyo/blob/master/Yahtzee/src/test/java/yahtzee/domain/PlayerTest.java)
* [DiceTest](https://github.com/Hiisable/ot-harjoitustyo/blob/master/Yahtzee/src/test/java/yahtzee/domain/DiceTest.java)
* [DieTest](https://github.com/Hiisable/ot-harjoitustyo/blob/master/Yahtzee/src/test/java/yahtzee/domain/DiceTest.java)

Testien määrittelemissä testitapauksissa on pyritty simuloimaan pelin aikana tapahtuvia tominnallisuuksia.

### Testauskattavuus

Käyttöliittymän muodostava koodi on jätetty testauksen ulkopuolelle. Testauksen alaisen koodin testien rivikattavuus on 96% ja haarautuvuuskattavuus 84%.

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Testikattavuus1.png">

Testaamatta jäi joitakin mahdollisia noppien muodostamia kokonaisuuksia pisteytystilanteissa sekä joitakin marginaalisia toiminnallisuuksia, joissa ei kuitenkaan pitäisi olla ongelmia.

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Testikattavuus2.png">

## Järjestelmätestaus

### Asennus

Sovellus on ladattu ja sitä on testattu [käyttöohjeen](https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/Kayttoohje.md) mukaisesti Windows-ympäristössä. Sovelluksen käyttöönotossa ei tarvita erillisiä konfiguraatioita, joten sen käyttöönotto on varsin suoraviivaista.

### Toiminnallisuudet

[Määrittelydokumentissa](https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/Vaatimusmaarittely.md) listatut asiat on testattu ja järjestelmään on pyritty syöttämään virheellisiä arvoja. Pelaajien nimiä luodessa on testattu tyhjien kenttien syöttämistä (jolloin pelin tulisi aloittaa peli oletusnimellä Player, kun varsinainen peli käynnistetään) ja pelitilanteissa jo tehtyjen pistesuoritusten uudelleenkirjaamista, jonka ei tulisi olla mahdollista.

### Sovellukseen jääneet laatuongelmat

Sovellukseen olisi voitu toteuttaa ilmoitus tyhjästä pelaajan nimestä, kun tällä hetkellä pelaajalle asetetaan tässä tilanteessa oletusnimi. New Game-nappiin voitaisiin lisätä varoitus halutaanko uusi peli varmasti aloittaa, samaten voitaisiin pyytää vahvistusta tilanteissa, jossa pelaaja on merkkaamassa itselleen nollan pisteen pistesuoritusta.
