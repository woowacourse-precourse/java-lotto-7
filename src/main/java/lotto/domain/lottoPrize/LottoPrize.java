package lotto.domain.lottoPrize;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public enum LottoPrize {

    FIFTH_PRIZE(
            new MatchCondition(3, false),
            5_000L,
            "3개 일치 (5,000원)"
    ),
    FOURTH_PRIZE(
            new MatchCondition(4, false),
            50_000L,
            "4개 일치 (50,000원)"
    ),
    THIRD_PRIZE(
            new MatchCondition(5, false),
            1_500_000L,
            "5개 일치 (1,500,000원)"
    ),
    SECOND_PRIZE(
            new MatchCondition(5, true),
            30_000_000L,
            "5개 일치, 보너스 볼 일치 (30,000,000원)"
    ),
    FIRST_PRIZE(
            new MatchCondition(6, false),
            2_000_000_000L,
            "6개 일치 (2,000,000,000원)"
    ),
    ;

    private final MatchCondition matchCondition;
    public final long prizeMoney;
    public final String description;

    LottoPrize(MatchCondition matchCondition, long prizeMoney, String description) {
        this.matchCondition = matchCondition;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static Optional<LottoPrize> calculatePrize(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize.matchCondition.canMatchWith(matchCount, matchBonus))
                .max(Comparator.comparingLong(lottoPrize -> lottoPrize.prizeMoney));
    }
}
