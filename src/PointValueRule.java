public class PointValueRule {
    private String face;
    private String suit;
    private int pointValue;

    public PointValueRule(String face, String suit, int pointValue) {
        this.face = face;
        this.suit = suit;
        this.pointValue = pointValue;
    }

    public String getFace() {
        return face;
    }

    public String getSuit() {
        return suit;
    }

    public int getPointValue() {
        return pointValue;
    }

    @Override
    public String toString() {
        return "PointValueRule{" +
                "face='" + face + '\'' +
                ", suit='" + suit + '\'' +
                ", pointValue=" + pointValue +
                '}';
    }
}
