import java.util.ArrayList;

import static java.lang.Integer.MIN_VALUE;

public class RegularBot extends Player {

    public RegularBot(String name) {
        super(name);
    }

    @Override
    protected int decidePlayCardIndex(Board board) {
        // bu method için parametre ekliceez RegularBot tipinde !
        // Bot hangi kartı oynayacağına karar verecek ver Card nesnesi return edecek.
        Card topCard = board.getTopCard();
        ArrayList<Card> cardsOnTheBoard = board.getKnownCardsOnTheBoard();

        int maxPointValue = MIN_VALUE;
        int maxPointValueCardIndex = 0;
        int nthCardPointValue;

        for (int i = 0; i < getHand().size(); i++) {
            Card card = getHand().get(i);
            if (topCard != null && (topCard.getFace().equals(card.getFace()) || card.isJack())) { // this is a possible win case
                ArrayList<Card> hypoteticalWonStackCards = new ArrayList<>();
                for (Card cardOnTheBoard : cardsOnTheBoard) {
                    hypoteticalWonStackCards.add(cardOnTheBoard);
                }
                hypoteticalWonStackCards.add(card);
                WonCardCollection hypoteticalWonStack = new WonCardCollection(hypoteticalWonStackCards);

                nthCardPointValue = hypoteticalWonStack.getPoints();
                // map yap: cardIndex'den atarsam kazanacağım puana
                // Key: cardIndex( at hand), value: collection.getPoints
            } else {
                nthCardPointValue = 0;
            }

            if (maxPointValue < nthCardPointValue) {
                maxPointValue = nthCardPointValue;
                maxPointValueCardIndex = i;
            }
        }
        return maxPointValueCardIndex;
    }
}
