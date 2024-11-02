package lotto;

import static lotto.Rank.SECOND;
import static lotto.Rank.NONE;

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
        if (isSecondRanking(winningNumberMatchCount, isBonusNumberMatched)) {
            return SECOND;
        }
        return rankRule.getOrDefault(winningNumberMatchCount, NONE);
    }

    private static boolean isSecondRanking(final int winningNumberMatchCount, final boolean isBonusNumberMatched) {
        return winningNumberMatchCount == SECOND.getWinningNumberMatchCount() && isBonusNumberMatched;
    }
}