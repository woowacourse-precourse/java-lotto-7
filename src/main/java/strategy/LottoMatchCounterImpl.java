package strategy;

import domain.lotto.Lotto;

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

        while (purchasedLottLeftPointer < 6 && winningLottoLeftPointer < 6) {
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
        return matchCount == 5 &&
                purchasedLottLeftPointer.getNumbers().contains(bonusNumber);
    }
}
