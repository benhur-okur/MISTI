import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class
ScoreBoard {
    private static final int limit = 5;
    private static String filename = "highscore.txt";
    private ArrayList<HighScoreEntry> list = new ArrayList<>();

    public ScoreBoard() {
        File highScoreFile = new File(filename);
        if (!highScoreFile.exists()) {
            return;
        }

        try {
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int spaceIndex = line.indexOf(",");
                int score = Integer.parseInt(line.substring(0, spaceIndex));
                String name = line.substring(spaceIndex + 1);
                list.add(new HighScoreEntry(score, name));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void apply(Player winner) {
        list.add(new HighScoreEntry(winner.getPoint(), winner.getName()));
        list.sort(new Comparator<HighScoreEntry>() {
            @Override
            public int compare(HighScoreEntry o1, HighScoreEntry o2) {
                return o2.getScore().compareTo(o1.getScore());
            }
        });

        while (list.size() > limit) {
            list.remove(limit);
        }
    }

    public void export() throws IOException {
        File highScoreFile = new File(filename);
        if (!highScoreFile.exists()) {
            highScoreFile.createNewFile();
        } else {
            System.out.println(highScoreFile.getName() + " file already exists! ");
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
        for (HighScoreEntry entry : list) {
            bufferedWriter.write(entry.toLine().concat("\n"));
        }
        bufferedWriter.close();
    }

    public void show() {
        System.out.println("HIGH SCORES");
        for (int i = 0; i < list.size(); i++) {
            HighScoreEntry entry = list.get(i);
            System.out.println(
                    (i+1) + " - " + entry.getName() + " - " + entry.getScore()
            );
        }
    }
}
