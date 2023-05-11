import java.util.ArrayList;

public class WonCardCollection {
    private ArrayList<Card> cards;

    private boolean isPisti;

    public WonCardCollection(ArrayList<Card> cards) {
        this.cards = new ArrayList<>();
        for (Card card : cards) {
            this.cards.add(card);
        }
        this.isPisti = cards.size() == 2 && cards.get(0).getFace().equals(cards.get(1).getFace());
        //Todo: clarify Eğer Jack + Jack pişti olmaz ise, yukarıya ekse &&  ( !cards.get(0).isJack() )
    }

    public boolean isPisti() {
        return isPisti;
    }

    private int getCardPointValues(){
        int total = 0;
        for (Card card: cards){
            total += card.getPointValue();
        }
        return total;
    }

    public int getPoints() {
        int cardTotalValues = this.getCardPointValues();
        if(this.isPisti){
            return 5 * cardTotalValues;
        }
        return cardTotalValues;
    }

    @Override
    public String toString() {
        return "WonCardCollection{\n" +
                "cards=" + cards +
                ", isPisti=" + isPisti +
                "}\n";
    }
}
