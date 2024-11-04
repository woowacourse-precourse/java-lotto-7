package lotto;

public enum WinningStatistics {
    THREE_MATCH(3, 5000,"3개 일치"),
    FOUR_MATCH(4, 50000,"4개 일치"),
    FIVE_MATCH(5, 1500000,"5개 일치"),
    FIVE_MATCH_BONUS(5, 30000000,"5개 일치, 보너스 볼 일치"),
    SIX_MATCH(6, 2000000000,"6개 일치");

    private int matchCount;
    private int prize;
    private String describe;

    WinningStatistics(int matchCount, int prize,String describe){
        this.matchCount = matchCount;
        this.prize = prize;
        this.describe=describe;

    }

    public int getMatchCount(){
        return this.matchCount;
    }
    public int getPrize(){
        return this.prize;
    }
    public String getDescribe(){
        return this.describe;
    }

}
