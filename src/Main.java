import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Board board = new Board();
        board.getDeck().createDeck();
        board.howManyPlayers();

        while(board.getDeck().deck.size() != 0){
            board.dealCard();
            board.humanPlay();
            board.getTopCard();
        }



    }
}