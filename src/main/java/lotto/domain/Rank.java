package lotto.domain;

import java.util.Arrays;

public enum Rank {
    UNDER_TWO_HIT(0, BonusExistence.IRRELEVANT, 0),
    THREE_HIT(3, BonusExistence.IRRELEVANT, 5000),
    FOUR_HIT(4, BonusExistence.IRRELEVANT, 50000),
    FIVE_HIT_WITHOUT_BONUS(5, BonusExistence.NO_BONUS, 1500000),
    FIVE_HIT_WITH_BONUS(5, BonusExistence.HAVE_BONUS, 30000000),
    SIX_HIT(6, BonusExistence.IRRELEVANT, 2000000000);

    private int hits;
    private BonusExistence bonusExistence;
    private long prizeAmount;

    Rank(int hits, BonusExistence haveBonus, long prizeAmount) {
        this.hits = hits;
        this.bonusExistence = haveBonus;
        this.prizeAmount = prizeAmount;
    }

    public static Rank of(int hits, BonusExistence bonusExistence) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(hits, bonusExistence))
                .findFirst()
                .orElse(UNDER_TWO_HIT);
    }

    private boolean matches(long hits, BonusExistence bonusExistence) {
        return this.hits == hits && this.bonusExistence == bonusExistence;
    }

}