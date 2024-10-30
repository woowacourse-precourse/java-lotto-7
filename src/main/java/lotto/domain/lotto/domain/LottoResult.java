package lotto.domain.lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    FIRST(6, 2_000_000_000, "6개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    NONE(0, 0, "미당첨");

    private final int matchCount;
    private final int prize;
    private final String description;

    LottoResult(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static LottoResult of(
            final int matchCount,
            final boolean matchBonus
    ) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(result -> result.matchCount == matchCount)
                .filter(result -> result != SECOND)
                .findFirst()
                .orElse(NONE);
    }

    public String getResultMessage(int count) {
        return String.format("%s (%d원) - %d개", description, prize, count);
    }

    public int getPrize() {
        return prize;
    }
}
