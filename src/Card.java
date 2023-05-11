public class Card {
    private String face;
    private String suit;
    private int pointValue;

    public Card(String face, String suit, int pointValue) {
        this.face = face;
        this.suit = suit;
        this.pointValue = pointValue;
    }

    public Card() {
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    @Override
    public String toString() {
        return
                suit + face  + " -> point: " + pointValue;
    }

    public boolean isJack(){
        return this.getFace().equals("J");
    }
    // ToDo: add toString method


}
