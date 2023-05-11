import java.io.*;
import java.util.*;
import static java.lang.Integer.MIN_VALUE;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayList<Integer> topPlayersPoint = new ArrayList<>();
        ArrayList<String> topPlayerName = new ArrayList<>();
        Deck deck = new Deck();
        Board board = new Board(deck);
        board.playerSelect();
        board.modSelect();
        board.createPlayers();
        deck.shuffleDeck();
        deck.cutDeck();

        board.firstFourCard();
        board.dealCard();
        while (true) {
            for (int i = 0; i < 4; i++) {
                board.play(); // S6 C7 H9 DK

            }
            if (deck.deck.size() == 0) {
                break;
            }
            board.dealCard();
            System.out.println("Top card: " + board.getTopCard());
        }

        int maxPoint = MIN_VALUE;
        System.out.println("Game has finished!!");
        System.out.println("Points are coming");
        Thread.sleep(2000);
        for (Player player : board.getPlayers()) {
            //System.out.println(player.;);
            System.out.println(player.getName() + "Earned " + player.getPoint() + " Point");

        }
        for (int i = 0; i < board.getPlayers().size(); i++) {
            if (maxPoint < board.getPlayers().get(i).getPoint()) {
                maxPoint = board.getPlayers().get(i).getPoint();
                topPlayersPoint.add(maxPoint);
                topPlayerName.add(board.getPlayers().get(i).getName());
                for (int j = 0; j < topPlayersPoint.size(); j++) {
                    if (topPlayersPoint.get(j) != maxPoint) {
                        topPlayersPoint.remove(topPlayersPoint.get(j));
                        topPlayerName.remove(topPlayerName.get(j));
                    }
                }

            }
        }
        System.out.println(topPlayerName.get(0) + "has won with: " + topPlayersPoint.get(0) + " point");



    }
}