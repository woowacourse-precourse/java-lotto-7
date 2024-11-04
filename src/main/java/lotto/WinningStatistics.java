package lotto;

public enum WinningStatistics {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000);

    private int matchCount;
    private int prize;

    WinningStatistics(int matchCount, int prize){
        this.matchCount = matchCount;
        this.prize = prize;

    }

    public int getMatchCount(){
        return this.matchCount;
    }
    public int getPrize(){
        return this.prize;
    }


}
