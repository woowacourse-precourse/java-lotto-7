package lotto.domain.constant;

import java.util.List;

public enum Ranking {
    NONE(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private static final List<Ranking> RANKING = List.of(FIFTH, FOURTH, THIRD, FIRST);

    private final int matchingNumber;
    private final int prize;
    private final boolean hasBonusNumber;

    Ranking(int matchingNumber, int prize, boolean hasBonusNumber) {
        this.matchingNumber = matchingNumber;
        this.prize = prize;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Ranking getRanking(int matchingNumber, boolean hasBonusNumber) {
        if (matchingNumber == SECOND.matchingNumber && hasBonusNumber) {
            return SECOND;
        }
        return RANKING.stream()
                .filter(rank -> rank.matchingNumber == matchingNumber)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }
}
