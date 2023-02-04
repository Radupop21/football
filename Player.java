public class Player {
    private String name;
    private int score;
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public void print() {
        System.out.print("{name: " + this.name + ", " + "score: " + this.score + "}");
    }
    public int getScore() {
        return this.score;
    }
}
