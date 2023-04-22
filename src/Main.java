import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Board board = new Board();
        board.getDeck().createDeck();
        board.howManyPlayers();

        while(board.getDeck().deck.size() != 0){
            board.dealCard();
            while(board.gethPlayer().getHand().size() > 0 && board.getnPlayer().getHand().size() > 0){
                System.out.println(board.getTopCard());
                board.humanPlay();
                board.novicePlay();
            }

        }



    }
}