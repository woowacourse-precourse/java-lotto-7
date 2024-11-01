package lotto.model;

import java.util.Arrays;
import java.util.Map;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    MISS(0, 0, "");

    private int countOfMatch;
    private int winningMoney;
    private String message;

    Rank(final int countOfMatch, final int winningMoney, final String message) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public static Rank extractRanking(final int countOfMatch, final boolean shotBonus) {
        if (SECOND.matchCount(countOfMatch) && shotBonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount(countOfMatch))
                .findFirst()
                .orElse(MISS);
    }

    public static int calculateMoney(final Map<Rank, Integer> results) {
        return results.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .mapToInt(entry -> entry.getKey().winningMoney)
                .sum();
    }

    private boolean matchCount(final int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public String getMessage() {
        return message;
    }
}
