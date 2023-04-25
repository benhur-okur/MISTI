import java.util.ArrayList;
import java.util.Random;

public class NoviceBot extends Player{

    public int noviceSelect;
    public NoviceBot() {
    }

    public NoviceBot(String name, String type, String point, ArrayList<String> hand, ArrayList<String> earnedWithoutPisti, ArrayList<String> earnedWithPisti, int numOfPlayers, int noviceSelect) {
        super(name, type, point, hand, earnedWithoutPisti, earnedWithPisti, numOfPlayers);
        this.noviceSelect = noviceSelect;
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
        noviceSelect = ran.nextInt(getHand().size());
        return noviceSelect;
    }
}
