package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, false, "6개 일치 (2,000,000,000원)", 2_000_000_000),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    THIRD(5, false, "5개 일치 (1,500,000원)", 1_500_000),
    FOURTH(4, false, "4개 일치 (50,000원)", 50_000),
    FIFTH(3, false, "3개 일치 (5,000원)", 5_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final String message;
    private final int prize;

    LottoRanking(int matchCount, boolean matchBonus, String message, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.message = message;
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getMessage() {
        return message;
    }

    public static LottoRanking of(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.matchCount == matchCount && ranking.matchBonus == matchBonus)
                .findFirst()
                .orElse(null);
    }
}