package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class DefaultLottoResultCalculator implements LottoResultCalculator {
    private static final int MIN_MATCH_COUNT = 3;

    @Override
    public Map<WinningResult, Integer> checkLottoResult(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        Map<WinningResult, Integer> results = initializeResults();
        for (Lotto lotto : purchasedLottos) {
            updateLottoResult(results, lotto, winningLotto);
        }
        return results;
    }

    private Map<WinningResult, Integer> initializeResults() {
        Map<WinningResult, Integer> results = new EnumMap<>(WinningResult.class);
        Arrays.stream(WinningResult.values()).forEach(result -> results.put(result, 0));
        return results;
    }

    private void updateLottoResult(Map<WinningResult, Integer> results, Lotto lotto, WinningLotto winningLotto) {
        int matchCount = winningLotto.countMatches(lotto);
        if (matchCount < MIN_MATCH_COUNT) {
            return;
        }

        WinningResult result = findResultAsMatchCount(matchCount, winningLotto.containsBonusNum(lotto));
        results.put(result, results.get(result) + 1);
    }

    private WinningResult findResultAsMatchCount(int matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch) {
            return WinningResult.BONUS;
        }
        return WinningResult.fromMatchCount(String.valueOf(matchCount));
    }
}
