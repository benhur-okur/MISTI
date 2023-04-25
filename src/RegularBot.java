import java.util.ArrayList;
import java.util.Random;

public class RegularBot extends Player{
    public RegularBot() {
    }

    public RegularBot(String name, String type, String point, ArrayList<String> hand, ArrayList<String> earnedWithoutPisti, ArrayList<String> earnedWithPisti, int numOfPlayers) {
        super(name, type, point, hand, earnedWithoutPisti, earnedWithPisti, numOfPlayers);
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
