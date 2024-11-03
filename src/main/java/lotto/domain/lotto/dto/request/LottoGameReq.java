package lotto.domain.lotto.dto.request;

import java.util.List;

public class LottoGameReq {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int cost;

    private LottoGameReq(
            int cost,
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.cost = cost;
    }

    public static LottoGameReq of(
            final int cost,
            final List<Integer> winningNumbers,
            final int bonusNumber
    ) {
        return new LottoGameReq(cost, winningNumbers, bonusNumber);
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