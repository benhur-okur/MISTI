import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Board board = new Board();
        board.howManyPlayers();
       // board.playForRegularB();

        board.modSelect();
        board.getDeck().createDeck();
        while(board.getDeck().deck.size() != 0) {
            board.dealCard();
            board.displayHand();
            board.getTopCard();
        }



        /*for (int i = 0;i<2;i++) {
            board.playForRegularB();
        }*/
    }
}