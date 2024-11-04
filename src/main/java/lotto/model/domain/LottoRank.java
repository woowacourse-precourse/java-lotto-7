package lotto.model.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    FAIL(0, false, 0),
    ;

    private final int matchCount;
    private final boolean bonus;
    private final int prize;

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public static LottoRank of(int matchCount, boolean bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getMatchCount() == matchCount && lottoRank.isBonus() == bonus)
                .findFirst()
                .orElse(FAIL);
    }

    public int getPrize() {
        return prize;
    }

    LottoRank(int matchCount, boolean bonus, int prize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;
    }
}
