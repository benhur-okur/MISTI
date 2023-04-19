import java.io.*;

public class Point {
    public Point() throws FileNotFoundException {
        this.points = new File("points.txt");
        this.bReader = new BufferedReader(new FileReader(points));
    }
    File points;
    BufferedReader bReader;


}
