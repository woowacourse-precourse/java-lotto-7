package lotto;

public enum LottoResult{
    FIFTH_PRIZEl(3, false, 5000),
    FOURTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 1500000),
    SECOND_PRIZE(5, true, 30000000),
    FIRST_PRIZE(6, false, 2000000000);


    private final int matchCount;
    private final boolean matchBonusNumber;
    private final int prizeMoney;
    private int prizeCount;

    LottoResult(int matchCount, boolean matchBonusNumber, int prizeMoney) {
        this.matchCount = matchCount;
        this.matchBonusNumber = matchBonusNumber;
        this.prizeMoney = prizeMoney;
        this.prizeCount = 0;
    }

    public int getMatchCount(){
        return matchCount;
    }
    public boolean getMatchBonusNumber(){
        return matchBonusNumber;
    }
    public int getPrizeMoney(){
        return prizeMoney;
    }
    public int getPrizeCount(){
        return prizeCount;
    }
    public void increaseCount(){
        this.prizeCount++;
    }

    public static double returnRate(int purchaseMoney){
        long total = 0;
        for(LottoResult result : values()){
            total += result.prizeMoney * result.prizeCount;
        }
        return (double)total/(purchaseMoney)*100;
    }
}
