package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Winning;
import lotto.domain.WinningResult;

public class CalculateResult {
    private static final int MATCH_THREE = 3;
    private static final int MATCH_FOUR = 4;
    private static final int MATCH_FIVE = 5;
    private static final int MATCH_SIX = 6;

    public WinningResult calculateResult(Lottos lottos, Winning winning) {
        WinningResult result = new WinningResult();

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = countMatchingNumbers(lotto, winning);
            boolean bonusMatch = hasBonusNumber(lotto, winning);

            if (matchCount == MATCH_SIX) {
                result.increaseMatchSix();
                continue;
            }
            if (matchCount == MATCH_FIVE && bonusMatch) {
                result.increaseMatchFiveAndBonus();
                continue;
            }
            if (matchCount == MATCH_FIVE) {
                result.increaseMatchFive();
                continue;
            }
            if (matchCount == MATCH_FOUR) {
                result.increaseMatchFour();
                continue;
            }
            if (matchCount == MATCH_THREE) {
                result.increaseMatchThree();
            }
        }
        return result;
    }

    private int countMatchingNumbers(Lotto lotto, Winning winning) {
        return (int) lotto.getNumbers().stream()
                .filter(num -> winning.getWinningNumbers().getNumbers().stream()
                        .anyMatch(winningNum -> winningNum.winningNumber() == num))
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto, Winning winning) {
        return lotto.getNumbers().contains(winning.getBonusNumber().bonusNumber());
    }
}
