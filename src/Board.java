import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    Scanner sc = new Scanner(System.in);
    private Point point;
    private ArrayList<String> board = new ArrayList<>();
    private boolean isHuman; // we will use this data for dealing the hand for human or not;
    private String askingUser; // in this data we are asking the user whether he or she is playing as a player;

    private Human hPlayer;
    private NoviceBot nPlayer;
    private RegularBot rPlayer;
    private ExpertBot ePlayer;
    private Deck deck;
    //private Mod mod;
    private int noOfPlayer;
    private int counter = 0;

    public void makePisti() throws IOException {
        boolean isSameValue = false;
        int countPistiIndex = 0;
        Character chr;
        chr = point.bReader.readLine().charAt(3);
        if(board.size() == 1 && chr.equals("+") && board) {

        }
    }

    public void howManyPlayers() {
        while(noOfPlayer != 2 && noOfPlayer != 4) {
            System.out.println("How many players will be in the board '2 or 4' ?");
            try {
                noOfPlayer = sc.nextInt();
            } catch (Exception ex) {
                System.out.println(ex.toString());;
            }
        }
        System.out.println("Do you want to be a part of this game as a player? (yes / no) ");
        try {
            askingUser = sc.nextLine();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        if (askingUser.toUpperCase().equals("YES")) {
            isHuman = true;
        } else {
            isHuman = false;
        }
    }
    public void dealCard(){
       if(noOfPlayer == 2){
           //Deal cards on board
           if(counter < 4) {
               for(int i=0;i<4;i++){
                   counter++;
                   board.add(deck.deck.get(0));
                   deck.deck.remove(0);
               }
               System.out.println("Cards has dealt to the table");
               System.out.println("Top card: " + board.get(3));
           }else if(counter > 4){
               if(isHuman == true){
                   System.out.println("Which bot do you want to play?");
                   System.out.println("'Novice', 'Regular', 'Expert'");
                   String s = sc.nextLine();
                   if(s.toUpperCase().equals("NOVİCE")){
                       System.out.println("Novice bot has selected!");
                       for(int i=0;i<deck.deck.size();i++){

                       }
                   }else if(s.toUpperCase().equals("REGULAR")){
                       System.out.println("Regular bot has selected!");

                   }else if(s.toUpperCase().equals("EXPERT")){
                       System.out.println("Expert bot has selected!");

                   }
               }

           }



       }
    }

    public int getSameCardIndex() {
        int counter = 0;
        for (int i = 0;i<hPlayer.getHand().size();i++) {
            if(hPlayer.getHand().get(i) == getTopCard())
        }
    }

    public String getTopCard(){
        return board.get(board.size()-1);
    }


}
