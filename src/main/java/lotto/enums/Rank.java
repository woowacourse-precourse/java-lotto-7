package lotto.enums;

import java.util.Arrays;

public enum Rank {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    Rank(int correctCount, boolean bonusCheck, int amount) {
        this.correctCount = correctCount;
        this.bonusCheck = bonusCheck;
        this.amount = amount;
    }

    private final int correctCount;
    private final boolean bonusCheck;
    private final int amount;

    public int getCorrectCount() {
        return correctCount;
    }

    public boolean getBonusCheck() {
        return bonusCheck;
    }

    public int getAmount() {
        return amount;
    }

    public static Rank findRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != NONE)
                .filter(rank -> rank.correctCount == matchCount)
                .filter(rank -> !rank.bonusCheck || (rank.bonusCheck && matchBonus))
                .findFirst()
                .orElse(NONE);
    }
}
