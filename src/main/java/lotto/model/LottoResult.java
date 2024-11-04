package lotto.model;

import java.util.List;

public class LottoResult {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private int lottoCost;
    private int totalPrize;

    public LottoResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void setLottoCost(int lottoCost) {
        this.lottoCost = lottoCost;
    }

}
