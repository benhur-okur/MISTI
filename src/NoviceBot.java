import java.util.Random;

public class NoviceBot extends Player{

    public NoviceBot(String name) {
        super(name);
    }

    @Override
    protected int decidePlayCardIndex(Board board){
        Random ran = new Random();
        int cardIndex = ran.nextInt(getHand().size());

        return cardIndex;
    }
}
