package lotto.lotto;

import static lotto.lotto.Rank.initializeRankCounts;

import java.util.EnumMap;

public class WinningResult {

    private final WinningNumbers winningNumbers;
    private final Number bonusNumber;
    private final EnumMap<Rank, Integer> rankCounts;

    public WinningResult(WinningNumbers winningNumbers, Number bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.rankCounts = initializeRankCounts();
    }

    public void calculateResult(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = calculateRank(lotto);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
    }

    private Rank calculateRank(Lotto lotto) {
        int matchCount = winningNumbers.countMatches(lotto);
        boolean hasBonusNumber = lotto.containsNumber(bonusNumber);

        return Rank.valueOf(matchCount, hasBonusNumber);
    }
}
