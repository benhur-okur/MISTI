import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        Board board = new Board();
        board.getDeck().createDeck();
        board.modSelect();
        board.playerSelect();
        board.createPlayers();
        board.firstFourCard();


        for (int i = 0; i < 20; i++) {
            board.dealCard();
            board.play();

        }

    }
}