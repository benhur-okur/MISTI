import java.util.ArrayList;

public abstract class Player {

    public Player() {
    }

    public Player(String name, String type, String point, ArrayList<String> hand, ArrayList<String> earnedWithoutPisti,ArrayList<String> earnedWithPisti, int numOfPlayers) {
        this.name = name;
        this.type = type;
        this.point = point;
        this.hand = hand;
        this.earnedWithoutPisti = earnedWithoutPisti;
        this.earnedWithPisti = earnedWithPisti;
        NumOfPlayers = numOfPlayers;
    }

    private String name;
    private String type;
    private String point;
    private ArrayList<String> hand = new ArrayList<>();
    private ArrayList<String> earnedWithoutPisti = new ArrayList<>();
    private ArrayList<String> earnedWithPisti = new ArrayList<>();

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

    public ArrayList<String> getHand() {
        return hand;
    }

    public void setHand(ArrayList<String> hand) {
        this.hand = hand;
    }

    public ArrayList<String> getEarnedWithoutPisti() {
        return earnedWithoutPisti;
    }

    public void setEarnedWithoutPisti(ArrayList<String> earnedWithoutPisti) {
        this.earnedWithoutPisti = earnedWithoutPisti;
    }

    public ArrayList<String> getEarnedWithPisti() {
        return earnedWithPisti;
    }

    public void setEarnedWithPisti(ArrayList<String> earnedWithPisti) {
        this.earnedWithPisti = earnedWithPisti;
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
    public abstract int play();




}
