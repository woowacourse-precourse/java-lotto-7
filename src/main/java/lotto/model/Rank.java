package lotto.model;

import java.util.Arrays;

public enum Rank {
    NONE(0, null, 0L,
            ""),
    FIFTH(3, null, 5000L,
            "3개 일치 (5,000원) - "),
    FOURTH(4, null, 50000L,
            "4개 일치 (50,000원) - "),
    THIRD(5, false, 1500000L,
            "5개 일치 (1,500,000원) - "),
    SECOND(5, true, 30000000L,
            "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, null, 2000000000L,
            "6개 일치 (2,000,000,000원) - ");

    private final int matchNumbers;
    private final Boolean isBonus;
    private final long price;
    private final String message;

    Rank(int matchNumbers, Boolean isBonus, long price, String message) {
        this.matchNumbers = matchNumbers;
        this.isBonus = isBonus;
        this.price = price;
        this.message = message;
    }

    public static Rank createLottoRank(int matchNumbers, Boolean isBonus) {
        return findMatchRank(matchNumbers, isBonus);
    }

    private static Rank findMatchRank(int matchNumbers, Boolean isBonus) {
        return Arrays.stream(Rank.values())
                .filter(e -> isMatch(e, matchNumbers, isBonus))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isMatch(Rank rank, int matchNumbers, Boolean isBonus) {
        if (rank.isBonus == null) {
            return matchNumbers == rank.matchNumbers;
        }
        return matchNumbers == rank.matchNumbers
                && rank.isBonus.equals(isBonus);
    }

    public long getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
