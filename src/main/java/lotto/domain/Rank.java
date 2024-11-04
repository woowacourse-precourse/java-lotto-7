package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean bonusRequired;
    private final long prize;
    private final String displayMessage;

    Rank(int matchCount, boolean bonusRequired, long prize, String displayMessage) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
        this.displayMessage = displayMessage;
    }

    public long getPrize() {
        return prize;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusRequired() {
        return bonusRequired;
    }

    public static Rank findRank(int matchCount, boolean hasBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount && (!rank.bonusRequired || hasBonus == rank.bonusRequired))
                .findFirst()
                .orElse(NONE);
    }
}
