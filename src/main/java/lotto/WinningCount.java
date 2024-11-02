package lotto;

public enum WinningCount {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_AND_BONUS(5,true, 30000000),
    SIX(6, false, 2000000000);

    private int countOfWinningNumber;
    private boolean isBonusMatched;
    private int  amountToWin;

    WinningCount(int countOfWinningNumber, boolean isBonusMatched, int amountToWin) {
        this.countOfWinningNumber = countOfWinningNumber;
        this.isBonusMatched = isBonusMatched;
        this.amountToWin = amountToWin;
    }

    public int getCountOfWinningNumber() {
        return countOfWinningNumber;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    public int getAmountToWin() {
        return amountToWin;
    }

    public static WinningCount from(int countOfWinningNumber, boolean isBonusMatched){
        if(countOfWinningNumber == 5){
            if(isBonusMatched) return FIVE_AND_BONUS;
            return FIVE;
        }

        for(WinningCount winningCount: WinningCount.values()){
            if(winningCount.getCountOfWinningNumber() == countOfWinningNumber){
                return winningCount;
            }
        }

        return null;
    }
}
