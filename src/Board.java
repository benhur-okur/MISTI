import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Board {
    Random ran = new Random();
    Scanner sc = new Scanner(System.in);

    private boolean firstThreeCardInvisible = false;

    public ArrayList<Character> chosenPlayerList = new ArrayList<>(); // N E R
    private boolean matchingValue = false;
    private boolean isPisti = false;

    public int getNoOfPlayer() {
        return noOfPlayer;
    }

    private ArrayList<Card> cardsOnTheBoard = new ArrayList<>();
    private boolean isHuman; // we will use this data for dealing the hand for human or not;
    private String askingUser; // in this data we are asking the user whether he or she is playing as a player;

    private Deck deck;
    private ArrayList<Player> players = new ArrayList<>();


    private Human hPlayer;
    //private Mod mod;
    private int noOfPlayer;
    private int mod;
    public String s, t;

    public ArrayList<Card> getKnownCardsOnTheBoard() {
        if (firstThreeCardInvisible) {
            this.cardsOnTheBoard.subList(3, this.cardsOnTheBoard.size());
        }
        return cardsOnTheBoard;
    }

    public ArrayList<Card> getCardsOnTheBoard() {
        return cardsOnTheBoard;
    }


    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Board(Deck deck) throws IOException {
        this.deck = deck;
    }

    public void howManyPlayers() {
        while (noOfPlayer != 2 && noOfPlayer != 4) {
            System.out.println("How many players will be in the cardsOnTheBoard '2 or 4' ?");
            try {
                noOfPlayer = sc.nextInt();
            } catch (Exception ex) {
                System.out.println(ex);
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
            chosenPlayerList.add('H');
        } else {
            isHuman = false; //If user decides to not join then our boolean type will be false.
        }
    }


    public void dealCard() throws InterruptedException, IOException {
        boolean atLeastOnePlayerHasCards = false;
        for (Player player : players) {
            if (!player.isEmpty()) {
                atLeastOnePlayerHasCards = true;
            }
        }

        if (!atLeastOnePlayerHasCards) { // elleri boş olduğu zaman dağıtmak için çalışıcak (or gelebilir)   0   1
            for (int dealingCardIndex = 0; dealingCardIndex < 4; dealingCardIndex++) {
                for (Player player : players) {
                    player.addCard(deck.pop());
                }
                displayHand();
            }
        }
    }

    //It displays the deck by calling the displayDeck() method of the Deck class.
    //If there are two players (noOfPlayer is 2), it deals cards to the cardsOnTheBoard and players.
    //If the counter variable is less than 4, it deals 4 cards to the cardsOnTheBoard by iterating over the deck and adding the first card to the cardsOnTheBoard and removing it from the deck...
    // The counter variable keeps track of how many cards have been dealt to the cardsOnTheBoard.
    //If the counter variable is greater than or equal to 4, it first checks if the human player is playing.
    // If the human player is playing, it calls the modSelect() method to select the mode of the game, and adds a bot to the game if the counter is less than 5.
    //It then checks the mode of the game by checking the modNo variable, and based on the mode and the difficulty of the bot selected by the player...
    // It deals 4 cards to the human player and the selected bot by iterating over the deck and adding the first two cards to the human player's hand and the next two cards to the bot's hand.
    //And finally, If the human player is not playing, it sets the mode of the game to 2 and adds bots automatically.


    int modNo;

    int count = 0;

    public void modSelect() throws InterruptedException {
        if (count == 0) {
            if (isHuman) {
                try {
                    count++;
                    System.out.println("Please select game mod");
                    System.out.println("1 -> SelfMod (this mod just shows hand of human player)"); //It will just show the human's hand, not the others.
                    System.out.println("2 -> SpectateMod (this mod shows all hands of bots )"); // In this mode everyone's hand will be shown.
                    modNo = sc.nextInt();
                    // ToDo: Add validation
                    sc.nextLine();
                    //According to user's choice selected mode will be activated.
                } catch (Exception ex) {
                    System.out.println("Please select valid number 1 or 2 "); //Değişiklikler yapıldı
                    System.out.println(ex.toString());
                }
            } else {
                modNo = 2;
            }
        }
    }
    //If an exception is thrown while reading the user's input -for example an non-integer value-
    // Then the code will catch the exception and displays an error message asking the user to select a valid number again. It also prints the exception message.


    public ArrayList<Player> getPlayers() {
        return players;
    }

    private int totalPointsOfBoard() throws IOException {
        int totalPoint = 0;
        for (Card card : cardsOnTheBoard) {
            totalPoint += card.getPointValue();
        }

        return totalPoint;
    }


    //The code first checks if there is a matching card in the regular bot's hand with the top card of the cardsOnTheBoard.
    // If there is a match, the corresponding point values of the card in the regular bot's hand and the top card are looked up from a text file called "points.txt".
    // If the sum of these point values is greater than 0, then the regular bot plays the matching card, removes it from its hand, adds it to the cardsOnTheBoard and saves the points earned.
    //(Since it is a 'regular bot', it should calculate this score and play cards accordingly.)

    //If there is no matching card in the regular bot's hand, a random card from its hand is played and added to the cardsOnTheBoard.
    //In both cases, the card played by the regular bot and the action taken are printed out.

    public Card getTopCard() { // eğer ki topCard null olur ise 2. return sağlanamayacağı için if şartı eklenmiştir.
        if (cardsOnTheBoard.size() == 0) {
            return null;
        }

        return cardsOnTheBoard.get(cardsOnTheBoard.size() - 1);
    }

    public void play() throws IOException, InterruptedException {


        int nthPlayer = 1;
        for (Player player : this.players) { // N E
            System.out.println("Top card: " + getTopCard());
            if(modNo == 1 && player == hPlayer){
                System.out.println(hPlayer.getName() + "'s hand: " + hPlayer.getHand());


            }else if(modNo == 2){
                System.out.println("Player "+ nthPlayer + "." + player.getName() + "'s hand: " + player.getHand());

            }
            Card playedCard = player.play(this);

            System.out.println("Player "+ nthPlayer + "." + player.getName() + " has played: " + playedCard);

            // ToDo: Increase here, to count how many faces are already played out

            Card topCard = getTopCard();


            cardsOnTheBoard.add(playedCard); // oynayacağımız kartı board'a ekliyoruz

            if ((playedCard.isJack() && topCard != null) || (topCard != null && playedCard.getFace().equals(topCard.getFace()))) {
                System.out.printf("Player %s won", player.getName());
                System.out.println(cardsOnTheBoard);

                player.addWonStack(cardsOnTheBoard);
                cardsOnTheBoard.clear();
                firstThreeCardInvisible = false;
            }
            nthPlayer++;
        }
    }

//This code defines a method called play(), which is responsible for starting the game and handling the playing of each player.
    //First, the method checks which bots are playing (based on a list of chosen bot types) and deals 4 cards to each player if their hand is empty...
    // This is done using a switch statement for each bot type, with the isEmpty() method used to check if their hand needs cards.

    //Next, a for-each loop is used to go through each character in the chosenPlayerList and call the corresponding play method for that bot type...
    //The play methods for each bot type are defined elsewhere in the code.
    //The play() method does not return anything, but it can throw a FileNotFoundException if there is an error which is about reading input.


    public void displayHand() {
        if (modNo == 1) { // Human player mode, can only see his own hand
            System.out.println(hPlayer.getName() + "'s hand: " + hPlayer.getHand());
        } else if (modNo == 2) {  // Human spectator mode, can see everyone's hand
            for (int i = 0; i < players.size(); i++) {
                Player player = players.get(i);
                System.out.println("Player " + (i+1) + ". " + player.getName() + "'s hand: " + player.getHand());
            }
        }
    }

    public void createPlayers() throws IOException { // player select metodunda seçilen botların objelerini oluşturan methodları sırasıyla çağırır.
        for (int i = 0; i < chosenPlayerList.size(); i++) { // N R N
            // Todo: Provide proper naming for the bots
            if (chosenPlayerList.get(i).equals('N')) {
                this.players.add(new NoviceBot("Novice Bot"));
            } else if (chosenPlayerList.get(i).equals('R')) {
                this.players.add(new RegularBot("Regular Bot"));
            } else if (chosenPlayerList.get(i).equals('E')) {
                this.players.add(new ExpertBot("Expert Bot"));
            } else if (chosenPlayerList.get(i).equals('H')) {
                // ToDo : Print user-friendly messages to enter name, and etc
                System.out.println("Please enter your name: ");
                String name = sc.nextLine();

                this.hPlayer = new Human(name);
                this.players.add(this.hPlayer);
            }
        }
    }

    public void playerSelect() { // oyunun içnde olucak bütün oyuncuların sayısı ve türü bu metod tarafından sağlanır
        howManyPlayers();
        int numberOfBots;
        if (isHuman) {
            numberOfBots = noOfPlayer - 1;
        } else {
            numberOfBots = noOfPlayer;
        }
        for (int i = 0; i < numberOfBots; i++) {

            System.out.println("Which bot do you want to play?");
            System.out.println("'Novice', 'Regular', 'Expert'");
            s = sc.nextLine();

            switch (s.toUpperCase(Locale.ENGLISH)) { // bilgisayarın diline göre büyük harf kucuk harfte sıkıntı oluyor!!!!
                case "NOVICE":
                    chosenPlayerList.add('N');
                    break;
                case "REGULAR":
                    chosenPlayerList.add('R');
                    break;
                case "EXPERT":
                    chosenPlayerList.add('E');
                    break;
            }
        }
    }

    public void firstFourCard() { // oyun başında ortaya atılcak ilk dört kart bu metod tarafından sağlanır.
        firstThreeCardInvisible = true;
        for (int i = 0; i < 4; i++) {
            cardsOnTheBoard.add(deck.pop());
        }
        System.out.println("Cards has dealt to the table");
    }

    public int findCardsCountMin(ArrayList<Card> hand, ArrayList<Integer> indexesOfNegativeCards) { // + - + -
        ArrayList<ArrayList<String>> count = new ArrayList<ArrayList<String>>();
        count.add(new ArrayList<String>());
        count.add(new ArrayList<String>());
        int realIndex = 0;
        for (int i = 0;i<indexesOfNegativeCards.size();i++) {
            realIndex = indexesOfNegativeCards.get(i); // 1 3
            for (int j = 0;j<13;j++) {
                if ((hand.get(realIndex).getFace().equals(countersOfFaces[0][j]))) { // S6
                    count.get(0).add(countersOfFaces[0][j]); // A 2 6 J
                    count.get(1).add(countersOfFaces[1][j]); // 1 0 3 4
                }

            }
        }
        int indexOfMinCount = 0;
        for (int i = 0;i<count.get(1).size()-1;i++) { // 1 3 0 2
            for (int j = i + 1;j<count.get(1).size();j++) {
                if (Integer.parseInt(String.valueOf(count.get(1).get(j))) < Integer.parseInt(String.valueOf(count.get(1).get(i)))) {
                    indexOfMinCount = j;
                }
            }
        }
        return indexesOfNegativeCards.get(indexOfMinCount);
    }

     public int findCardsCountMax(ArrayList<Card> hand) {
        ArrayList<ArrayList<String>> count = new ArrayList<ArrayList<String>>();
        count.add(new ArrayList<String>());
        count.add(new ArrayList<String>());
            for (int i = 0; i < hand.size(); i++) {
                for (int j = 0; j < 13; j++) {
                    if ((hand.get(i).getFace().equals(countersOfFaces[0][j]))) {
                        count.get(0).add(countersOfFaces[0][j]); // A 2 6 J
                        count.get(1).add(countersOfFaces[1][j]); // 1 0 3 4
                    }

                }
            }
            int indexOfMaxCount = 0;
            for (int i = 0; i < count.get(1).size() - 1; i++) { // 1 3 0 2
                for (int j = i + 1; j < count.get(1).size(); j++) {
                    if (Integer.parseInt(String.valueOf(count.get(1).get(j))) > Integer.parseInt(String.valueOf(count.get(1).get(i)))) {
                        indexOfMaxCount = j;
                    }
                }
            }
        return indexOfMaxCount;
    }

    String[][] countersOfFaces = {
            {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}
    };


    public void increaseCounter(Card card) { // paraetredeki kart oyuncunu oynyacağı kart olucaktır.
        int newCount = 0;
        String faceOfCard = String.valueOf(card.getFace());
        for (int i = 0; i < 13; i++) {
            if (faceOfCard.equals(countersOfFaces[0][i])) {
                newCount = Integer.parseInt(String.valueOf(countersOfFaces[1][i]));
                newCount++;
                countersOfFaces[1][i] = String.valueOf(newCount);
            }
        }
    }



}

