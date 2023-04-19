import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    Scanner sc = new Scanner(System.in);
    private Point point;
    private ArrayList<String> board = new ArrayList<>();

    private int noOfPlayer;


    /*public void makePisti() throws IOException {
        Character chr;
        chr = point.bReader.readLine().charAt(3);
        if(board.size() == 1 && chr.equals("+") && board) {

        }
    }*/

    public void howManyPlayers() {
        System.out.println("How many players will be in the board 2 or 4 ?");
        try {
            noOfPlayer = sc.nextInt();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
