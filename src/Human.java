import java.util.Scanner;

public class Human extends Player{
    public Human(String name) {
        super(name);
    }

    @Override
    protected int decidePlayCardIndex(Board board){
        Scanner sc = new Scanner(System.in);

        System.out.printf("Please Select a Card in your hand use index between 0 - %d [both include] !%n", getHand().size()-1);
        int selectCard = sc.nextInt();

        return selectCard;
    }
}
