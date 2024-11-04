package lotto;

public enum WinningRank {
    FIFTH_WINNING(3, 5_000),
    FOURTH_WINNING(4, 50_000),
    THIRD_WINNING(5, 1_500_000),
    SECOND_WINNING(5, 30_000_000), //일반 번호 5개, 보너스 번호 1개
    FIRST_WINNING(6, 2_000_000_000),
    NO_WINNING(0, 0);

    private final int matchCount;
    private final int winningAmount;

    WinningRank(int matchCount, int winningAmount){
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getWinningAmount(){
        return winningAmount;
    }

    public static WinningRank getRank(int matchCount, boolean bonusMatch){
        if(matchCount == 6) return FIRST_WINNING;
        if(matchCount == 5 && bonusMatch) return SECOND_WINNING;
        if(matchCount == 5) return THIRD_WINNING;
        if(matchCount == 4) return FOURTH_WINNING;
        if(matchCount == 3) return FIFTH_WINNING;
        return NO_WINNING;
    }
}
