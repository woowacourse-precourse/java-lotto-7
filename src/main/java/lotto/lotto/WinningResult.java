package lotto.lotto;

import static lotto.lotto.Rank.initializeRankCounts;

import java.util.EnumMap;
import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;

public class WinningResult {

    private final WinningNumbers winningNumbers;
    private final Number bonusNumber;
    private final EnumMap<Rank, Integer> rankCounts;

    public WinningResult(WinningNumbers winningNumbers, Number bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
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

    public EnumMap<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    private void validateBonusNumber(WinningNumbers winningNumbers, Number bonusNumber) {
        if (winningNumbers.containsNumber(bonusNumber)) {
            throw new CustomException(ExceptionMessage.DUPLICATE_BONUS_NUMBER);
        }
    }
}
