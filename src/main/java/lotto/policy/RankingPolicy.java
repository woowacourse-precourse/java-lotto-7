package lotto.policy;

import java.util.Arrays;

public enum RankingPolicy {
    FIFTH(3,5_000),
    FOURTH(4,50_000),
    THIRD(5,1_500_000),
    SECOND(7,30_000_000),
    FIRST(6,2_000_000_000),
    MATCH_NONE(0,0);

    private final int matchCount;
    private final int prize;

    RankingPolicy(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }


    public static RankingPolicy getPolicy(int matchCount, boolean bonusMatch) {
        if (matchCount == THIRD.getMatchCount() && bonusMatch) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(policy -> policy.getMatchCount() == matchCount)
                .findFirst()
                .orElse(MATCH_NONE);
    }
}
