import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        Board board = new Board();
        board.getDeck().createDeck();
        board.playerSelect();
        board.modSelect();
        board.createPlayers();

        for (int i = 0; i < (48/(board.getNoOfPlayer()*4)); i++) {
            board.dealCard();
            System.out.println(board.getBoard());
            board.play(); // S6 C7 H9 DK

        }
        System.out.println("Pİştisiz: " + board.gethPlayer().getEarnedWithoutPisti());
        System.out.println("Pİştili:" + board.gethPlayer().getEarnedWithPisti());
        System.out.println("Pİştisiz: " + board.eBots[0].getEarnedWithoutPisti());
        System.out.println("Pİştili: " + board.eBots[0].getEarnedWithPisti());
        System.out.println("Game has finished!!");


    }
}