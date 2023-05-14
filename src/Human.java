import java.util.Scanner;

public class Human extends Player{
    public Human(String name) {
        super(name);
    }

    @Override
    protected int decidePlayCardIndex(Board board){
        int selectCard = -1;
        boolean trueIndex = false;
        // ToDo: Please select a card using index between 0 - ???
        // for( Card card: hand ){ print'te hand.getFace, hand.getSuit vs } )
        // seçtikten sonra da  index kullanarak Card return et
        Scanner sc = new Scanner(System.in);

        do {
            System.out.printf("Please Select a Card in your hand use index between 0 - %d [both include] !%n", getHand().size() - 1);
            try {
                selectCard = sc.nextInt();
                if (selectCard >= 0 && selectCard <= (getHand().size()-1)) {
                    trueIndex = true;
                } else {
                    System.out.printf("Please Select a Card in your hand use index between 0 - %d [both include] !%n", getHand().size() - 1);                }
            } catch (Exception e) {
                System.out.printf("Please Select a Card in your hand use index between 0 - %d [both include] !%n", getHand().size() - 1);
                sc.next(); // clear the input buffer
            }
        } while (!trueIndex);

        /*while (selectCard < 0 || selectCard > getHand().size()-1) {

            System.out.printf("Please Select a Card in your hand use index between 0 - %d [both include] !%n", getHand().size() - 1);
            selectCard = Integer.parseInt(sc.nextLine());
        }*/

        return selectCard;
    }
}
