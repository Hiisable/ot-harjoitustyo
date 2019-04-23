
package yahtzee.domain;

/**
 * Luokka tarjoaa metodit yahtzee-pelissä käytettävien pistesuorituksien
 * tarkistamiseen. Metodit tarkistavat sekä pistesuoritusten oikeellisuutta
 * että pistesuorituksen arvoja.
 */
public class ScoreChecker {
    
    public ScoreChecker() {
        
    }
    
    /**
     * Metodi tarkistaa noppien silmäluvuista ykkösten määrän.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Ykkösten määrä silmäluvuista.
     */
    public int checkOnes(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 1) {
                score = score + 1;
            }
        }
        return score;    
    }
    
    /**
     * Metodi tarkistaa noppien silmäluvuista kakkosten määrän.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Kakkosten määrä silmäluvuista.
     */
    public int checkTwos(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 2) {
                score = score + 1;
            }
        }
        return score;
    }
    
    /**
     * Metodi tarkistaa noppien silmäluvuista kolmosten määrän.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Kolmosten määrä silmäluvuista.
     */
    public int checkThrees(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 3) {
                score = score + 1;
            }
        }
        return score;
    }
    
    /**
     * Metodi tarkistaa noppien silmäluvuista nelosten määrän.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Nelosten määrä silmäluvuista.
     */
    public int checkFours(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 4) {
                score = score + 1;
            }
        }
        return score;
    }
    
    /**
     * Metodi tarkistaa noppien silmäluvuista viitosten määrän.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Viitosten määrä silmäluvuista.
     */
    public int checkFives(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 5) {
                score = score + 1;
            }
        }
        return score;
    }
    
    /**
     * Metodi tarkistaa noppien silmäluvuista kuutosten määrän.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Kuutosten määrä silmäluvuista.
     */
    public int checkSixes(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 6) {
                score = score + 1;
            }
        }
        return score;
    }
    
    /**
     * Metodi tarkistaa noppien silmäluvuista mahdollisen yahtzee-suorituksen.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Palauttaa mahdollisen yahtzee-suorituksen oikeellisuuden.
     */
    public boolean checkYahtzee(Dice dice) {
        boolean yahtzee = false;
        if (checkOnes(dice) == 5) {
            yahtzee = true;
        } else if (checkTwos(dice) == 5) {
            yahtzee = true;
        } else if (checkThrees(dice) == 5) {
            yahtzee = true;
        } else if (checkFours(dice) == 5) {
            yahtzee = true;
        } else if (checkFives(dice) == 5) {
            yahtzee = true;
        } else if (checkSixes(dice) == 5) {
            yahtzee = true;
        } 
        return yahtzee;
    }
    
    /**
     * Metodi tarkistaa löytyykö noppien silmäluvuista pari.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Mahdollisen pistesuorituksen oikeellisuus.
     */
    public boolean checkPair(Dice dice) {
        boolean pair = false;
        if (checkOnes(dice) > 1 || checkTwos(dice) > 1 || checkThrees(dice) > 1 || checkFours(dice) > 1 || checkFives(dice) > 1 ||
            checkSixes(dice) > 1) {
            pair = true;
        } 
        return pair;
    }
    
    /**
     * Metodi tarkistaa noppien silmäluvuista mahdollisen suurimman parin ja
     * palauttaa sen pistearvon.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Pistesuorituksen arvo.
     */
    public int checkLargestPair(Dice dice) {
        int pair = 0;
        if (checkSixes(dice) >= 2) {
            pair = 12;
        } else if (checkFives(dice) >= 2 && pair == 0) {
            pair = 10;
        } else if (checkFours(dice) >= 2 && pair == 0) {
            pair = 8;
        } else if (checkThrees(dice) >= 2 && pair == 0) {
            pair = 6;
        } else if (checkTwos(dice) >= 2 && pair == 0) {
            pair = 4;
        } else if (checkOnes(dice) >= 2 && pair == 0) {
            pair = 2;
        }
        return pair;
    }
    
    /**
     * Metodi tarkistaa noppien silmäluvuista mahdollisesti löytyvän toiseksi
     * suurimman parin ja sen pistesuorituksen arvon.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Pistesuorituksen arvo.
     */
    public int checkSecondLargestPair(Dice dice) {
        int largestPair = checkLargestPair(dice);
        int smallerPair = 0;
        if (checkFourOfAKind(dice)) {
            smallerPair = largestPair;
        } else if (largestPair == 12) {
            if (checkFives(dice) >= 2) {
                smallerPair = 10;
            } else if (checkFours(dice) >= 2) {
                smallerPair = 8;
            } else if (checkThrees(dice) >= 2) {
                smallerPair = 6;
            } else if (checkTwos(dice) >= 2) {
                smallerPair = 4;
            } else if (checkOnes(dice) >= 2) {
                smallerPair = 2;
            }
        } else if (largestPair == 10) {
            if (checkFours(dice) >= 2) {
                smallerPair = 8;
            } else if (checkThrees(dice) >= 2) {
                smallerPair = 6;
            } else if (checkTwos(dice) >= 2) {
                smallerPair = 4;
            } else if (checkOnes(dice) >= 2) {
                smallerPair = 2;
            }
        } else if (largestPair == 8) {
            if (checkThrees(dice) >= 2) {
                smallerPair = 6;
            } else if (checkTwos(dice) >= 2) {
                smallerPair = 4;
            } else if (checkOnes(dice) >= 2) {
                smallerPair = 2;
            }
        } else if (largestPair == 6) {
            if (checkTwos(dice) >= 2) {
                smallerPair = 4;
            } else if (checkOnes(dice) >= 2) {
                smallerPair = 2;
            }
        } else if (largestPair == 4) {
            if (checkOnes(dice) >= 2) {
                smallerPair = 2;
            }
        }
        return smallerPair;
    }
    
    /**
     * Metodi tarkistaa noppien silmäluvuista mahdollisen kolme samaa-
     * suorituksen pistearvon.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Pistesuorituksen arvo.
     */
    public int checkThreeOfAKindScore(Dice dice) {
        int score = 0;
        if (checkThreeOfAKind(dice)) {
            if (checkSixes(dice) >= 3) {
                score = 18;
            } else if (checkFives(dice) >= 3) {
                score = 15;
            } else if (checkFours(dice) >= 3) {
                score = 12;
            } else if (checkThrees(dice) >= 3) {
                score = 9;
            } else if (checkTwos(dice) >= 3) {
                score = 6;
            } else if (checkOnes(dice) >= 3) {
                score = 3;
            }
        }
        return score;
    }
    
    /**
     * Metodi tarkistaa mikäli noppien silmäluvuista löytyy kolme
     * samaa arvoa.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Pistesuorituksen oikeellisuus.
     */
    public boolean checkThreeOfAKind(Dice dice) {
        boolean threeOfAKind = false;
        if (checkOnes(dice) > 2 || checkTwos(dice) > 2 || checkThrees(dice) > 2 || checkFours(dice) > 2 || checkFives(dice) > 2 ||
            checkSixes(dice) > 2) {
            threeOfAKind = true;
        } 
        return threeOfAKind;
    }
    
    /**
     * Metodi tarkistaa noppien silmäluvuista mahdollisen neljä samaa-
     * pistesuorituksen arvon.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Pistesuorituksen arvo.
     */
    public int checkFourOfAKindScore(Dice dice) {
        int score = 0;
        if (checkSixes(dice) >= 4) {
            score = 24;
        } else if (checkFives(dice) >= 4) {
            score = 20;
        } else if (checkFours(dice) >= 4) {
            score = 16;
        } else if (checkThrees(dice) >= 4) {
            score = 12;
        } else if (checkTwos(dice) >= 4) {
            score = 8;
        } else if (checkOnes(dice) >= 4) {
            score = 4;
        }
        return score;
    }
    
    /**
     * Metodi tarkistaa mikäli noppien silmäluvuista löytyy neljä samaa arvoa.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Mahdollisen pistesuorituksen oikeellisuus.
     */
    public boolean checkFourOfAKind(Dice dice) {
        boolean fourOfAKind = false;
        if (checkOnes(dice) > 3 || checkTwos(dice) > 3 || checkThrees(dice) > 3 || checkFours(dice) > 3 || checkFives(dice) > 3 ||
            checkSixes(dice) > 3) {
            fourOfAKind = true;
        }
        return fourOfAKind;
    }
    
    /**
     * Metodi tarkistaa mikäli noppien silmäluvuista voidaan koostaa
     * täyskäsi-suoritus eli sekä kolme samaa ja pari.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Mahdollisen pistesuorituksen oikeellisuus.
     */
    public boolean checkFullHouse(Dice dice) {
        boolean fullHouse = false;
        if (!checkFourOfAKind(dice) && checkThreeOfAKind(dice)) {
            if (checkOnes(dice) == 2 || checkTwos(dice) == 2 || checkThrees(dice) == 2 || checkFours(dice) == 2 ||
                checkFives(dice) == 2 || checkSixes(dice) == 2) {
                fullHouse = true;
            }
        }
        return fullHouse;
    }
    
    /**
     * Metodi tarkistaa täyskäsi-pistesuoritukseen sisältyvän parin arvon.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Parin pistearvo.
     */
    public int checkPairForFullHouse(Dice dice) {
        int pair = 0;
        if (checkSixes(dice) == 2) {
            pair = 12;
        } else if (checkFives(dice) == 2) {
            pair = 10;
        } else if (checkFours(dice) == 2) {
            pair = 8;
        } else if (checkThrees(dice) == 2) {
            pair = 6;
        } else if (checkTwos(dice) == 2) {
            pair = 4;
        } else if (checkOnes(dice) == 2) {
            pair = 2;
        }
        return pair;
    }
    
    /**
     * Metodi tarkistaa voidaanko noppien silmäluvuista muodostaa pieni suora eli
     * löytyvätkö noppien silmäluvuista arvot 1,2,3,4 ja 5.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Mahdollisen pistesuorituksen oikeellisuus.
     */
    public boolean checkSmallStraight(Dice dice) {
        boolean smallStraight = false;
        if (checkOnes(dice) == 1 && checkTwos(dice) == 1 && checkThrees(dice) == 1 && checkFours(dice) == 1 && checkFives(dice) == 1) {
            smallStraight = true;
        }
        return smallStraight;
    }
    
    /**
     * Metodi tarkistaa voidaanko noppien silmäoluvuista muodostaa suuri suora eli
     * löytyvätkö noppien silmäluvuista arvot 2,3,4,5 ja 6.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Mahdollisen pistesuorituksen oikeellisuus.
     */
    public boolean checkLargeStraight(Dice dice) {
        boolean largeStraight = false;
        if (checkTwos(dice) == 1 && checkThrees(dice) == 1 && checkFours(dice) == 1 && checkFives(dice) == 1 && checkSixes(dice) == 1) {
            largeStraight = true;
        }
        return largeStraight;
    }
    
    /**
     * Metodi tarkistaa voidaanko noppien silmäluvuista muodostaa kaksi erillistä paria.
     * 
     * @param dice Pelissä käytettävät viisi noppaa ja niiden arvot.
     * @return Mahdollisen pistesuorituksen oikeellisuus.
     */
    public boolean checkTwoPairs(Dice dice) {
        boolean twoPairs = false;
        if (checkFourOfAKind(dice)) {
            twoPairs = true;
        } else if (checkOnes(dice) >= 2) {
            if (checkTwos(dice) >= 2 || checkThrees(dice) >= 2 || checkFours(dice) >= 2 || checkFives(dice) >= 2 || checkSixes(dice) >= 2) {
                twoPairs = true;
            }
        } else if (checkTwos(dice) >= 2) {
            if (checkThrees(dice) >= 2 || checkFours(dice) >= 2 || checkFives(dice) >= 2 || checkSixes(dice) >= 2) {
                twoPairs = true;
            }
        } else if (checkThrees(dice) >= 2) {
            if (checkFours(dice) >= 2 || checkFives(dice) >= 2 || checkSixes(dice) >= 2) {
                twoPairs = true;
            }
        } else if (checkFours(dice) >= 2) {
            if (checkFives(dice) >= 2 || checkSixes(dice) >= 2) {
                twoPairs = true;
            }
        } else if (checkFives(dice) >= 2 && checkSixes(dice) >= 2) {
            twoPairs = true;
        }
        return twoPairs;
    }
    

    
    
}



