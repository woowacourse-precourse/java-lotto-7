package lotto.strategy;

import lotto.Lotto;
import lotto.domain.LottoCondition;
import lotto.domain.rank.MatchCount;

public class LottoMatchCounterImpl implements LottoMatchCounter {
    @Override
    public int count(Lotto purchasedLotto, Lotto selectWinnerLotto, int bonusNumber) {
        int matchCount = countMatchingNumbers(purchasedLotto, selectWinnerLotto);

        if (hasFiveMatchesWithBonus(purchasedLotto, bonusNumber, matchCount)) {
            // 7 = Five Match && BonusNumber Match
            matchCount += 2;
        }
        return matchCount;
    }

    private int countMatchingNumbers(Lotto purchasedLotto, Lotto selectWinnerLotto) {
        int matchCount = 0;
        int purchasedLottLeftPointer = 0;
        int winningLottoLeftPointer = 0;

        while (purchasedLottLeftPointer < LottoCondition.MAX_COUNT.getConditionNumber()
                && winningLottoLeftPointer < LottoCondition.MAX_COUNT.getConditionNumber()) {
            if (isMatch(purchasedLotto, selectWinnerLotto, purchasedLottLeftPointer, winningLottoLeftPointer)) {
                matchCount++;
                purchasedLottLeftPointer++;
                winningLottoLeftPointer++;
                continue;
            }

            if (isPurchasedLessThanWinning(purchasedLotto, selectWinnerLotto, purchasedLottLeftPointer,
                    winningLottoLeftPointer)) {
                purchasedLottLeftPointer++;
                continue;
            }

            winningLottoLeftPointer++;
        }

        return matchCount;
    }


    private boolean isMatch(Lotto purchasedLotto, Lotto selectWinnerLotto, int purchasedLottLeftPointer,
                            int winningLottoLeftPointer) {
        return purchasedLotto.getNumbers().get(purchasedLottLeftPointer)
                .equals(selectWinnerLotto.getNumbers().get(winningLottoLeftPointer));
    }

    private boolean isPurchasedLessThanWinning(Lotto purchasedLotto, Lotto selectWinnerLotto,
                                               int purchasedLottLeftPointer,
                                               int winningLottoLeftPointer) {
        return purchasedLotto.getNumbers().get(purchasedLottLeftPointer) < selectWinnerLotto.getNumbers()
                .get(winningLottoLeftPointer);
    }

    private boolean hasFiveMatchesWithBonus(Lotto purchasedLottLeftPointer, int bonusNumber, int matchCount) {
        return matchCount == MatchCount.FIVE_MATCH.getMatchCount() &&
                purchasedLottLeftPointer.getNumbers().contains(bonusNumber);
    }
}
