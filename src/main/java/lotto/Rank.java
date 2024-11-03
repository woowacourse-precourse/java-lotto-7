package lotto;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);


    private final int matchNumCount; // 매칭되는 숫자의 개수
    private final boolean isBonusNum; // 보너스 숫자 의미 유무
    private final int winningAmount; // 당첨 금액

    Rank(int matchNumCount,boolean isBonusNum,int winningAmount){
        this.matchNumCount = matchNumCount;
        this.isBonusNum = isBonusNum;
        this.winningAmount = winningAmount;
    }

    public int getWinningAmount(){
        return winningAmount;
    }

    public static Rank checkRank(int matchNumCount, boolean isBonusNum){
        for(Rank rank :Rank.values()){
            if(rank.matchNumCount == matchNumCount && rank.isBonusNum == isBonusNum){
                return rank;
            }
        }
        return NONE;
    }
}
