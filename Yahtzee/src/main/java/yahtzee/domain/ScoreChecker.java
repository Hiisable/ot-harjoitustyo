
package yahtzee.domain;


public class ScoreChecker {
    
    public ScoreChecker() {
        
    }
    
    public int checkOnes(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 1) {
                score = score + 1;
            }
        }
        return score;    
    }
    
    public int checkTwos(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 2) {
                score = score + 1;
            }
        }
        return score;
    }
    
    public int checkThrees(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 3) {
                score = score + 1;
            }
        }
        return score;
    }
    
    public int checkFours(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 4) {
                score = score + 1;
            }
        }
        return score;
    }
    
    public int checkFives(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 5) {
                score = score + 1;
            }
        }
        return score;
    }
    
    public int checkSixes(Dice dice) {
        int score = 0;
        for (int i = 0; i < 5; i++) {
            if (dice.getValueOfDie(i) == 6) {
                score = score + 1;
            }
        }
        return score;
    }
    
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
    
    public boolean checkPair(Dice dice) {
        boolean pair = false;
        if (checkOnes(dice) > 1 || checkTwos(dice) > 1 || checkThrees(dice) > 1 || checkFours(dice) > 1 || checkFives(dice) > 1 ||
            checkSixes(dice) > 1) {
            pair = true;
        } 
        return pair;
    }
    
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
    
    public boolean checkThreeOfAKind(Dice dice) {
        boolean threeOfAKind = false;
        if (checkOnes(dice) > 2 || checkTwos(dice) > 2 || checkThrees(dice) > 2 || checkFours(dice) > 2 || checkFives(dice) > 2 ||
            checkSixes(dice) > 2) {
            threeOfAKind = true;
        } 
        return threeOfAKind;
    }
    
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
    
    public boolean checkFourOfAKind(Dice dice) {
        boolean fourOfAKind = false;
        if (checkOnes(dice) > 3 || checkTwos(dice) > 3 || checkThrees(dice) > 3 || checkFours(dice) > 3 || checkFives(dice) > 3 ||
            checkSixes(dice) > 3) {
            fourOfAKind = true;
        }
        return fourOfAKind;
    }
    
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
    
    public boolean checkSmallStraight(Dice dice) {
        boolean smallStraight = false;
        if (checkOnes(dice) == 1 && checkTwos(dice) == 1 && checkThrees(dice) == 1 && checkFours(dice) == 1 && checkFives(dice) == 1) {
            smallStraight = true;
        }
        return smallStraight;
    }
    
    public boolean checkLargeStraight(Dice dice) {
        boolean largeStraight = false;
        if (checkTwos(dice) == 1 && checkThrees(dice) == 1 && checkFours(dice) == 1 && checkFives(dice) == 1 && checkSixes(dice) == 1) {
            largeStraight = true;
        }
        return largeStraight;
    }
    
    public boolean checkTwoPairs(Dice dice) {
        boolean twoPairs = false;
        if (checkOnes(dice) >= 2) {
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



