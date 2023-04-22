import java.util.ArrayList;
import java.util.Scanner;

public class Human extends Player{
    public int selectCard;
    public Human() {
    }

    public Human(String name, String type, String point, ArrayList<String> hand, ArrayList<Board> earned, int numOfPlayers) {
        super(name, type, point, hand, earned, numOfPlayers);
    }

    @Override
    public boolean isEmpty() {
        if (getHand().size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void earn() {

    }

    @Override
    public int play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Select a Card in your hand use index between 0 - 3 [both include] !");
        selectCard = sc.nextInt();
        return selectCard;

    }


}
