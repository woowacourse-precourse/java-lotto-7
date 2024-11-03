package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.util.PrizeCalculator;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class DefaultLottoResultCalculator implements LottoResultCalculator {
    private static final int MIN_MATCH_COUNT = 3;

    @Override
    public LottoResult calculateResult(final List<Lotto> purchasedLottos, final WinningLotto winningLotto) {
        Map<WinningResult, Integer> results = calcPurchasedAndWinning(purchasedLottos, winningLotto);
        int totalAmount = PrizeCalculator.calcTotalPrizeAmount(results);
        return new LottoResult(results, totalAmount);
    }

    private Map<WinningResult, Integer> calcPurchasedAndWinning(final List<Lotto> purchased, final WinningLotto winning) {
        Map<WinningResult, Integer> results = initializeResults();
        for (Lotto lotto : purchased) {
            updateLottoResult(results, lotto, winning);
        }
        return results;
    }

    private Map<WinningResult, Integer> initializeResults() {
        Map<WinningResult, Integer> results = new EnumMap<>(WinningResult.class);
        Arrays.stream(WinningResult.values()).forEach(result -> results.put(result, 0));
        return results;
    }

    private void updateLottoResult(final Map<WinningResult, Integer> results, final Lotto lotto, final WinningLotto winningLotto) {
        int matchCount = winningLotto.countMatches(lotto);
        if (matchCount < MIN_MATCH_COUNT) {
            return;
        }

        WinningResult result = findResultAsMatchCount(matchCount, winningLotto.containsBonusNum(lotto));
        results.put(result, results.get(result) + 1);
    }

    private WinningResult findResultAsMatchCount(final int matchCount, final boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch) {
            return WinningResult.BONUS;
        }
        return WinningResult.fromMatchCount(String.valueOf(matchCount));
    }
}
