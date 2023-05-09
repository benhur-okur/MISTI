import java.util.ArrayList;

import static java.lang.Integer.MIN_VALUE;

public class ExpertBot extends Player{
    public ExpertBot(String name) {
        super(name);
    }

    protected int decidePlayCardIndex(Board board){
        // bu method için parametre ekliceez RegularBot tipinde !
        // Bot hangi kartı oynayacağına karar verecek ver Card nesnesi return edecek.
        Card topCard = board.getTopCard();
        ArrayList<Card> cardsOnTheBoard = board.getKnownCardsOnTheBoard();

        //

        if (cardsOnTheBoard.size() == 0) {

            // Atacağım pozitif kart pişti yapılamasın. If ( count === 3 && pointValue > 0, sakla bunu, atma  )

            // Atacağım negatif kart pişti yapılabilsin, ya da alınabilsin. If ( count < 3 && pointValue < 0, kartı at, negatife pişti yapsınlar  )

        }

        int maxPointValue = MIN_VALUE;
        int maxPointValueCardIndex = 0;
        int nthCardPointValue;

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
            }else{
                nthCardPointValue = 0;
            }

            if (maxPointValue < nthCardPointValue) {
                maxPointValue = nthCardPointValue;
                maxPointValueCardIndex = i;
            }
        }

        if(maxPointValue == 0){
            // try to decrease the stake size, throw minimum valued card

        }

        return maxPointValueCardIndex;
    }
}
