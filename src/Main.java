import java.io.*;
import java.util.*;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.max;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        Deck deck = new Deck();
        Board board = new Board(deck);
        board.playerSelect();
        board.modSelect();
        board.createPlayers();
        deck.shuffleDeck();
        deck.cutDeck();

        board.firstFourCard();
        while (deck.deck.size() > 0) {
            board.dealCard();
            for (int i = 0; i < 4; i++) {
                board.play(); // S6 C7 H9 DK
            }
            System.out.println("Top card: " + board.getTopCard());
        }

        System.out.println("--------GAME HAS FINISHED--------");
        Thread.sleep(1000);
        System.out.println("--------POINTS ARE COMING--------" +
                "");
        Thread.sleep(1500);
        for (Player player : board.getPlayers()) {
            //System.out.println(player.;);
            System.out.println(player.getName() + "Earned " + player.getPoint() + " Point");
        }
        Player winner = board.getWinner();

        System.out.println(winner.getName() + "has won with: " + winner.getPoint() + " point");

        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.apply(winner);
        scoreBoard.export();
        scoreBoard.show();
    }
}