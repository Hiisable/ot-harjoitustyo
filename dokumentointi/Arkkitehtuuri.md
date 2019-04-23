
# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne on kaksitasoinen ja sen pakkausrakenne on esitetty kuvassa:
<br/>
<br/>
<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Pakkausrakenne.png">
<br/>

Pakkauksista yahtzee.ui sisältää graafisen käyttöliittymän toteutuksen. Pakkaus yahtzee.domain sisältää taasen käyttöliittymästä eriytetyn sovelluslogiikan.

## Käyttöliittymä

Käyttöliittymä koostuu kolmesta erillisestä näkymästä, jotka ovat:

* Pelimoodin valinta
* Pelaajien nimien kirjaaminen
* Varsinainen pelinäkymä

Jokaiselle näkymälle luodaan koodissa oma Scene-olio. Pelaajien nimien kirjaus on toteutettu kahtena erillisenä Scene-olion, joista toisessa kirjataan yhden pelaajan nimi ja toisessa molempien pelaajien nimi riippuen aloitusnäkymässä valitusta pelimoodista. Scene-olioista näkyy kerrallaan yksi stageen sijoitettuna.

## Sovelluslogiikka

Pelisovelluksen toiminnallisuus hoidetaan luokkien YahtzeeControlle ja ScoreChecker kautta. ScoreChecker sisältää metodit pelaajien pistesuoritusten oikeellisuuksien ja pistemäärien tarkistamiseen. YahtzeeControllerin avulla hoidetaan varsinaiset pelitapahtumat kuten pelivuoron vaihtaminen, pistesuoritusten lisäys pelaajille ja noppien heittäminen. Käyttöliittymän toiminnoissa käytettäviä metodeja ovat esim.

* void roll()
* void scoreYahtzee()
* void addPlayerOne(String name)
* void addPlayerTwo(String name)

YahtzeeControllerin ja sovelluksen muiden osien suhteet ovat esitettynä kuvassa:

## **Nopanheittonapin painalluksen sekvenssikaavio**

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Dice%20Rolling%20Sequence.png">
