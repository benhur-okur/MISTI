import java.util.ArrayList;
import java.util.Random;

public class NoviceBot extends Player{

    public int noviceSelect;
    public NoviceBot() {
    }

    public NoviceBot(String name, String type, String point, ArrayList<String> hand, ArrayList<Board> earned, int numOfPlayers) {
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
    public int play() {
        Random ran = new Random();
        noviceSelect = ran.nextInt(4);
        return noviceSelect;
    }
}
