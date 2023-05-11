import java.util.ArrayList;

public abstract class Player {
    //It's our abstract class, other player classes(expert,human...) will extend this class and override it's functions.

    public Player(String name) {
        this.name = name;
    }
    private Card card = new Card();
    private String name;
    private String type;
    private ArrayList<WonCardCollection> wonStacks = new ArrayList<>();
    private ArrayList<Card> hand = new ArrayList<>();

    public Card getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPoint() { //
        int total = 0;
        for (WonCardCollection wonStack: wonStacks){
            total += wonStack.getPoints();
        }
        return total;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addWonStack(ArrayList<Card> wonCards){
        this.wonStacks.add(new WonCardCollection(wonCards));
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public boolean hasJoker() {
        for (Card card : hand) {
            if (card.getFace().equals('J')) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCardWithSameFace(Card card) {
        for (Card playerCard : hand) {
            if (playerCard.getFace().equals(card.getFace())) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.hand.size() == 0;
    }

    protected abstract int decidePlayCardIndex(Board board);

    public final Card play(Board board){
        int playingCardIndex = this.decidePlayCardIndex(board);
        Card card = this.hand.get(playingCardIndex);
        this.hand.remove(playingCardIndex);
        board.increaseCounter(card);
        return card;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "Point = " + getPoint();
    }
}
