import java.util.Scanner;

public class Human extends Player{
    public Human(String name) {
        super(name);
    }

    @Override
    protected int decidePlayCardIndex(Board board){
        // ToDo: Please select a card using index between 0 - ???
        // for( Card card: hand ){ print'te hand.getFace, hand.getSuit vs } )
        // seçtikten sonra da  index kullanarak Card return et
        Scanner sc = new Scanner(System.in);

        System.out.println("Please Select a Card in your hand use index between 0 - %d [both include] !");
        int selectCard = sc.nextInt();

        return selectCard;
    }
}
