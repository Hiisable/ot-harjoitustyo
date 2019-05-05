
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

Pelisovelluksen toiminnallisuus hoidetaan luokkien YahtzeeController ja ScoreChecker kautta. ScoreChecker sisältää metodit pelaajien pistesuoritusten oikeellisuuksien ja pistemäärien tarkistamiseen. YahtzeeControllerin avulla hoidetaan varsinaiset pelitapahtumat kuten pelivuoron vaihtaminen, pistesuoritusten lisäys pelaajille ja noppien heittäminen. Käyttöliittymän toiminnoissa käytettäviä metodeja ovat esim.

* void roll()
* void changeTurn()
* void scoreYahtzee()
* void addPlayerOne(String name)
* void addPlayerTwo(String name)

YahtzeeControllerin ja sovelluslogiikan muiden osien suhteet ovat esitettynä kuvassa:
<br/>
<br/>
<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/uusi_luokkakaavio.png">

### Päätoiminnallisuudet

Seuraavaksi on koottu joitakin merkittäviä tapauksia sovelluslogiikan toiminnallisuuksista ja kuvattu niiden suorituksia sekvenssikaavioiden avulla.

#### Noppien heitto

Pelinäkymässä painettaessa Roll dice-nappia koodin suoritus etenee seuraavan sekvenssikaavion mukaisesti:

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Dice%20Rolling%20Sequence.png">

Napin painallukseen reagoiva tapahtumankäsittelijä kutsuu YahtzeeController-luokan metodia roll. Tämä kutsuu edelleen Dice-luokan metodia rollDice. Dice-luokka sisältää taulukkolistan pelissä käytettävistä nopista, jonka sisältävien jokaisen nopan kohdalla kutsutaan Die-luokan metodia rollDie. Die-luokan rollDie-metodi tarkistaa ensin ehdon onko nopan selected-muuttujan arvo true vai false, mikäli tulos on false luo metodi uuden Random-luokan ja kutsuu tämän metodia nextInt, jolle annetaan parametrina nopan sivujen lukumäärä. Arvoon lisätään +1, koska arvottavat luvut alkavat nollasta. nextInt-Metodi palauttaa arvotun kokonaisluvun, joka asetetaan Die-olion muuttujan value-arvoksi.

Kun kaikille nopille on arvottu uusi arvo napin painalluksen koodin suoritus jatkuu eteenpäin, jolloin kutsutaan noppia käyttöliittymässä kuvaavien togglenappien setText-metodia, jonka parametrissa kutsutaan YahtzeeController-luokan metodia getDice. Metodi palauttaa Dice-olion, jolta kutsutaan metodia getValueOfDie, jonka parametriksi annetaan halutun nopan indeksi nopat sisältävässä taulukkolistassa. Tämä metodi kutsuu edelleen arrayListin get-metodia, jolla haetaan listasta parametrina annetusta indeksistä löytyvä Die-olio. Die-luokasta kutsutaan metodia getValue, joka palauttaa nopan sen hetkisen value-muuttujan arvon. Sama toistetaan jokaisen noppaa kuvaavan togglenapin kohdalla.
