package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoDraw {
    private final Map<LottoPrize, Integer> prizeCount;

    public LottoDraw() {
        this.prizeCount = new EnumMap<>(LottoPrize.class);
        initializePrizeCount();
    }

    private void initializePrizeCount() {
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCount.put(prize, 0);
        }
    }

    public void countWinningResult(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = lotto.matchCount(winningNumber.getWinningNumbers());
        boolean bonusMatch = matchCount == 5 &&
                lotto.containsNumber(winningNumber.getBonusNumber());

        updatePrizeCount(matchCount, bonusMatch);
    }

    private void updatePrizeCount(int matchCount, boolean bonusMatch) {
        LottoPrize prize = findPrize(matchCount, bonusMatch);
        if (prize != null) {
            increasePrizeCount(prize);
        }
    }

    private LottoPrize findPrize(int matchCount, boolean bonusMatch) {
        if (matchCount == LottoPrize.FIRST.getMatchCount()) {
            return LottoPrize.FIRST;
        }
        if (matchCount == LottoPrize.SECOND.getMatchCount() && bonusMatch) {
            return LottoPrize.SECOND;
        }
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.getMatchCount() == matchCount && prize != LottoPrize.SECOND)
                .findFirst()
                .orElse(null);
    }

    private void increasePrizeCount(LottoPrize prize) {
        prizeCount.put(prize, prizeCount.get(prize) + 1);
    }
}
