package lotto;

public class LottoResult {
    int winningCount;
    int bonusCount;

    public LottoResult(int winningCount, int bonusCount) {
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }


    public void checkWinningLotto() {
        for (WinningPrize str:WinningPrize.values()){
            if (str.winningCount == getWinningCount() && str.bonusCount <= getBonusCount()){
                str.setTotalCount();
                return;
            }
        }
    }
}
