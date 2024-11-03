package lotto.domain.constant;

import java.util.List;

public enum Ranking {

    NONE(0, 0, false),
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    private static final List<Ranking> RANKING_WITHOUT_SECOND = List.of(FIRST, THIRD, FOURTH, FIFTH);

    private final int matchingCount;
    private final int prize;
    private final boolean hasBonusNumber;

    Ranking(int matchingCount, int prize, boolean hasBonusNumber) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Ranking getRanking(int matchingCount, boolean hasBonusNumber) {
        if (matchingCount == SECOND.matchingCount && hasBonusNumber) {
            return SECOND;
        }
        return RANKING_WITHOUT_SECOND.stream()
                .filter(ranking -> ranking.matchingCount == matchingCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }
}
