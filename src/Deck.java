import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Deck {
    //Cutting and shuffling method will be done in this class
    //Also we will create our ArrayLists for suits, faces and deck

    private PointFileReader pointFileReader;


    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    ArrayList<String> suits = new ArrayList<>();
    ArrayList<String> faces = new ArrayList<>();
    ArrayList<Card> deck = new ArrayList<>();

    private int counter = 0;

    public Deck() throws IOException {
        createSuit();
        createFace();
        createCards(this.getPointValueRules());
    }

    private void createCards(ArrayList<PointValueRule> pointValueRulus) {
        System.out.println(pointValueRulus);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                String face = faces.get(j);
                String suit = suits.get(i);
                int pointValue = 1;
                for (PointValueRule rule : pointValueRulus) {
                    if (
                            (rule.getFace().equals(face) || rule.getFace().equals("*"))
                                    &&
                                    (rule.getSuit().equals(suit) || rule.getSuit().equals("*"))
                    ) {
                        pointValue = rule.getPointValue();
                        break;
                    }
                }
                deck.add(
                        new Card(face, suit, pointValue)
                );
            }
        }
    }

    //Todo : BU metod araştırılacak!!
    private ArrayList<PointValueRule> getPointValueRules() throws IOException {
        System.out.println("Please enter points file path [points.txt]");
        String path = sc.nextLine();
        if (path.equals("")) {
            path = "points.txt";
        }

        BufferedReader fileReader = new BufferedReader(new FileReader(path));

        String scan;
        ArrayList<PointValueRule> pointValueRulus = new ArrayList<>();
        while ((scan = fileReader.readLine()) != null) {
            if (scan.length() == 0) {
                continue;
            }

            String suit = scan.substring(0, 1);
            String face = scan.substring(1, 2).trim();
            int pointValue = Integer.parseInt(scan.substring(3));
            pointValueRulus.add(new PointValueRule(face, suit, pointValue));
        }
        return pointValueRulus;
    }

    private void createSuit() {
        suits.add("S");
        suits.add("C");
        suits.add("H");
        suits.add("D");
    }

    private void createFace() {
        faces.add("A");
        faces.add("2");
        faces.add("3");
        faces.add("4");
        faces.add("5");
        faces.add("6");
        faces.add("7");
        faces.add("8");
        faces.add("9");
        faces.add("10");
        faces.add("J");
        faces.add("Q");
        faces.add("K");
    }

    //Deck is cutting
    public void cutDeck() {
        ArrayList<Card> temporary = new ArrayList<>();

        ////Player will make a decision and give a number to cut then the deck will be cut from this number.
        // random nokta belirlendi!!!
        int  cutDeckFrom = r.nextInt(52)+1; //Todo : 0 olabilir mi?;
        for (int i = 0; i < cutDeckFrom; i++) {
            temporary.add(deck.get(i));
        }
        for (int i = cutDeckFrom; i < deck.size(); i++) {
            temporary.add(deck.get(i));
        }
        deck = temporary;
        System.out.println("Deck has just cut randomly..");

        //We defined a method called cutDeck() that allows the player to cut the deck.
        //User will enter a number to indicate where to cut the deck.
        //Then we created a temporary ArrayList to store the cards that come before the cut site, removes those cards from the main deck, and adds them back to the end of the deck after the cut site.
        //With this way cutting will be successfully done.
    }


    //Deck is shuffling
    public void shuffleDeck() {
        Collections.shuffle(deck);
        System.out.println("Deck has just shuffled..");
    }

    //Show the deck
    public void displayDeck() {
        if (counter < 1) {
            cutDeck();
            shuffleDeck();
            counter++;
        }
    }

    public Card pop() {
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }
}
