import java.util.*;

public class Deck {

    Scanner sc = new Scanner(System.in);
    ArrayList<String> suit = new ArrayList<>();
    ArrayList<String> face = new ArrayList<>();
    ArrayList<String> deck = new ArrayList<>();

    public Deck(){}

    private void createSuit(){
        suit.add("♠");
        suit.add("♣");
        suit.add("♥");
        suit.add("♦");
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
    private void createDeck(){
        createSuit();
        createFace();
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
                String s = suit.get(i).concat(face.get(j));
                deck.add(s);
            }
        }
    }

    //Deck is cutting
    private void cutDeck(){
        ArrayList<String> temporary = new ArrayList<>();
        System.out.println("Please choose where you want to cut: ");
        int cutSite = sc.nextInt();
        for(int i=0;i<cutSite;i++){
            temporary.add(deck.get(i));
            deck.remove(0);
        }
        for(int i=0;i<temporary.size();i++){
            deck.add(temporary.get(i));
        }
        System.out.println(deck);
    }

    //Deck is shuffling
    private void shuffleDeck(){
        Collections.shuffle(deck);
        System.out.println(deck);
    }

    //Show the deck
    public void displayDeck(){
        createDeck();
        for(int i=0;i<52;i++){
            System.out.println(deck.get(i));
        }
        cutDeck();
        shuffleDeck();
    }
}
