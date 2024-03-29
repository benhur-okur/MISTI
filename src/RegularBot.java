import java.util.ArrayList;

import static java.lang.Integer.MIN_VALUE;

public class RegularBot extends Player {

    public RegularBot(String name) {
        super(name);
    }

    @Override
    protected int decidePlayCardIndex(Board board) {
        Card topCard = board.getTopCard();
        ArrayList<Card> cardsOnTheBoard = board.getKnownCardsOnTheBoard();

        int maxPointValue = MIN_VALUE;
        int maxPointValueCardIndex = 0;
        int nthCardPointValue;

        for (int i = 0; i < getHand().size(); i++) {
            Card card = getHand().get(i);
            if (topCard != null) {
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


                nthCardPointValue = hypoteticalWonStack.getPoints();
            } else {
                nthCardPointValue = 0;}

            if (maxPointValue < nthCardPointValue) {
                maxPointValue = nthCardPointValue;
                maxPointValueCardIndex = i;}
            break;}
        return maxPointValueCardIndex;}

                if (maxPointValue < nthCardPointValue) {
                    maxPointValue = nthCardPointValue;
                    maxPointValueCardIndex = i;
                }
            }


        return maxPointValueCardIndex;
    }

