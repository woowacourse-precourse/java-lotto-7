package lotto.model;

import java.util.List;

public class LottoResult {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private int lottoCost;
    private int totalPrize;

    public LottoResult(List<Integer> winningNumbers, int bonusNumber, int lottoCost) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoCost = lottoCost;
    }

    public void setTotalPrize(int totalPrize) {
        this.totalPrize = totalPrize;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getLottoCost() {
        return lottoCost;
    }

    public int getTotalPrize() {
        return totalPrize;
    }
}
