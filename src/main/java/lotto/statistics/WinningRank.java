package lotto.statistics;

import java.util.Arrays;

public enum WinningRank {

    NONE(0, 0) {
        @Override
        int calculateRevenue() {
            return 0;
        }
    },
    FIFTH(3, 5_000) {
        @Override
        int calculateRevenue() {
            return FIFTH.reward * FIFTH.successMatch;
        }
    },
    FOURTH(4, 50_000) {
        @Override
        int calculateRevenue() {
            return FOURTH.reward * FOURTH.successMatch;
        }
    },
    THIRD(5, 1_500_000) {
        @Override
        int calculateRevenue() {
            return THIRD.reward * THIRD.successMatch;
        }
    },
    SECOND(5, 30_000_000) {
        @Override
        int calculateRevenue() {
            return SECOND.reward * SECOND.successMatch;
        }
    },
    FIRST(6, 2_000_000_000) {
        @Override
        int calculateRevenue() {
            return FIRST.reward * FIRST.successMatch;
        }
    };

    private final int requiredMatch;
    private final int reward;
    private int successMatch;

    WinningRank(int requiredMatch, int reward) {
        this.requiredMatch = requiredMatch;
        this.reward = reward;
        this.successMatch = 0;
    }

    abstract int calculateRevenue();

    public int getRequiredMatch() {
        return requiredMatch;
    }

    public int getReward() {
        return reward;
    }

    public int getSuccessMatch() {
        return successMatch;
    }

    public void resetSuccessMatch() {
        successMatch = 0;
    }

    public static WinningRank match(int requiredMatch, boolean hasBonus) {
        if (isMatchSecond(requiredMatch, hasBonus)) {
            return increase(SECOND);
        }

        return increase(getWinningRank(requiredMatch));
    }

    private static boolean isMatchSecond(int requiredMatch, boolean hasBonus) {
        return requiredMatch == SECOND.requiredMatch && hasBonus;
    }

    private static WinningRank getWinningRank(int requiredMatch) {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank != SECOND)
                .filter(rank -> rank.requiredMatch == requiredMatch)
                .findFirst()
                .orElse(NONE);
    }

    private static WinningRank increase(WinningRank rank) {
        rank.successMatch++;
        return rank;
    }
}
