import java.io.IOException;
import java.util.ArrayList;
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


    /*public void makePisti() throws IOException {
        Character chr;
        chr = point.bReader.readLine().charAt(3);
        if(board.size() == 1 && chr.equals("+") && board) {

        }
    }*/

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

       }
    }


}
