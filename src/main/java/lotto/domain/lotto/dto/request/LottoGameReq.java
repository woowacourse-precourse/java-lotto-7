package lotto.domain.lotto.dto.request;

import java.util.List;

public class LottoGameReq {
    private final List<List<Integer>> purchasedNumbers;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int cost;

    private LottoGameReq(
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

    public static LottoGameReq of(
            final List<List<Integer>> purchasedNumbers,
            final List<Integer> winningNumbers,
            final int bonusNumber
    ) {
        final int cost = purchasedNumbers.size() * 1000;
        return new LottoGameReq(purchasedNumbers, winningNumbers, bonusNumber, cost);
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