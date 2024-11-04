package lotto.model;

import java.util.stream.Stream;

public enum Rank {
    FIFTH("3개 일치 (5,000원) - ", 5000, 3, false),
    FOURTH("4개 일치 (50,000원) - ", 50000, 4, false),
    THIRD("5개 일치 (1,500,000원) - ", 1500000, 5, false),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000, 5, true),
    FIRST("6개 일치 (2,000,000,000원) - ", 2000000000, 6, false);

    private final String rank;
    private final long winningPrice;
    private final int matchingCount;
    private final boolean requiresBonus;

    Rank(String rank, long winningPrice, int matchingCount, boolean requiresBonus) {
        this.rank = rank;
        this.winningPrice = winningPrice;
        this.matchingCount = matchingCount;
        this.requiresBonus = requiresBonus;
    }

    public static Rank of(int matchingCount, boolean hasBonus) {
        return Stream.of(values())
                .filter(rank -> rank.matchingCount == matchingCount && (!rank.requiresBonus || hasBonus))
                .findFirst()
                .orElse(null);
    }

    public String getRank() {
        return rank;
    }

    public long getWinningPrice() {
        return winningPrice;
    }
}
