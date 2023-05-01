import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Board board = new Board();
        board.getDeck().createDeck();
        board.playerSelect();
        System.out.println(board.chosenBotList);
        board.modSelect();
        board.createPlayers();

        for (int i = 0; i < (48/(board.getNoOfPlayer()*4)); i++) {
            board.dealCard();
            board.play();

        }
        System.out.println("Game has finished!!");


    }
}