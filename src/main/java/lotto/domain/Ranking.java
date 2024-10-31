package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Ranking {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false);

    private final int prize;
    private final int matchCount;
    private final boolean isRequireMatchBonus;

    Ranking(int prize, int matchCount, boolean isRequireMatchBonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.isRequireMatchBonus = isRequireMatchBonus;
    }

    public static int calculatePrize(Match match) {
        Optional<Ranking> ranking = findByMatch(match);
        return ranking.map(value -> value.prize)
                .orElse(0);
    }

    public static Optional<Ranking> findByMatch(Match match) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.matchCount == match.matchCount() &&
                        (!ranking.isRequireMatchBonus || match.isMatchBonus()))
                .findFirst();
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequireMatchBonus() {
        return isRequireMatchBonus;
    }
}
