import java.util.*;

public class Deck {
    //Cutting and shuffling method will be done in this class
    //Also we will create our ArrayLists for suits, faces and deck

    Scanner sc = new Scanner(System.in);
    ArrayList<String> suit = new ArrayList<>();
    ArrayList<String> face = new ArrayList<>();
    ArrayList<String> deck = new ArrayList<>();

    private int counter = 0;

    public Deck(){}


    private void createSuit(){
        suit.add("S");
        suit.add("C");
        suit.add("H");
        suit.add("D");
    }

    private void createFace(){
        face.add("A");
        face.add("2");
        face.add("3");
        face.add("4");
        face.add("5");
        face.add("6");
        face.add("7");
        face.add("8");
        face.add("9");
        face.add("10");
        face.add("J");
        face.add("Q");
        face.add("K");
    }

    //Deck is creating
    public void createDeck(){
        createSuit();
        createFace();
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
                String s = suit.get(i).concat(face.get(j));
                deck.add(s);
            }
        }
    }

    public void showDeckLineByLine() {
        for (String i : deck) {
            System.out.println(i);
        }
    }

    //Deck is cutting
    public void cutDeck(){
        ArrayList<String> temporary = new ArrayList<>();
        System.out.println("Please choose where you want to cut: ");
        int cutSite = sc.nextInt();
        ////Player will make a decision and give a number to cut then the deck will be cut from this number.

        for(int i=0;i<cutSite;i++){
            temporary.add(deck.get(0));
            deck.remove(0);
        }
        for(int i=0;i<temporary.size();i++){
            deck.add(temporary.get(i));
        }
        System.out.println("Deck has just cut..");

//We defined a method called cutDeck() that allows the player to cut the deck.
//User will enter a number to indicate where to cut the deck.
//Then we created a temporary ArrayList to store the cards that come before the cut site, removes those cards from the main deck, and adds them back to the end of the deck after the cut site.
//With this way cutting will be successfully done.
    }



    //Deck is shuffling
    public void shuffleDeck(){
        Collections.shuffle(deck);
        System.out.println("Deck has just shuffled..");
    }

    //Show the deck
    public void displayDeck(){
        if(counter < 1){
            cutDeck();
            shuffleDeck();
            counter ++;
        }

    }

}
