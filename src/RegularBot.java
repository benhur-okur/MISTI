import java.util.ArrayList;
import java.util.Random;

public class RegularBot extends Player{
    public RegularBot() {
    }

    public RegularBot(String point, ArrayList<String> hand, ArrayList<Board> earned, int numOfPlayers) {
        super("RegularBot", "Level-2", point, hand, earned, numOfPlayers);
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
        return 0;
    }


}
