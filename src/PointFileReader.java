import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PointFileReader {

    // Todo: make sure if it's not used, and remove
    public PointFileReader() throws FileNotFoundException {
        this.points = new File("points.txt");
        this.bReader = new BufferedReader(new FileReader(points));
    }

    public PointFileReader(String path) throws FileNotFoundException {
        this.points = new File(path);
        this.bReader = new BufferedReader(new FileReader(points));
    }

    File points;
    BufferedReader bReader;
}
