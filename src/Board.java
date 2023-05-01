import java.io.*;
import java.util.*;

public class Board {
    Random ran = new Random();
    Scanner sc = new Scanner(System.in);
    private Point point = new Point();
    //
    public ArrayList<Character> chosenBotList = new ArrayList<>();
    private boolean matchingValue = false;
    private boolean isPisti = false;


    private ArrayList<String> board = new ArrayList<>();
    private boolean isHuman; // we will use this data for dealing the hand for human or not;
    private String askingUser; // in this data we are asking the user whether he or she is playing as a player;

    private Human hPlayer = new Human();
    private NoviceBot nPlayer;
    private NoviceBot nPlayer1;
    private NoviceBot nPlayer2;
    private NoviceBot nPlayer3;
    private NoviceBot nPlayer4;

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
    public String s, t;


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
        if (askingUser.equalsIgnoreCase("YES")) { //Our boolean value will change according to the response we get from the user.
            isHuman = true;
            chosenBotList.add('H');
        } else {
            isHuman = false; //If user decides to not join then our boolean type will be false.
        }
    }

    int c = 0; //We used 'counter' to make the code run only once when there are no human.

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
                System.out.println("Top card: " + board.get(3));  //4th card will be the top card.
            }
            if (counter >= 4) {
                if (isHuman == true) {

                    modSelect(); // This method will be written only for once because we have added counter inside this method to run once.
                    if (counter < 5) { // We add a bot because it did it at 4.
                        counter++;
                        chosenBotList.add('H');
                        System.out.println("Which bot do you want to play?");
                        System.out.println("'Novice', 'Regular', 'Expert'");
                        s = sc.nextLine();
                        //In this line our user will select the difficulty of the bots.
                    }

                    if (modNo == 1) {
                        if (s.equalsIgnoreCase("NOVİCE")) {
                            chosenBotList.add('N'); // bnunu büyük harf kucuk harf sıkıntısı olabilir ileride dikkat!!
                            if (hPlayer.getHand().size() == 0 && nPlayer1.getHand().size() == 0) {
                                for (int i = 0; i < 4; i++) {
                                    Thread.sleep(1000);
                                    //To make our code more realistic, in this part output will be come after 1000 miliseconds which is equals to 1 second.
                                    hPlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Human player's hand: " + hPlayer.getHand());
                                    deck.deck.remove(i);
                                    nPlayer.getHand().add(deck.deck.get(i));
                                    deck.deck.remove(i);
                                }
                            }
                        } else if (s.equalsIgnoreCase("REGULAR")) {
                            chosenBotList.add('R');
                            if (hPlayer.getHand().size() == 0) {
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
                            if (hPlayer.getHand().size() == 0) {
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
                    } else if (modNo == 2) {
                        if (s.equalsIgnoreCase("NOVİCE")) {
                            chosenBotList.add('N'); // bnunu büyük harf kucuk harf sıkıntısı olabilir ileride dikkat!!
                            //System.out.println("Novice bot has selected!");
                            if (hPlayer.getHand().size() == 0) {
                                for (int i = 0; i < 4; i++) {
                                    Thread.sleep(1000);
                                    hPlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Human player's hand: " + hPlayer.getHand());
                                    deck.deck.remove(i);
                                    nPlayer1.getHand().add(deck.deck.get(i));
                                    System.out.println("Novice Bot's hand: " + nPlayer1.getHand());
                                    deck.deck.remove(i);
                                }
                            }
                        } else if (s.equalsIgnoreCase("REGULAR")) {
                            chosenBotList.add('R');
                            //System.out.println("Regular bot has selected!");
                            if (hPlayer.getHand().size() == 0) {
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
                            //System.out.println("Expert bot has selected!");
                            if (hPlayer.getHand().size() == 0) {
                                for (int i = 0; i < 4; i++) {
                                    Thread.sleep(1000);
                                    hPlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Human player's hand: " + hPlayer.getHand());
                                    deck.deck.remove(i);
                                    ePlayer.getHand().add(deck.deck.get(i));
                                    System.out.println("Expert Bot's hand: " + ePlayer.getHand());
                                    deck.deck.remove(i);
                                    //We just added the same methods for our 3 different bots.
                                }
                            }

                        }
                    }

                } else {
                    if (c == 0) {
                        c++;
                        System.out.println("mod 2 will be apply the automatically (SpectateMod)");
                        modNo = 2;
                    }
                    while (counter < 5) { // counter 4
                        counter++;
                        System.out.println("Which bot do you want to add?");
                        System.out.println("'Novice', 'Regular', 'Expert'");
                        s = sc.nextLine();
                    }
                    while (counter < 6) {
                        counter++;
                        System.out.println("Which bot do you want to add?");
                        System.out.println("'Novice', 'Regular', 'Expert'");
                        t = sc.nextLine();
                    }
                    createPlayers();
                    if (s.equalsIgnoreCase("NOVİCE")) {
                        chosenBotList.add('N'); // bnunu büyük harf kucuk harf sıkıntısı olabilir ileride dikkat!!
                        System.out.println("Novice bot has selected!");
                        if (nPlayer1.getHand().size() == 0) {
                            for (int i = 0; i < 4; i++) {
                                Thread.sleep(1000);
                                nPlayer1.getHand().add(deck.deck.get(i));
                                System.out.println("novice bot's hand : " + nPlayer1.getHand());
                                deck.deck.remove(i);
                            }
                        }
                    } else if (s.equalsIgnoreCase("REGULAR")) {
                        chosenBotList.add('R');
                        System.out.println("Regular bot has selected!");
                        if (rPlayer.getHand().size() == 0) {
                            for (int i = 0; i < 4; i++) {
                                Thread.sleep(1000);
                                rPlayer.getHand().add(deck.deck.get(i));
                                System.out.println("regular bot's hand : " + rPlayer.getHand());
                                deck.deck.remove(i);
                            }
                        }
                    } else if (s.equalsIgnoreCase("EXPERT")) {
                        chosenBotList.add('E');
                        System.out.println("Expert bot has selected!");
                        if (ePlayer.getHand().size() == 0) {
                            for (int i = 0; i < 4; i++) {
                                Thread.sleep(1000);
                                ePlayer.getHand().add(deck.deck.get(i));
                                System.out.println("expert bot's hand : " + ePlayer.getHand());
                                deck.deck.remove(i);
                            }
                        }
                    }
                    if (t.equalsIgnoreCase("NOVİCE")) {
                        chosenBotList.add('N'); // bnunu büyük harf kucuk harf sıkıntısı olabilir ileride dikkat!!
                        System.out.println("Novice bot has selected!");
                        if (nPlayer2.getHand().size() == 0) {
                            for (int i = 0; i < 4; i++) {
                                Thread.sleep(1000);
                                nPlayer2.getHand().add(deck.deck.get(i));
                                System.out.println("novice bot's hand : " + nPlayer2.getHand());
                                deck.deck.remove(i);
                            }
                        }
                    } else if (t.equalsIgnoreCase("REGULAR")) {
                        chosenBotList.add('R');
                        System.out.println("Regular bot has selected!");
                        if (rPlayer.getHand().size() == 0) {
                            for (int i = 0; i < 4; i++) {
                                Thread.sleep(1000);
                                rPlayer.getHand().add(deck.deck.get(i));
                                System.out.println("regular bot's hand : " + rPlayer.getHand());
                                deck.deck.remove(i);
                            }
                        }
                    } else if (t.equalsIgnoreCase("EXPERT")) {
                        chosenBotList.add('E');
                        System.out.println("Expert bot has selected!");
                        if (ePlayer.getHand().size() == 0) {
                            for (int i = 0; i < 4; i++) {
                                Thread.sleep(1000);
                                ePlayer.getHand().add(deck.deck.get(i));
                                System.out.println("expert bot's hand : " + ePlayer.getHand());
                                deck.deck.remove(i);
                            }
                        }
                    }
                }

            }
        }
        //It displays the deck by calling the displayDeck() method of the Deck class.
        //If there are two players (noOfPlayer is 2), it deals cards to the board and players.
        //If the counter variable is less than 4, it deals 4 cards to the board by iterating over the deck and adding the first card to the board and removing it from the deck...
        // The counter variable keeps track of how many cards have been dealt to the board.
        //If the counter variable is greater than or equal to 4, it first checks if the human player is playing.
        // If the human player is playing, it calls the modSelect() method to select the mode of the game, and adds a bot to the game if the counter is less than 5.
        //It then checks the mode of the game by checking the modNo variable, and based on the mode and the difficulty of the bot selected by the player...
        // It deals 4 cards to the human player and the selected bot by iterating over the deck and adding the first two cards to the human player's hand and the next two cards to the bot's hand.
        //And finally, If the human player is not playing, it sets the mode of the game to 2 and adds bots automatically.
    }

    int modNo;

    int count = 0;

    private void modSelect() throws InterruptedException {
        if (count == 0) {//ishuman == true olmalı!!!
            try {
                count++;
                System.out.println("Please select game mod");
                System.out.println("1 -> SelfMod (this mod just shows hand of human player)"); //It will just show the human's hand, not the others.
                System.out.println("2 -> SpectateMod (this mod shows all hands of bots )"); // In this mode everyone's hand will be shown.
                modNo = sc.nextInt();
                sc.nextLine();
                //According to user's choice selected mode will be activated.
            } catch (Exception ex) {
                System.out.println("Please select valid number 1 or 2 "); //Değişiklikler yapıldı
                System.out.println(ex.toString());
            }
        }
    }
    //If an exception is thrown while reading the user's input -for example an non-integer value-
    // Then the code will catch the exception and displays an error message asking the user to select a valid number again. It also prints the exception message.

    private void playForNoviceBot() { // novice bot play bitti !
        for (int i = 0; i < iN; i++) {
            String returnValue = nBots[i].getHand().get(nBots[i].play());
            board.add(returnValue);
            System.out.println("Novice" + i + 1 + " bot has played : " + returnValue);
            nBots[i].getHand().remove(returnValue);
        }

    }

    private void playForHuman() { // bitti !
        String returnValue = hPlayer.getHand().get(hPlayer.play());
        System.out.println("You have been played : " + returnValue);
        board.add(returnValue);
        hPlayer.getHand().remove(returnValue);


    }


    private void playForExpertBot() {
        board.add(ePlayer.getHand().get(ran.nextInt(4)));
    }

    public void playForRegularBot() throws FileNotFoundException { // puana
        matchingValue = false;
        String s1;
        String s2;
        int i1 = 0;
        int i2 = 0;
        boolean f1 = true;
        boolean f2 = true;
        int matchingIndex = 0;
        for (int i = 0; i < rPlayer.getHand().size(); i++) {
            if (rPlayer.getHand().get(i).charAt(1) == (getTopCard().charAt(1))) {
                matchingValue = true;
                matchingIndex = i; // We have 4 cards in our hand and it will tell which card will be make pisti out of them(as imdex)
            }
        }
        if (matchingValue) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("points.txt"));
            try {
                String line = bufferedReader.readLine();
                while (line != null && f1 && f2) {
                    if (line.length() == 0) {
                        break;
                    }
                    s1 = String.valueOf(line.charAt(0) + line.charAt(1)); // txt file'daki her satırın kartı örn: 1. satır için SA
                    if (rPlayer.getHand().get(matchingIndex).equals(s1)) { // S6
                        i1 = Integer.parseInt(String.valueOf(line.charAt(3))) + Integer.parseInt(String.valueOf(line.charAt(4)));
                        f1 = false;
                    } else {
                        i1 = 1;
                        f2 = false;
                    }
                    if (getTopCard().equals(s1)) {
                        i2 = Integer.parseInt(String.valueOf(line.charAt(3) + line.charAt(4)));
                        f2 = false;
                    } else {
                        i2 = 1;
                        f2 = false;
                    }
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            if ((i1 + i2) > 0) {
                board.add(rPlayer.getHand().get(matchingIndex));
                System.out.println("Regular bot has just played : " + rPlayer.getHand().get(matchingIndex));
                rPlayer.getHand().remove(rPlayer.getHand().get(matchingIndex));
                saveEarnedCards('r');
            } else {
                int indexOfPlay = ran.nextInt(rPlayer.getHand().size()); // 2
                while (indexOfPlay == matchingIndex) {  // 2
                    indexOfPlay = ran.nextInt(rPlayer.getHand().size());
                }
                board.add(rPlayer.getHand().get(indexOfPlay));
                System.out.println("Regular bot has just played : " + rPlayer.getHand().get(indexOfPlay));
                rPlayer.getHand().remove(rPlayer.getHand().get(indexOfPlay));
            }
        } else {
            int indexOfPlay = ran.nextInt(rPlayer.getHand().size()); // eğer uyuşan kart yoksa rastgele bir kart oynayacak bu degeri inte atamamızın sebebi ikinci kez rastgele seçim yapmamak için.
            board.add(rPlayer.getHand().get(indexOfPlay));
            System.out.println("Regular bot has just played : " + rPlayer.getHand().get(indexOfPlay));
            rPlayer.getHand().remove(rPlayer.getHand().get(indexOfPlay));

        }

    }
    //The code first checks if there is a matching card in the regular bot's hand with the top card of the board.
    // If there is a match, the corresponding point values of the card in the regular bot's hand and the top card are looked up from a text file called "points.txt".
    // If the sum of these point values is greater than 0, then the regular bot plays the matching card, removes it from its hand, adds it to the board and saves the points earned.
    //(Since it is a 'regular bot', it should calculate this score and play cards accordingly.)

    //If there is no matching card in the regular bot's hand, a random card from its hand is played and added to the board.
    //In both cases, the card played by the regular bot and the action taken are printed out.

    public String getTopCard() {
        return board.get(board.size() - 1);
    }

    public void play() throws FileNotFoundException, InterruptedException {
        //System.out.println(getTopCard());
        //if (!isHuman) {
        for (int i = 0; i < chosenBotList.size(); i++) {


            switch (chosenBotList.get(i)) {
                case 'N':
                    for (int j = 0; j < iN; j++) {
                        if (nBots[j].getHand().isEmpty()) {
                            nBots[j].getHand().add(deck.deck.get(0));

                        }
                        displayHand();

                    }
                        case 'R':
                                if (rPlayer.getHand().isEmpty()) {
                                    for (int j = 0; j < 4; j++) {
                                        rPlayer.getHand().add(deck.deck.get(0));
                                        deck.deck.remove(0);
                                    }
                                    displayHand();

                                }
                            case 'E':
                                if (ePlayer.getHand().isEmpty()) {
                                    for (int j = 0; j < 4; j++) {
                                        ePlayer.getHand().add(deck.deck.get(0));
                                        deck.deck.remove(0);
                                    }
                                    displayHand();
                                }
                            case 'H':
                                if (hPlayer.getHand().isEmpty()) {
                                    for (int j = 0; j < 4; j++) {
                                        hPlayer.getHand().add(deck.deck.get(0));
                                        deck.deck.remove(0);
                                    }
                                    displayHand();
                                }

                    }
                    for (Character character : chosenBotList) {
                        switch (character) {
                            case 'N' -> playForNoviceBot();
                            case 'R' -> playForRegularBot();
                            case 'E' -> playForExpertBot();
                            case 'H' -> playForHuman();
                            default -> System.out.println("Please enter a valid character");
                        }
                    }
            }
        }

//This code defines a method called play(), which is responsible for starting the game and handling the playing of each player.
                    //First, the method checks which bots are playing (based on a list of chosen bot types) and deals 4 cards to each player if their hand is empty...
                    // This is done using a switch statement for each bot type, with the isEmpty() method used to check if their hand needs cards.

                    //Next, a for-each loop is used to go through each character in the chosenBotList and call the corresponding play method for that bot type...
                    //The play methods for each bot type are defined elsewhere in the code.
                    //The play() method does not return anything, but it can throw a FileNotFoundException if there is an error which is about reading input.


            public void displayHand () {
                if (modNo == 1) {
                    System.out.println("Human player's hand: " + hPlayer.getHand());
                } else if (modNo == 2) {
                    for (int i = 0; i < chosenBotList.size(); i++) {
                        if (chosenBotList.get(i).equals('N')) {
                            System.out.println("Novice player's hand: " + nPlayer.getHand());
                        } else if (chosenBotList.get(i).equals('R')) {
                            System.out.println("Regular player's hand: " + rPlayer.getHand());
                        } else if (chosenBotList.get(i).equals('E')) {
                            System.out.println("Expert player's hand: " + ePlayer.getHand());
                        } else if (chosenBotList.get(i).equals('H')) {
                            System.out.println("Human player's hand " + hPlayer.getHand());
                        }
                    }
                }
            }

            private boolean canMakePisti ()
            { // pişti yapabiliyor muyuz onu belirliyoruz boolean tipinde bu da piştiden kazanılan kartların earnedWithPisti array list'ine gitmesini sağlıcak şart.
                if (matchingValue && board.size() == 1) {
                    isPisti = true;
                }
                return isPisti;
            }

            private void saveEarnedCards (Character c){
                switch (c) {
                    case 'N':
                        if (canMakePisti()) {
                            for (String b : board) {
                                nPlayer.getEarnedWithPisti().add(b);
                                board.remove(0);
                            }
                        } else {
                            for (String b : board) {
                                nPlayer.getEarnedWithoutPisti().add(b);
                                board.remove(0);
                            }
                        }
                    case 'R':
                        if (canMakePisti()) {
                            for (String b : board) {
                                rPlayer.getEarnedWithPisti().add(b);
                                board.remove(0);
                            }
                        } else {
                            for (String b : board) {
                                rPlayer.getEarnedWithoutPisti().add(b);
                                board.remove(0);
                            }
                        }
                    case 'E':
                        if (canMakePisti()) {
                            for (String b : board) {
                                ePlayer.getEarnedWithPisti().add(b);
                                board.remove(0);
                            }
                        } else {
                            for (String b : board) {
                                ePlayer.getEarnedWithoutPisti().add(b);
                                board.remove(0);
                            }
                        }
                    case 'H':
                        if (canMakePisti()) {
                            for (String b : board) {
                                hPlayer.getEarnedWithPisti().add(b);
                                board.remove(0);
                            }
                        } else {
                            for (String b : board) {
                                hPlayer.getEarnedWithoutPisti().add(b);
                                board.remove(0);
                            }
                        }

                }

            }
            int iN = 0;

            public void createPlayers () {
                switch (noOfPlayer) {
                    case 2:
                        for (int i = 0; i < chosenBotList.size(); i++) { // N R N
                            if (chosenBotList.get(i).equals('N')) {
                                createNoviceBot();
                            }
                        }


                        //case 4 :

                }
            }
            int nCounter = 2;
            NoviceBot[] nBots = {nPlayer1, nPlayer2, nPlayer3, nPlayer4};

            public void createNoviceBot () {
                for (int j = iN; j < nCounter; j++) {
                    nBots[iN] = new NoviceBot();
                    iN++;
                }
            }
            public void playerSelect () {
                howManyPlayers();
                int x = 0;
                if(isHuman){
                    x = noOfPlayer-1 ;
                }else{
                    x = noOfPlayer;
                }
                    for (int i = 0; i < x; i++) {
                        System.out.println("Which bot do you want to play?");
                        System.out.println("'Novice', 'Regular', 'Expert'");
                        s = sc.nextLine();
                        switch (s.toUpperCase()) {
                            case "NOVİCE" -> chosenBotList.add('N');
                            case "REGULAR" -> chosenBotList.add('R');
                            case "EXPERT" -> chosenBotList.add('E');
                        }
                    }

            }

        }


