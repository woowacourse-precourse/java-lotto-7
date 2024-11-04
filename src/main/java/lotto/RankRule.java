package lotto;

import static lotto.Rank.SECOND;
import static lotto.Rank.NONE;
import static lotto.Rank.THIRD;

import java.util.HashMap;
import java.util.Map;

public class RankRule {
    private final static Map<Integer, Rank> rankRule;

    static {
        rankRule = new HashMap<>();
        addRule();
    }

    private static void addRule() {
        for (Rank rank : Rank.values()) {
            int winningNumberMatchCount = rank.getWinningNumberMatchCount();
            rankRule.put(winningNumberMatchCount, rank);
        }
    }

    public static Rank checkRank(final int winningNumberMatchCount, final boolean isBonusNumberMatched) {
        if (winningNumberMatchCount == SECOND.getWinningNumberMatchCount()) {
            return checkSecondOrThird(isBonusNumberMatched);
        }
        return rankRule.getOrDefault(winningNumberMatchCount, NONE);
    }

    private static Rank checkSecondOrThird(final boolean isBonusNumberMatched) {
        if (isBonusNumberMatched) {
            return SECOND;
        }
        return THIRD;
    }
}