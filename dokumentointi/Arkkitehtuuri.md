
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

Jokaiselle näkymälle luodaan koodissa oma _Scene_-olio. Pelaajien nimien kirjaus on toteutettu kahtena erillisenä _Scene_-olion, joista toisessa kirjataan yhden pelaajan nimi ja toisessa molempien pelaajien nimi riippuen aloitusnäkymässä valitusta pelimoodista. _Scene_-olioista näkyy kerrallaan yksi stageen sijoitettuna.

## Sovelluslogiikka

Pelisovelluksen toiminnallisuus hoidetaan luokkien _YahtzeeController_ ja _ScoreChecker_ kautta. _ScoreChecker_ sisältää metodit pelaajien pistesuoritusten oikeellisuuksien ja pistemäärien tarkistamiseen. _YahtzeeControllerin_ avulla hoidetaan varsinaiset pelitapahtumat kuten pelivuoron vaihtaminen, pistesuoritusten lisäys pelaajille ja noppien heittäminen. Käyttöliittymän toiminnoissa käytettäviä metodeja ovat esim.

* void roll()
* void changeTurn()
* void scoreYahtzee()
* void addPlayerOne(String name)
* void addPlayerTwo(String name)

_YahtzeeControllerin_ ja sovelluslogiikan muiden osien suhteet ovat esitettynä kuvassa:
<br/>
<br/>
<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/uusi_luokkakaavio.png">

### Päätoiminnallisuudet

Seuraavaksi on koottu kaksi merkittävää tapausta sovelluslogiikan toiminnallisuuksista ja kuvattu niiden suorituksia sekvenssikaavioiden avulla.

#### Noppien heitto

Pelinäkymässä painettaessa Roll dice-nappia koodin suoritus etenee seuraavan sekvenssikaavion mukaisesti:

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Dice%20Rolling%20Sequence.png">

Napin painallukseen reagoiva tapahtumankäsittelijä kutsuu _YahtzeeController_-luokan metodia _roll_. Tämä kutsuu edelleen _Dice_-luokan metodia _rollDice_. _Dice_-luokka sisältää taulukkolistan pelissä käytettävistä nopista, jonka sisältävien jokaisen nopan kohdalla kutsutaan _Die_-luokan metodia _rollDie_. _Die_-luokan _rollDie_-metodi tarkistaa ensin ehdon onko nopan selected-muuttujan arvo true vai false, mikäli tulos on false luo metodi uuden _Random_-luokan ja kutsuu tämän metodia _nextInt_, jolle annetaan parametrina nopan sivujen lukumäärä. Arvoon lisätään +1, koska arvottavat luvut alkavat nollasta. _nextInt_-Metodi palauttaa arvotun kokonaisluvun, joka asetetaan _Die_-olion muuttujan value -arvoksi.

Kun kaikille nopille on arvottu uusi arvo napin painalluksen koodin suoritus jatkuu eteenpäin, jolloin kutsutaan noppia käyttöliittymässä kuvaavien togglenappien _setText_-metodia, jonka parametrissa kutsutaan _YahtzeeController_-luokan metodia _getDice_. Metodi palauttaa _Dice_-olion, jolta kutsutaan metodia _getValueOfDie_, jonka parametriksi annetaan halutun nopan indeksi nopat sisältävässä taulukkolistassa. Tämä metodi kutsuu edelleen arrayListin _get_-metodia, jolla haetaan listasta parametrina annetusta indeksistä löytyvä _Die_-olio. _Die_-luokasta kutsutaan metodia _getValue_, joka palauttaa nopan sen hetkisen value-muuttujan arvon. Sama toistetaan jokaisen noppaa kuvaavan togglenapin kohdalla.

#### Pistesuorituksen kirjaaminen

Seuraavassa sekvenssikaaviossa kuvataan tilannetta, jossa yhden pelaajan pelissä käyttäjä painaa Ones-nappia ykkösten pistesuorituksen kirjaamiseksi. Kaaviosta on jätetty pois joitakin ehtojen täyttämislausekkeita, jottei kuvasta tulisi järkyttävän monimutkainen:

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Scoring%20Sequence.png">

Tapahtumankäsittelijä reagoi jälleen napin painallukseen. Kuvasta on jätetty pois ensimmäisenä tapahtuva ehtojen tarkistus, jossa kutsutaan _YahtzeeController_-luokan _getCurrentPlayer_ metodia, jonka palautusta verrataan _equals_-metodilla eri pelaajiin. Tämän lisäksi ehdoissa tarkistetaan onko kyseisestä kategoriasta jo kirjattu pelaajalle pistesuoritus. Ehdon jälkeen tapahtumankäsittelijä kutsuu _YahtzeeController_-luokan _scoreOnes_-metodia. 

Seuraavaksi kutsutaan _ScoreChecker_-luokan metodia _checkOnes_, joka käy nopanheittosekvenssin tavoin läpi kaikki nopat kutsuen niiden _getValue_-metodia _Dice_-luokan kautta. Lopuksi palautetaan ykkösten määrä kokonaislukuna. Seuraavaksi tarkastetaan onko pelaajalla kirjattuna pistesuoritusta kutsumalla _Player_-luokan metodia _checkIfScored_, jonka parametrina on tarkastellun pistesuorituksen indeksi. Palautuksen ollessa false, kutsutaan _setOnes_-metodia, joka asettaa pelaajalle pistesuorituksen. Tämän lisäksi pistesuoritus kirjataan kutsumalla _Player_-luokan metodia _addScore_, joka edelleen kutsuu _Player_-luokan metodeja _addScoreToCheckArray_, jonka parametrina on pistesuorituksen indeksi, ja _addScoreToScoreArray_, jonka parametreina ovat pistesuorituksen indeksi sekä pistesuorituksen arvo kokonaislukuna. _addScore_-metodi tarkistaa myös kuuluuko pistesuoritus yahtzee-pelin ylempään kategoriaan ja täyttyykö pistesuorituksen kirjaamisen jälkeen mahdollinen bonusehto, mutta tätä ei ole kuvattu kaaviossa.

Tämän jälkeen eteenpäin siirryttäessä päivitetään käyttöliittymää asettamalla pistesuoritusta käyttöliittymässä kuvaavan Labelin tekstiksi pistesuorituksen arvo, jota ei ole esitetty kaaviossa. Lopuksi kutsutaan _YahtzeeUI_-käyttäliittymän omaa metodia _scoreButtonEndSequence_, joka sisältää metodit _changeTurn_, _turnDialog_, _updateTotals_ ja ehdon, jolloin käytetään metodia _checkGameState_.

Loppusekvenssin aikana kutsutaan ensin _YahtzeeControllerin_ metodia _changeTurn_, joka kasvattaa aktiivisen pelaajan käytettyjen vuorojen määrää kutsumalla _Player_-luokan metodia _advanceTurnCount_, jonka jälkeen asetetaan käytettyjen heittojen määrä nollaan kutsumalla _Player_-luokan metodia _setRollCount_ sen parametrin ollessa 0. Esimerkkitapauksessa oli kyse yhden pelaajan pelistä, mutta kahden pelaajan pelissä metodi vaihtaisi myös aktiiviseksi pelaajaksi toisen pelaajan. 

_turnDialog_-Metodi asettaa pelinäkymän dialogi-labelin tekstin kertomaan aktiivisen pelaajan vuorosta ja _updateTotals_-metodi päivittää pelinäkymän pistesaldot sekä asettaa kaikkien noppien arvoiksi nollat kutsumalla _Dice_-luokan metodia _setAllDice_, jolle on annettu parametriksi 0. _updateTotals_-Metodi kutsuu myös käyttöliittymän metodia _resetDice_, joka aiheuttaa tapahtumasekvenssin jokaisessa noppaakuvaavassa togglenapissa, joka on ollut aktivoituna vuoron aikana ja asettaa ne oletustilaan.

Viimeisenä tarkistetaan pelitilanne kutsumalla _YahtzeeController_-luokan metodia _checkGameState_, joka palauttaa arvon false ja peli jatkuu.

#### Muut toiminnallisuudet

Kaikkien pistesuoritusten kirjaamiseen käytettävien nappien logiikka noudattaa edellistä tapausta, joskin ehtoihin käytettävät metodit vaihtuvat. Yleisesti kaikkien nappien tapahtumankäsittelijät kutsuvat sopivaa sovelluslogiikan metodia ja napista riippuen vaihtavat halutun näkymän aktiiviseksi.

## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Käyttöliittymä on koodattu lähes kokonaan _YahtzeeUI_-luokan metodissa _start_. Näkymät voitaisiin jakaa niille omiin luokkiin ja FXML voitaisiin ottaa käyttöön. Graafista ulkonäköä voitaisiin myös luonnollisesti parantaa huomattavasti.

### Sovelluslogiikka

Pistesuorituksia testaavia metodeja voitaisiin miettiä uudelleen, jotta ne eivät olisi yhtä pitkiä kuin nyt. Suorituksia kirjattaessa tulisi myös pyrkiä pienempään määrään ehtojen tarkistusta, joitakin asioita tarkastetaan kahteen kertaan, mutta aika ei riittänyt alkaa miettimään näitä uudelleen.
