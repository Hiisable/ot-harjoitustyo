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

Käyttöliittymän muodostava koodi on jätetty testauksen ulkopuolelle.

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Testikattavuus1.png">
