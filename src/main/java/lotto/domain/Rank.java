package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, BonusBall.IRRELEVANT, 2000000000),
    SECOND(5, BonusBall.MATCH, 30000000),
    THIRD(5, BonusBall.NOT_MATCH, 1500000),
    FOURTH(4, BonusBall.IRRELEVANT, 50000),
    FIFTH(3, BonusBall.IRRELEVANT, 5000),
    NONE(0, BonusBall.NOT_MATCH, 0);

    private final int matchCount;
    private final BonusBall bonusBall;
    private final int prize;

    Rank(int matchCount, BonusBall bonusBall, int prize) {
        this.matchCount = matchCount;
        this.bonusBall = bonusBall;
        this.prize = prize;
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
