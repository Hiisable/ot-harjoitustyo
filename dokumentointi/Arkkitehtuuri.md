
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

Seuraavaksi on koottu kaksi merkittävää tapausta sovelluslogiikan toiminnallisuuksista ja kuvattu niiden suorituksia sekvenssikaavioiden avulla.

#### Noppien heitto

Pelinäkymässä painettaessa Roll dice-nappia koodin suoritus etenee seuraavan sekvenssikaavion mukaisesti:

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Dice%20Rolling%20Sequence.png">

Napin painallukseen reagoiva tapahtumankäsittelijä kutsuu YahtzeeController-luokan metodia roll. Tämä kutsuu edelleen Dice-luokan metodia rollDice. Dice-luokka sisältää taulukkolistan pelissä käytettävistä nopista, jonka sisältävien jokaisen nopan kohdalla kutsutaan Die-luokan metodia rollDie. Die-luokan rollDie-metodi tarkistaa ensin ehdon onko nopan selected-muuttujan arvo true vai false, mikäli tulos on false luo metodi uuden Random-luokan ja kutsuu tämän metodia nextInt, jolle annetaan parametrina nopan sivujen lukumäärä. Arvoon lisätään +1, koska arvottavat luvut alkavat nollasta. nextInt-Metodi palauttaa arvotun kokonaisluvun, joka asetetaan Die-olion muuttujan value-arvoksi.

Kun kaikille nopille on arvottu uusi arvo napin painalluksen koodin suoritus jatkuu eteenpäin, jolloin kutsutaan noppia käyttöliittymässä kuvaavien togglenappien setText-metodia, jonka parametrissa kutsutaan YahtzeeController-luokan metodia getDice. Metodi palauttaa Dice-olion, jolta kutsutaan metodia getValueOfDie, jonka parametriksi annetaan halutun nopan indeksi nopat sisältävässä taulukkolistassa. Tämä metodi kutsuu edelleen arrayListin get-metodia, jolla haetaan listasta parametrina annetusta indeksistä löytyvä Die-olio. Die-luokasta kutsutaan metodia getValue, joka palauttaa nopan sen hetkisen value-muuttujan arvon. Sama toistetaan jokaisen noppaa kuvaavan togglenapin kohdalla.

#### Pistesuorituksen kirjaaminen

Seuraavassa sekvenssikaaviossa kuvataan tilannetta, jossa yhden pelaajan pelissä käyttäjä painaa Ones-nappia ykkösten pistesuorituksen kirjaamiseksi. Kaaviosta on jätetty pois joitakin ehtojen täyttämislausekkeita, jottei kuvasta tulisi järkyttävän monimutkainen:

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Scoring%20Sequence.png">

Tapahtumankäsittelijä reagoi jälleen napin painallukseen. Kuvasta on jätetty pois ensimmäisenä tapahtuva ehtojen tarkistus, jossa kutsutaan YahtzeeController-luokan getCurrentPlayer metodia, jonka palautusta verrataan equals-metodilla eri pelaajiin. Tämän lisäksi ehdoissa tarkistetaan onko kyseisestä kategoriasta jo kirjattu pelaajalle pistesuoritus. Ehdon jälkeen tapahtumankäsittelijä kutsuu YahtzeeController-luokan scoreOnes-metodia. 

Seuraavaksi kutsutaan ScoreChecker-luokan metodia checkOnes, joka käy nopanheittosekvenssin tavoin läpi kaikki nopat kutsuen niiden getValue-metodia dice-luokan kautta. Lopuksi palautetaan ykkösten määrä kokonaislukuna. Seuraavaksi tarkastetaan onko pelaajalla kirjattuna pistesuoritusta kutsumalla Player-luokan metodia checkIfScored, jonka parametrina on tarkastellun pistesuorituksen indeksi. Palautuksen ollessa false, kutsutaan setOnes-metodia, joka asettaa pelaajalle pistesuorituksen. Tämän lisäksi pistesuoritus kirjataan kutsumalla Player-luokan metodia addScore, joka edelleen kutsuu Player-luokan metodeja addScoreToCheckArray, jonka parametrina on pistesuorituksen indeksi, ja addScoreToScoreArray, jonka parametreina ovat pistesuorituksen indeksi sekä pistesuorituksen arvo kokonaislukuna. addScore-metodi tarkistaa myös kuuluuko pistesuoritus yahtzee-pelin ylempään kategoriaan ja täyttyykö pistesuorituksen kirjaamisen jälkeen mahdollinen bonusehto, mutta tätä ei ole kuvattu kaaviossa.

Tämän jälkeen eteenpäin siirryttäessä päivitetään käyttöliittymää asettamalla pistesuoritusta käyttöliittymässä kuvaavan Labelin tekstiksi pistesuorituksen arvo, jota ei ole esitetty kaaviossa. Lopuksi kutsutaan yahtzeeUI-käyttäliittymän omaa metodia scoreButtonEndSequence, joka sisältää metodit changeTurn, turnDialog, updateTotals ja ehdon, jolloin käytetään metodia checkGameState.

Loppusekvenssin aikana kutsutaan ensin yahtzeeControllerin metodia changeTurn, joka kasvattaa aktiivisen pelaajan käytettyjen vuorojen määrää kutsumalla Player-luokan metodia advanceTurnCount, jonka jälkeen asetetaan käytettyjen heittojen määrä nollaan kutsumalla Player-luokan metodia setRollCount sen parametrin ollessa 0. Esimerkkitapauksessa oli kyse yhden pelaajan pelistä, mutta kahden pelaajan pelissä metodi vaihtaisi myös aktiiviseksi pelaajaksi toisen pelaajan. 

turnDialog-Metodi asettaa pelinäkymän dialogi-labelin tekstin kertomaan aktiivisen pelaajan vuorosta ja updateTotals metodi päivittää pelinäkymän pistesaldot sekä asettaa kaikkien noppien arvoiksi nollat kutsumalla dice-luokan metodia setAllDice, jolle on annettu parametriksi 0. updateTotals-Metodi kutsuu myös käyttöliittymän metodia resetDice, joka aiheuttaa tapahtumasekvenssin jokaisessa noppaakuvaavassa togglenapissa, joka on ollut aktivoituna vuoron aikana ja asettaa ne oletustilaan.

Viimeisenä tarkistetaan pelitilanne kutsumalla YahtzeeController-luokan metodia checkGameState, joka palauttaa arvon false ja peli jatkuu.

#### Muut toiminnallisuudet

Kaikkien pistesuoritusten kirjaamiseen käytettävien nappien logiikka noudattaa edellistä tapausta, joskin ehtoihin käytettävät metodit vaihtuvat. Yleisesti kaikkien nappien tapahtumankäsittelijät kutsuvat sopivaa sovelluslogiikan metodia ja napista riippuen vaihtavat halutun näkymän aktiiviseksi.

## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Käyttöliittymä on koodattu lähes kokonaan YahtzeeUI-luokan metodissa start. Näkymät voitaisiin jakaa niille omiin luokkiin ja FXML voitaisiin ottaa käyttöön. Graafista ulkonäköä voitaisiin myös luonnollisesti parantaa huomattavasti.

### Sovelluslogiikka

Pistesuorituksia testaavia metodeja voitaisiin miettiä uudelleen, jotta ne eivät olisi yhtä pitkiä kuin nyt. Suorituksia kirjattaessa tulisi myös pyrkiä pienempään määrään ehtojen tarkistusta, joitakin asioita tarkastetaan kahteen kertaan, mutta aika ei riittänyt alkaa miettimään näitä uudelleen.
