package lotto.model;

public class LottoResult {
    private final String winningScore;
    private final int winningsMoney;

    public LottoResult(String winningScore, int winningsMoney) {
        this.winningScore = winningScore;
        this.winningsMoney = winningsMoney;
    }

    public String getWinningScore() {
        return winningScore;
    }

    public int getWinningsMoney() {
        return winningsMoney;
    }

}
