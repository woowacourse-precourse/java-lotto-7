package lotto.domain.lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiPredicate;

public enum LottoRank {

    FIRST(BigDecimal.valueOf(2_000_000_000), 6, (count, isBonus) -> count == 6),
    SECOND(BigDecimal.valueOf(30_000_000), 5, (count, isBonus) -> count == 5 && isBonus),
    THIRD(BigDecimal.valueOf(1_500_000), 5, (count, isBonus) -> count == 5 && !isBonus),
    FOURTH(BigDecimal.valueOf(50_000), 4, (count, isBonus) -> count == 4),
    FIFTH(BigDecimal.valueOf(5_000), 3, (count, isBonus) -> count == 3);

    private static final String DEFAULT_FORMAT = "%d개 일치 (%,.0f원) - %,.0f개";
    private static final String BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%,.0f원) - %,.0f개";

    private final BigDecimal award;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> condition;

    LottoRank(final BigDecimal award, final int matchCount, final BiPredicate<Integer, Boolean> condition) {
        this.award = award;
        this.matchCount = matchCount;
        this.condition = condition;
    }

    public static Optional<LottoRank> findRank(final int matchingCount, final boolean isBonus) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.condition.test(matchingCount, isBonus))
                .findFirst();
    }

    public BigDecimal getAward() {
        return award;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getFormat() {
        if (this == SECOND) {
            return BONUS_FORMAT;
        }
        return DEFAULT_FORMAT;
    }
}

