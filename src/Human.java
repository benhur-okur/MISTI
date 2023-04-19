import java.util.ArrayList;

public class Human extends Player{
    public Human() {
    }

    public Human(String name, String type, String point, ArrayList<Deck> hand, ArrayList<Board> earned, int numOfPlayers) {
        super(name, type, point, hand, earned, numOfPlayers);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void earn() {

    }

    @Override
    public void play() {

    }
}
