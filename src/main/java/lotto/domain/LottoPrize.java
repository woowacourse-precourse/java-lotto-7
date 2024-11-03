package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LottoPrize {

    FIRST_PRIZE(6, false, 2_000_000_000),
    SECOND_PRIZE(5, true, 30_000_000),
    THIRD_PRIZE(5, false, 1_500_000),
    FOURTH_PRIZE(4, false, 50_000),
    FIFTH_PRIZE(3, false, 5_000),
    NO_PRIZE(0, false, 0);

    private final int winningCount;
    private final boolean bonusExists;
    private final int prize;

    LottoPrize(int winningCount, boolean bonusExists, int prize) {
        this.winningCount = winningCount;
        this.bonusExists = bonusExists;
        this.prize = prize;
    }

    public static LottoPrize findPrize(int matchingCount, boolean hasBonus) {
        return Arrays.stream(values())
            .filter(prize -> prize.winningCount == matchingCount
                && prize.bonusExists == hasBonus)
            .findFirst()
            .orElse(NO_PRIZE);
    }

    public static Map<LottoPrize, Integer> createLottoPrizeResult(List<Lotto> lottoList,
        Lotto winningLotto, Integer bonusNumber) {

        Map<LottoPrize, Integer> prizeCountMap = new HashMap<>();
        for (LottoPrize prize : LottoPrize.values()) {
            prizeCountMap.put(prize, 0);
        }

        for (Lotto lotto : lottoList) {
            LottoPrize prize = lotto.compareNumber(winningLotto, bonusNumber);
            prizeCountMap.compute(prize, (k, count) -> count + 1);
        }
        return prizeCountMap;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isBonusExists() {
        return bonusExists;
    }

    public int getPrize() {
        return prize;
    }
}
