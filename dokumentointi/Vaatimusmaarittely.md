
## Vaatimusmäärittely

### Sovelluksen tarkoitus

Sovelluksen on tarkoitus olla yahtzee -pelisovellus. Sovellusta voi 
pelata yksi tai kaksi pelaajaa vuorotellen. Yahtzee pelissä on tarkoitus 
heittää viittä noppaa ja kerätä pelin sääntöjen mukaisesti pisteitä 
noppien silmäluvuista.

### Käyttäjät

Sovelluksen ainoa käyttäjärooli on pelaaja eli normaali käyttäjä.

### Käyttöliittymäluonnos

Sovellus koostuu kolmesta eri näkymästä, jotka on esitetty kuvassa.

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/K%C3%A4ytt%C3%B6liittym%C3%A4%20vaatimusm%C3%A4%C3%A4rittelyyn.png">

Sovellus aukeaa näkymään, jossa valitaan kuinka monta käyttäjää haluaa 
pelata. Seuraavassa näkymässä pelaajat kirjoittavat nimensä kenttään. 
Nimien kirjaamisen jälkeen aukeaa varsinainen pelinäkymä, jossa pelaajat 
heittävät noppia ja kirjaavat pisteensä taulukkoon.

### Perusversion tarjoama toiminnallisuus

#### Ennen pelin alkua

* Käyttäjä voi valita pelaajien määrän.

* Käyttäjä(t) voivat kirjata itselleen pelinimen.

#### Pelin luomisen jälkeen

* Käyttäjät voivat heittää noppia.

* Käyttäjät voivat kirjata haluamiaan tuloksia itselleen pelin sääntöjen 
mukaisesti.

* Pelin tulee kertoa käyttäjille heidän pistesaldonsa sääntöjen mukaisesti 
ja pelin lopuksi kertoa pelin voittaja.

* Käyttäjien tulee pystyä aloittamaan uusi peli pelin loputtua ilman 
ohjelman uudelleenkäynnistystä.

### Jatkokehitysideoita

Perusversion jälkeen sovellusta täyfennetään ajan salliessa esim. 
seuraavilla toiminnallisuuksilla.

* Peliä voi pelata suurempi määrä kuin kaksi pelaajaa kerrallaan.
* Peliin voidaan lisätä käyttäjätunnuksen luomisen ja kirjautumisen 
mahdollisuus.
* Edellisen toiminnallisuuden toteutuessa peliin voidaan lisätä 
tietokanta, johon kerätään käyttäjien pelaamien 
pelien tuloksia.
* Tuloksiin voidaan lisätä toiminnallisuus, jossa käyttäjät näkevät 
toisiaan vastaan pelaamiensa pelien tulokset.
