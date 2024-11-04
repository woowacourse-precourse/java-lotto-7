package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {

    FIFTH_PRIZE(
            3, 0,
            5_000L,
            "3개 일치 (5,000원)"
    ),
    FOURTH_PRIZE(
            4, 0,
            50_000L,
            "4개 일치 (50,000원)"
    ),
    THIRD_PRIZE(
            5, 0,
            1_500_000L,
            "5개 일치 (1,500,000원)"
    ),
    SECOND_PRIZE(
            5, 1,
            30_000_000L,
            "5개 일치, 보너스 볼 일치 (30,000,000원)"
    ),
    FRIST_PRIZE(
            6, 0,
            2_000_000_000L,
            "6개 일치 (2,000,000,000원)"
    ),
    ;

    private final int numberMatch;
    private final int bonusNumberMatch;
    public final long prizeMoney;
    public final String description;

    LottoPrize(int numberMatch, int bonusNumberMatch, long prizeMoney, String description) {
        this.numberMatch = numberMatch;
        this.bonusNumberMatch = bonusNumberMatch;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static Optional<LottoPrize> calculatePrize(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return Optional.of(SECOND_PRIZE);
        }

        return Arrays.stream(values())
                .filter(prize -> prize.numberMatch == matchCount)
                .filter(prize -> prize.bonusNumberMatch == 0)
                .findFirst();
    }
}
