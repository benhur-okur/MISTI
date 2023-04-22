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

    public Human gethPlayer() {
        return hPlayer;
    }

    public NoviceBot getnPlayer() {
        return nPlayer;
    }

    public RegularBot getrPlayer() {
        return rPlayer;
    }

    public ExpertBot getePlayer() {
        return ePlayer;
    }

    private ExpertBot ePlayer = new ExpertBot();
    private Deck deck = new Deck();
    //private Mod mod;
    private int noOfPlayer;
    private int mod;
    private int counter = 0;
    private String s;

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
        if (askingUser.equalsIgnoreCase("YES")) { //Kullanıcıdan aldığımız veriye göre boolean tipi değişiyor!!
            isHuman = true;
        } else {
            isHuman = false; //YES cevabı vermezse false döndürüyor!!
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
                if (isHuman == true) {
                    modSelect();
                    if(counter < 5){
                        counter ++;
                        System.out.println("Which bot do you want to play?");
                        System.out.println("'Novice', 'Regular', 'Expert'");
                        s = sc.nextLine();
                    }

                    if(modNo == 1){
                        if (s.equalsIgnoreCase("NOVİCE")) {
                            chosenBotList.add('N'); // bnunu büyük harf kucuk harf sıkıntısı olabilir ileride dikkat!!
                            System.out.println("Novice bot has selected!");
                            if(hPlayer.getHand().size() == 0 && nPlayer.getHand().size() == 0){
                                for (int i = 0; i < 4; i++) {
                                    Thread.sleep(1000);
                                    hPlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Human player's hand: " + hPlayer.getHand());
                                    deck.deck.remove(i);
                                    nPlayer.getHand().add(deck.deck.get(i));
                                    deck.deck.remove(i);
                                }
                            }
                        } else if (s.equalsIgnoreCase("REGULAR")) {
                            chosenBotList.add('R');
                            System.out.println("Regular bot has selected!");
                            if(hPlayer.getHand().size() == 0){
                                for (int i = 0; i < 4; i++) {
                                    Thread.sleep(1000);
                                    hPlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Human player's hand: " + hPlayer.getHand());
                                    deck.deck.remove(i);
                                    rPlayer.getHand().add(deck.deck.get(i));
                                    deck.deck.remove(i);
                                }
                            }
                        } else if (s.equalsIgnoreCase("EXPERT")) {
                            chosenBotList.add('E');
                            System.out.println("Expert bot has selected!");
                            if(hPlayer.getHand().size() == 0){
                                for (int i = 0; i < 4; i++) {
                                    Thread.sleep(1000);
                                    hPlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Human player's hand: " + hPlayer.getHand());
                                    deck.deck.remove(i);
                                    ePlayer.getHand().add(deck.deck.get(i));
                                    deck.deck.remove(i);
                                }
                            }
                        }
                    }else if(modNo == 2){
                        if (s.equalsIgnoreCase("NOVİCE")) {
                            chosenBotList.add('N'); // bnunu büyük harf kucuk harf sıkıntısı olabilir ileride dikkat!!
                            System.out.println("Novice bot has selected!");
                            if(hPlayer.getHand().size() == 0){
                                for (int i = 0; i < 4; i++) {
                                    Thread.sleep(1000);
                                    hPlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Human player's hand: " + hPlayer.getHand());
                                    deck.deck.remove(i);
                                    nPlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Novice Bot's hand: " + nPlayer.getHand());
                                    deck.deck.remove(i);
                                }
                            }
                        } else if (s.equalsIgnoreCase("REGULAR")) {
                            chosenBotList.add('R');
                            System.out.println("Regular bot has selected!");
                            if(hPlayer.getHand().size() == 0){
                                for (int i = 0; i < 4; i++) {
                                    Thread.sleep(1000);
                                    hPlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Human player's hand: " + hPlayer.getHand());
                                    deck.deck.remove(i);
                                    rPlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Regular Bot's hand: " + rPlayer.getHand());
                                    deck.deck.remove(i);
                                }
                            }
                        } else if (s.equalsIgnoreCase("EXPERT")) {
                            chosenBotList.add('E');
                            System.out.println("Expert bot has selected!");
                            if(hPlayer.getHand().size() == 0){
                                for (int i = 0; i < 4; i++) {
                                    Thread.sleep(1000);
                                    hPlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Human player's hand: " + hPlayer.getHand());
                                    deck.deck.remove(i);
                                    ePlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Expert Bot's hand: " + ePlayer.getHand());
                                    deck.deck.remove(i);
                                }
                            }

                        }
                    }

                } else {

                    
                }
            }
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

    int count = 0;
    private void modSelect() throws InterruptedException {
            if(count == 0){
                try {
                    count++;
                    System.out.println("Please select game mod");
                    System.out.println("1 -> SelfMod (this mod just shows hand of human player)"); //Sadece insanın elini gösteriyotr
                    System.out.println("2 -> SpectateMod (this mod shows all hands of bots )"); // Tüm oyuncuların eli gözükecek
                    modNo = sc.nextInt();
                    sc.nextLine();
                } catch (Exception ex) {
                    System.out.println("Please select valid number 1 or 2 "); //Değişiklikler yapıldı
                    System.out.println(ex.toString());
                }
            }
    }

    /*
    public void displayHand() throws InterruptedException {

        if (!isHuman) {
            for (int i = 0; i < chosenBotList.size(); i++) {
                Thread.sleep(1500);
                if (chosenBotList.get(i).equals('N')) { //Deal'da seçiyoruz
                    System.out.println("Novice bot's hand : " + nPlayer.getHand());
                } else if (chosenBotList.get(i).equals('R')) {
                    System.out.println("Regular bot's hand : " + rPlayer.getHand());
                } else if (chosenBotList.get(i).equals('E')) {
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
                } else if (chosenBotList.get(i).equals('E')) {
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
                } else if (chosenBotList.get(i).equals('E')) {
                    System.out.println("Expert bot's hand : " + ePlayer.getHand());
                }
            }
        }

    }*/
    private void playForNoviceBot() {
        System.out.println("Novice Bot Has Played!");
        board.add(nPlayer.getHand().get(nPlayer.play()));
    }
    private void playForHuman() {
        hPlayer.play();
    }
    public void humanPlay(){
            board.add(hPlayer.getHand().get(hPlayer.play()));
            //System.out.println(hPlayer.getHand().get(hPlayer.selectCard));
            hPlayer.getHand().remove(hPlayer.selectCard);
            System.out.println(hPlayer.getHand());
    }
    public void novicePlay(){
            board.add(nPlayer.getHand().get(nPlayer.play()));
            nPlayer.getHand().remove(nPlayer.noviceSelect);
            System.out.println(nPlayer.getHand());
    }
}
