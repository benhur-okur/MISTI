import java.util.ArrayList;

public class NoviceBot extends Player{
    public NoviceBot() {
    }

    public NoviceBot(String name, String type, String point, ArrayList<Deck> hand, ArrayList<Board> earned, int numOfPlayers) {
        super(name, type, point, hand, earned, numOfPlayers);
    }
    @Override
    public boolean isEmpty() {
        if (getHand().size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void earn() {

    }

    @Override
    public void play() {

    }
}
