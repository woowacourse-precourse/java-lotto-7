package lotto.domain;

public enum Prize {
    FIRST(6, 2_000_000_000, 4),
    SECOND(5, 30_000_000, 3),
    THIRD(5, 1_500_000, 2),
    FOURTH(4, 50_000, 1),
    FIFTH(3, 5_000, 0),
    NONE(0, 0, -1);

    private final int matchCount;
    private final int prizeAmount;
    private final int index;

    Prize(int matchCount, int prizeAmount, int index){
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.index = index;
    }
    public int getPrizeAmount(){
        return prizeAmount;
    }
    public int getIndex(){return index;}

    public static Prize getPrize(int matchCount, boolean bonusMatch){
        if(matchCount == 6){
            return FIRST;
        }
        if(matchCount == 5 && bonusMatch){
            return SECOND;
        }
        if(matchCount == 5){
            return THIRD;
        }
        if(matchCount == 4){
            return FOURTH;
        }
        if(matchCount == 3){
            return FIFTH;
        }
        return NONE;
    }
}
