package lotto.domain.lotto.dto;

import java.util.List;

public class LottoReq {
    private final List<List<Integer>> purchasedNumbers;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int cost;

    private LottoReq(
            List<List<Integer>> purchasedNumbers,
            List<Integer> winningNumbers,
            int bonusNumber,
            int cost
    ) {
        this.purchasedNumbers = purchasedNumbers;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.cost = cost;
    }

    public static LottoReq of(
            List<List<Integer>> purchasedNumbers,
            List<Integer> winningNumbers,
            int bonusNumber,
            int cost
    ) {
        return new LottoReq(purchasedNumbers, winningNumbers, bonusNumber, cost);
    }

    public List<List<Integer>> getPurchasedNumbers() {
        return purchasedNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getCost() {
        return cost;
    }
}