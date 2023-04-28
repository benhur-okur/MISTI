import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {



        Board board = new Board();
        board.getDeck().createDeck();
        board.playerSelect();
        board.createPlayers();
        for (int i = 0;i<20;i++){
            System.out.println(board.iN);
            //board.dealCard();
            board.play();

        }

    }
}