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
            System.out.println(board.getCardsOnTheBoard());
        }

        System.out.println(board.getPlayers());
//        System.out.println("Pİştisiz: " + board.gethPlayer().getEarnedWithoutPisti());
//        System.out.println("Pİştili:" + board.gethPlayer().getEarnedWithPisti());
//        System.out.println("Pİştisiz: " + board.eBots[0].getEarnedWithoutPisti());
//        System.out.println("Pİştili: " + board.eBots[0].getEarnedWithPisti());
        System.out.println("Game has finished!!");


    }
}