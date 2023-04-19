import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> str = new ArrayList<>();
        str.add("benhur");
        str.add("doğa");

        for (String s : str) {
            System.out.println(s);
        }
        System.out.println("BENHUR");
        String str1 = "sa";
        Character chr = str1.charAt(3);
        System.out.println();

        Deck d = new Deck();
        d.displayDeck();

    }
}