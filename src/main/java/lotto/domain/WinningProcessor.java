package lotto.domain;

import static lotto.controller.LottoController.initializeResultMap;
import static lotto.domain.Rank.findRank;

import java.util.Map;
import java.util.Map.Entry;
import lotto.dto.UserLotto;
import lotto.dto.WinningResult;

public class WinningProcessor {

    private final UserLotto userLotto;
    private final WinningLotto winningLotto;
    private final int bonusNumber;

    public WinningProcessor(UserLotto userLotto, WinningLotto winningLotto, int bonusNumber) {
        this.userLotto = userLotto;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult calculate(long buyAmount) {

        Map<Rank, Integer> result = initializeResultMap();
        calculateResult(result);
        long prize = calculateTotalPrize(result);

        return WinningResult.of(result, prize, calculateRateOfReturn(buyAmount, prize));
    }

    private void calculateResult(Map<Rank, Integer> result) {
        for (Lotto lotto : userLotto.getLottos()) {
            int score = winningLotto.countMatchingNumbers(lotto);
            boolean isBonusMatches = lotto.getNumbers().contains(bonusNumber);

            Rank rank = findRank(score, isBonusMatches);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    private long calculateTotalPrize(Map<Rank, Integer> result) {
        long prize = 0L;
        for (Entry<Rank, Integer> entry : result.entrySet()) {
            prize += entry.getKey().getPrize() * entry.getValue();
        }
        return prize;
    }

    private double calculateRateOfReturn(long buyAmount, long prize) {
        return ((double) prize / buyAmount) * 100.0;
    }
}
