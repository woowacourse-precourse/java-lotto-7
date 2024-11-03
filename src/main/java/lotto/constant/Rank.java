package lotto.constant;

import java.util.Arrays;

public enum Rank {
    THIRDS(3, false, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    FIFTH(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FIFTH_WITH_BONUS(4, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final boolean matchBonus;
    private final int reward;
    private final String description;

    Rank(int matchCount, boolean matchBonus, int reward, String description) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.reward = reward;
        this.description = description;
    }

    public static Rank calculate(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount && rank.matchBonus == matchBonus)
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException("기존 순위에 포함되지 않은 경우의수가 존재합니다."));
    }

    public static boolean contains(int matchCount) {
        return Arrays.stream(Rank.values())
                .map(rank -> rank.matchCount)
                .anyMatch(originalMatchCount -> originalMatchCount == matchCount);
    }

    public String getDescription() {
        return description;
    }
}
