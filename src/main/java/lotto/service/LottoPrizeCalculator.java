package lotto.service;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoPrizeCalculator {

    private static final int FIRST_WINNER_PRIZE = 2_000_000_000;
    private static final int SECOND_WINNER_PRIZE = 30_000_000;
    private static final int THIRD_WINNER_PRIZE = 1_500_000;
    private static final int FOURTH_WINNER_PRIZE = 50_000;
    private static final int FIFTH_WINNER_PRIZE = 5_000;

    public long calculatePrize(Lottos generatedLottos, Lotto parsedWinningNumbers, int parsedWinningBonus) {
        long totalPrize = 0;

        for (Lotto lotto : generatedLottos.getLottos()) {
            int matchingNumbers = countMatchingNumbers(lotto, parsedWinningNumbers);
            boolean hasBonusNumber = lotto.getNumbers().contains(parsedWinningBonus);

            totalPrize += calculateIndividualPrize(matchingNumbers, hasBonusNumber);
        }
        return totalPrize;
    }

    private int countMatchingNumbers(Lotto lotto, Lotto winningNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningNumber.getNumbers();

        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private int calculateIndividualPrize(int matchingNumbers, boolean hasBonusNumber) {
        if (matchingNumbers == 6) {
            return FIRST_WINNER_PRIZE;
        }
        if (matchingNumbers == 5 && hasBonusNumber) {
            return SECOND_WINNER_PRIZE;
        }
        if (matchingNumbers == 5) {
            return THIRD_WINNER_PRIZE;
        }
        if (matchingNumbers == 4) {
            return FOURTH_WINNER_PRIZE;
        }
        if (matchingNumbers == 3) {
            return FIFTH_WINNER_PRIZE;
        }
        return 0;
    }

    public double calculateYield(long totalPrize, long purchaseAmount) {

        double yield = ((double) totalPrize / purchaseAmount) * 100;
        return Math.round(yield * 100) / 100.0;
    }
}
