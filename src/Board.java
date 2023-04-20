import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Board {
    Random ran = new Random();
    Scanner sc = new Scanner(System.in);
    private Point point = new Point();
    private boolean matchingValue = false;
    private ArrayList<Character> chosenBotList = new ArrayList<>();

    private ArrayList<String> board = new ArrayList<>();
    private boolean isHuman; // we will use this data for dealing the hand for human or not;
    private String askingUser; // in this data we are asking the user whether he or she is playing as a player;

    private Human hPlayer = new Human();
    private NoviceBot nPlayer = new NoviceBot();
    private RegularBot rPlayer = new RegularBot();
    private ExpertBot ePlayer = new ExpertBot();
    private Deck deck = new Deck();
    //private Mod mod;
    private int noOfPlayer;
    private int counter = 0;
    private int counter2 = 0;

    public ArrayList<String> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<String> board) {
        this.board = board;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Board() throws FileNotFoundException {}

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
            sc.nextLine();
            askingUser = sc.nextLine();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        if (askingUser.equalsIgnoreCase("YES")) {
            isHuman = true;
        } else {
            isHuman = false;
        }
    }
    public void dealCard() throws InterruptedException {
        deck.displayDeck();
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
           }if(counter >= 4){
               if(isHuman) {
                   System.out.println("Which bot do you want to play?");
                   System.out.println("'Novice', 'Regular', 'Expert'");
                   sc.nextLine();
                   String s = sc.nextLine();
                   if (s.equalsIgnoreCase("NOVİCE")) {
                       chosenBotList.add('N'); // bnunu büyük harf kucuk harf sıkıntısı olabilir ileride dikkat!!
                       System.out.println("Novice bot has selected!");
                       for (int i = 0; i < 4; i++) {
                           hPlayer.getHand().add(deck.deck.get(i));
                           deck.deck.remove(i);
                           nPlayer.getHand().add(deck.deck.get(i));
                           deck.deck.remove(i);
                       }
                   } else if (s.equalsIgnoreCase("REGULAR")) {
                       chosenBotList.add('R');
                       System.out.println("Regular bot has selected!");
                       for (int i = 0; i < 4; i++) {
                           hPlayer.getHand().add(deck.deck.get(i));
                           deck.deck.remove(i);
                           rPlayer.getHand().add(deck.deck.get(i));
                           deck.deck.remove(i);
                       }
                   } else if (s.equalsIgnoreCase("EXPERT")) {
                       chosenBotList.add('E');
                       System.out.println("Expert bot has selected!");
                       for (int i = 0; i < 4; i++) {
                           hPlayer.getHand().add(deck.deck.get(i));
                           deck.deck.remove(i);
                           ePlayer.getHand().add(deck.deck.get(i));
                           deck.deck.remove(i);
                       }
                   }

               }else {
                   System.out.println("Which bot do you want to play?");
                   System.out.println("'Novice', 'Regular', 'Expert'");
                   String s = sc.nextLine();
                   if (s.equalsIgnoreCase("NOVİCE")) {
                       chosenBotList.add('N'); // bnunu büyük harf kucuk harf sıkıntısı olabilir ileride dikkat!!
                       System.out.println("Novice bot has selected!");
                       for (int i = 0; i < 4; i++) {
                           nPlayer.getHand().add(deck.deck.get(i));
                           deck.deck.remove(i);
                       }
                   } else if (s.equalsIgnoreCase("REGULAR")) {
                       chosenBotList.add('R');
                       System.out.println("Regular bot has selected!");
                       for (int i = 0; i < 4; i++) {
                           rPlayer.getHand().add(deck.deck.get(i));
                           deck.deck.remove(i);
                       }
                   } else if (s.equalsIgnoreCase("EXPERT")) {
                       chosenBotList.add('E');
                       System.out.println("Expert bot has selected!");
                       for (int i = 0; i < 4; i++) {
                           ePlayer.getHand().add(deck.deck.get(i));
                           deck.deck.remove(i);
                       }
                   }

               }
           }
       }
    }
    public void playForRegularB() throws IOException {
        boolean isSameValue = false;
        int countPistiIndex = 0;
        Character chr;
        chr = point.bReader.readLine().charAt(3); //close the readerd don't forget!
        point.bReader.close();
        if(board.size() == 1 && chr.equals('+') ) {
            board.add(String.valueOf(getCardForRegularB()));
        } else if(chr.equals('+') ) {
            board.add(String.valueOf(getCardForRegularB()));
        } else {
            board.add(String.valueOf(getCardForRegularB()));
        }
    }

    public String getCardForRegularB() { // regular bot'un elinden cıkardıgı kart.
        matchingValue = false;
        for (int i = 0;i<rPlayer.getHand().size();i++) {
            if(rPlayer.getHand().get(i).charAt(1) == (getTopCard().charAt(1))) {
                matchingValue = true;
                return rPlayer.getHand().get(i);
            }
        }
        return rPlayer.getHand().get(ran.nextInt(4));
    }
    public String getTopCard(){
        return board.get(board.size()-1);
    }
    int modNo;
    public void modSelect() throws InterruptedException {
            try {
                System.out.println("Please select game mod");
                System.out.println("1 -> SelfMod (this mod just shows hand of human player)");
                System.out.println("2 -> SpectateMod (this mod shows all hands of player )");
                modNo = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Please select valid number you can select 1 ");
                System.out.println(ex.toString());
            }

    }
    public void displayHand() throws InterruptedException {

        if(!isHuman) {
            for (int i = 0;i<chosenBotList.size();i++) {
                Thread.sleep(1500);
                if (chosenBotList.get(i).equals('N')) {
                    System.out.println("Novice bot's hand : " + nPlayer.getHand());
                }
                else if (chosenBotList.get(i).equals('R')) {
                    System.out.println("Regular bot's hand : " + rPlayer.getHand());
                }
                else if (chosenBotList.get(i).equals('N')) {
                    System.out.println("Expert bot's hand : " + ePlayer.getHand());
                }
            }
        } else if (modNo == 1) {
            for (int i = 0;i<chosenBotList.size();i++) {
                Thread.sleep(1500);
                if (chosenBotList.get(i).equals('N')) {
                    System.out.println("Novice bot's hand : " + nPlayer.getHand());
                }
                else if (chosenBotList.get(i).equals('R')) {
                    System.out.println("Regular bot's hand : " + rPlayer.getHand());
                }
                else if (chosenBotList.get(i).equals('N')) {
                    System.out.println("Expert bot's hand : " + ePlayer.getHand());
                }
            }
        } else if (modNo == 2) {
            for (int i = 0;i<chosenBotList.size();i++) {
                Thread.sleep(1500);
                if (chosenBotList.get(i).equals('N')) {
                    System.out.println("Novice bot's hand : " + nPlayer.getHand());
                }
                else if (chosenBotList.get(i).equals('R')) {
                    System.out.println("Regular bot's hand : " + rPlayer.getHand());
                }
                else if (chosenBotList.get(i).equals('N')) {
                    System.out.println("Expert bot's hand : " + ePlayer.getHand());
                }
            }
        }

    }

    /*private void singleReturnMethods() {
        if (c < 1) {
            getDeck().cutDeck();
            getDeck().shuffleDeck();

        }

    }*/
}
