package lotto.domain;

import java.util.stream.Stream;

public enum LottoRank {
    FIRST(6, 2_000_000_000L, false),
    SECOND_BONUS(5, 30_000_000L, true),
    SECOND(5, 1_500_000L, false),
    THIRD(4, 50_000L, false),
    FOURTH(3, 5_000L, false);

    private final int matchCount;
    private final long prize;
    private final boolean requiresBonus;

    LottoRank(int matchCount, long prize, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requiresBonus = requiresBonus;
    }

    public long getPrize() {
        return prize;
    }

    public boolean isMatch(int matchCount, boolean bonusMatched) {
        if (this.requiresBonus) {
            return this.matchCount == matchCount && bonusMatched;
        }
        return this.matchCount == matchCount;
    }

    public String getDescription() {
        if (this.requiresBonus) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원)", matchCount, prize);
        }
        return String.format("%d개 일치 (%,d원)", matchCount, prize);
    }

    public static Stream<LottoRank> stream() {
        return Stream.of(LottoRank.values());
    }
}
