package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Rank {
    THREE_MATCHES(3, false, "3개 일치 (5,000원)", 5000),
    FOUR_MATCHES(4, false, "4개 일치 (50,000원)", 50000),
    FIVE_MATCHES(5, false, "5개 일치 (1,500,000원)", 1500000),
    FIVE_MATCHES_BONUS(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX_MATCHES(6, false, "6개 일치 (2,000,000,000원)", 2000000000),
    NO_RANK(0, false, "", 0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final String description;
    private final int prize;

    Rank(int matchCount, boolean requiresBonus, String description, int prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.description = description;
        this.prize = prize;
    }

    public static Rank of(int matchCount, boolean bonusMatch) {
        List<Rank> rankList = Arrays.asList(Rank.values());
        Collections.reverse(rankList);

        for (Rank rank : rankList) {
            if (rank.matchCount == matchCount && (!rank.requiresBonus || bonusMatch)) {
                return rank;
            }
        }
        return NO_RANK;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }
}
