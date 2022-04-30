public class Test {
    private String time;
    private int fullScore;

    public Test(String time, int fullScore){
        this.time = time;
        this.fullScore = fullScore;
    }

    public String getTime(){
        return time;
    }

    public int getFullScore(){
        return this.fullScore;
    }
}
