
# Käyttöohje

Lataa tiedosto Yahtzee-1.0-SNAPSHOT.jar

## Ohjelman käynnistäminen

Ohjelma käynnistetään joko tuplaklikkaamalla ladattua jar-tiedostoa tai komennolla

`java -jar Yahtzee-1.0-SNAPSHOT.jar`

## Pelin aloitus

Ohjelma avautuu aloitusnäkymään:

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Aloitusn%C3%A4kym%C3%A4.png">

Näkymästä valitaan nappia painamalla haluaako pelata yhden vai kahden pelaajan pelin. Napin painalluksella siirrytään seuraavaan näkymään:

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Nimenkirjausn%C3%A4kym%C3%A4.png">

Tekstikenttään/kenttiin pelaajat syöttävät haluamansa nimen ja painavat Add-player nappia, jolloin nimi tallentuu pelijärjestelmään. 
Nimien kirjaamisen jälkeen siirrytään varsinaiseen pelinäkymään painamalla Start game! -nappia.

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Pelin%C3%A4kym%C3%A4.png">

Pelinäkymässä pelaajat heittävät noppia painamalla Roll dice! -nappia. Noppia, joita ei haluta heittää, voidaan klikata, 
jolloin niiden silmäluvut säilyvät pelaajan vuoron ajan. Noppia voidaan klikata uudelleen, jolloin niitä voidaan jälleen heittää. 
Saatuaan haluamansa tuloksen tai enintään kolmen saman vuoron aikana tapahtuneen heittokierroksen jälkeen pelaaja
kirjaa itselleen pisteensä haluamaansa käyttämättä olevaan kategoriaan painamalla sen kohdalla olevaa nappia.
