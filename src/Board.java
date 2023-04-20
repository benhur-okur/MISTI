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

    public Board() throws FileNotFoundException {
    }

    public void howManyPlayers() {
        while (noOfPlayer != 2 && noOfPlayer != 4) {
            System.out.println("How many players will be in the board '2 or 4' ?");
            try {
                noOfPlayer = sc.nextInt();
            } catch (Exception ex) {
                System.out.println(ex.toString());
                ;
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
        if (noOfPlayer == 2) {
            //Deal cards on board
            if (counter < 4) {
                for (int i = 0; i < 4; i++) {
                    counter++;
                    board.add(deck.deck.get(0));
                    deck.deck.remove(0);
                }
                System.out.println("Cards has dealt to the table");
                System.out.println("Top card: " + board.get(3));
            }
            if (counter >= 4) {

            }
        }
    }


    public void playForRegularB() throws IOException {
        boolean isSameValue = false;
        int countPistiIndex = 0;
        Character chr;
        chr = point.bReader.readLine().charAt(3); //close the readerd don't forget!
        point.bReader.close();
        if (board.size() == 1 && chr.equals('+')) {
            board.add(String.valueOf(getCardForRegularB()));
        } else if (chr.equals('+')) {
            board.add(String.valueOf(getCardForRegularB()));
        } else {
            board.add(String.valueOf(getCardForRegularB()));
        }
    }

    public String getCardForRegularB() { // regular bot'un elinden cıkardıgı kart.
        matchingValue = false;
        for (int i = 0; i < rPlayer.getHand().size(); i++) {
            if (rPlayer.getHand().get(i).charAt(1) == (getTopCard().charAt(1))) {
                matchingValue = true;
                return rPlayer.getHand().get(i);
            }
        }
        return rPlayer.getHand().get(ran.nextInt(4));
    }

    public String getTopCard() {
        return board.get(board.size() - 1);
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

        if (!isHuman) {
            for (int i = 0; i < chosenBotList.size(); i++) {
                Thread.sleep(1500);
                if (chosenBotList.get(i).equals('N')) {
                    System.out.println("Novice bot's hand : " + nPlayer.getHand());
                } else if (chosenBotList.get(i).equals('R')) {
                    System.out.println("Regular bot's hand : " + rPlayer.getHand());
                } else if (chosenBotList.get(i).equals('N')) {
                    System.out.println("Expert bot's hand : " + ePlayer.getHand());
                }
            }
        } else if (modNo == 1) {
            for (int i = 0; i < chosenBotList.size(); i++) {
                Thread.sleep(1500);
                if (chosenBotList.get(i).equals('N')) {
                    System.out.println("Novice bot's hand : " + nPlayer.getHand());
                } else if (chosenBotList.get(i).equals('R')) {
                    System.out.println("Regular bot's hand : " + rPlayer.getHand());
                } else if (chosenBotList.get(i).equals('N')) {
                    System.out.println("Expert bot's hand : " + ePlayer.getHand());
                }
            }
        } else if (modNo == 2) {
            for (int i = 0; i < chosenBotList.size(); i++) {
                Thread.sleep(1500);
                if (chosenBotList.get(i).equals('N')) {
                    System.out.println("Novice bot's hand : " + nPlayer.getHand());
                } else if (chosenBotList.get(i).equals('R')) {
                    System.out.println("Regular bot's hand : " + rPlayer.getHand());
                } else if (chosenBotList.get(i).equals('N')) {
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

    private void playForNoviceBot() {
        System.out.println("Novice Bot Has Played!");
        board.add(nPlayer.getHand().get(nPlayer.play()));
    }

    private void playForHuman() {
        hPlayer.play();
    }

    private void addBot() {
        int selectedBot;
        int selectedBot2;
        howManyPlayers();
        switch (noOfPlayer) {
            case 2:
                if (isHuman) {
                    System.out.println("you have to select one bot for opponent");
                    System.out.println("1 -> NoviceBot\n2 -> RegularBot\n3 -> ExpertBot");
                    selectedBot = sc.nextInt();
                    switch (selectedBot) {
                        case 1 -> chosenBotList.add('N');
                        case 2 -> chosenBotList.add('R');
                        case 3 -> chosenBotList.add('E');
                        default -> System.out.println("you have chosen invalid number");
                    }

                } else {
                    System.out.println("you have to select two bots to scramble: ");
                    System.out.println("Choose:\n1 -> NoviceBot\n2 -> RegularBot\n3 -> ExpertBot");
                    selectedBot = sc.nextInt();
                    switch (selectedBot) {
                        case 1 -> chosenBotList.add('N');
                        case 2 -> chosenBotList.add('R');
                        case 3 -> chosenBotList.add('E');
                        default -> System.out.println("you have chosen invalid number");
                    }
                    System.out.println("Choose:\n1 -> NoviceBot\n2 -> RegularBot\n3 -> ExpertBot");
                    selectedBot2 = sc.nextInt();
                    switch (selectedBot2) {
                        case 1 -> chosenBotList.add('N');
                        case 2 -> chosenBotList.add('R');
                        case 3 -> chosenBotList.add('E');
                        default -> System.out.println("you have chosen invalid number");
                    }
                    break;
                }
            case 4:
                int sb1;
                int sb2;
                int sb3;
                int sb4;
                int sb5;
                int sb6;
                int sb7;


                if (isHuman) {
                    System.out.println("you have to select two bots to scramble: ");
                    System.out.println("Choose:\n1 -> NoviceBot\n2 -> RegularBot\n3 -> ExpertBot");
                    sb1 = sc.nextInt();
                    switch (sb1) {
                        case 1 -> chosenBotList.add('N');
                        case 2 -> chosenBotList.add('R');
                        case 3 -> chosenBotList.add('E');
                        default -> System.out.println("you have chosen invalid number");
                    }
                    System.out.println("you have to select two bots to scramble: ");
                    System.out.println("Choose:\n1 -> NoviceBot\n2 -> RegularBot\n3 -> ExpertBot");
                    sb2 = sc.nextInt();
                    switch (sb2) {
                        case 1 -> chosenBotList.add('N');
                        case 2 -> chosenBotList.add('R');
                        case 3 -> chosenBotList.add('E');
                        default -> System.out.println("you have chosen invalid number");
                    }
                    System.out.println("you have to select two bots to scramble: ");
                    System.out.println("Choose:\n1 -> NoviceBot\n2 -> RegularBot\n3 -> ExpertBot");
                    sb3 = sc.nextInt();
                    switch (sb3) {
                        case 1 -> chosenBotList.add('N');
                        case 2 -> chosenBotList.add('R');
                        case 3 -> chosenBotList.add('E');
                        default -> System.out.println("you have chosen invalid number");
                    }
                } else {
                    System.out.println("you have to select two bots to scramble: ");
                    System.out.println("Choose:\n1 -> NoviceBot\n2 -> RegularBot\n3 -> ExpertBot");
                    sb4 = sc.nextInt();
                    switch (sb4) {
                        case 1 -> chosenBotList.add('N');
                        case 2 -> chosenBotList.add('R');
                        case 3 -> chosenBotList.add('E');
                        default -> System.out.println("you have chosen invalid number");
                    }
                    System.out.println("you have to select two bots to scramble: ");
                    System.out.println("Choose:\n1 -> NoviceBot\n2 -> RegularBot\n3 -> ExpertBot");
                    sb5 = sc.nextInt();
                    switch (sb5) {
                        case 1 -> chosenBotList.add('N');
                        case 2 -> chosenBotList.add('R');
                        case 3 -> chosenBotList.add('E');
                        default -> System.out.println("you have chosen invalid number");
                    }
                    System.out.println("you have to select two bots to scramble: ");
                    System.out.println("Choose:\n1 -> NoviceBot\n2 -> RegularBot\n3 -> ExpertBot");
                    sb6 = sc.nextInt();
                    switch (sb6) {
                        case 1 -> chosenBotList.add('N');
                        case 2 -> chosenBotList.add('R');
                        case 3 -> chosenBotList.add('E');
                        default -> System.out.println("you have chosen invalid number");
                    }
                    System.out.println("you have to select two bots to scramble: ");
                    System.out.println("Choose:\n1 -> NoviceBot\n2 -> RegularBot\n3 -> ExpertBot");
                    sb7 = sc.nextInt();
                    switch (sb7) {
                        case 1 -> chosenBotList.add('N');
                        case 2 -> chosenBotList.add('R');
                        case 3 -> chosenBotList.add('E');
                        default -> System.out.println("you have chosen invalid number");


                    }
                }
        }
    }
}
