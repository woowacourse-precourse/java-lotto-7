package lotto.domain;

import lotto.service.WinningResult;
import lotto.util.PrizeCalculator;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int MIN_PLACE = 3;

    private final Map<WinningResult, Integer> results = new EnumMap<>(WinningResult.class);
    private final WinningLotto winningLotto;
    private final int totalAmount;

    public LottoResult(final List<Lotto> purchasedLotto, final WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        initialize();
        updateLottoResults(purchasedLotto);
        totalAmount = PrizeCalculator.calcTotalPrizeAmount(results);
    }

    private void initialize() {
        Arrays.stream(WinningResult.values())
                .forEach(value -> results.put(value, 0));
    }

    private void updateLottoResults(final List<Lotto> purchasedLottos) {
        for (Lotto lotto : purchasedLottos) {
            updatePerLottoResult(lotto);
        }
    }

    private void updatePerLottoResult(final Lotto lotto) {
        int matchCount = lotto.countMatchingLottoNumber(winningLotto.getWinningLottoNumbers());

        if (matchCount < MIN_PLACE) {
            return;
        }

        WinningResult winningResult = findResultAsMatchCount(matchCount, lotto.getNumbers());
        results.put(winningResult, results.get(winningResult) + 1);
    }

    private WinningResult findResultAsMatchCount(final int matchCount, final List<Integer> lottoNumbers) {
        if (matchCount == 5 && winningLotto.containsBonusNum(lottoNumbers)) {
            return WinningResult.BONUS;
        }
        return WinningResult.fromMatchCount(String.valueOf(matchCount));
    }

    public Map<WinningResult, Integer> getResults() {
        return results;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
