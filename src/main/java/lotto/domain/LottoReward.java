package lotto.domain;

import java.util.Arrays;

public enum LottoReward {
    NONE(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private final int prize;
    private final int matchCount;

    LottoReward(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public static LottoReward findByMatchCount(int matchCount) {
        return Arrays.stream(LottoReward.values())
                .filter(lottoReward -> lottoReward.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }
}
