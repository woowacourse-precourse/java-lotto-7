package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    private final WinningNumbers winningNumbers;
    private final int LOTTO_PRICE = 1000;

    public Calculator(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Ranking calculateRanking(Lotto lotto) {
        int matchedCount = lotto.matchCount(winningNumbers);
        boolean bonusMatch = lotto.hasBonusNumber(winningNumbers);
        return Ranking.getRank(matchedCount, bonusMatch);
    }

    public Map<Ranking, Long> lottoResults(List<Lotto> purchasedLotto) {
        Map<Ranking, Long> results = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(ranking -> results.put(ranking, 0L));

        purchasedLotto.forEach(lotto -> {
            Ranking rank = calculateRanking(lotto);
            results.put(rank, results.get(rank) + 1);
        });
        return results;
    }

}
