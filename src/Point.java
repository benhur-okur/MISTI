import java.io.*;

public class Point {
    File points = new File("points.txt");
    BufferedReader bReader = new BufferedReader(new FileReader(points));

    public Point() throws FileNotFoundException {
    }
}
