import java.io.IOException;

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
        board.dealCard();
        while(true){
            for(int i = 0;i < 4; i++ ){
                board.play(); // S6 C7 H9 DK

            }
            if( deck.deck.size() == 0){
                break;
            }
            board.dealCard();
            System.out.println("Top card: " + board.getTopCard());
        }

        System.out.println("Game has finished!!");
        System.out.println("Points are coming");
        Thread.sleep(2000);
        for (Player player : board.getPlayers()) {
            System.out.println(player.getName() + "Earned " + player.getPoint() + " Point");
        }


    }
}