package lotto;

public class LottoResult {
    int winningCount;
    int bonusCount;

    public LottoResult(int winningCount, int bonusCount) {
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
    }

    private int getWinningCount() {
        return winningCount;
    }

    private int getBonusCount() {
        return bonusCount;
    }

    public void checkWinningLotto() {
        for (WinningPrize prize:WinningPrize.values()){
            if (prize.winningCount == getWinningCount() && prize.bonusCount <= getBonusCount()){
                prize.setTotalCount();
                return;
            }
        }
    }
}
