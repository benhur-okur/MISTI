public class HighScoreEntry {
    private String name;
    private Integer score;

    public HighScoreEntry(Integer score, String name){
        this.name = name;
        this.score = score;
    }

    public String toLine(){
        return this.score.toString().concat(",").concat(this.name);
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
}
