import java.util.ArrayList;

public abstract class Player {

    public Player() {
    }

    public Player(String name, String type, String point, ArrayList<Deck> hand, ArrayList<Board> earned, int numOfPlayers) {
        this.name = name;
        this.type = type;
        this.point = point;
        this.hand = hand;
        this.earned = earned;
        NumOfPlayers = numOfPlayers;
    }

    private String name;
    private String type;
    private String point;
    private ArrayList<Deck> hand = new ArrayList<>();
    private ArrayList<Board> earned = new ArrayList<>();
    private int NumOfPlayers;

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

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public ArrayList<Deck> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Deck> hand) {
        this.hand = hand;
    }

    public ArrayList<Board> getEarned() {
        return earned;
    }

    public void setEarned(ArrayList<Board> earned) {
        this.earned = earned;
    }

    public int getNumOfPlayers() {
        return NumOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        NumOfPlayers = numOfPlayers;
    }



//    +boolean isEmpty()
//    +String getPisti();
//    +void earn();
//    +void play();
    public abstract boolean isEmpty();
    public abstract void earn();
    public abstract void play();
}
