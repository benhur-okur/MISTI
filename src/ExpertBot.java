import java.util.ArrayList;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class ExpertBot extends Player{
    public ExpertBot(String name) {
        super(name);
    }


    private boolean isThereNegativeCardInHand() {
        boolean atLeastOneCardNegative = false;
        for (Card hand : getHand()) {
            if (hand.getPointValue() < 0) {
                atLeastOneCardNegative = true;
            }
        }
        return atLeastOneCardNegative;
    }

    ArrayList<Integer> indexesOfNegativeCards = new ArrayList<>();
    private ArrayList<Integer> whichCardsAreNegative() {
        indexesOfNegativeCards.clear();
        for (int i = 0;i<getHand().size();i++) {
            if (getHand().get(i).getPointValue() < 0) {
                indexesOfNegativeCards.add(i);
            }
        }
        return indexesOfNegativeCards;
    }

    protected int decidePlayCardIndex(Board board){
        // bu method için parametre ekliceez RegularBot tipinde !
        // Bot hangi kartı oynayacağına karar verecek ver Card nesnesi return edecek.
        Card topCard = board.getTopCard();
        ArrayList<Card> cardsOnTheBoard = board.getKnownCardsOnTheBoard();

        //
        int negativeCardsIndex = 0;
        if (topCard == null) {      // orta null ise
            if(isThereNegativeCardInHand()) {
                return board.findCardsCountMin(getHand(), whichCardsAreNegative()); // return statement
            } else {
                return board.findCardsCountMax(getHand()); // return statement
            }
            // Atacağım pozitif kart pişti yapılamasın. If ( count == 3 && pointValue > 0, sakla bunu, atma  )
            // Atacağım negatif kart pişti yapılabilsin, ya da alınabilsin. If ( count < 3 && pointValue < 0, kartı at, negatife pişti yapsınlar  )
        }

        int maxPointValue = MIN_VALUE;
        int maxPointValueCardIndex = 0;
        int nthCardPointValue;


        int cardWhichIsMinValue = MAX_VALUE;
        int nthCardMinValue;
        int nthCardMinValueIndex = 0;

            for (int i = 0; i < getHand().size(); i++) {
                Card card = getHand().get(i);
                if (topCard.getFace().equals(card.getFace()) || card.isJack()) { // this is a possible win case
                    ArrayList<Card> hypoteticalWonStackCards = new ArrayList<>();
                    for (Card cardOnTheBoard : cardsOnTheBoard) {
                        hypoteticalWonStackCards.add(cardOnTheBoard);
                    }
                    hypoteticalWonStackCards.add(card);
                    WonCardCollection hypoteticalWonStack = new WonCardCollection(hypoteticalWonStackCards);
                    nthCardPointValue = hypoteticalWonStack.getPoints();
                } else {
                    nthCardPointValue = 0;
                }

                if (maxPointValue < nthCardPointValue) {
                    maxPointValue = nthCardPointValue;
                    maxPointValueCardIndex = i;
                }
            }



        int minPointValue = MAX_VALUE;
        int minPointValueCardIndex = 0;
        int nthCardMinPointValue;

        if(maxPointValue < 0){ // in here ı am changing the code block !! in original it was like : if(maxPointValue == 0);
            for (int j = 0;j<getHand().size();j++) {
                nthCardMinPointValue = getHand().get(j).getPointValue();
                if (nthCardMinPointValue < minPointValue) {
                    minPointValue = nthCardMinPointValue;
                    minPointValueCardIndex = j;
                }
            }
            // try to decrease the stake size, throw minimum valued card
            return minPointValueCardIndex;
        }

        return maxPointValueCardIndex;
    }
    /*private int calculateTotalPointOfBoard () {
        int total = 0;
        for (Card hand : getHand()) {
            total += hand.getPointValue();
        }
        return total;
    }*/
}
