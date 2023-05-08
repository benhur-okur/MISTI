import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Board {
    Random ran = new Random();
    Scanner sc = new Scanner(System.in);
    private Point point = new Point();

    public ArrayList<Character> chosenBotList = new ArrayList<>();
    private boolean matchingValue = false;
    private boolean isPisti = false;

    public int getNoOfPlayer() {
        return noOfPlayer;
    }

    private ArrayList<String> board = new ArrayList<>();
    private boolean isHuman; // we will use this data for dealing the hand for human or not;
    private String askingUser; // in this data we are asking the user whether he or she is playing as a player;

    private Human hPlayer = new Human();
    private NoviceBot nPlayer1;
    private NoviceBot nPlayer2;
    private NoviceBot nPlayer3;
    private NoviceBot nPlayer4;

    private RegularBot rPlayer1;
    private RegularBot rPlayer2;
    private RegularBot rPlayer3;
    private RegularBot rPlayer4;

    private ExpertBot ePlayer1;
    private ExpertBot ePlayer2;
    private ExpertBot ePlayer3;
    private ExpertBot ePlayer4;


    public RegularBot getrPlayer1() {
        return rPlayer1;
    }

    public RegularBot getrPlayer2() {
        return rPlayer2;
    }

    public RegularBot getrPlayer3() {
        return rPlayer3;
    }

    public RegularBot getrPlayer4() {
        return rPlayer4;
    }

    public ExpertBot getePlayer1() {
        return ePlayer1;
    }

    public ExpertBot getePlayer2() {
        return ePlayer2;
    }

    public ExpertBot getePlayer3() {
        return ePlayer3;
    }

    public ExpertBot getePlayer4() {
        return ePlayer4;
    }

    public NoviceBot getnPlayer1() {
        return nPlayer1;
    }

    public NoviceBot getnPlayer2() {
        return nPlayer2;
    }

    public NoviceBot getnPlayer3() {
        return nPlayer3;
    }

    public NoviceBot getnPlayer4() {
        return nPlayer4;
    }

    public Human gethPlayer() {
        return hPlayer;
    }


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


    public void dealCard() throws InterruptedException, IOException {
        firstFourCard();
        int counterN = 0;
        int counterR = 0;
        int counterE = 0;
        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;
        boolean f4 = false;
        //System.out.println(getTopCard());
        //if (!isHuman) {
            for (int i = 0; i < chosenBotList.size(); i++) { // N R E
                switch (chosenBotList.get(i)) {
                    case 'N':
                        if (nBots[counterN].getHand().isEmpty()) {
                            f1 = true;
                            //nBots[counterN].getHand().add(deck.deck.get(0));
                            //deck.deck.remove(0);
                        }
                        break;

                    case 'R':
                        if (rBots[counterR].getHand().isEmpty()) {
                            f2 = true;
                        }
                        break;
                        //counterR++;
                    case 'E':
                        if (eBots[counterE].getHand().isEmpty()) {
                            f3 = true;

                        }
                        break;

                    case 'H':
                        if (hPlayer.getHand().isEmpty()) {
                            f4 = true;

                        }
                        break;

                }
            }
            while (f1 || f2 || f3 || f4) { // elleri boş olduğu zaman dağıtmak için çalışıcak (or gelebilir)   0   1
                for (int j = 0;j<4;j++) {
                    for (int i = 0; i < chosenBotList.size(); i++) {
                        if (chosenBotList.get(i).equals('N')) {
                            nBots[counterN].getHand().add(deck.deck.get(0));
                            deck.deck.remove(0);
                            counterN++;
                            if(counterN == iN){
                                counterN = 0;
                            }
                        } else if (chosenBotList.get(i).equals('R')) {
                            rBots[counterR].getHand().add(deck.deck.get(0));
                            deck.deck.remove(0);
                            counterR++;
                            if(counterR == iR){
                                counterR = 0;
                            }
                        } else if (chosenBotList.get(i).equals('E')) {
                            eBots[counterE].getHand().add(deck.deck.get(0));
                            deck.deck.remove(0);
                            counterE++;
                            if(counterE == iE){
                                counterE = 0;
                            }
                        } else if (chosenBotList.get(i).equals('H')) {
                            hPlayer.getHand().add(deck.deck.get(0));
                            deck.deck.remove(0);
                        }
                    }
                    displayHand();
                }
                f1 = false; f2 =false; f3 = false; f4 = false;
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


    int modNo;

    int count = 0;

    public void modSelect() throws InterruptedException {
        if (count == 0) {
            if(isHuman){
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
            }else {
                modNo = 2;
            }

        }
    }
    //If an exception is thrown while reading the user's input -for example an non-integer value-
    // Then the code will catch the exception and displays an error message asking the user to select a valid number again. It also prints the exception message.

    private void playForNoviceBot(int cN) throws IOException { // novice bot play bitti !
        matchingValue = false;
        String returnValue = nBots[cN].getHand().get(nBots[cN].play());
        if (getTopCard() != null) { // bu if şartı top card null olursa alttaki if'in çalımadığı gözlendiği için konulmuştur.
            if (returnValue.charAt(1) == getTopCard().charAt(1)) {
                matchingValue = true;
            }
        }
        increaseCounter(returnValue);
        board.add(returnValue);
        System.out.println("Novice" + (cN + 1) + " bot has played : " + returnValue);
        nBots[cN].getHand().remove(returnValue);
        if (matchingValue) {
            saveEarnedCards('N');
        }
    }

    private void playForHuman() { // bu metodun içine sadece saveEarnedCards eklenmeli ondan sonra bitti !! ***
         matchingValue = false;
        String returnValue = hPlayer.getHand().get(hPlayer.play());
        if(getTopCard() != null){
            if(returnValue.charAt(1) == getTopCard().charAt(1)){
                matchingValue = true;
            }
        }
        increaseCounter(returnValue);
        board.add(returnValue);
        System.out.println("You have been played : " + returnValue);
        hPlayer.getHand().remove(returnValue);

        if(matchingValue){
            saveEarnedCards('H');
        }

    }


    int totalPoint = 0;

    private int totalPointsOfBoard() throws IOException {

        if(board.size() == 0){//board'daki kartlar sıfırlandığında totalPoint 0'a eşitlenir!!!
            totalPoint = 0;
        }

        for (int i = 0;i<board.size();i++) {
            pointOfBoardCards(i);
        }

        return totalPoint;

    }

    private void pointOfBoardCards(int i) throws IOException {
        boolean b1 = true;
        BufferedReader br = new BufferedReader(new FileReader("points.txt"));

            String line = br.readLine();
            while(line != null){
                try {
                    if (line.startsWith(board.get(i))) {
                        totalPoint += Integer.parseInt(line.substring(3).trim());
                        b1 = false;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                line = br.readLine();
            }
            if (b1) {
                totalPoint += 1;
            }

    }

    String[][] countersOfFaces = {
            {"A", "2", "3", "4", "5", "6", "7", "8", "9", "1", "J", "Q", "K"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"}
    };

    private String findCardsCountMin(int cE) {
        ArrayList<ArrayList<String>> count = new ArrayList<ArrayList<String>>();
        count.add(new ArrayList<String>());
        count.add(new ArrayList<String>());
        for (int i = 0;i<eBots[cE].getHand().size();i++) {
            for (int j = 0;j<13;j++) {
                if (String.valueOf(eBots[cE].getHand().get(i).charAt(1)).equals(countersOfFaces[0][j])) {
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
        return eBots[cE].getHand().get(indexOfMinCount);
    }

    private String findCardsCountMax(int cE) {
        ArrayList<ArrayList<String>> count = new ArrayList<ArrayList<String>>();
        count.add(new ArrayList<String>());
        count.add(new ArrayList<String>());
        for (int i = 0;i<eBots[cE].getHand().size();i++) {
            for (int j = 0;j<13;j++) {
                if (String.valueOf(eBots[cE].getHand().get(i).charAt(1)).equals(countersOfFaces[0][j])) {
                    count.get(0).add(countersOfFaces[0][j]); // A 2 6 J
                    count.get(1).add(countersOfFaces[1][j]); // 1 0 3 4
                }

            }
        }
        int indexOfMaxCount = 0;
        for (int i = 0;i<count.get(1).size()-1;i++) { // 1 3 0 2
            for (int j = i + 1;j<count.get(1).size();j++) {
                if (Integer.parseInt(String.valueOf(count.get(1).get(j))) > Integer.parseInt(String.valueOf(count.get(1).get(i)))) {
                    indexOfMaxCount = j;
                }
            }
        }
        return eBots[cE].getHand().get(indexOfMaxCount);
    }

    private void increaseCounter(String card) { // paraetredeki kart oyuncunu oynyacağı kart olucaktır.
        int newCount = 0;
        String faceOfCard = String.valueOf(card.charAt(1));
        for (int i = 0;i<13;i++) {
            if (faceOfCard.equals(countersOfFaces[0][i])) {
                newCount = Integer.parseInt(String.valueOf(countersOfFaces[1][i]));
                newCount++;
                countersOfFaces[1][i] = String.valueOf(newCount);
            }
        }
    }

    private void playForExpertBot(int eN) throws IOException {

        int p1 = 0;
        matchingValue = false;
        boolean f1 = true;
        int matchingIndex = 0;
        for (int i = 0; i < eBots[eN].getHand().size(); i++) {
            if (getTopCard() != null) { // top card null ise hemen aşağıdaki if error vericektir o yuzden bu if eklenmiştir.
                if (eBots[eN].getHand().get(i).charAt(1) == (getTopCard().charAt(1))) {
                    matchingValue = true; // pişti var demek gibi bir şey
                    matchingIndex = i; // elimizde 4 kart var hangi kartın pişti yapabilecegini söylüyor (index olarak)
                    break; // We have 4 cards in our hand and it will tell which card will be make pisti out of them(as imdex)
                }
            }
        }
        if(matchingValue){ // eğer expertin elindeki kartın face'i top cardın face'i ile uyuşuyorsa bu if şartına giricek
            System.out.println("matching value giriyo mu");
            BufferedReader bufferedReader = new BufferedReader(new FileReader("points.txt"));
            try {
                String line = bufferedReader.readLine();
                while (line != null && f1) { // bu döngüde elimizdeki uyuşan kartın txt file'dan puanını buluyoruz
                    if (line.length() == 0) {
                        break;
                    }
                    if (f1) {
                        if (line.startsWith(eBots[eN].getHand().get(matchingIndex))) {
                            p1 = Integer.parseInt(line.substring(3).trim());
                            //System.out.println("Points from txt file : " + i1);
                            f1 = false;
                        } else {
                            p1 = 1;
                            //System.out.println("Card has not found thus point : " + i1);
                        }
                    }
                    line = bufferedReader.readLine();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("matching value sonu");
            if(totalPointsOfBoard() + p1 > 0){ // eğer ki olası kazanılcak kartların toplam puanı pozitif ise matching index'li kartı oynuyor ve boarddaki bütün kartları kaznmış oluyor
                System.out.println(totalPointsOfBoard());
                System.out.println(p1);
                System.out.println("giriyo mu buraya?");
                board.add(eBots[eN].getHand().get(matchingIndex));
                System.out.println("Expert bot" + (eN+1) + " has just played : " + eBots[eN].getHand().get(matchingIndex));
                eBots[eN].getHand().remove(eBots[eN].getHand().get(matchingIndex));
                saveEarnedCards('E'); // kazanma durumunda bu method çağrılıyor ve içindeki parametreye de regular bot oldugunu belli etmemiz lazım
            }else{ // eğer ki olası kazanaılcak kartların toplam puanı 0 veya negatif ise elindeki matching index'li karttan vazgeçiyor ve elindeki counter'ı en düşük kartı oynuyor +++
                // board'da biriken -'li kartları karşıya kazandırması kolay olsun çünkü karşıda expert dışında bir bot varsa board'da biriken bütün kartlrın puanını hesap edemicek
                System.out.println("her yere sout");
                String card = findCardsCountMin(eN); // burada karşımızda regular varken countMin atmak degil de + puanlı bir kart atmak daha iyi olabilir mi acaba ?
                if(eBots[eN].getHand().size() != 1){//Face'lerin farklı olmasını istiyoruz o yüzden saveEarnedC çağrılmadı!!!
                    while (card.charAt(1) == eBots[eN].getHand().get(matchingIndex).charAt(1)) {
                        card = eBots[eN].getHand().get(ran.nextInt(eBots[eN].getHand().size()));

                    }
                    board.add(card);
                    System.out.println("Expert bot" + (eN+1) + " has just played : " + card);
                    eBots[eN].getHand().remove(card);
                }else {//Mecburen aynı face atılabilir o yüzden saveEarnedC çağırıldı!!!
                    board.add(card);
                    System.out.println("Expert bot" + (eN+1) + " has just played : " + card);
                    eBots[eN].getHand().remove(card);
                    saveEarnedCards('E');
                }

            }
        } else {
            if (totalPointsOfBoard() > 0) { // ortadaki kartların toplam puanı 0'dan büyükse counterı en büyük olanı atıcak
                board.add(findCardsCountMax(eN));
                System.out.println("Expert bot" + (eN+1) + " has just played : " + findCardsCountMax(eN));
                eBots[eN].getHand().remove(findCardsCountMax(eN));
            }
            else {
                board.add(findCardsCountMin(eN));
                System.out.println("Expert bot" + (eN+1) + " has just played : " + findCardsCountMin(eN));
                eBots[eN].getHand().remove(findCardsCountMin(eN));
            }
        }

    }


    private void playForRegularBot(int rN) throws FileNotFoundException { // bu method için parametre ekliceez RegularBot tipinde !
        matchingValue = false;
        String cardOfLine;
        String s1 = null;
        String s2 = null;
        int i1 = 0;
        int i2 = 0;
        boolean f1 = true;
        boolean f2 = true;
        int matchingIndex = 0;
        for (int i = 0; i < rBots[rN].getHand().size(); i++) {
            if (getTopCard() != null) { // top card null ise hemen aşağıdaki if error vericektir o yuzden bu if eklenmiştir.
                if (rBots[rN].getHand().get(i).charAt(1) == (getTopCard().charAt(1))) {
                    matchingValue = true; // pişti var demek gibi bir şey
                    matchingIndex = i; // elimizde 4 kart var hangi kartın pişti yapabilecegini söylüyor (index olarak)
                    break; // We have 4 cards in our hand and it will tell which card will be make pisti out of them(as imdex)
                }
            }
        }
        if (matchingValue) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("points.txt"));
            try {
                String line = bufferedReader.readLine();
                while (f1 || f2) {
                    if (line.length() == 0) {
                        break;
                    }
                    cardOfLine = String.valueOf(line.charAt(0) + line.charAt(1)); // txt file'daki her satırın kartı örn: 1. satır için SA
                    if (f1) {
                        if (line.startsWith(rBots[rN].getHand().get(matchingIndex))) {
                            i1 = Integer.parseInt(line.substring(3).trim());
                            //System.out.println("Points from txt file : " + i1);
                            f1 = false;
                        } else {
                            i1 = 1;
                            //System.out.println("Card has not found thus point : " + i1);
                        }
                    }
                    if (f2) {
                        if (line.startsWith(getTopCard())) {
                            i2 = Integer.parseInt(line.substring(3).trim());
                            //System.out.println("Points from top card : " + i2);
                            f2 = false;
                        } else {
                            i2 = 1;
                            //System.out.println("Card has not found thus point : " + i2);
                        }
                    }
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            if ((i1 + i2) > 0) {
                increaseCounter(rBots[rN].getHand().get(matchingIndex));
                board.add(rBots[rN].getHand().get(matchingIndex));
                System.out.println("Regular bot" + (rN+1) + " has just played : " + rBots[rN].getHand().get(matchingIndex));
                rBots[rN].getHand().remove(rBots[rN].getHand().get(matchingIndex));
                saveEarnedCards('R'); // kazanma durumunda bu method çağrılıyor ve içindeki parametreye de regular bot oldugunu belli etmemiz lazım
                //Our regular player has to think about the points and it should play accordingly to points because it's advanced player than novice bot.
            }
            else {
                int indexOfPlay = ran.nextInt(rBots[rN].getHand().size()); // 2
                if (rBots[rN].getHand().size() != 1) { // elimizde tek kart kaldıysa mecbur o kartı atmak zorunda kalıcak o yüzden bu if şartı eklenmiştir (yoksa sonsuza kadar aşağıdaki döngüde kalıcaktır)
                    while (indexOfPlay == matchingIndex) {  // 2
                        indexOfPlay = ran.nextInt(rBots[rN].getHand().size());
                        //if our random card is the same as the matching card, our random card will return to this loop until it is different from the matching card
                    }
                    increaseCounter(rBots[rN].getHand().get(indexOfPlay));
                    board.add(rBots[rN].getHand().get(indexOfPlay));
                    System.out.println("Regular bot" + (rN+1) + " has just played : " + rBots[rN].getHand().get(indexOfPlay));
                    rBots[rN].getHand().remove(rBots[rN].getHand().get(indexOfPlay));
                } else {//Elimizde 1 kart varken ortadaki karta eşit olma durumunda saveEarnedCards metodunun çağırılıp çağırılmayacağını inceler
                    if (rBots[rN].getHand().get(indexOfPlay).charAt(1) == getTopCard().charAt(1)) {
                        increaseCounter(rBots[rN].getHand().get(indexOfPlay));
                        board.add(rBots[rN].getHand().get(indexOfPlay));
                        saveEarnedCards('R');
                        System.out.println("Regular bot" + (rN+1) + " has just played : " + rBots[rN].getHand().get(indexOfPlay));
                        rBots[rN].getHand().remove(rBots[rN].getHand().get(indexOfPlay));
                    }
                    else {
                        increaseCounter(rBots[rN].getHand().get(indexOfPlay));
                        board.add(rBots[rN].getHand().get(indexOfPlay));
                        System.out.println("Regular bot" + (rN+1) + " has just played : " + rBots[rN].getHand().get(indexOfPlay));
                        rBots[rN].getHand().remove(rBots[rN].getHand().get(indexOfPlay));
                    }
                }


            }
        } else {
            int indexOfPlay = ran.nextInt(rBots[rN].getHand().size()); // eğer uyuşan kart yoksa rastgele bir kart oynayacak bu degeri inte atamamızın sebebi ikinci kez rastgele seçim yapmamak için.
            increaseCounter(rBots[rN].getHand().get(indexOfPlay));
            board.add(rBots[rN].getHand().get(indexOfPlay));
            System.out.println("Regular bot " + (rN+1) + "has just played : " + rBots[rN].getHand().get(indexOfPlay));
            rBots[rN].getHand().remove(rBots[rN].getHand().get(indexOfPlay));

        }

    }

    //The code first checks if there is a matching card in the regular bot's hand with the top card of the board.
    // If there is a match, the corresponding point values of the card in the regular bot's hand and the top card are looked up from a text file called "points.txt".
    // If the sum of these point values is greater than 0, then the regular bot plays the matching card, removes it from its hand, adds it to the board and saves the points earned.
    //(Since it is a 'regular bot', it should calculate this score and play cards accordingly.)

    //If there is no matching card in the regular bot's hand, a random card from its hand is played and added to the board.
    //In both cases, the card played by the regular bot and the action taken are printed out.

    public String getTopCard() { // eğer ki topCard null olur ise 2. return sağlanamayacağı için if şartı eklenmiştir.
        if (board.size() == 0) {
            return null;
        }
        return board.get(board.size() - 1);
    }

    public void play() throws IOException, InterruptedException {
        int cN = 0;
        int rN = 0;
        int eN = 0;
        for(int i =0;i<4;i++){
            for (Character character : chosenBotList) { // R R
                switch (character) {
                    case 'N' :
                        playForNoviceBot(cN);
                        cN++;
                        if(cN == iN){
                            cN = 0;
                        }
                        break;
                    case 'R' :
                        playForRegularBot(rN);
                        rN++;
                        if (rN == iR) {
                            rN = 0;
                        }
                        break;
                    case 'E' :
                        playForExpertBot(eN);
                        eN++;
                        if (eN == iE) {
                            eN = 0;
                        }
                        break;
                    case 'H' :
                        playForHuman();
                        break;
                    default :
                        System.out.println("Please enter a valid character");
                        break;
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


    public void displayHand() {
        int n = 0;
        int r = 0;
        int e = 0;

        if (modNo == 1) {
            System.out.println("Human player's hand: " + hPlayer.getHand());
        } else if (modNo == 2) {
            for (int i = 0; i < chosenBotList.size(); i++) {
                if (chosenBotList.get(i).equals('N')) {
                    System.out.println((n+1) + ".Novice player's hand: " + nBots[n].getHand()); //
                    n++;
                    if(n == iN){
                        n = 0;
                    }
                } else if (chosenBotList.get(i).equals('R')) {
                    System.out.println((r+1) + ".Regular player's hand: " + rBots[r].getHand() );
                    r++;
                    if (r == iR) {
                        r = 0;
                    }
                } else if (chosenBotList.get(i).equals('E')) {
                    System.out.println((e+1) + ".Expert player's hand: "  + eBots[e].getHand());
                    e++;
                } else if (chosenBotList.get(i).equals('H')) {
                    System.out.println("Human player's hand " + hPlayer.getHand());
                }
            }
        }
    }

    private boolean canMakePisti() { // pişti yapabiliyor muyuz onu belirliyoruz boolean tipinde bu da piştiden kazanılan kartların earnedWithPisti array list'ine gitmesini sağlıcak şart.
        if (matchingValue && (board.size() == 2) ){
            isPisti = true;
        }
        return isPisti;
    }



    // saveEarnedCardsMetodu açıklama;
    // bu method oyuncuların iyi bir kart atıp ortadaki kartları kazanma durumlarını göz önünde bulunduruyor ve kartları pişti'den kazanılıp-
    //kazanılmadığını anlayıp 2 farklı arrayliste aktarıyor(getEarnedWithPisti or getEarnedWithoutPisti gibi) bunun sebebi de pişti'den kazanılan
    // kartların puan değerinin farklı olması sebebiyle karışıklık olmaması içindir.
    // aynı zamanda bu methodun içinde kazanma durumu için ortadaki kartlaın silinmesi hazırlanmıştır.
    private void saveEarnedCards(Character c) { // aşağıdaki 3 counter aynı tip bottan birden fazla var ise bu durumu yerine getirmek için konulmuştur.
        int boardSize = 0;
        int counterN_save = 0;
        int counterR_save = 0;
        int counterE_save = 0;
        switch (c) {
            case 'N' -> {
                boardSize = board.size();
                if (canMakePisti()) {
                    for (int i = 0;i<boardSize;i++) {
                        nBots[counterN_save].getEarnedWithPisti().add(board.get(0));
                        board.remove(0);
                    }
                    System.out.println("Board has just cleaned!! " + nBots[counterN_save] + " has made a pişti and it took all cards from board!!");
                } else {
                    for (int i = 0;i<boardSize;i++) {
                        nBots[counterN_save].getEarnedWithoutPisti().add(board.get(0)); // add'in içine b'mi gelicek yoksa sıfır mı ?? dikkat !
                        board.remove(0);
                    }
                    System.out.println("Board has just cleaned!! " + nBots[counterN_save] + " has just win all cards of board");
                }
                counterN_save++;
            }
            case 'R' -> {
                boardSize = board.size();
                if (canMakePisti()) {
                    for (int i = 0;i<boardSize;i++) {
                        rBots[counterR_save].getEarnedWithPisti().add(board.get(0));
                        board.remove(0);
                    }
                    System.out.println("Board has just cleaned!! " + rBots[counterR_save] + " has made a pişti and it took all cards from board!!");

                } else {
                    for (int i = 0;i<boardSize;i++) {
                        rBots[counterR_save].getEarnedWithoutPisti().add(board.get(0));
                        board.remove(0);
                    }
                    System.out.println("Board has just cleaned!! " + rBots[counterR_save] + " has just win all cards of board");
                }
                counterR_save++;
            }
            case 'E' -> {
                boardSize = board.size();
                if (canMakePisti()) {
                    for (int i = 0;i<boardSize;i++) {
                        eBots[counterE_save].getEarnedWithPisti().add(board.get(0));
                        board.remove(0);
                    }
                    System.out.println("Board has just cleaned!! " + eBots[counterE_save] + " has made a pişti and it took all cards from board!!");
                } else {
                    for (int i = 0;i<boardSize;i++) {
                        eBots[counterE_save].getEarnedWithoutPisti().add(board.get(0));
                        board.remove(0);
                    }
                    System.out.println("Board has just cleaned!! " + eBots[counterE_save] + " has just win all cards of board");
                }
                counterE_save++;
            }
            case 'H' -> {
                boardSize = board.size();
                if (canMakePisti()) {
                    for (int i = 0;i<boardSize;i++) {
                        hPlayer.getEarnedWithPisti().add(board.get(0));
                        board.remove(0);
                    }
                    System.out.println("Board has just cleaned!! " + "Human Player" + " has made a pişti and it took all cards from board!!");
                } else {
                    for (int i = 0;i<boardSize;i++) {
                        hPlayer.getEarnedWithoutPisti().add(board.get(0));
                        board.remove(0);
                    }
                    System.out.println("Board has just cleaned!! " + "Human Player" + " has just win all cards of board");
                }
            }
        }

    }

    int iN = 0; // important for if there are more than one same bot
    int iR = 0; // important for if there are more than one same bot
    int iE = 0; // important for if there are more than one same bot

    public void createPlayers() throws IOException { // player select metodunda seçilen botların objelerini oluşturan methodları sırasıyla çağırır.
        for (int i = 0; i < chosenBotList.size(); i++) { // N R N
            if (chosenBotList.get(i).equals('N')) {
                createNoviceBot();
            }else if(chosenBotList.get(i).equals('R')){
                createRegularBot();
            } else if(chosenBotList.get(i).equals('E')){
                createExpertBot();
            }
        }
    }


    //case 4 :


    NoviceBot[] nBots = {nPlayer1, nPlayer2, nPlayer3, nPlayer4};

    RegularBot[] rBots = {rPlayer1, rPlayer2, rPlayer3, rPlayer4};

    ExpertBot[] eBots = {ePlayer1, ePlayer2, ePlayer3, ePlayer4};


    public void createNoviceBot() throws IOException { // player select methodundan sonra create players methodunda duruma göre eğer oyuna novice bot eklendiyse o botun objelerini tanımalr

        nBots[iN] = new NoviceBot(); // nplayer1
        iN++; // 1

    }

    public void createRegularBot() throws IOException { // player select methodundan sonra create players methodunda duruma göre eğer oyuna regular bot eklendiyse o botun objelerini tanımalr

        rBots[iR] = new RegularBot(); // nplayer1
        iR++; // 1

    }

    public void createExpertBot() throws IOException { // player select methodundan sonra create players methodunda duruma göre eğer oyuna expert bot eklendiyse o botun objelerini tanımalr

        eBots[iE] = new ExpertBot(); // nplayer1
        iE++; // 1

    }

    public void playerSelect() { // oyunun içnde olucak bütün oyuncuların sayısı ve türü bu metod tarafından sağlanır
        howManyPlayers();
        int x = 0;
        if(isHuman){
            x = noOfPlayer-1;
        }else{
            x = noOfPlayer;
        }
            for (int i = 0; i < x; i++) {

                System.out.println("Which bot do you want to play?");
                System.out.println("'Novice', 'Regular', 'Expert'");
                s = sc.nextLine();

                switch (s.toUpperCase()) { // bilgisayarın diline göre büyük harf kucuk harfte sıkıntı oluyor bunu if else'ten equals ile yapılması lazım !!!!
                    case "NOVICE" :
                        chosenBotList.add('N');
                        break;
                    case "REGULAR" :
                        chosenBotList.add('R');
                        break;
                    case "EXPERT" :
                        chosenBotList.add('E');
                        break;
                }
            }


    }
    public void firstFourCard() { // oyun başında ortaya atılcak ilk dört kart bu metod tarafından sağlanır.
        deck.displayDeck();
        if(counter < 4){
            for (int i = 0; i < 4; i++) {
                board.add(deck.deck.get(0));
                deck.deck.remove(0);
                counter++;
            }
            System.out.println("Cards has dealt to the table");
            System.out.println("Top card: " + board.get(3));  //4th card will be the top card.
        }
    }
    /*public boolean conditionOfWin(char c) {
        if ()
    }*/

    public String playJack(ArrayList<>) {
        for (int i = 0;i<)
    }

}



