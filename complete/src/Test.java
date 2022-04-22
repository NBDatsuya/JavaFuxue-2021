public class Test {
    private String time;
    private int FullScore;

    public Test(String time, int FullScore) {
        this.time = time;
        this.FullScore = FullScore;
    }

    public String getTime() {
        return time;
    }

    public int getFullScore() {
        return FullScore;
    }

    public String toString() {
        return "Test{" + "time=" + time + ", FullScore=" + FullScore + '}';
    }
}
