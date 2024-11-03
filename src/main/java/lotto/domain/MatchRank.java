package lotto.domain;

public class MatchRank {

    public static Rank matchRank(int matchWinning, boolean matchBonus) {
        if (matchBonus) {
            return compareBonusTrue(matchWinning);
        }
        return compareBonusFalse(matchWinning);
    }

    private static Rank compareBonusTrue(int matchWinning) {
        for (Rank rank : Rank.values()) {
            if (rank.getRankWinning() == matchWinning && rank.getRankBonus()) {
                return rank;
            }
        }
        return Rank.NOTHING;
    }

    private static Rank compareBonusFalse(int matchWinning) {
        for (Rank rank : Rank.values()) {
            if (rank.getRankWinning() == matchWinning && !rank.getRankBonus()) {
                return rank;
            }
        }
        return Rank.NOTHING;
    }

}
