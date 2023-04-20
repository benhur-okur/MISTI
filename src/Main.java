import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Board board = new Board();
        board.howManyPlayers();
        board.dealCard();
        board.playForRegularB();



        /*for (int i = 0;i<2;i++) {
            board.playForRegularB();
        }*/
    }
}