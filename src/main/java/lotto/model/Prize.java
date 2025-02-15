package lotto.model;

import java.util.List;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prizeAmount;
    private final boolean requiresBonus;

    Prize(int matchCount, int prizeAmount) {
        this(matchCount, prizeAmount, false);
    }

    Prize(int matchCount, int prizeAmount, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.requiresBonus = requiresBonus;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static Prize calculatePrize(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        long matchCount = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        boolean bonusMatch = lottoNumbers.contains(bonusNumber);

        for (Prize prize : Prize.values()) {
            if (prize.matchCount == matchCount && (!prize.requiresBonus || bonusMatch)) {
                return prize;
            }
        }
        return NONE;
    }
}