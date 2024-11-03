package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, BonusBall.IRRELEVANT, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, BonusBall.MATCH, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, BonusBall.NOT_MATCH, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, BonusBall.IRRELEVANT, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, BonusBall.IRRELEVANT, 5000, "3개 일치 (5,000원)"),
    NONE(0, BonusBall.NOT_MATCH, 0, "0개 일치");

    private final int matchCount;
    private final BonusBall bonusBall;
    private final int prize;
    private final String message;

    Rank(int matchCount, BonusBall bonusBall, int prize, String message) {
        this.matchCount = matchCount;
        this.bonusBall = bonusBall;
        this.prize = prize;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank findRank(int matchCount, boolean bonusBall) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.bonusBall.match() == bonusBall) {
                return rank;
            }
        }
        return NONE;
    }
}
