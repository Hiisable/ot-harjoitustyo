
# Käyttöohje

Lataa tiedosto Yahtzee.jar

## Ohjelman käynnistäminen

Ohjelma käynnistetään joko tuplaklikkaamalla ladattua jar-tiedostoa tai komennolla

`java -jar Yahtzee-1.0-SNAPSHOT.jar`

## Pelin aloitus

Ohjelma avautuu aloitusnäkymään:<br/>

<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Aloitusn%C3%A4kym%C3%A4.png">
<br/>
Näkymästä valitaan nappia painamalla haluaako pelata yhden vai kahden pelaajan pelin. Napin painalluksella siirrytään seuraavaan näkymään:<br/>
<br/>
<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Nimenkirjausn%C3%A4kym%C3%A4.png">
<br/>
Tekstikenttään/kenttiin pelaajat syöttävät haluamansa nimen ja painavat Add-player nappia, jolloin nimi tallentuu pelijärjestelmään. 
Nimien kirjaamisen jälkeen siirrytään varsinaiseen pelinäkymään painamalla Start game! -nappia.<br/>
<br/>
<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Pelinakyma.jpg">
<br/>
Pelinäkymässä pelaajat heittävät noppia painamalla Roll dice! -nappia. Noppia, joita ei haluta heittää, voidaan klikata, 
jolloin niiden silmäluvut säilyvät pelaajan vuoron ajan. Noppia voidaan klikata uudelleen, jolloin niitä voidaan jälleen heittää. 
Saatuaan haluamansa tuloksen tai enintään kolmen saman vuoron aikana tapahtuneen heittokierroksen jälkeen pelaaja
kirjaa itselleen pisteensä haluamaansa käyttämättä olevaan kategoriaan painamalla sen kohdalla olevaa nappia. Uusi peli voidaan
aloittaa pelaamatta kesken olevaa peliä loppuun asti painamalla New Game-nappia, josta siirrytään takaisin pelaajien määrän valintaan.
<br/>
Jos peli pelataan loppuun asti peli ilmoittaa voittajan tai tasapelin sattuessa kertoo pelin päättyneen tasapeliin.
<br/>
<br/>
<img src="https://github.com/Hiisable/ot-harjoitustyo/blob/master/dokumentointi/kuvat/GameOver.png">
<br/>
<br/>
Painamalla Yes näkymä vaihtuu pelaajien määrän valintaan, muussa tapauksessa ohjelma sulkeutuu.
