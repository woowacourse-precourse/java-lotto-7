package lotto.lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    LOSE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    ;

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;

    LottoResult(int matchCount, boolean hasBonus, int prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static LottoResult calculate(int matchCount, boolean hasBonus) {
        if (matchCount == THIRD.matchCount) {
            if (hasBonus) {
                return SECOND;
            }
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(lottoResult -> lottoResult.matchCount == matchCount)
                .findFirst()
                .orElse(LOSE);
    }

    public int getPrize() {
        return prize;
    }
}
