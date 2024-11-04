package lotto;

public enum PrizeMoneyByRank {
    FIFTH(3,5000),
    FOURTH(4,50000),
    THIRD(5,1500000),
    SECOND(5,30000000),
    FIRST(6,2000000000),
    TRASH(0,0);

    private final int matchCount;
    private final int prizeMoney;


    PrizeMoneyByRank(int matchCount, int prizeMoney){
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }
    public int getMatchCount(){
        return  matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
    public static PrizeMoneyByRank getRankByMatchCount(int matchCount, int bonusMatch){
        if(matchCount == FIRST.getMatchCount()){
            return FIRST;
        }
        if(matchCount == SECOND.getMatchCount()&& bonusMatch == 1 ){
            return SECOND;
        }
        if(matchCount == THIRD.getMatchCount()&& bonusMatch == 0 ){
            return THIRD;
        }
        if(matchCount == FOURTH.getMatchCount()){
            return FOURTH;
        }
        if(matchCount == FIFTH.getMatchCount()){
            return FIFTH;
        }
        return TRASH;
    }
}
